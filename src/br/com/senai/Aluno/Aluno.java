package br.com.senai.Aluno;

import br.com.senai.Curso.Curso;
import br.com.senai.Endereco.Endereco;


public class Aluno extends Endereco {
	
	//ATRIBUTOS
	
		private String nomeAluno;
		private int anoDeNascimento;
		private int idadeAluno;
		private Curso curso;
		
		//METODOS
		public String getNomeAluno() {
			return nomeAluno;
		}
		public void setNomeAluno(String nomeAluno) {
			this.nomeAluno = nomeAluno;
		}
		public int getAnoDeNascimento() {
			return anoDeNascimento;
		}
		public void setAnoDeNascimento(int anoDeNascimento) {
			this.anoDeNascimento = anoDeNascimento;
		}
		public int getIdadeAluno() {
			return idadeAluno;
		}
		public void setIdadeAluno(int idadeAluno) {
			this.idadeAluno = idadeAluno;
		}
		public Curso getCurso() {
			return curso;
		}
		public void setCurso(Curso curso) {
			this.curso = curso;
		}
	}