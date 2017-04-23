package DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import Items.ElectricityItem;
import Items.Fan;
import Items.Refrigirator;
import Items.VacuumCleaner;

public class MsSqlDataService implements DataService {

	

	@Override
	public ArrayList<ElectricityItem> GetData() {
		
		ArrayList<ElectricityItem> list = new ArrayList<ElectricityItem>();
		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
        	try {
        		// Establish the connection.
        		
        		        		
    			SQLServerDataSource ds = new SQLServerDataSource();
    			ds.setIntegratedSecurity(true);
    			ds.setServerName("SHAND-PC\\MSSQLSERVER2012");
    			ds.setPortNumber(1433); 
    			ds.setDatabaseName("Electricity");
    			con = ds.getConnection();

    					            
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "SELECT TOP 10 * FROM [Electricity].[dbo].[Device]";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
            
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
            			int type=rs.getInt("TypeId");
            			ElectricityItem item;
            			switch(type)
            			{
            			case 1:
            				item=new VacuumCleaner(rs.getString("Name"), rs.getInt("Power"),rs.getInt("Consumption"));
            				break;
            			case 2:
            				item=new Fan(rs.getString("Name"), rs.getInt("Power"),rs.getInt("Consumption"));
            				break;
            			case 3:
            				item=new Refrigirator(rs.getString("Name"), rs.getInt("Power"),rs.getInt("Consumption"));
            				break;
            			default:
            				item=new Refrigirator(rs.getString("Name"), rs.getInt("Power"),rs.getInt("Consumption"));
            				break;
            			}
            			
            			list.add(item);
            		}
            		return list;
        	}
        
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
			return list;

	}

}
