package ProgramaController;

import java.util.Scanner;

public class Menu {
Scanner tec = new Scanner(System.in);
	
	public void listarMenu() {
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
}
