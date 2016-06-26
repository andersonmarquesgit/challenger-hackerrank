package br.com.hack.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.hack.rest.exception.AddressException;
import br.com.hack.rest.model.Address;
import br.com.hack.rest.model.ZipCode;
import br.com.hack.rest.repository.AddressRepository;

/**
 * @author Anderson
 *
 */
@Service
public class AddressService {

	public static final String REST_SERVICE_ZIP_CODE_URI = "http://localhost:8080/buscarCep";

	@Autowired
	private AddressRepository addressRepository;

	/**
	 * Método responsável pela criação do endereço de usuário
	 * @param address
	 * @return O address inserido
	 */
	public Address create(Address address) {
		address.setZipCode(findByZipCode(address));
		return addressRepository.save(address);
	}

	/**
	 * Método responsável por buscar um endereço pelo ID
	 * @param id
	 * @return address
	 */
	public Address findById(Integer id) {
		return addressRepository.findOne(id);
	}

	/**
	 * Método responsável por atualizar um endereço existente
	 * @param address
	 * @return O address atualizado
	 */
	public Address update(Address address) {
		return addressRepository.save(address);
	}

	/**
	 * Método responsável por deletar um endereço de usuário pelo ID
	 * @param id
	 */
	public void deleteById(Integer id) {
		addressRepository.delete(id);
	}

	/**
	 * Método responsável por listar todos os endereços de usuários cadastrados no sistema
	 * @return Lista de endereços
	 */
	public List<Address> findAll() {
		return (List<Address>) addressRepository.findAll();
	}

	/**
	 * Método responsável por usar o serviço REST (buscaCep) e retonar um CEP para o cadastro de endereço de usuário
	 * @param address
	 * @return zipCode
	 */
	public ZipCode findByZipCode(Address address) {
		RestTemplate restTemplate = new RestTemplate();
		ZipCode zipCode = null;
		try {
			zipCode = restTemplate.postForObject(REST_SERVICE_ZIP_CODE_URI, address.getZipCode().getZipCode(),
					ZipCode.class);
			address.setZipCode(zipCode);
			if (zipCode == null) {
				zipCode = address.getZipCode();
			}
		} catch (HttpClientErrorException e) {
			throw new AddressException("Erro durante operação. Os dados não foram inseridos/alterados!");
		}

		return zipCode;
	}
}
