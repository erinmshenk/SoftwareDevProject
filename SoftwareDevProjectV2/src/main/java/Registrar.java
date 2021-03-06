
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
        int patientID;
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
    
    public Registrar(String nameFirst1, String nameLast1, String ssn1)
    {
        nameFirst = nameFirst1;
        nameLast = nameLast1;
        ssn = ssn1;
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
    
    public void passInfo(String nameFirst1, String nameLast1, String ssn1)
    {
        String i = "select * from Patient where firstName = '" + nameFirst1 + "' and lastName = '" + nameLast1 + "' and ssn = '" + ssn1 + "';";
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/hospitalSystem", "root", "root");
            
            PreparedStatement prst = con.prepareStatement("select * from Patient where firstName = ? and lastName = ? and ssn = ?;");
            
            prst.setString(1, nameFirst1);
            prst.setString(2, nameLast1);
            prst.setString(3, ssn1);
            
            ResultSet rs = prst.executeQuery();
            
            if(rs.next())
            {
                patientID = rs.getInt(1);
                nameFirst = rs.getString(2);
                nameLast = rs.getString(3);
                dob = rs.getString(4);
                address = rs.getString(5);
                zip = rs.getString(6);
                ssn = rs.getString(7);
                insurance = rs.getString(8);
                phys = rs.getString(9);
                height = rs.getInt(10);
                weight = rs.getInt(11);
                vax1 = rs.getString(12);
                vax2 = rs.getString(13);
                symptom = rs.getString(14);
                allergy = rs.getString(15);
                meds = rs.getString(16);
                alcdrug = rs.getBoolean(17);
            }
            
        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
    }
}
