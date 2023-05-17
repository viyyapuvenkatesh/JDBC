import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Jdbc {
	public static void main(String[] args) {
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    System.out.println("Driver Found Successfully..");
		    //URL with IP address.
		    //jdbc:mysql:192.168.10.44:portNumber/databasename
		    
		    //URL with local host
		    //jdbc:mysql://localhost:portNumber/databasename
		    
		    String url = "jdbc:mysql://localhost:3306/data";
		    String username = "root";
		    String password = "root";
		    
		    Connection con;
		    
		    con = DriverManager.getConnection(url,username,password);
		    
		    System.out.println("Connected with Database Successfully...");
		    /*
		    Statement st = con.createStatement();
		    
		    String query = "insert into student values(10001,'venky','Male','viyyapuv4@gmail.com')";
		    
		    st.execute(query);
		    System.out.println("Data has been inserted Successfully...");
		    */
		    
		    Scanner scan = new Scanner(System.in);
		    
		    System.out.println("Enter the Course Id ");
		    int cid = scan.nextInt();
		    scan.nextLine();
		    System.out.println("Enter the Course Name ");
		    String cname = scan.nextLine();
		    
		    System.out.println("Enter Course Duration ");
		    int duration = scan.nextInt();
		    System.out.println("Enter Course fee ");
		    double fee = scan.nextDouble();
		    System.out.println("Course Status ");
		    String status = scan.next();
		    
		    String query = "insert into venky values(?,?,?,?,?)";
		    
		    PreparedStatement ps = con.prepareStatement(query);
		    ps.setInt(1, cid);
		    ps.setString(2, cname);
		    ps.setInt(3, duration);
		    ps.setDouble(4, fee);
		    ps.setString(5, status);
		    ps.execute();
		    
		    System.out.println("Data has been inserted Successfully...");
		   
		}catch(ClassNotFoundException e) {
			System.out.println("Unable to find the Driver class.");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}


