package br.com.hack.rest.repository;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.hack.rest.model.Address;
import br.com.hack.rest.model.ZipCode;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {br.com.hack.rest.RepositoryConfiguration.class })
public class AddressRepositoryTest {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ZipCodeRepository zipCodeRepository;
	

	@Test
	public void testSaveAddress() {
		ZipCode zipCode01 = new ZipCode();
		zipCode01.setId(null);
		zipCode01.setZipCode("01135040");
		zipCode01.setStreet("Rua Ângelo Catapano");
		zipCode01.setNeighborhood("Barra Funda");
		zipCode01.setCity("São Paulo");
		zipCode01.setState("SP");
		// Salva o cep, verifica o ID após salvar
		assertNull(zipCode01.getId()); // null antes de salvar
		zipCodeRepository.save(zipCode01);
		assertNotNull(zipCode01.getId()); // not null depois de salvar
		
		Address address01 = new Address();
		address01.setNumber("101");
		address01.setZipCode(zipCode01);
		// Salva endereço, verifica o ID após salvar
		assertNull(address01.getId()); // null antes de salvar
		addressRepository.save(address01);
		assertNotNull(address01.getId()); // not null depois de salvar

		// buscar no BD
		Address fetchedAddress = addressRepository.findOne(address01.getId());

		// não deve ser nulo
		assertNotNull(fetchedAddress);

		// deve ser igual
		assertEquals(address01.getId(), fetchedAddress.getId());
		assertEquals(address01.getNumber(), fetchedAddress.getNumber());

		// atualiza numero e complemento
		fetchedAddress.setNumber("novo111");
		fetchedAddress.setComplement("novoComplemento");
		addressRepository.save(fetchedAddress);

		// buscar no BD, deve estar atualizado
		Address fetchedUpdatedAddress = addressRepository.findOne(fetchedAddress.getId());
		assertEquals(fetchedAddress.getNumber(), fetchedUpdatedAddress.getNumber());

		// verifica quantidade de endereços no BD, deve ser 1
		long addressCount = addressRepository.count();
		assertEquals(addressCount, 1);

		// busca todos os endereços, a lista deve ter apenas 1
		Iterable<Address> addressList = addressRepository.findAll();

		int count = 0;

		for (Address address : addressList) {
			count++;
		}

		assertEquals(count, 1);
	}
}
