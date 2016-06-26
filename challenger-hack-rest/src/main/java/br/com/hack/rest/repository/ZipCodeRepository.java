package br.com.hack.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hack.rest.model.ZipCode;

/**
 * @author Anderson
 *
 */
@Repository
public interface ZipCodeRepository extends CrudRepository<ZipCode, Integer> {

	public ZipCode findByZipCode(String zipCode);
}
