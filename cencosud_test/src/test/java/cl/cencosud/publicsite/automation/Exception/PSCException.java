package cl.cencosud.publicsite.automation.Exception;

import cl.cencosud.publicsite.automation.flow.BaseFlow;

public class PSCException extends Exception{

private static final long serialVersionUID = 1L;
	
    public PSCException() {
    	super();
    }

    public PSCException(String message) {
    	super(message);
    }

    
    
    public PSCException(String message, Throwable cause) {
        super(message, cause);
    }

    public PSCException(Throwable cause) {
        super(cause);
    }
}
