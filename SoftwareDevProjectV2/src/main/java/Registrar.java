
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
  
    //should be called when sumbit button is pushed by registrar
    public void insertPatient(String nameFirst, String nameLast, String dob, String address, String zip, String ssn, String insurance, String phys,
            int height, int weight, String vax1, String vax2, String symptom, String allergy, String meds, boolean alcdrug)
    {
        System.out.println("it actually printed!!!!!");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/hospitalSystem", "root", "root");
                Statement stmt = con.createStatement();
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
}
