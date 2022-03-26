package Modules;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Main {

    
    public static void main(String args[]) throws IOException, SQLException, ClassNotFoundException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Username : ");
		String username=br.readLine();
		System.out.println("Password : ");
		Integer password=Integer.parseInt(br.readLine());
		Login l=new Login(username, password);
		System.out.println();
		
		System.out.println("****************************************Welcome*****************************************");
		System.out.println();
		System.out.println("*********HAPPINESS IS LOOKING DOWN AT YOUR NEXT DESTINATION FROM A PLANE WINDOW*********");
		System.out.println();
		
		
	System.out.println("Enter the name of the Aircraft");
	String aircraftName=br.readLine();
	System.out.println("Enter the source");
	String sources=br.readLine();
	System.out.println("Enter the destination");
	String destination = br.readLine();
	System.out.println("Enter the type of Flight\n1.Public Aircraft\n2.Private Aircraft");
	int choice=Integer.parseInt(br.readLine());
	if(choice==1)
		{
		System.out.println("Is the flight check in before two hours");
		String ans = br.readLine();
		Boolean b1;
		if(ans.equals("yes"))
		{
		  b1=true;	
		}
		else
		{
			b1=false;
		}
		System.out.println("Enter the number of kgs allowed per person");
		int noOfKgsallowed=Integer.parseInt(br.readLine());
		
		System.out.println("Enter the additional fee charged for extra baggage per Kg");
		float additionalFeeperkg=Float.parseFloat(br.readLine());
		
		
		Aircraft b = new PublicAircraft(aircraftName,sources,destination,noOfKgsallowed,additionalFeeperkg,b1);
		System.out.println("Flight Details :");
		System.out.println();
		System.out.println("Public Aircraft:");
		System.out.println();
		b.displayDetails();
		System.out.println();
		System.out.println("Are you sure to reserve the Ticket (Yes/No) ");
		String t=br.readLine();
		System.out.println();
		
		if(!t.equals("No"))
			{
		    System.out.println("*************!!!!!!!Your Ticket Booking is Reserved Successfully !!!!!!!***************");
		    System.out.println();
		    System.out.println("A Mile of Highway will Take you a Mile. A Mile of Runway will Take You AnyWhere !");
		    System.out.println();
		    System.out.println("******************Have a Happy Journey***********************");
		    System.out.println();
		    
		    Class.forName("com.mysql.cj.jdbc.Driver");
		 	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline1","root","root");
		 	   PreparedStatement ps = con.prepareStatement("INSERT INTO airdata1 VALUES(?,?,?,?,?)");
			   ps.setString(1, aircraftName);
			   ps.setString(2, sources);
			   ps.setString(3, destination);
			   ps.setInt(4, noOfKgsallowed);
			   ps.setFloat(5, additionalFeeperkg);
			   int i = ps.executeUpdate();
			   
			   Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline1","root","root");
			  
				
				PreparedStatement ps1 = con1.prepareStatement("SELECT * FROM airdata1");
				//ps.setInt(5, personal_number);
				ResultSet rs = ps1.executeQuery();
				
				System.out.printf("%-15s%-15s%-15s%-15s\n","Aircraft","Source","Destination","NOofKgsAllowed","AdditionalFeeperKg");
				System.out.println();
				while(rs.next()) 
				{
					System.out.printf("%-15s%-15s%-15s%-15s\n", rs.getString(1), rs.getString(3),rs.getString(2),rs.getString(4),rs.getString(5));
				}
		    
		    
		    
		     }
		        else{
		         System.out.println("*************!!!!!!Your Ticket Booking is cancelled!!!!!!**************");
		         System.out.println();
		         System.out.println("Looking forward to help you");
		         System.out.println();
		         System.out.println("**********Make ur life with full of memories by travelling all over the world**********");
		        }

		
		
	}
	
	if(choice==2)
	{
		System.out.println("Is the flight check in before two hours");
		Boolean ans = Boolean.parseBoolean(br.readLine());
		System.out.println("Enter the name of the pilot chose");
		String pilotPreference=br.readLine();
		System.out.println("Enter the Purpose of your flight");
		String purpose=br.readLine();
		
		
		Aircraft b = new PrivateAircraft(aircraftName,sources,destination,ans,pilotPreference,purpose);
		System.out.println("Flight Details :");
		System.out.println();
		System.out.println("Private Aircraft:");
		System.out.println();
		b.displayDetails();
		System.out.println();
		System.out.println("Are you sure to reserve the Ticket (Yes/No) ");
		String t=br.readLine();
		System.out.println();
		if(!t.equals("No"))
			{
		    System.out.println("*****************!!!!!!!Your Ticket Booking is Reserved Successfully !!!!!!!*****************");
		    System.out.println("A Mile of Highway will Take you a Mile. A Mile of Runway will Take You AnyWhere !");
		    System.out.println();
		    System.out.println("******************Have a Happy Journey***********************");
		    
		    Class.forName("com.mysql.cj.jdbc.Driver");
		 	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline1","root","root");
		 	   PreparedStatement ps = con.prepareStatement("INSERT INTO airdata2 VALUES(?,?,?,?,?)");
			   ps.setString(1, aircraftName);
			   ps.setString(2, sources);
			   ps.setString(3, destination);
			   ps.setString(4,pilotPreference );
			   ps.setString(5,purpose );
			   int i = ps.executeUpdate();
			   
			   Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline1","root","root");
			  
				
				PreparedStatement ps1 = con1.prepareStatement("SELECT * FROM airdata2");
				//ps.setInt(5, personal_number);
				ResultSet rs = ps1.executeQuery();
				
				System.out.printf("%-15s%-15s%-15s%-15s\n","Aircraft","Source","Destination","Pilot Name","purpose");
				System.out.println();
				while(rs.next()) 
				{
					System.out.printf("%-15s%-15s%-15s%-15s\n", rs.getString(1), rs.getString(3),rs.getString(2),rs.getString(4),rs.getString(5));
				}
		    
				
		     }
		        else{
		         System.out.println("******************!!!!!!Your Ticket Booking is cancelled!!!!!!********************");
		         System.out.println();
		         
		         System.out.println("Looking forward to help you");
		         System.out.println();
		         System.out.println("**********Make ur life with full of memories by travelling all over the world**********");
		        }


		
	}
	
	 
	 
	
	
	
	
	
	
	
		
}
}
