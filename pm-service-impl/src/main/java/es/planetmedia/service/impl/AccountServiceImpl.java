package es.planetmedia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import es.planetmedia.api.AccountNotFoundException;
import es.planetmedia.api.AccountService;
import es.planetmedia.entity.Account;
import es.planetmedia.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Value("${dummy.type}")
    private String dummyType;
	
	@Autowired
	private AccountRepository accountRepository;
	
	/**
     * {@inheritDoc}
     * <p/>
     * Dummy method for testing purposes.
     * 
     * @param number The account number. Set 0000 to get an {@link AccountNotFoundException} 
     */
	@Override
	public Account findOne(String number) throws AccountNotFoundException {
		 if(number.equals("0000")) {
	            throw new AccountNotFoundException("0000");
	        }
	        
	        Account account = accountRepository.findByNumber(number);
	        if(account == null){
	          account = createAccountByNumber(number);
	        }

	        return account;
	}

	@Override
	public Account createAccountByNumber(String number) {
		Account account = new Account();
		account.setNumber(number);
		return accountRepository.save(account);
	}
	
	public String getDummyType() {
        return dummyType;
    }

    public void setDummyType(String dummyType) {
        this.dummyType = dummyType;
    }

}
