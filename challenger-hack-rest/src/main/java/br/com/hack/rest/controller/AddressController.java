package br.com.hack.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.hack.rest.model.Address;
import br.com.hack.rest.service.AddressService;
import br.com.hack.rest.validator.AddressCreateOrUpdateValidator;
import br.com.hack.rest.validator.AddressReadOrDeleteValidator;

/**
 * @author Anderson
 *
 */
@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;

	@Autowired 
	private AddressCreateOrUpdateValidator addressCreateOrUpdateValidator;
	
	@Autowired
	private AddressReadOrDeleteValidator addressReadOrDeleteValidator;
	
	@RequestMapping(value = "/create", 
			method = RequestMethod.POST, 
			produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Address save(@RequestBody Address address, BindingResult result) {
		addressCreateOrUpdateValidator.validate(address, result);
		return addressService.create(address);
	}
	
	@RequestMapping(value = "/read", 
			method = RequestMethod.POST, 
			produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Address read(@RequestBody Integer id, BindingResult result) {
		addressReadOrDeleteValidator.validate(id, result);
		return addressService.findById(id);
	}
	
	@RequestMapping(value = "/update", 
			method = RequestMethod.POST, 
			produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Address update(@RequestBody Address address, BindingResult result) {
		addressCreateOrUpdateValidator.validate(address, result);
		return addressService.update(address);
	}
	
	@RequestMapping(value = "/delete", 
			method = RequestMethod.DELETE, 
			produces = "application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@RequestBody Integer id, BindingResult result) {
		addressReadOrDeleteValidator.validate(id, result);
		addressService.deleteById(id);
	}
	
	@RequestMapping(value = "/listarEnderecos",
			method = RequestMethod.GET, 
	        produces = "application/json")
	public @ResponseBody List<Address> get() {
		return addressService.findAll();
	}
}
