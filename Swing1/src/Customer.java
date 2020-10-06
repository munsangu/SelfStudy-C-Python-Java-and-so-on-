import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Customer
{ 	
//	public static void main(String[] args) 
//	{
//		createTable();
//		createCustomer("1111","MSW","123456789","Male","29","Random Note....");
//		ArrayList<String> list = getCustomers();
//		for(String item: list) 
//		{
//			System.out.println(item);
//		}
//		createCustomer("2222","ICU","987654321","FeMale","25","Customer");
//		list = getCustomers();
//		for(String item: list) 
//		{
//			System.out.println(item);
//		}
//	}
	public static String[][] getCustomers()
	{
		try 
		{
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select id, name, phone,gender,age,note FROM customer");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) 
			{
				list.add(new String [] {
						results.getString("id"),
						results.getString("name"),
						results.getString("phone"),
						results.getString("gender"),
						results.getString("age"),
						results.getString("note")});
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][6];
			return list.toArray(arr);
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	public static void createCustomer(String id ,String name, String phone,String gender,String age ,String note) 
	{
		try 
		{
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO customer"
					+ "(id,name,phone,gender,age,note)"
					+ "VALUES "
					+"('"+id+"','"+name+"','"+phone+"','"+gender+"','"+age+"','"+note+"')");
					// ('id','name','phone','gender','age','note')
			insert.executeUpdate();
			System.out.println("The data has been saved!");
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}		
	}
	public static void createTable() 
	{
		try 
		{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE customer "
					+ "(id varChar2(20) PRIMARY KEY, "
					+ "name varChar2(20),"
					+ "phone varChar2(20),"
					+ "gender varChar2(20),"
					+ "age varChar2(20),"
					+ "note varChar2(20))"
					);
			create.execute();
			System.out.println("Table successfully created");
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	public static Connection getConnection() 
	{
		try 
		{
			String driver = "oracle.jdbc.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "system";
			String pass = "123456";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("The Connection Successful");
			return con;
			
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
}
