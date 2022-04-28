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
    
    //variables to get results from database query
    int testID = 0;
    String dischargeInstruct = "";
    String diagnosis = "";
    int testPrice = 0;
    int medPrice = 0;
    String medName = "";
    String testName = "";
    int nightsStayed = 0;
    int nightPrice = 0;
    
    public void searchBill(String nameFirst, String nameLast, String ssn)
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
        
        //get number of nights stayed
        String ns = "select nightsStayed from nursePhysicianRecord where firstName = " 
                + nameFirst + " AND lastName = " + nameLast + " AND ssn = " + ssn + ";";
        
        
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
            
            prst = con.prepareStatement(ns);
            
            rs = prst.executeQuery();
            
            if(rs.next())
            {
                nightsStayed = rs.getInt(1);
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
            
            //get medication name
            String mn = "select medication from diagnosis where condition = " + diagnosis + ";";
            
            //get test name
            String tn = "select testName from tests where testID = " + testID + ";";
            
            
            
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
                
                //execute medication name query
                prst = con.prepareStatement(mn);
            
                rs = prst.executeQuery();
            
                if(rs.next())
                {
                    medName = rs.getString(1);
                }
                
                //execute test name query
                prst = con.prepareStatement(tn);
            
                rs = prst.executeQuery();
            
                if(rs.next())
                {
                    testName = rs.getString(1);
                }
            }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
            
            //calculates hospital stay price
            nightPrice = nightsStayed * 250;
        }
        
        //display list of prices and discharge instructions
        //this should be connected to GUI and run when search button is pressed
        public void printBill()
        {
            System.out.println("Item: \t Price:");
            System.out.println(medName + "\t" + medPrice);
            System.out.println(testName + "\t" + testPrice);
            System.out.println("Nights Stayed: " + nightsStayed + "\t" + nightPrice);
            System.out.println(dischargeInstruct);
        }
        
        
    
}
