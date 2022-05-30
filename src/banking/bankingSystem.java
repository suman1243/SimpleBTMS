package banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class bankingSystem {
	
	

	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		System.out.println("1. New User");
		System.out.println("2. Exsiting User");
		System.out.println("Enter your choice:(1 or 2)");
		String val=sc.nextLine();
		Connection c= Connect.connect();
		PreparedStatement ps;
		
		switch(val) {
		case "1":
//			System.out.println("1");
			System.out.println("Enter your name");
			String name=sc.nextLine();
			System.out.println("Enter Password");
			String pass=sc.nextLine();
			System.out.println("Enter Confirm Password");
			String conpas=sc.nextLine();
			if (!pass.equals(conpas))
			{
				System.out.println("Password and Confirm password don not match");
				break;
			}
			try {
				
				ps= c.prepareStatement("Insert into bankinguser(name,password) values(?,?)");
				ps.setString(1, name);
				ps.setString(2,pass);
				ps.execute();
				
				System.out.println("new user created");
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case "2":
			System.out.println("Enter account no");
			String accno=sc.nextLine();
			System.out.println("Enter Password");
			String existingpass=sc.nextLine();
			try {
				ps=c.prepareStatement("Select * from bankinguser where accnum='"+accno+"' and password='"+existingpass+"'");
				ResultSet rs= ps.executeQuery();
				if (rs.next()) {
					String username=rs.getString("name");
					System.out.println(username+" Logged in successfully");
				}
				else {
					break;
				}
			} catch (Exception e) {
				System.out.println("");
			}
			
			break;
		default:
				System.out.println("Invalid select");
			
		}
	}

}
