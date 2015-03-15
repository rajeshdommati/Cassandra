package com.datastax.cassandra.cassandra_driver_core;
import com.datastax.driver.core.*;
//import com.example.cassandra.*;
/**
 * Hello world!
 *
 */
public class App 
{
	private Cluster cluster;
	private Session session;
	public void connect (String node){
		cluster = Cluster.builder()
		         .addContactPoint(node)
		         .build();
		session = cluster.connect();
		Metadata metadata =cluster.getMetadata();
		System.out.print(" Connected to cluster -->" +metadata.getClusterName());

		System.out.println("\n selecting users table data \n");
		ResultSet results = session.execute("SELECT first_name FROM mykeyspace.	users " + "WHERE user_id=1;");
		
		for (Row row : results)
		{
			//System.out.println(row.getString("first_name"), row.getString("last_name"), row.getInt("user_id"));
			String firstname= row.getString("first_name");
			System.out.println(" guest's firstname is -->>" + firstname);
		}
		
	}
	
public void close ()
{cluster.close();}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	App client= new App();	
	client.connect("10.0.0.50");
	client.close();
	//client.retiveData();
	}

}
	