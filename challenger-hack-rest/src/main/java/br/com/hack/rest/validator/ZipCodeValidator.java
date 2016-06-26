package br.com.hack.rest.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.hack.rest.exception.ZipCodeException;
import br.com.hack.rest.model.ZipCode;
import br.com.hack.rest.service.ZipCodeService;

/**
 * @author Anderson
 *
 */
@Component
public class ZipCodeValidator implements Validator {

	@Autowired
	private ZipCodeService zipCodeService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return String.class.equals(clazz);
	}

	@Override
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void validate(Object target, Errors errors) {
		String zipCode = (String) target;
		ZipCode zCode = zipCodeService.findByZipCode(zipCode);
		
		if(zCode == null) {
			throw new ZipCodeException("CEP Inválido");
		}
	}

}
