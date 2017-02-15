package es.planetmedia.api;

public class AccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7013986397902652607L;

	public AccountNotFoundException (String accountId){
		super("No such account with id: " + accountId);
	}
}
