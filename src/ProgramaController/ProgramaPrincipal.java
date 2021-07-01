package ProgramaController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.Aluno.Aluno;
import br.com.senai.Aluno.AlunoController;
import br.com.senai.Curso.Curso;
import br.com.senai.Curso.CursoController;

public class ProgramaPrincipal {
	private Scanner tec;

	public ProgramaPrincipal() {
		tec = new Scanner(System.in);

	}
	public void listarMenu(List<Aluno> alunos, List<Curso> cursos) {
		System.out.println("\n---------------- MENU ----------------");
		System.out.println("1) ALUNO");
		System.out.println("2) CURSO");
		System.out.println("3) SAIR");
		System.out.println("----------------------------------------");
	}

	public int leOpcao() {
		System.out.print("> ");
		return tec.nextInt();
	}

	public static void main(String[] args) {
		List<Aluno> alunos = new ArrayList<>();
		List<Curso> cursos = new ArrayList<>();

		boolean sair = false;
		AlunoController alunoController = new AlunoController();
		CursoController cursoController = new CursoController();
		ProgramaPrincipal menu = new ProgramaPrincipal();
		Menu menu = new Menu();
		
		do {

			int opcao = menu.leOpcao();
			switch (opcao) {

			case 1:
				alunoController.menu(alunos);
				break;

			case 2:
				cursoController.menu(cursos, alunos);
				break;

			case 3:
				sair = true;
				break;

			default:
				System.out.println("Opção inválida!");
				break;

			}

		} while (!sair);

		System.out.println("SISTEMA FINALIZADO!!");
	}
}