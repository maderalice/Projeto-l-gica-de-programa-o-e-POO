package br.com.senai.Aluno;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class AlunoController {

	private static Scanner tec;

	public AlunoController() {
		tec = new Scanner(System.in);
	}

	public int leOpcao() {
		System.out.print("> ");
		return tec.nextInt();
	}
	public Aluno cadastrarAluno() {
		Aluno aluno = new Aluno();
		System.out.println("------------ CADASTRAR ALUNO ------------");

		System.out.print("Informe o nome: ");
		tec.nextLine();
		aluno.setNomeAluno(tec.nextLine().toUpperCase());

		System.out.println("Informe o ano de nascimento: ");
			aluno.setAnoDeNascimento(tec.nextInt());
			Calendar calendar = Calendar.getInstance();

		aluno.setIdadeAluno(calendar.get(Calendar.YEAR) - aluno.getAnoDeNascimento());

		System.out.print("Informe o país do aluno: ");
		tec.nextLine();
		aluno.setPais(tec.nextLine().toUpperCase());

		System.out.print("Informe o estado: ");
		aluno.setEstado(tec.nextLine().toString());

		System.out.print("Informe a cidade: ");
		aluno.setCidade(tec.nextLine().toUpperCase());

		return aluno;
	}

	public List<Aluno> listarAlunos(List<Aluno> alunos) {
		if (alunos.isEmpty()) {
			System.out.println("Não possui alunos cadastrados!");
			return null;
		}
		System.out.println("---------------------ALUNOS CADASTRADOS---------------------");

		System.out.printf("| %2s | %13s | %4s | %5s |  %5s | %5s | %16s |\n", "ID", "Nome", "Ano", "Idade", "País",
				"Estado", "Cidade");

		for (int i = 0; i < alunos.size(); i++) {
			System.out.printf(
				"| %2d | %13s | %4d | %5d | %5s | %5s | %16s | \n", 
				i + 1, 
				alunos.get(i).getNomeAluno(),
				alunos.get(i).getAnoDeNascimento(), 
				alunos.get(i).getIdadeAluno(),
				alunos.get(i).getPais(),
				alunos.get(i).getEstado(), 
				alunos.get(i).getCidade());
		}
			return alunos;
	}
	public List<Aluno> editarAlunos(List<Aluno> alunos) {

		Aluno aluno = new Aluno();
		listarAlunos(alunos);

		if (alunos.isEmpty()) {
			return null;
		}

		System.out.print("Informe o Id do aluno para editar: ");
		int idAluno = tec.nextInt() - 1;

		System.out.println("1) Nome do aluno: ");
		System.out.println("2) Ano de nascimento: ");
		System.out.println("3) País: ");
		System.out.println("4) Estado: ");
		System.out.println("5) Cidade: ");

		System.out.print("Informe o campo para ser editado: ");
		int opcao = tec.nextInt();
	
		switch (opcao) {

		case 1:
			System.out.println("---------------------EDITAR NOME DA PESSOA---------------------");
			System.out.println("Informe o novo nome do aluno: ");
			aluno.setNomeAluno(tec.next());

			aluno.setAnoDeNascimento(alunos.get(idAluno).getAnoDeNascimento());

			alunos.set(idAluno, aluno);

			break;

		case 2:
			System.out.println("---------------------EDITAR ANO DE NASCIMENTO---------------------");

			System.out.print("Informe o novo ano de nascimento: ");
			aluno.setAnoDeNascimento(tec.nextInt());

			aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
			Calendar calendar = Calendar.getInstance();
			aluno.setIdadeAluno(calendar.get(Calendar.YEAR) - aluno.getAnoDeNascimento());

			alunos.set(idAluno, aluno);

			break;

		case 3:
			System.out.println("---------------------EDITAR PAÍS---------------------");

			System.out.print("Informe o novo país: ");
			aluno.setPais(tec.next());

			aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
			aluno.setAnoDeNascimento(alunos.get(idAluno).getAnoDeNascimento());
			aluno.setEstado(alunos.get(idAluno).getEstado());
			aluno.setCidade(alunos.get(idAluno).getCidade());

			alunos.set(idAluno, aluno);

			break;

		case 4:

			System.out.println("---------------------EDITAR O ESTADO---------------------");

			System.out.println("Informe o novo estado: ");
			aluno.setEstado(tec.next());

			aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
			aluno.setAnoDeNascimento(alunos.get(idAluno).getAnoDeNascimento());
			aluno.setPais(alunos.get(idAluno).getPais());
			aluno.setCidade(alunos.get(idAluno).getCidade());

			alunos.set(idAluno, aluno);

			break;

		case 5:

			System.out.println("---------------------EDITAR CIDADE---------------------");
			System.out.println("Informe o novo nome da cidade: ");
			aluno.setCidade(tec.next());

			aluno.setNomeAluno(alunos.get(idAluno).getNomeAluno());
			aluno.setAnoDeNascimento(alunos.get(idAluno).getAnoDeNascimento());
			aluno.setPais(alunos.get(idAluno).getPais());
			aluno.setEstado(alunos.get(idAluno).getEstado());

			alunos.set(idAluno, aluno);

			break;

		default:
			System.out.println("Opção Inválida!");
		}

		return alunos;
	}

	public void excluirAluno(List<Aluno> alunos) {
		listarAlunos(alunos);
		if (alunos.isEmpty()) {
			return;
		}

		System.out.println("---------------------EXCLUIR ALUNO---------------------");

		System.out.print("Informe o ID do aluno para excluir: ");
		int idAluno = tec.nextInt() - 1;

		if (alunos.size() <= idAluno) {

			System.out.println("Aluno não cadastrado.");
			return;
		}

		alunos.remove(idAluno);
	}

	public void menu(List<Aluno> alunos) {

		boolean sair = false;

		do {

			System.out.println("\n--------------MENU--------------");
			System.out.println("1) CADASTRAR ALUNO");
			System.out.println("2) LISTAR ALUNOS CADASTRADOS");
			System.out.println("3) EDITAR ALUNOS");
			System.out.println("4) EXCLUIR ALUNOS");
			System.out.println("5) SAIR");
			System.out.println("---------------------------------");

			int opcao = leOpcao();

			switch (opcao) {

			case 1:

				alunos.add(cadastrarAluno());
				break;

			case 2:

				listarAlunos(alunos);
				break;

			case 3:
				editarAlunos(alunos);
				break;

			case 4:
				excluirAluno(alunos);

			case 5:
				sair = true;
				break;

			default:
				System.out.println("Opção inválida!!!");

			}

		} while (!sair);

	}
}
