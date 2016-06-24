package br.com.hack.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hack.rest.model.ZipCode;
import br.com.hack.rest.repository.ZipCodeRepository;

@Service
public class ZipCodeService {

	@Autowired
	private ZipCodeRepository zipCodeRepository;
	
	public ZipCode findByZipCode(String zipCode) {
		return zipCodeRepository.findByZipCode(zipCode);
	}
	
}
