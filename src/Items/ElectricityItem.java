package Items;

import java.lang.Exception;

import Exceptions.ConsumptionPositiveException;
import Exceptions.PowerPositiveException;
import Exceptions.TurnOnItemException;

public abstract class ElectricityItem {
	
	private String name = null;
	private Integer power = 0;
	private int consumption = 0;
	Boolean turnedOn;
	
	
	//constructor
	public ElectricityItem (String name, int power, int consumption){
		this.name=name;
		
		this.power = power;
		this.consumption = consumption;
		turnedOn=false;
	
	}
	
		//getters and setters
		public String getName(){
		return name;
		}
	
		public void setName (String name){
		this.name = name;
		}
		
		public  int getPower(){
		return power;
		}
	
		public void setPower (int power) throws Exception{
			if(power<0)
			{
				throw new PowerPositiveException();
			}
			this.power = power;
		}
				
		public int getConsumption(){
		return consumption;
		}
	
		public void setConsumption (int consumption) throws Exception{
			
			if(consumption<0)
			{
				throw new ConsumptionPositiveException();
			}
			
		this.consumption = consumption;
		}
		
		public Boolean getTurnedOn(){
			return turnedOn;
			}
		
		public void setTurnedOn (Boolean turnedOn){
			this.turnedOn = turnedOn;
			}
		
		
		//create method Turn On
		public void turnOn(){
		
		turnedOn =true;
		}
		
		
		//create method Turn Off
		public void turnOff(){
		
		turnedOn =false;
		}
	
	
	 //create general for all items method "Working"
	 public String working() throws Exception 
	 
	 {
		 if(!turnedOn)
		 {			
			 throw new TurnOnItemException();
		 }	
		 
	    return "Work has started: ";
		 
	 }
	 
	 
	 	 
	//convert to String
	public String toString(){
		return( "[Item from: " + getClass()+ " name = " + name +" power= "+power +" consumption= "+ consumption+" turnedOn= "+ turnedOn + " ]");
	}
	
	

}
