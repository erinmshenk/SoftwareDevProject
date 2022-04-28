import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BillingSearchDisplayController implements Initializable {
    private Stage stage;
    private Scene scene;
    

    @FXML
    private Text medNameT, medPriceT, testNameT, testPriceT, nightsStayedText, nightPriceT;    
    
     int testID = 0;
    String dischargeInstruct = "";
    String diagnosis = "";
    int testPrice = 0;
    int medPrice = 0;
    String medName = "";
    String testName = "";
    int nightsStayed = 0;
    int nightPrice = 0;
    String nameFirst;
    String nameLast;
    String ssn;
    
    
    public BillingSearchDisplayController(String nameFirst, String nameLast, String dob, String address, String zip, String ssn, String insurance, String phys,
            int height, int weight, String vax1, String vax2, String symptom, String allergy, String meds, boolean alcdrug)
    {
//        medNameText = new Text(medName);
//        medPriceText = new Text(nameLast);
//        testNameText = new Text(dob);
//        testPriceText = new Text(address);
//        zipText = new Text(zip);
//        ssnText = new Text(ssn);
//        insuranceText = new Text(insurance);
//        physText = new Text(phys);
//        heightText = new Text(Integer.toString(height));
//        weightText = new Text(Integer.toString(weight));
//        vax1Text = new Text(vax1);
//        vax2Text = new Text(vax2);
//        symptomText = new Text(symptom);
//        medsText = new Text(meds);
//        allergyText = new Text(allergy);
//        alcdrugText = new Text(Boolean.toString(alcdrug));
    }
    
    public BillingSearchDisplayController(int vitals, int nightsStayed, String bloodpressure, String admittance, String observation, String pretreatment)
    {
//        vitalsText = new Text(Integer.toString(vitals));
//        nightsStayedText = new Text(Integer.toString(nightsStayed));
//        bloodPressureText = new Text(bloodpressure);
//        admittanceText = new Text(admittance);
//        observationText = new Text(observation);
//        pretreatmentText = new Text(pretreatment);  
    }
    
    public BillingSearchDisplayController()
    {
        
    }
    
    
//Billing Search Display Controller (display bill)
    @FXML
    private void returnToMainPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/BillingMainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Nurse Main Page");
        stage.setScene(scene);
        stage.show();
    }

    public void updateDisplayTable(){
        //fill this with the same code from PatientFileDisplayController (nurse)
        //left empty for now
        //Billing test = new Billing();
        //this.nameFirst = test.getNameF();
        //System.out.println("testing " + nameFirst);
        //test.searchBill(nameFirst, nameLast, ssn);
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/hospitalSystem", "root", "root");
            
           java.sql.PreparedStatement prst = null;
          
            
            //execute testID query
            prst = con.prepareStatement("SELECT testID from nursePhysicianRecord join Patient on nursePhysicianRecord.patientID = Patient.patientID WHERE firstName = ? AND lastName = ? AND ssn = ?;");
            prst.setString(1, "John");
            prst.setString(2, "Doe");
            prst.setString(3, "222-22-2222");
            
            ResultSet rs = prst.executeQuery();
            
            if(rs.next())
            {
                testID = rs.getInt(1);
            }
            
            //execute discharge instructions query
            prst = con.prepareStatement("SELECT discharge from nursePhysicianRecord join Patient on nursePhysicianRecord.patientID = Patient.patientID WHERE firstName = ? AND lastName = ? AND ssn = ?;");
            
            prst.setString(1, "John");
            prst.setString(2, "Doe");
            prst.setString(3, "222-22-2222");
            
            rs = prst.executeQuery();
            
            if(rs.next())
            {
                dischargeInstruct = rs.getString(1);
            }
            
            //execute diagnosis query
            prst = con.prepareStatement("SELECT diagnosis from nursePhysicianRecord join Patient "
                + "on nursePhysicianRecord.patientID = Patient.patientID"
                + " WHERE firstName = ? AND lastName = ? AND ssn = ?;");
            
            prst.setString(1, "John");
            prst.setString(2, "Doe");
            prst.setString(3, "222-22-2222");
            
            rs = prst.executeQuery();
            
            if(rs.next())
            {
                diagnosis = rs.getString(1);
            }
            
            prst = con.prepareStatement("select nightsStayed from nursePhysicianRecord where firstName = ? AND lastName = ? AND ssn = ?;");
            
            prst.setString(1, "John");
            prst.setString(2, "Doe");
            prst.setString(3, "222-22-2222");
            
            rs = prst.executeQuery();
            
            if(rs.next())
            {
                nightsStayed = rs.getInt(1);
            }
            
             prst = con.prepareStatement("select price from tests where testID = ?;");
             
             prst.setInt(1, testID);
                
               rs = prst.executeQuery();
            
                rs = prst.executeQuery();
            
                if(rs.next())
                {
                    testPrice = rs.getInt(1);
                }
                
                //execute discharge instructions query
                prst = con.prepareStatement("select price from diagnosis where condition = ?;");
            
                prst.setString(1, diagnosis);
                rs = prst.executeQuery();
            
                if(rs.next())
                {
                    medPrice = rs.getInt(1);
                }
                
                //execute medication name query
                prst = con.prepareStatement("select medication from diagnosis where condition = ?;");
            
                prst.setString(1, diagnosis);
                rs = prst.executeQuery();
            
                if(rs.next())
                {
                    medName = rs.getString(1);
                }
                
                //execute test name query
                prst = con.prepareStatement("select testName from tests where testID = ?;");
            
                prst.setInt(1, testID);
                rs = prst.executeQuery();
            
                if(rs.next())
                {
                    testName = rs.getString(1);
                }
            
        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
        
        nightPrice = nightsStayed * nightPrice;
        
        medNameT.setText(medName); 
        medPriceT.setText(Integer.toString(medPrice));
        testNameT.setText(testName);
        testPriceT.setText(Integer.toString(testPrice));
        nightsStayedText.setText(Integer.toString(nightsStayed));
        nightPriceT.setText(Integer.toString(nightPrice));
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateDisplayTable();

    }
}
