package Exceptions;

import java.lang.Exception;

public class ConsumptionPositiveException extends Exception{
	public ConsumptionPositiveException(){
		super("Error: Power is negative");
	}
	
	public ConsumptionPositiveException(String message){
		super(message);
	}
}
