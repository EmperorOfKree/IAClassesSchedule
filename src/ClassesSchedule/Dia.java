package ClassesSchedule;

public class Dia implements Clonavel<Dia> {

	private Disciplina aula1;
	private Disciplina aula2;
	private String nome;
	
	public Dia(String nome) {
		this(nome, null, null);
	}
	
	public Dia(String nome, Disciplina aula1, Disciplina aula2) {
		this.nome = nome;
		this.aula1 = aula1;
		this.aula2 = aula2;
	}

	public boolean ehMesmaAula() {
		return this.aula1.getNome().equals(this.aula2.getNome());
	}

	public boolean professorEstaLivre(Professor professor) {
		return (this.aula1 == null || this.aula1.getProfessorMinistrando() != professor) && 
			   (this.aula2 == null || this.aula2.getProfessorMinistrando() != professor);
	}

	public boolean estaCompleto() {
		return this.aula1 != null && this.aula2 != null;
	}

	public void setAula1(Disciplina disciplina) {
		disciplina.alocar(); 
		this.aula1 = disciplina;
	}
	
	public void setAula2(Disciplina disciplina) {
		disciplina.alocar(); 
		this.aula2 = disciplina;
	}
	
	public Disciplina getAula1() {
		return this.aula1;
	}

	public Disciplina getAula2() {
		return this.aula2;
	}

	public void adicionarDisciplina(Disciplina disciplina) {
		if (this.aula1 == null) {
			this.setAula1(disciplina);
		} else {
			this.setAula2(disciplina);
		}
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String descricao) {
		this.nome = descricao;
	}

	public boolean estaPrimeiroHorario(Professor professor) {
		return this.aula1 != null && this.aula1.getProfessorMinistrando().equals(professor); 
	}
	
	public boolean estaSegundoHorario(Professor professor) {
		return this.aula2 != null && this.aula2.getProfessorMinistrando().equals(professor); 
	}
	
	@Override
	public int hashCode() {
		int hash = 17;
		
		hash = 31 * hash + (this.aula1 != null ? this.aula1.hashCode() : 0);
		hash = 31 * hash + (this.aula2 != null ? this.aula2.hashCode() : 0);
		hash = 31 * hash + this.nome.hashCode();
		
		return hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Dia))
			return false;

		Dia outro = (Dia) obj;

		if (this.getAula1() != null) { 
			if(!this.getAula1().equals(outro.getAula1()))
				return false;
		} else {
			if (outro.getAula1() != null) {
				return false;
			}
		}
		
		if (this.getAula2() != null) { 
			if (!this.getAula2().equals(outro.getAula2()))
				return false;
		} else {
			if (outro.getAula2() != null) {
				return false;
			}
		}
		
		if (!this.getNome().equals(outro.getNome())) return false;

		return true;
	}

	@Override
	public String toString() {
		String descricao = "";
		
		descricao += this.nome + "\n";
		descricao += this.criarDescricaoDisciplina(this.aula1);
		descricao += this.criarDescricaoDisciplina(this.aula2);
		
		return descricao;
	}

	public boolean professorEstaNoMesmoHorario(Dia outro, Professor professor) {
		if (this.estaPrimeiroHorario(professor)) {
			return outro.estaPrimeiroHorario(professor);
		} else {
			return outro.estaSegundoHorario(professor);
		}
	}
	
	private String criarDescricaoDisciplina(Disciplina aula) {
		String descricao = "";
		
		if (aula != null) {
			descricao += aula.getNome();
			descricao += "(" + aula.getProfessorMinistrando().getNome() + ")\n";			
		} else {
			descricao += "X\n";
		}
		
		return descricao;
	}

	@Override
	public Dia clonar() {
		Dia copia = new Dia(this.nome, this.aula1, this.aula2);
		return copia;
	}
}
