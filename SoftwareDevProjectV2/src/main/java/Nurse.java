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
    
    //variables to get results from patient file
//    String insurance = insurance;
//    String phys = phys;
//    String height = height; 
//    String weight = weight;
//    String vax1 = vax1;
//    String vax2 = vax2;
//    String symptom = symptom;
//    String allergy = allergy; 
//    String meds = meds;
//    String alcdrug = alcdrug;   
    
//    public void searchNurse()
//    {
//        //query for patient's insurance
//        String in = "SELECT patient's insurance provider "
//                + "WHERE firstName = " + nameFirst + " AND lastName = " + nameLast + " AND ssn = " + ssn + ";";
//        
//        //query for patient's primary care provider
//        String pcp = "SELECT patient's primary care provider "
//                + "WHERE firstName = " + nameFirst + " AND lastName = " + nameLast + " AND ssn = " + ssn + ";";
//        
//        //query for patient's height
//        String h =  "SELECT patient's height "
//                + "WHERE firstName = " + nameFirst + " AND lastName = " + nameLast + " AND ssn = " + ssn + ";";
//        
//        //query for patient's weight
//        String w = "SELECT patient's weight "
//                + "WHERE firstName = " + nameFirst + " AND lastName = " + nameLast + " AND ssn = " + ssn + ";";
//        
//        //query for patient's first covid vaccine provider
//        String v1 = "SELECT patient's first covid vaccine provider "
//                + "WHERE firstName = " + nameFirst + " AND lastName = " + nameLast + " AND ssn = " + ssn + ";";
//        
//        //query for patient's second covid vaccine provider
//        String v2 =  "SELECT patient's second covid vaccine provider "
//                + "WHERE firstName = " + nameFirst + " AND lastName = " + nameLast + " AND ssn = " + ssn + ";";
//        
//        //query for patient's symptoms
//        String s = "SELECT the patient's symptoms "
//                + "WHERE firstName = " + nameFirst + " AND lastName = " + nameLast + " AND ssn = " + ssn + ";";
//        
//        //query for patient's allergies
//        String a = "SELECT the patient's allergies "
//                + "WHERE firstName = " + nameFirst + " AND lastName = " + nameLast + " AND ssn = " + ssn + ";";
//        
//        //query for patient's medications
//        String m =  "SELECT all known medications for the patient "
//                + "WHERE firstName = " + nameFirst + " AND lastName = " + nameLast + " AND ssn = " + ssn + ";";
//        
//        //query for patient's alcohol or drug use
//        String sa = "SELECT if the patient has a substance abuse issue "
//                + "WHERE firstName = " + nameFirst + " AND lastName = " + nameLast + " AND ssn = " + ssn + ";";
//       
//        try
//        {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8888/hospitalSystem", "root", "root");
//            
//            java.sql.PreparedStatement prst = null;
//            
//            //execute testID query
//            prst = con.prepareStatement(in);
//            
//            ResultSet rs = prst.executeQuery();
//            
//            if(rs.next())
//            {
//                insurance = rs.getString();
//            }
//            
//            //execute discharge instructions query
//            prst = con.prepareStatement(pcp);
//            
//            rs = prst.executeQuery();
//            
//            if(rs.next())
//            {
//                phys = rs.getString();
//            }
//            
//            //execute diagnosis query
//            prst = con.prepareStatement(h);
//            
//            rs = prst.executeQuery();
//            
//            if(rs.next())
//            {
//                height = rs.getString();
//            }
//            
//            prst = con.prepareStatement(w);
//            
//            rs = prst.executeQuery();
//            
//            if(rs.next())
//            {
//                weight = rs.getString();
//            }
//            
//             //execute testID query
//            prst = con.prepareStatement(v1);
//            
//            ResultSet rs = prst.executeQuery();
//            
//            if(rs.next())
//            {
//                vax1 = rs.getString(1);
//            }
//            
//             //execute testID query
//            prst = con.prepareStatement(v2);
//            
//            ResultSet rs = prst.executeQuery();
//            
//            if(rs.next())
//            {
//                vax2 = rs.getString(1);
//            }
//            
//             //execute testID query
//            prst = con.prepareStatement(s);
//            
//            ResultSet rs = prst.executeQuery();
//            
//            if(rs.next())
//            {
//                symptom = rs.getString();
//            }
//            
//             //execute testID query
//            prst = con.prepareStatement(a);
//            
//            ResultSet rs = prst.executeQuery();
//            
//            if(rs.next())
//            {
//                allergy = rs.getString();
//            }
//            
//             //execute testID query
//            prst = con.prepareStatement(m);
//            
//            ResultSet rs = prst.executeQuery();
//            
//            if(rs.next())
//            {
//                meds = rs.getString();
//            }
//            
//             //execute testID query
//            prst = con.prepareStatement(sa);
//            
//            ResultSet rs = prst.executeQuery();
//            
//            if(rs.next())
//            {
//                alcdrug = rs.getString();
//            }
//        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
//        
//    }
//        
//    //should be called when sumbit button is pushed by Nurse
//    public void updatePatient()
//    {
//        try
//        {
//            Class.forName("com.mysql.jdbc.Driver");
//                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8888/hospitalSystem", "root", "root");
//                Statement stmt = con.createStatement();
//                //insert data inputed by Nurse
//                PreparedStatement prst = con.prepareStatement("INSERT INTO `hospitalSystem`.`nursePhysicianRecord`\n" + "(" + "`vitals`,\n" + 
//                        "`nightsStayed`,\n" + "`bloodpressure`,\n" + "`admitted`,\n" + "`observation`,\n" + "`pretreatment`)\n" + 
//                        "VALUES\n" + "(?, ?, ?, ?, ?, ?);");
//                
//                prst.setInt(1, vitals);
//                prst.setInt(2, nightsStayed);
//                prst.setString(3, bloodpressure);
//                prst.setString(4, admittance);
//                prst.setString(5, observation);
//                prst.setString(6, pretreatment);
//        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
//    }
//    
//    public void passInfo()
//    {
//        String i = "select vitals, nightsStayed, bloodpressure, admitted, observation, pretreatment nursePhysicianRecord";
//        
//        try
//        {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/hospitalSystem", "root", "root");
//            
//            PreparedStatement prst = con.prepareStatement(i);
//            
//            ResultSet rs = prst.executeQuery();
//            
//            if(rs.next())
//            {
//                vitals = rs.getString(1);
//                nightsStayed = rs.getString(2);
//                bloodpressure = rs.getString(3);
//                admittance = rs.getString(4);
//                observation = rs.getString(5);
//                pretreatment = rs.getString(6);
//            }
//            
//        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
//        PatientFileDisplayController p = new PatientFileDisplayController(vitals, nightsStayed, bloodpressure, admittance, observation, pretreatment);
//    }
}
