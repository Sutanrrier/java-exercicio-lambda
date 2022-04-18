package br.com.sutanrrier.entities;

public class Funcionario {
	private String nomeFunc;
	private String emailFunc;
	private Double salarioFunc;
	
	public Funcionario(String nomeFunc, String emailFunc, Double salarioFunc) {
		this.nomeFunc = nomeFunc;
		this.emailFunc = emailFunc;
		this.salarioFunc = salarioFunc;
	}

	public String getNomeFunc() {
		return nomeFunc;
	}

	public void setNomeFunc(String nomeFunc) {
		this.nomeFunc = nomeFunc;
	}

	public String getEmailFunc() {
		return emailFunc;
	}

	public void setEmailFunc(String emailFunc) {
		this.emailFunc = emailFunc;
	}

	public Double getSalarioFunc() {
		return salarioFunc;
	}

	public void setSalarioFunc(Double salarioFunc) {
		this.salarioFunc = salarioFunc;
	}
	
}
