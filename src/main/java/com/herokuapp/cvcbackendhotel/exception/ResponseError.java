package com.herokuapp.cvcbackendhotel.exception;

/**
 * @author amart
 */
public class ResponseError {

	private String erro;
    private String exception;
	
    public ResponseError(String erro, String exception) {
		super();
		this.erro = erro;
		this.exception = exception;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}    

}
