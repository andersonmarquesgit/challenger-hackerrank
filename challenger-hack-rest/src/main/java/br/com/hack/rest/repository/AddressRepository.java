package br.com.hack.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hack.rest.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

	public Address findByCep(String cep);
}
