import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;

public class Physician extends EmergencyRoom{
    
    Scanner keyboard = new Scanner(System.in);
    
    //user input to search for patient
    String nameFirst = keyboard.nextLine();
    String nameLast = keyboard.nextLine();
    String ssn = keyboard.nextLine();          
    
    //variables for doctor to input
    String tests;
    String observation;
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
                stmt.executeUpdate("INSERT INTO `hospitalSystem`.`Patient`\n" + "(`Tests Required`,\n" 
                        + "`Observations`,\n" + "`Symptoms`,\n" + "`Discharge Information`,\n" 
                        + "`Prescribed Medications`,\n" + "`Diagnoses`,\n" + 
                        "VALUES\n" + "(AUTO_INCREMENT,\n" + tests + ",\n" + observation +",\n" + symptoms + 
                        ",\n" + discharge + ",\n" + medications + ",\n" + diagnoses + ");");
        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
    }

}
