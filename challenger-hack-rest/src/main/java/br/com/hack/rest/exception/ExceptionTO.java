package br.com.hack.rest.exception;

import java.io.Serializable;

public class ExceptionTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mensagem;

	public ExceptionTO(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}