import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Statement;

public class Nurse{
    
    Scanner keyboard = new Scanner(System.in);
    
    //user input to search for patient
    String nameFirst = keyboard.nextLine();
    String nameLast = keyboard.nextLine();
    String ssn = keyboard.nextLine();

    //variables for nurse to input
    int vitals;
    int nightsStayed;
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
                PreparedStatement prst = con.prepareStatement("INSERT INTO `hospitalSystem`.`Patient`\n" + "(" + "`vitals`,\n" + 
                        "`nightsStayed`,\n" + "`bloodpressure`,\n" + "`admittance`,\n" + "`observation`,\n" + "`pretreatment`)\n" + 
                        "VALUES\n" + "(?, ?, ?, ?, ?, ?);");
                
//                prst.setString(1, vitals);
//                prst.setString(2, nightsStayed);
                prst.setString(3, bloodpressure);
                prst.setString(4, admittance);
                prst.setString(5, observation);
                prst.setString(6, pretreatment);
        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
    }

}
