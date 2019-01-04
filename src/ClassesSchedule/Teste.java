package ClassesSchedule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Teste {

	private static HashMap<String, Professor> professores;
	private static HashMap<Integer, List<Disciplina>> mapaDisciplinasSemestre;
	private static HashMap<Integer, List<Professor>> mapaProfessoresSemestre;
	
	static {
		professores = new HashMap<>();
		
		professores.put("Daniel", new Professor("Daniel"));
		professores.put("Dalton", new Professor("Dalton"));
		professores.put("Mauro", new Professor("Mauro"));
		professores.put("Aurélio", new Professor("Aurélio"));
		professores.put("Matheus", new Professor("Matheus"));
		professores.put("Ratike", new Professor("Ratike"));
		professores.put("Jairson", new Professor("Jairson"));
		professores.put("Jacques", new Professor("Jacques"));
		professores.put("Paulo", new Professor("Paulo"));
		professores.put("Péricas", new Professor("Péricas"));
		professores.put("Pedro", new Professor("Pedro"));
		professores.put("Joyce", new Professor("Joyce"));
		professores.put("Luciana", new Professor("Luciana"));
		professores.put("Miguel", new Professor("Miguel"));
		professores.put("Lamar", new Professor("Lamar"));
		professores.put("Evandro", new Professor("Evandro"));
		professores.put("Waldir", new Professor("Waldir"));
		professores.put("Marcel", new Professor("Marcel"));
		professores.put("Tavares", new Professor("Tavares"));
		professores.put("Gilvan", new Professor("Gilvan"));
		professores.put("Henriete", new Professor("Henriete"));
		professores.put("Gabriele", new Professor("Gabriele"));
		professores.put("Cintia", new Professor("Cintia"));
		professores.put("Neumann", new Professor("Neumann"));

		mapaProfessoresSemestre = new HashMap<>();
		mapaProfessoresSemestre.put(1, professoresPrimeiroSemestre());
		mapaProfessoresSemestre.put(2, professoresSegundoSemestre());
		mapaProfessoresSemestre.put(3, professoresTerceiroSemestre());
		mapaProfessoresSemestre.put(4, professoresQuartoSemestre());
		mapaProfessoresSemestre.put(5, professoresQuintoSemestre());
		mapaProfessoresSemestre.put(6, professoresSextoSemestre());
		mapaProfessoresSemestre.put(7, professoresSetimoSemestre());
		
		mapaDisciplinasSemestre = new HashMap<>();
		
		criarDisciplinasPrimeiroSemestre();
		criarDisciplinasSegundoSemestre();
		criarDisciplinasTerceiroSemestre();
		criarDisciplinasQuartoSemestre();
		criarDisciplinasQuintoSemestre();
		criarDisciplinasSextoSemestre();
		criarDisciplinasSetimoSemestre();
	}
	
	private static List<Professor> professoresPrimeiroSemestre() {
		return Arrays.asList(professores.get("Miguel"), professores.get("Evandro"), professores.get("Mauro"), professores.get("Aurélio"), professores.get("Lamar"));
	}
	
	private static List<Professor> professoresSegundoSemestre() {
		return Arrays.asList(professores.get("Waldir"), professores.get("Joyce"), professores.get("Marcel"));
	}

	private static List<Professor> professoresTerceiroSemestre() {
		return Arrays.asList(professores.get("Tavares"), professores.get("Henriete"), professores.get("Gilvan"), professores.get("Gabriele"));
	}

	private static List<Professor> professoresQuartoSemestre() {
		return Arrays.asList(professores.get("Cintia"), professores.get("Luciana"), professores.get("Neumann"), professores.get("Péricas"));
	}

	private static List<Professor> professoresQuintoSemestre() {
		return Arrays.asList(professores.get("Paulo"), professores.get("Pedro"));
	}

	private static List<Professor> professoresSextoSemestre() {
		return Arrays.asList(professores.get("Ratike"), professores.get("Jairson"), professores.get("Jacques"));
	}

	private static List<Professor> professoresSetimoSemestre() {
		return Arrays.asList(professores.get("Daniel"), professores.get("Matheus"), professores.get("Dalton"));
	}
	
	private static void criarDisciplinasPrimeiroSemestre() {
		Disciplina compDig = CriarDisciplina("Computação Digital", CargaSemanalDisciplina.QUATRO_HORAS, "Miguel");
		Disciplina fundMat = CriarDisciplina("Fundamentos Matemáticos", CargaSemanalDisciplina.QUATRO_HORAS, "Evandro");
		Disciplina intComp = CriarDisciplina("Introdução a Computação", CargaSemanalDisciplina.QUATRO_HORAS, "Mauro");
		Disciplina progComp = CriarDisciplina("Programação de Computadores", CargaSemanalDisciplina.QUATRO_HORAS, "Aurélio");
		Disciplina univ = CriarDisciplina("Universidade Ciência e Pesquisa", CargaSemanalDisciplina.QUATRO_HORAS, "Lamar");
		
		List<Disciplina> disciplinasPrimeiro = Arrays.asList(compDig, fundMat, intComp, progComp, univ);

		mapaDisciplinasSemestre.put(1, disciplinasPrimeiro);
	}
	
	private static void criarDisciplinasSegundoSemestre() {
		Disciplina algebLin = CriarDisciplina("Álgebra Linear", CargaSemanalDisciplina.QUATRO_HORAS, "Evandro");
		Disciplina arqComp = CriarDisciplina("Arquitetura de Computadores", CargaSemanalDisciplina.QUATRO_HORAS, "Miguel");
		Disciplina lingCien = CriarDisciplina("Linguagem Científica", CargaSemanalDisciplina.QUATRO_HORAS, "Waldir");
		Disciplina logicComp = CriarDisciplina("Lógica para Computação", CargaSemanalDisciplina.QUATRO_HORAS, "Joyce");
		Disciplina progObj1 = CriarDisciplina("Programação Orientada a Objetos I", CargaSemanalDisciplina.QUATRO_HORAS, "Marcel");
		
		List<Disciplina> disciplinasSegundo = Arrays.asList(algebLin, arqComp, lingCien, logicComp, progObj1);
		
		mapaDisciplinasSemestre.put(2, disciplinasSegundo);
	}

	private static void criarDisciplinasTerceiroSemestre() {
		Disciplina algEstDad = CriarDisciplina("Algoritmos e Estruturas de Dados", CargaSemanalDisciplina.QUATRO_HORAS, "Tavares", "Aurélio");
		Disciplina estatistica = CriarDisciplina("Estatística", CargaSemanalDisciplina.QUATRO_HORAS, "Henriete");
		Disciplina progObj2 = CriarDisciplina("Programação Orientada a Objetos II", CargaSemanalDisciplina.QUATRO_HORAS, "Gilvan");
		Disciplina sisOp = CriarDisciplina("Sistemas Operacionais", CargaSemanalDisciplina.QUATRO_HORAS, "Tavares");
		Disciplina teoriComp = CriarDisciplina("Teoria da Computação", CargaSemanalDisciplina.QUATRO_HORAS, "Gabriele");
		
		List<Disciplina> disciplinasTerceiro = Arrays.asList(algEstDad, estatistica, progObj2, sisOp, teoriComp);
		
		mapaDisciplinasSemestre.put(3, disciplinasTerceiro);
	}

	private static void criarDisciplinasQuartoSemestre() {
		Disciplina desSoc = CriarDisciplina("Desafios Sociais e Contemporâneos", CargaSemanalDisciplina.QUATRO_HORAS, "Cintia");
		Disciplina lingProg = CriarDisciplina("Linguagens de Programação", CargaSemanalDisciplina.QUATRO_HORAS, "Luciana");
		Disciplina lingForm = CriarDisciplina("Linguagens Formais", CargaSemanalDisciplina.DUAS_HORAS, "Joyce");
		Disciplina metQuant = CriarDisciplina("Métodos Quantitativos", CargaSemanalDisciplina.QUATRO_HORAS, "Neumann");
		Disciplina protComDad = CriarDisciplina("Protocolos de Comunicação de Dados", CargaSemanalDisciplina.DUAS_HORAS, "Péricas");
		Disciplina grafos = CriarDisciplina("Teoria dos Grafos", CargaSemanalDisciplina.QUATRO_HORAS, "Aurélio");
		
		List<Disciplina> disciplinasQuarto = Arrays.asList(desSoc, lingProg, lingForm, metQuant, protComDad, grafos);
		
		mapaDisciplinasSemestre.put(4, disciplinasQuarto);
	}

	private static void criarDisciplinasQuintoSemestre() {
		Disciplina bd1 = CriarDisciplina("Banco de Dados I", CargaSemanalDisciplina.QUATRO_HORAS, "Luciana");
		Disciplina compiladores = CriarDisciplina("Compiladores", CargaSemanalDisciplina.QUATRO_HORAS, "Joyce");
		Disciplina concorr = CriarDisciplina("Galáxias", CargaSemanalDisciplina.QUATRO_HORAS, "Paulo");
		Disciplina engSoft = CriarDisciplina("Engenharia de Software", CargaSemanalDisciplina.QUATRO_HORAS, "Pedro");
		Disciplina redes = CriarDisciplina("Redes de Computadores", CargaSemanalDisciplina.QUATRO_HORAS, "Péricas");
		
		List<Disciplina> disciplinasQuinto = Arrays.asList(bd1, compiladores, concorr, engSoft, redes);
		
		mapaDisciplinasSemestre.put(5, disciplinasQuinto);
	}

	private static void criarDisciplinasSextoSemestre() {
		Disciplina bd2 = CriarDisciplina("Banco de Dados II", CargaSemanalDisciplina.QUATRO_HORAS, "Ratike");
		Disciplina compOrg = CriarDisciplina("Comportamento Organizacional", CargaSemanalDisciplina.QUATRO_HORAS, "Jairson");
		Disciplina ps1 = CriarDisciplina("Processos de Software I", CargaSemanalDisciplina.QUATRO_HORAS, "Jacques");
		Disciplina sisDist = CriarDisciplina("Sistemas Distribuídos", CargaSemanalDisciplina.QUATRO_HORAS, "Paulo");
		Disciplina prRedes = CriarDisciplina("Prática de Redes", CargaSemanalDisciplina.QUATRO_HORAS, "Péricas");
		
		List<Disciplina> disciplinasSexto = Arrays.asList(bd2, compOrg, ps1, sisDist, prRedes);
		
		mapaDisciplinasSemestre.put(6, disciplinasSexto);
	}

	private static void criarDisciplinasSetimoSemestre() {
		Disciplina ia = CriarDisciplina("Inteligência Artificial", CargaSemanalDisciplina.QUATRO_HORAS, "Daniel");
		Disciplina ps2 = CriarDisciplina("Processos de Software II", CargaSemanalDisciplina.QUATRO_HORAS, "Mauro");
		Disciplina rob = CriarDisciplina("Robótica", CargaSemanalDisciplina.QUATRO_HORAS, "Aurélio");
		Disciplina web = CriarDisciplina("Desenvolvimento Web", CargaSemanalDisciplina.QUATRO_HORAS, "Matheus");
		Disciplina cg = CriarDisciplina("Computação Gráfica", CargaSemanalDisciplina.QUATRO_HORAS, "Dalton");
		
		List<Disciplina> disciplinasSetimo = Arrays.asList(ia, ps2, rob, web, cg);
		
		mapaDisciplinasSemestre.put(7, disciplinasSetimo);
	}

	private static Disciplina CriarDisciplina(String nome, CargaSemanalDisciplina carga, String... nomeProfessores) {
		Disciplina disciplina = new Disciplina(nome, carga);
		for (String nomeProfessor : nomeProfessores) {
			professores.get(nomeProfessor).addDisciplinasAptoMinistrar(disciplina);
		}
		return disciplina;
	}
	
	public static EstadoSemestre criarEstadoInicial(int numeroSemestres) {
		List<Semestre> semestres = new ArrayList<>();
		
		for (int i = 1; i <= numeroSemestres; i++) {
			Semestre semestre = new Semestre(i, mapaDisciplinasSemestre.get(i));
			semestres.add(semestre);
		}

		List<Professor> professores = criarListaProfessores(numeroSemestres);
		
		EstadoSemestre estadoInicial = new EstadoSemestre(professores, semestres);
		return estadoInicial;
	}

	private static List<Professor> criarListaProfessores(int numeroSemestres) {
		List<Professor> professores = new ArrayList<Professor>();
		
		for (int i = 1; i <= numeroSemestres; i++) {
			professores.addAll(mapaProfessoresSemestre.get(i));
		}
		
		return professores;
	}
	
}
