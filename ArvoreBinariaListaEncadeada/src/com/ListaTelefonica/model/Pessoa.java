package com.ListaTelefonica.model;

public class Pessoa<T> implements Comparable<Pessoa> {

	private String nome;
	private String telefone;
	
	public Pessoa()
	{
		nome = null;
		telefone = null;
	}
	
	public Pessoa(String nome)
	{
		this.nome = nome;
		this.telefone = null;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int compareTo(Pessoa arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
