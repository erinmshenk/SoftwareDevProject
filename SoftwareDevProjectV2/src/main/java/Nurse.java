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
    String nameFirst;
    String nameLast;
    String ssn;
    
    public Nurse(int vitals, int nightsStayed, String bloodpressure, String admittance, String observation, String pretreatment)
    {
        this.vitals = vitals;
        this.nightsStayed = nightsStayed; 
        this.bloodpressure = bloodpressure;
        this.admittance = admittance; 
        this.observation = observation; 
        this.pretreatment = pretreatment;
    }
    
    //recieve patient info for query
    public Nurse(String nameFirst1, String nameLast1, String ssn1)
    {
        nameFirst = nameFirst1;
        nameLast = nameLast1;
        ssn = ssn1;
    }
    
    //do not delete
    public Nurse()
    {
        
    }
    
    //searches for patient file
    public Boolean searchPatient(String nameFirst, String nameLast, String ssn)
    {
        String sp = "select * from patient where firstName = '" + nameFirst + "' and lastName = '" + nameLast + "' and ssn = '" + ssn + "';";
       
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/hospitalSystem", "root", "root");
            Statement stmt = con.createStatement();
            
            PreparedStatement prst = con.prepareStatement("select * from Patient where firstName = ? and lastName = ? and ssn = ?;");
            
            prst.setString(1, nameFirst);
            prst.setString(2, nameLast);
            prst.setString(3, ssn);
            
            ResultSet rs = prst.executeQuery();
            
            if(rs.absolute(1))
            {
                //passInfo(nameFirst, nameLast, ssn);
                //Registrar r = new Registrar();
                //r.passInfo(nameFirst, nameLast, ssn);
                return true;               
            }
            
            else
            {
                return false;
            }
            
        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
        
        return false;
    }
    

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
    
    public void passInfo(String nameFirst1, String nameLast1, String ssn1)
    {
        String i = "select vitals, nightsStayed, bloodpressure, admitted, observation, pretreatment nursePhysicianRecord where firstName = '" + nameFirst1 + "' and lastName = '" + nameLast1 + "' and ssn = '" + ssn1 + "';";
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/hospitalSystem", "root", "root");
            
            PreparedStatement prst = con.prepareStatement("select vitals, nightsStayed, bloodpressure, admitted, observation, pretreatment nursePhysicianRecord where firstName = ? and lastName = ? and ssn = ?;");
            prst.setString(1, nameFirst1);
            prst.setString(2, nameLast1);
            prst.setString(3, ssn1);
            
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
    }
}
