import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Statement;

public class Nurse{
    
        int vitals;
        int nightsStayed; 
        String bloodpressure;
        String admittance; 
        String observation; 
        String pretreatment;
        
    public Nurse(int vitals, int nightsStayed, String bloodpressure, String admittance, String observation, String pretreatment)
    {
        vitals = vitals;
        nightsStayed = nightsStayed; 
        bloodpressure = bloodpressure;
        admittance = admittance; 
        observation = observation; 
        pretreatment = pretreatment;
    }
    
    /**
     *
     */
    public Nurse()
    {
        
    }
    
    Scanner keyboard = new Scanner(System.in);
    
    //user input to search for patient
    String nameFirst = keyboard.nextLine();
    String nameLast = keyboard.nextLine();
    String ssn = keyboard.nextLine();

    
    //should be called when sumbit button is pushed by Nurse
    public void updatePatient()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8888/hospitalSystem", "root", "root");
                Statement stmt = con.createStatement();
                //insert data inputed by Nurse
                PreparedStatement prst = con.prepareStatement("INSERT INTO `hospitalSystem`.`nursePhysicianRecord`\n" + "(" + "`vitals`,\n" + 
                        "`nightsStayed`,\n" + "`bloodpressure`,\n" + "`admitted`,\n" + "`observation`,\n" + "`pretreatment`)\n" + 
                        "VALUES\n" + "(?, ?, ?, ?, ?, ?);");
                
                prst.setInt(1, vitals);
                prst.setInt(2, nightsStayed);
                prst.setString(3, bloodpressure);
                prst.setString(4, admittance);
                prst.setString(5, observation);
                prst.setString(6, pretreatment);
        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
    }
    
    public void passInfo()
    {
        String i = "select vitals, nightsStayed, bloodpressure, admitted, observation, pretreatment nursePhysicianRecord";
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/hospitalSystem", "root", "root");
            
            PreparedStatement prst = con.prepareStatement(i);
            
            ResultSet rs = prst.executeQuery();
            
            if(rs.next())
            {
                vitals = rs.getInt(1);
                nightsStayed = rs.getInt(2);
                bloodpressure = rs.getString(3);
                admittance = rs.getString(4);
                observation = rs.getString(5);
                pretreatment = rs.getString(6);
            }
            
        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
        PatientFileDisplayController p = new PatientFileDisplayController(vitals, nightsStayed, bloodpressure, admittance, observation, pretreatment);
    }
}
