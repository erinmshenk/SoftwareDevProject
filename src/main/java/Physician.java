import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

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
    
    //should be called when sumbit button is pushed by registrar
    public void updatePatient()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8888/hospitalSystem", "root", "root");
                Statement stmt = con.createStatement();
                //insert patient
                stmt.executeUpdate("INSERT INTO `hospitalSystem`.`Patient`\n" + "(`patientID`,\n" + "`firstName`,\n" + 
                        "`lastName`,\n" + "`dob`,\n" + "`address`,\n" + "`zip`,\n" + "`ssn`,\n" + "`insurance`,\n" + 
                        "`primaryPhys`,\n" + "`height`,\n" + "`weight`,\n" + "`vax1`,\n" + "`vax2`,\n" + "`symptom`,\n" + 
                        "`allergy`,\n" + "`meds`,\n" + "`alcdrug`)\n" + 
                        "VALUES\n" + "(AUTO_INCREMENT,\n" + nameFirst + ",\n" + nameLast +",\n" + dob + ",\n" +
                         address + ",\n" + zip + ",\n" + ssn + ",\n" + insurance + ",\n" + phys + ",\n" + height + ",\n" +
                         weight + ",\n" + vax1 + ",\n" + vax2 + ",\n" + symptom + ",\n" + allergy + ",\n" +
                         meds + ",\n" + alcdrug + ");");
        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
    }

}
