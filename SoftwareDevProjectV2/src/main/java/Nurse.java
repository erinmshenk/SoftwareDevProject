import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;

public class Nurse extends EmergencyRoom{
    
    Scanner keyboard = new Scanner(System.in);
    
    //user input to search for patient
    String nameFirst = keyboard.nextLine();
    String nameLast = keyboard.nextLine();
    String ssn = keyboard.nextLine();

    //variables for nurse to input
    int vitals;
    int nightsstayed;
    String bloodpressure;
    String admittance;
    String observation;
    String pretreatment;
    
    //should be called when sumbit button is pushed by Nurse
    public void updatePatient()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8888/hospitalSystem", "root", "root");
                Statement stmt = con.createStatement();
                //insert data inputed by Nurse
                stmt.executeUpdate("INSERT INTO `hospitalSystem`.`Patient`\n" + "(`Vitals`,\n" + "`Nights Stayed`,\n" + 
                        "`Blood pressure`,\n" + "`Is patient Admitted`,\n" + "`Observation`,\n" + "`Pre-Treatment`,\n" + 
                        "VALUES\n" + "(AUTO_INCREMENT,\n" + vitals + ",\n" + nightsstayed +",\n" + bloodpressure + 
                        ",\n" + admittance + ",\n" + observation + ",\n" + pretreatment + ");");
        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
    }

}