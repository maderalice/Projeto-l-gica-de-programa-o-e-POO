package br.com.senai.Curso;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import br.com.senai.Aluno.Aluno;

public class CursoController {

	private static Scanner tec;

	public CursoController() {
		tec = new Scanner(System.in);
	}

	public int leOpcao() {
		System.out.print("> ");
		return tec.nextInt();
	}
	public Curso cadastrarCurso() {
		Curso curso = new Curso ();
		System.out.println("------------ CADASTRAR CURSO ------------");

		System.out.print("Informe o curso: ");
		tec.nextLine();
		curso.setNomeCurso(tec.nextLine());

		return curso;
	}

	public List<Curso> listarCursos(List<Curso> cursos) {
		if (cursos.isEmpty()) {
			System.out.println("Não possui cursos cadastrados!");
			return null;
		}
		System.out.println("---------------------CURSOS CADASTRADOS---------------------");

		System.out.printf("| %2s | %13s | %4s | %5s |  %5s | %5s | %16s |\n", "ID", "Nome", "Ano", "Idade", "País",
				"Estado", "Cidade");

		for (int i = 0; i < cursos.size(); i++) {
			System.out.printf(
				"| %2d | %13s | \n", 
				i + 1, 
				cursos.get(i).getNomeCurso();
		}
			return cursos;
	}
	public List<Curso> editarCurso(List<Curso> cursos) {

		Curso curso = new Curso();
		listarCursos(cursos);

		if (cursos.isEmpty()) {
			return null;
		}

		System.out.print("Informe o Id do curso para editar: ");
		int idCurso = tec.nextInt() - 1;

		System.out.println("1) Nome do curso: ");

		System.out.print("Informe o campo para ser editado: ");
		int opcao = tec.nextInt();
	
		switch (opcao) {

		case 1:
			System.out.println("---------------------EDITAR NOME DO CURSO---------------------");
			System.out.println("Informe o novo nome do curso: ");
			curso.setNomeCurso(tec.next());

			curso.setNomeCurso(cursos.get(idCurso).getNomeCurso());

			cursos.set(idCurso, curso);

			break;

		System.out.println("---------------------EXCLUIR CURSO---------------------");

		System.out.print("Informe o ID do curso para excluir: ");
		int idCursos = tec.nextInt() - 1;

		if (cursos.size() <= idCurso) {

			System.out.println("Curso não cadastrado.");
			return;
		}

		cursos.remove(idCurso);
	}

	public void menu(List<Curso> cursos) {

		boolean sair = false;

		do {

			System.out.println("\n--------------MENU--------------");
			System.out.println("1) Cadastrar cursos: ");
			System.out.println("2) Listar cursos cadastrados: ");
			System.out.println("3) Editar cursos: ");
			System.out.println("4) Excluir cursos: ");
			System.out.println("5) SAIR");
			System.out.println("---------------------------------");

			int opcao = leOpcao();

			switch (opcao) {

			case 1:

				cursos.add(cadastrarCurso());
				break;

			case 2:

				listarCurso(cursos);
				break;

			case 3:
				editarCurso(cursos);
				break;

			case 4:
				excluirAluno(cursos);

			case 5:
				sair = true;
				break;

			default:
				System.out.println("Opção inválida!!!");

			}

		} while (!sair);

	}
}