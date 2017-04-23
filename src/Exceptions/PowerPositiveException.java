package Exceptions;

import java.lang.Exception;

public class PowerPositiveException extends Exception{
	
	public PowerPositiveException(){
		super("Error: Power is negative");
	}
	
	public PowerPositiveException(String message){
		super(message);
	}
}
