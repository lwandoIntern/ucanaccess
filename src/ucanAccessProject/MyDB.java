package ucanAccessProject;

import java.sql.*;

public class MyDB {
    private static Connection conn;
    private static PreparedStatement ps = null;
    private static Statement s = null;

    public void Load()
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            System.out.println("Driver successfully loaded");

        }catch(ClassNotFoundException c)
        {
            System.out.println("Unable to load database driver");
        }

    }


    //Connect to the database
    public Connection Connect()
    {
        try
        {
            String filename = "C:\\Users\\Nceba\\Downloads\\ProgramUcanaccess\\CustomerDetails.accdb";
            String database = "jdbc:ucanaccess://";
            database+= filename.trim() + ";DriverID=22;READONLY=true}";
            conn = DriverManager.getConnection(database, "", "");

            System.out.println("Connection to MyDB database successful");

        }catch(Exception e)
        {
            System.out.println("Unable to load database");
        }
        return conn;
    }

    public static void CreateStockTakingTable(int id, String currentDate, String clothingItem, int totalStock, int currentStock, int stockAfterDeductions)
    {
        //Loop Forwards////////////
        try
        {
            String createTable = "Create Table stockIntake(id Integer, currentDate varchar(32), clothingItem varchar(32), totalStock Integer, currentStock Integer, stockAfterDeductions Integer)";
            System.out.println("I am creating a StockIntake table");
            s = conn.createStatement();
            s.executeUpdate(createTable);
            String sql;

            //Enter value into table
            for(int i = 0; i < 30; i++)
            {
                sql = "INSERT INTO StockIntake(id, currentDate, clothingItem, totalStock, currentStock, stockAfterDeductions) VALUES (?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);

                ps.setInt(1, id);
                ps.setString(2, currentDate);
                ps.setString(3, clothingItem);
                ps.setInt(4, totalStock);
                ps.setInt(5, currentStock);
                ps.setInt(6, stockAfterDeductions);
                ps.executeUpdate(createTable);
            }//End of while

            //Fetch table
            String selTable = "Select * FROM StockIntake";
            s.execute(selTable);
            ResultSet rs = s.getResultSet();
            if(rs != null)
            {
                while(rs.next())
                {
                    System.out.println(rs.getInt(1) + " : " + rs.getString(2)+ " : " + rs.getString(3)+ " : " + rs.getInt(4)+ " : " + rs.getInt(5)+ " : " + rs.getInt(6));
                }
            }
            //drop the table
            String dropTable = "Drop Table StockIntake";
            s.execute(dropTable);

            s.close();
            conn.close();

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void insertCustomerIntoTable(int id, String currentDate, String customerID, String customerName, String customerSurname, String customerEmail, String customerPhoneNo, String tellerEmail) {
//Loop Forwards////////////
        try
        {
            String createTable = "Create Table customerdetails(id Integer, CurrentDate varchar(32), CustomerID varchar(32), CustomerName varchar(32), CustomerSurname varchar(32), CustomerEmail varchar(32), CustomerPhoneNo varchar(32), TellerEmail varchar(32))";
            System.out.println("I am creating a customerdetails table");
            s = conn.createStatement();
            s.executeUpdate(createTable);
            String sql;

            //Enter value into table
            for(int i = 0; i < 30; i++)
            {
                sql = "INSERT INTO customerdetails(ID, CurrentDate, CustomerID, CustomerName, CustomerSurname, CustomerEmail, CustomerPhoneNo, TellerEmail) VALUES (?,?,?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);

                ps.setInt(1, id);
                ps.setString(2, currentDate);
                ps.setString(3, customerID);
                ps.setString(4, customerName);
                ps.setString(5, customerSurname);
                ps.setString(6, customerEmail);
                ps.setString(7, customerPhoneNo);
                ps.setString(8, tellerEmail);
                ps.executeUpdate(createTable);
            }//End of while

            //Fetch table
            String selTable = "Select * FROM customerdetails";
            s.execute(selTable);
            ResultSet rs = s.getResultSet();
            if(rs != null)
            {
                while(rs.next())
                {
                    System.out.println(rs.getInt(1) + " : " + rs.getString(2)+ " : " + rs.getString(3)+ " : " + rs.getString(4)+ " : " + rs.getString(5)+ " : " + rs.getString(6) + rs.getString(7) + rs.getString(8));
                }
            }
            //drop the table
            String dropTable = "Drop Table customerdetails";
            s.execute(dropTable);

            s.close();
            conn.close();

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
