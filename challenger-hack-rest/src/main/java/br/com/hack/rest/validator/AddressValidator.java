package br.com.hack.rest.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.hack.rest.exception.AddressException;
import br.com.hack.rest.model.Address;
import br.com.hack.rest.service.AddressService;

public class AddressValidator implements Validator {

	@Autowired
	private AddressService addressService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Address.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
//		String cep = (String) target;
//		Address address = addressService.findByCep(cep);
//		
//		if(address == null) {
//			throw new AddressException("CEP Inválido");
//		}

	}

}
