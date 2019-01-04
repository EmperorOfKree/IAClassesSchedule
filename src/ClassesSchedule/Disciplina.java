package ClassesSchedule;

public class Disciplina implements Clonavel<Disciplina> {

	private String nome;
	private Professor professorMinistrando;
	private int cargaSemanal;
	private int cargaAlocada;
	
	public Disciplina(String nome, CargaSemanalDisciplina carga) {
		this.nome = nome;
		this.cargaAlocada = 0;
		if (carga == CargaSemanalDisciplina.QUATRO_HORAS) {
			this.cargaSemanal = 2;
		} else {
			this.cargaSemanal = 1;
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Professor getProfessorMinistrando() {
		return professorMinistrando;
	}
	
	public void setProfessorMinistrando(Professor professorMinistrando) {
		this.professorMinistrando = professorMinistrando;
	}

	public void alocar() {
		this.cargaAlocada++;
	}
	
	public void desalocar() { 
		this.cargaAlocada--;
	}
	
	public boolean estaAlocada() {
		return this.cargaAlocada == this.cargaSemanal;
	}
	
	public int getCargaSemanal() {
		return this.cargaSemanal;
	}                            

	public int getCargaAlocada() {
		return this.cargaAlocada;
	}
	
	public void setCargaAlocada(int carga) {
		this.cargaAlocada = carga;
	}                                                                          
	
	@Override
	public int hashCode() {
		int hash = 17;
		
		hash = 31 * hash + this.nome.hashCode();
		
		return hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!(obj instanceof Disciplina)) return false;
		
		Disciplina outra = (Disciplina) obj;
		
		if (!this.nome.equals(outra.getNome())) return false;
		
		return true;
	}

	@Override
	public Disciplina clonar() {
		Disciplina copia = new Disciplina(this.nome, this.cargaSemanal == 1 ? CargaSemanalDisciplina.DUAS_HORAS : CargaSemanalDisciplina.QUATRO_HORAS);
		copia.setCargaAlocada(this.cargaAlocada);
		
		return copia;
	}
	
}
