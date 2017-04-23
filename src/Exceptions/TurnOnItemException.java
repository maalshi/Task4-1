package Exceptions;

import java.lang.Exception;

public class TurnOnItemException extends Exception {
	
	//create my exception
	public TurnOnItemException(){
		super("Error: Item is turned off");
	}
	
	public TurnOnItemException(String message){
		super(message);
	}

}
