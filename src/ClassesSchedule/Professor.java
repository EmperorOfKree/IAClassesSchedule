package ClassesSchedule;

import java.util.ArrayList;
import java.util.List;

public class Professor implements Clonavel<Professor> {

	private String nome;
	private List<Disciplina> disciplinasAptoMinistrar;

	public Professor(String nome) {
		this(nome, new ArrayList<Disciplina>());
	}
	
	public Professor(String nome, List<Disciplina> disciplinas) {
		this.nome = nome;
		this.disciplinasAptoMinistrar = disciplinas;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Disciplina> getDisciplinasAptoMinistrar() {
		return disciplinasAptoMinistrar;
	}
	
	public Professor addDisciplinasAptoMinistrar(Disciplina... disciplinas) {
		for (Disciplina disciplina : disciplinas) {
			this.disciplinasAptoMinistrar.add(disciplina);			
		}
		return this;
	}
	
	public boolean podeMinistrarDisciplina(Disciplina disciplina) {
		return disciplinasAptoMinistrar.contains(disciplina);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) 
			return false;
		if (!(obj instanceof Professor))
			return false;
		
		Professor outro = (Professor) obj;
		
		return this.nome.equals(outro.getNome());
	}
	
	@Override
	public int hashCode() {
		int hash = 17;

		return 31 * hash + this.nome.hashCode();
	}

	@Override
	public Professor clonar() {
		Professor copia = new Professor(this.nome, this.disciplinasAptoMinistrar);
		return copia;
	}
	
}
