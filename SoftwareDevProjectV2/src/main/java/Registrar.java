
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Statement;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erinshenk
 */
public class Registrar
{
        String nameFirst;
        String nameLast;
        String dob; 
        String address; 
        String zip; 
        String ssn; 
        String insurance;
        String phys;
        int height; 
        int weight;
        String vax1;
        String vax2;
        String symptom;
        String allergy; 
        String meds;
        boolean alcdrug; 
        
    public Registrar(String nameFirst, String nameLast, String dob, String address, String zip, String ssn, String insurance, String phys,
            int height, int weight, String vax1, String vax2, String symptom, String allergy, String meds, boolean alcdrug)
    {
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.dob = dob; 
        this.address = address; 
        this.zip = zip; 
        this.ssn = ssn; 
        this.insurance = insurance;
        this.phys = phys;
        this.height = height; 
        this.weight = weight;
        this.vax1 = vax1;
        this.vax2 = vax2;
        this.symptom = symptom;
        this.allergy = allergy; 
        this.meds = meds;
        this.alcdrug = alcdrug;            
    }
    
    public Registrar()
    {
        
    }
    
    //should be called when sumbit button is pushed by registrar
    public void insertPatient()
    {
        try
        {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/hospitalSystem", "root", "root");

                //insert patient
                
                PreparedStatement prst = con.prepareStatement("INSERT INTO `hospitalSystem`.`Patient`\n" + "(" + "`firstName`,\n" + 
                        "`lastName`,\n" + "`dob`,\n" + "`address`,\n" + "`zip`,\n" + "`ssn`,\n" + "`insurance`,\n" + 
                        "`primaryPhys`,\n" + "`height`,\n" + "`weight`,\n" + "`vax1`,\n" + "`vax2`,\n" + "`symptom`,\n" + 
                        "`allergy`,\n" + "`meds`,\n" + "`alcdrug`)\n" + 
                        "VALUES\n" + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
                prst.setString(1, nameFirst);
                prst.setString(2, nameLast);
                prst.setString(3, dob);
                prst.setString(4, address);
                prst.setString(5, zip);
                prst.setString(6, ssn);
                prst.setString(7, insurance);
                prst.setString(8, phys);
                prst.setInt(9, height);
                prst.setInt(10, weight);
                prst.setString(11, vax1);
                prst.setString(12, vax2);
                prst.setString(13, symptom);
                prst.setString(14, allergy);
                prst.setString(15, meds);
                prst.setBoolean(16, alcdrug);
                
                prst.executeUpdate();
        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
    }
    
    public void passInfo()
    {
        String i = "select * from Patient";
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/hospitalSystem", "root", "root");
            
            PreparedStatement prst = con.prepareStatement(i);
            
            ResultSet rs = prst.executeQuery();
            
            if(rs.next())
            {
                nameFirst = rs.getString(1);
                nameLast = rs.getString(2);
                dob = rs.getString(3);
                address = rs.getString(4);
                zip = rs.getString(5);
                ssn = rs.getString(6);
                insurance = rs.getString(7);
                phys = rs.getString(8);
                height = rs.getInt(9);
                weight = rs.getInt(10);
                vax1 = rs.getString(11);
                vax2 = rs.getString(12);
                symptom = rs.getString(13);
                allergy = rs.getString(14);
                meds = rs.getString(15);
                alcdrug = rs.getBoolean(16);
            }
            
        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
    }
}
