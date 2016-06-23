package br.com.hack.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hack.rest.model.Address;
import br.com.hack.rest.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	public Address findByCep(String cep) {
		return addressRepository.findByCep(cep);
	}
}
