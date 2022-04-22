import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Statement;

public class Physician{
    
    Scanner keyboard = new Scanner(System.in);
    
    //user input to search for patient
    String nameFirst = keyboard.nextLine();
    String nameLast = keyboard.nextLine();
    String ssn = keyboard.nextLine();          
    
    //variables for doctor to input
    String tests;
    String observations;
    String symptoms;
    String discharge;
    String medications;
    String diagnoses;
    
    //should be called when sumbit button is pushed by Physician
    public void updatePatient()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8888/hospitalSystem", "root", "root");
                Statement stmt = con.createStatement();
                //insert data inputed by Physician
               PreparedStatement prst = con.prepareStatement("INSERT INTO `hospitalSystem`.`Patient`\n" + "(" + "`tests`,\n" + 
                        "`observations`,\n" + "`symptoms`,\n" + "`discharge`,\n" + "`medications`,\n" + "`diagnoses`)\n" + 
                        "VALUES\n" + "(?, ?, ?, ?, ?, ?);");
                
                prst.setString(1, tests);
                prst.setString(2, observations);
                prst.setString(3, symptoms);
                prst.setString(4, discharge);
                prst.setString(5, medications);
                prst.setString(6, diagnoses);
        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
    }

}
