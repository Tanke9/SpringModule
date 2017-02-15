package es.planetmedia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.planetmedia.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{
	 Account findByNumber(String number);
}
