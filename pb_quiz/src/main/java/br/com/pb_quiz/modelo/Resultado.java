package br.com.pb_quiz.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "resultados")
public class Resultado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private int acertos;
	private int erros;
	private LocalDate dataPartida = LocalDate.now();
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getAcertos() {
		return acertos;
	}


	public void setAcertos(int acertos) {
		this.acertos = acertos;
	}


	public int getErros() {
		return erros;
	}


	public void setErros(int erros) {
		this.erros = erros;
	}
	
	public LocalDate getDataPartida() {
		return dataPartida;
	}
	public void setDataPartida(LocalDate dataPartida) {
		this.dataPartida = dataPartida;
	}

}
