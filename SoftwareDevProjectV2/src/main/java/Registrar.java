
import java.sql.Connection;
import java.sql.DriverManager;
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
                stmt.executeUpdate("INSERT INTO `hospitalSystem`.`Patient`\n" + "(" + "`firstName`,\n" + 
                        "`lastName`,\n" + "`dob`,\n" + "`address`,\n" + "`zip`,\n" + "`ssn`,\n" + "`insurance`,\n" + 
                        "`primaryPhys`,\n" + "`height`,\n" + "`weight`,\n" + "`vax1`,\n" + "`vax2`,\n" + "`symptom`,\n" + 
                        "`allergy`,\n" + "`meds`,\n" + "`alcdrug`)\n" + 
                        "VALUES\n" + "(" + nameFirst + ",\n" + nameLast +",\n" + dob + ",\n" +
                         address + ",\n" + zip + ",\n" + ssn + ",\n" + insurance + ",\n" + phys + ",\n" + height + ",\n" +
                         weight + ",\n" + vax1 + ",\n" + vax2 + ",\n" + symptom + ",\n" + allergy + ",\n" +
                         meds + ",\n" + alcdrug + ");");
        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
    }
}
