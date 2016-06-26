package br.com.hack.rest.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.hack.rest.exception.AddressException;
import br.com.hack.rest.model.Address;
import br.com.hack.rest.service.AddressService;

/**
 * @author Anderson
 *
 */
@Component
public class AddressCreateOrUpdateValidator implements Validator {

	@Autowired
	private AddressService addressService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Address.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Address address = (Address) target;
		
		if(addressService.findByZipCode(address) == null){
			throw new AddressException("Erro durante operação. Os dados não foram inseridos/alterados!");
		}

	}

}
