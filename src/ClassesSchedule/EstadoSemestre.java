package ClassesSchedule;

import java.util.ArrayList;
import java.util.List;

import busca.BuscaProfundidade;
import busca.Estado;
import busca.Heuristica;
import busca.MostraStatusConsole;
import busca.Nodo;

public class EstadoSemestre implements Estado, Heuristica {

	private List<Professor> professores;
	private List<Semestre> semestres;
	
	public EstadoSemestre(List<Professor> professores, List<Semestre> semestres) {
		this.professores = professores;
		this.semestres = semestres;
	}
	
	private boolean ehValido() {
		for (Semestre semestre : this.semestres) {
			if (!semestre.ehValido()) {
				return false;
			}
		}
		
		if (!todosProfessoresTemDiaLivre()) return false;
		if (!professoresSoTemUmaDisciplinaPorHorario()) return false;
		
		return true;
	}

	private boolean professoresSoTemUmaDisciplinaPorHorario() {
		for (Professor professor : professores) {
			List<Dia> diasAula = semestres.get(0).obterDiasProfessor(professor, true);	
			
			for (int i = 1; i < this.semestres.size(); i++) {
				Semestre semestre = this.semestres.get(i);
				boolean horarioValido = semestre.validarHorariosProfessor(diasAula, professor);
				if (!horarioValido) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean todosProfessoresTemDiaLivre() {
		for (Professor professor : this.professores) {
			List<Dia> diasLivres = semestres.get(0).obterDiasProfessor(professor, false);
			
			for (int i = 1; i < this.semestres.size(); i++) {
				this.semestres.get(i).validarDiasLivres(diasLivres, professor);
				if (diasLivres.isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public int custo() {
		return 1;
	}

	@Override
	public boolean ehMeta() {
		for (Semestre semestre : this.semestres) {
			if (!semestre.estaCompleto()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<Estado> sucessores() {
		Semestre incompleto = obterPrimeiroSemestreIncompleto();
		int indiceSemestre = this.semestres.indexOf(incompleto);
		
		List<Semestre> semestres = incompleto.gerarEstadosSemestre(this.professores);
		List<Estado> estados = new ArrayList<>();
		
		for (Semestre semestre : semestres) {
			List<Semestre> copiaSemestres = Utils.clonarLista(this.semestres);
			copiaSemestres.set(indiceSemestre, semestre);

			EstadoSemestre novo = new EstadoSemestre(this.professores, copiaSemestres);

			if (novo.ehValido()) {
				estados.add(novo);
			}
		}
		
		return estados;
	}
	
	private Semestre obterPrimeiroSemestreIncompleto() {
		for (Semestre semestre : this.semestres) {
			if (!semestre.estaCompleto()) {
				return semestre;
			}
		}
		return null;
	}

	public List<Professor> getProfessores() {
		return this.professores;
	}
	
	public List<Semestre> getSemestres() {
		return this.semestres;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) 
			return false;
		if (!(obj instanceof EstadoSemestre))
			return false;
		
		EstadoSemestre outro = (EstadoSemestre)obj;
		
		if (!semestresIguais(outro)) 
			return false;
			
		return true;
	}

	private boolean semestresIguais(EstadoSemestre outro) {
		for (int i = 0; i < this.semestres.size(); i++) {
			if (!this.semestres.get(i).equals(outro.getSemestres().get(i))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 17;
		
		for (Semestre semestre : this.semestres) {
			hash = 31 * hash + semestre.hashCode(); 
		}
		
		return hash;
	}
	
	@Override
	public String toString() {
		String descricaoEstado = "";
		
		for (Semestre semestre : this.semestres) {
			descricaoEstado += semestre.toString();
		}

		descricaoEstado += "\n\n";
		
		return descricaoEstado;
	}
	
	public static void main(String[] args) {
		EstadoSemestre estadoInicial = Teste.criarEstadoInicial(1);
		
//		Nodo nodoFinal = new BuscaIterativo().busca(inicial);
//		Nodo nodoFinal = new BuscaLargura(new MostraStatusConsole()).busca(estadoInicial);
		Nodo nodoFinal = new BuscaProfundidade(new MostraStatusConsole()).busca(estadoInicial);
//		Nodo nodoFinal = new AEstrela(new MostraStatusConsole()).busca(estadoInicial);
		
		if (nodoFinal != null) {
			System.out.println(nodoFinal.montaCaminho());	
		} else {
			 System.out.println("Não foi encontrado um estado final para o problema especificado.");
		}
		
	}

	@Override
	public int h() {
		int h = 0;
		
		h += obterProfessoresEmMultiplosSemestres();
		h += obterNumeroDiasProfessoresTrabalham();
		
		return h;
	}

	private int obterNumeroDiasProfessoresTrabalham() {
		int diasTotal = 0;
		
		for (Professor professor : this.professores) {
			List<Dia> dias = new ArrayList<>(); 
			for (Semestre semestre : this.semestres) {
				dias.addAll(semestre.obterDiasProfessor(professor, true));
			}
			
			int diasUnicos = obterDiasUnicos(dias); 
			diasTotal +=  diasUnicos;
		}

		return diasTotal;
	}
	
	private int obterDiasUnicos(List<Dia> dias) {
		boolean segunda = false;
		boolean terca = false;
		boolean quarta = false;
		boolean quinta = false;
		boolean sexta = false;
		
		for (Dia dia : dias) {
			if (dia.getNome().equals("Segunda")) {
				segunda = true;
			}
			if (dia.getNome().equals("Terça")) {
				terca = true;
			}
			if (dia.getNome().equals("Quarta")) {
				quarta = true;
			}
			if (dia.getNome().equals("Quinta")) {
				quinta = true;
			}
			if (dia.getNome().equals("Sexta")) {
				sexta = true;
			}
		}
		
		return (segunda ? 1 : 0) + (terca ? 1 : 0) + (quarta ? 1 : 0) + (quinta ? 1 : 0) + (sexta ? 1 : 0);
	}

	private int obterProfessoresEmMultiplosSemestres() {
		int semestresTotal = 0;
		
		for (Professor professor : this.professores) {
			int semestresProfessor = 0;
			for (Semestre semestre : this.semestres) {
				if (semestre.professorEstaTrabalhando(professor)) {
					semestresProfessor++;
				}
			}
			semestresTotal += semestresProfessor > 0 ? (semestresProfessor - 1) : 0;
		}

		return semestresTotal;
	}
}
