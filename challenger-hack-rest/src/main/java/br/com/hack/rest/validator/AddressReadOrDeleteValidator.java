package br.com.hack.rest.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.hack.rest.exception.AddressException;
import br.com.hack.rest.service.AddressService;

/**
 * @author Anderson
 *
 */
@Component
public class AddressReadOrDeleteValidator implements Validator {

	@Autowired
	private AddressService addressService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Integer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Integer addressId = (Integer) target;
        
		if(addressService.findById(addressId) == null){
			throw new AddressException("O endereço não foi encontrado!");
		}

	}

}
