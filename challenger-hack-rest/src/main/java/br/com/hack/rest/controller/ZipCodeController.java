package br.com.hack.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.hack.rest.model.ZipCode;
import br.com.hack.rest.service.ZipCodeService;
import br.com.hack.rest.validator.ZipCodeValidator;

/**
 * @author Anderson
 *
 */
@RestController
public class ZipCodeController {

	@Autowired
	private ZipCodeService zipCodeService;
	
	@Autowired 
	private ZipCodeValidator zipCodeValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    binder.setValidator(zipCodeValidator);
	}
	
	@RequestMapping(value = "/buscarCep", 
			method = RequestMethod.POST, 
			produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ZipCode findByZipCode(@Valid @RequestBody String zipCode) {
		return zipCodeService.findByZipCode(zipCode);
	}
	
	@RequestMapping(value = "/listarCeps",
			method = RequestMethod.GET, 
	        produces = "application/json")
	public @ResponseBody List<ZipCode> get() {
		return zipCodeService.findAll();
	}
}
