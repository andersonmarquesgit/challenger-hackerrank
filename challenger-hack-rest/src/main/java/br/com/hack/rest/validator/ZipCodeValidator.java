package br.com.hack.rest.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.hack.rest.exception.ZipCodeException;
import br.com.hack.rest.model.ZipCode;
import br.com.hack.rest.service.ZipCodeService;

public class ZipCodeValidator implements Validator {

	@Autowired
	private ZipCodeService zipCodeService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ZipCode.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ZipCode zipCode = zipCodeService.findByZipCode((String) target);
		
		if(zipCode == null) {
			throw new ZipCodeException("CEP Inválido");
		}

	}

}
