package br.com.hack.rest.exception;

public class AddressCreateException extends BusinessException {
	private static final long serialVersionUID = 8149208640082122854L;

	public AddressCreateException(String mensagem) {
		super(mensagem);
	}
}
