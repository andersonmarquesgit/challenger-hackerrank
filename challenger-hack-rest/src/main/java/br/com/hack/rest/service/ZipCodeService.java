package br.com.hack.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hack.rest.model.ZipCode;
import br.com.hack.rest.repository.ZipCodeRepository;

/**
 * @author Anderson
 *
 */
@Service
public class ZipCodeService {

	@Autowired
	private ZipCodeRepository zipCodeRepository;
	
	/**
	 * Método responsável por buscar um CEP (rua, bairro, cidade, estado) pelo número postal
	 * @param zipCode
	 * @return zipCode
	 */
	public ZipCode findByZipCode(String zipCode) {
		ZipCode zCode = zipCodeRepository.findByZipCode(zipCode);
		
		if(zCode == null && zipCode.length() == 8){
			StringBuilder newZipCode = new StringBuilder(zipCode); 

			for (int i = zipCode.length()-1; i >= 0; i--) {
				newZipCode.setCharAt(i,'0'); 
				zipCode = newZipCode.toString();
				zCode = zipCodeRepository.findByZipCode(zipCode);
				if(zCode != null) {
					break;
				}
			}
		}
		
		return zCode;
	}

	
	/**
	 * Método responsável por listar todos os CEPs cadastrados no sistema
	 * @return
	 */
	public List<ZipCode> findAll() {
		return (List<ZipCode>) zipCodeRepository.findAll();
	}
	
    /**
     * Método responsável por validar o tamanho do cep informado
     * @param zipCode
     * @return true ou false
     */
    public static Boolean validZipCode(String zipCode)
    {
        if (zipCode.length() == 8)
        {
        	return true;
        }
        return false;
    }
	
}
