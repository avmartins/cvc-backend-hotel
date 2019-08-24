package com.herokuapp.cvcbackendhotel.exception;

public class RecurseNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1936048420111996935L;
	private final String mensagemClient;

    public RecurseNotFoundException(String mensagemClient, String mensagemException) {
        super(mensagemException);
        this.mensagemClient = mensagemClient;
    }

	public String getMensagemClient() {
		return mensagemClient;
	}
    
    

}
