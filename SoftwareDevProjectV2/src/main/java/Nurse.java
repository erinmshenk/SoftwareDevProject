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
        this.vitals = vitals;
        this.nightsStayed = nightsStayed; 
        this.bloodpressure = bloodpressure;
        this.admittance = admittance; 
        this.observation = observation; 
        this.pretreatment = pretreatment;
    }
    
    
    //do not delete
    public Nurse()
    {
        
    }
    
}
