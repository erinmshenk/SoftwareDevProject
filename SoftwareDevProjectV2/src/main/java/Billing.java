import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erinshenk
 */
public class Billing 
{
    Scanner keyboard = new Scanner(System.in);
    
    //user input to search for patient
    String nameFirst = keyboard.nextLine();
    String nameLast = keyboard.nextLine();
    String ssn = keyboard.nextLine();
    
    //variables to get results from database query
    int testID = 0;
    String dischargeInstruct = "";
    String diagnosis = "";
    int testPrice = 0;
    int medPrice = 0;
    
    public void searchBill()
    {
        //query for testID
        String q = "SELECT testID from nursePhysicianRecord join Patient "
                + "on nursePhysicianRecord.patientID = Patient.patientID"
                + "WHERE firstName = " + nameFirst + " AND lastName = " + nameLast + " AND ssn = " + ssn + ";";
        //query for discharge instructions
        String di = "SELECT discharge from nursePhysicianRecord join Patient "
                + "on nursePhysicianRecord.patientID = Patient.patientID"
                + "WHERE firstName = " + nameFirst + " AND lastName = " + nameLast + " AND ssn = " + ssn + ";";
        //query for diagnosis
        String ds =  "SELECT diagnosis from nursePhysicianRecord join Patient "
                + "on nursePhysicianRecord.patientID = Patient.patientID"
                + "WHERE firstName = " + nameFirst + " AND lastName = " + nameLast + " AND ssn = " + ssn + ";";
        
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8888/hospitalSystem", "root", "root");
            
            java.sql.PreparedStatement prst = null;
            
            //execute testID query
            prst = con.prepareStatement(q);
            
            ResultSet rs = prst.executeQuery();
            
            if(rs.next())
            {
                testID = rs.getInt(1);
            }
            
            //execute discharge instructions query
            prst = con.prepareStatement(di);
            
            rs = prst.executeQuery();
            
            if(rs.next())
            {
                dischargeInstruct = rs.getString(1);
            }
            
            //execute diagnosis query
            prst = con.prepareStatement(ds);
            
            rs = prst.executeQuery();
            
            if(rs.next())
            {
                diagnosis = rs.getString(1);
            }
        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
        
    }
        
        //getting prices from database
        public void compileBill()
        {
            //query statements
            //get test price
            String tp = "select price from tests where testID = " + testID + ";";
            
            //get medication price
            String mp = "select price from diagnosis where condition = " + diagnosis + ";";
            
            
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8888/hospitalSystem", "root", "root");
            
                java.sql.PreparedStatement prst = null;
                
                //execute discharge instructions query
                prst = con.prepareStatement(tp);
                
                ResultSet rs = prst.executeQuery();
            
                rs = prst.executeQuery();
            
                if(rs.next())
                {
                    testPrice = rs.getInt(1);
                }
                
                //execute discharge instructions query
                prst = con.prepareStatement(mp);
            
                rs = prst.executeQuery();
            
                if(rs.next())
                {
                    medPrice = rs.getInt(1);
                }
            }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
        }
        
        
    
}
