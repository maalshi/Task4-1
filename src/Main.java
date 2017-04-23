import java.io.*;
import java.util.ArrayList;

import DataBase.DataService;
import DataBase.MsSqlDataService;

import Items.ElectricityItem;

public class Main {
	   

		public static void main(String[] args) throws IOException {
		
			
			DataService dataService= new MsSqlDataService();
			ArrayList<ElectricityItem> dbList=dataService.GetData();
			System.out.println(dbList);
			
		

		}	

	
}
		

