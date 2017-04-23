package Items;

public class VacuumCleaner extends ElectricityItem {
	
	
		
	//constructor
	public VacuumCleaner(String name, int power, int consumption) {
		super (name,power,consumption);
	}

	
	//create new items
	public static VacuumCleaner VacuumCleanerSamsung (){
		return new VacuumCleaner("Samsung", 800, 900);
			}
	
	public static VacuumCleaner VacuumCleanerLG (){
		return new VacuumCleaner("LG", 850, 950);
			}
	
	
	//Override general for all items method 
	
	public String working() throws Exception {
		
		return (super.working()+ "Cleaning is in progress");

	}


	public void turnOn() {
		// TODO Auto-generated method stub
		
	}

}
