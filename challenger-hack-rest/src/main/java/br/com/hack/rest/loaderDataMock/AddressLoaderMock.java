package br.com.hack.rest.loaderDataMock;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.hack.rest.model.Address;
import br.com.hack.rest.model.ZipCode;
import br.com.hack.rest.repository.AddressRepository;
import br.com.hack.rest.repository.ZipCodeRepository;

/**
 * @author Anderson
 *
 */
@Component
public class AddressLoaderMock implements ApplicationListener<ContextRefreshedEvent> {

	private Logger log = Logger.getLogger(AddressLoaderMock.class);
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ZipCodeRepository zipCodeRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ZipCode zipCode01 = new ZipCode();
		zipCode01.setId(null);
		zipCode01.setZipCode("01135040");
		zipCode01.setStreet("Rua Ângelo Catapano");
		zipCode01.setNeighborhood("Barra Funda");
		zipCode01.setCity("São Paulo");
		zipCode01.setState("SP");
		zipCodeRepository.save(zipCode01);
		
		ZipCode zipCode02 = new ZipCode();
		zipCode02.setId(null);
		zipCode02.setZipCode("03066054");
		zipCode02.setStreet("Viela Ângelo de Branco");
		zipCode02.setNeighborhood("Tatuapé");
		zipCode02.setCity("São Paulo");
		zipCode02.setState("SP");
		zipCodeRepository.save(zipCode02);
		
		ZipCode zipCode03 = new ZipCode();
		zipCode03.setId(null);
		zipCode03.setZipCode("05077140");
		zipCode03.setStreet("Praça Ângelo Rivetti");
		zipCode03.setNeighborhood("Lapa");
		zipCode03.setCity("São Paulo");
		zipCode03.setState("SP");
		zipCodeRepository.save(zipCode03);
		
		Address address01 = new Address();
		address01.setNumber("101");
		address01.setZipCode(zipCode01);
		addressRepository.save(address01);
        log.info("Saved Address01 - id: " + address01.getId());
		
		Address address02 = new Address();
		address02.setNumber("102");
		address02.setZipCode(zipCode02);
		addressRepository.save(address02);
        log.info("Saved Address02 - id: " + address02.getId());
		
		Address address03 = new Address();
		address03.setNumber("103");
		address03.setZipCode(zipCode03);
		addressRepository.save(address03);
        log.info("Saved Address03 - id: " + address03.getId());
		
		Address address04 = new Address();
		address04.setNumber("104");
		address04.setZipCode(zipCode01);
		addressRepository.save(address04);
        log.info("Saved Address04 - id: " + address04.getId());
		
		Address address05 = new Address();
		address05.setNumber("105");
		address05.setZipCode(zipCode02);
		addressRepository.save(address05);
        log.info("Saved Address05 - id: " + address05.getId());
		
		Address address06 = new Address();
		address06.setNumber("106");
		address06.setZipCode(zipCode03);
		addressRepository.save(address06);
        log.info("Saved Address06 - id: " + address06.getId());
		
	}

}
