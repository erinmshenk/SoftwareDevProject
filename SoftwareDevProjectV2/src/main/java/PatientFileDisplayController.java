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

public class PatientFileDisplayController implements Initializable {
    private Stage stage;
    private Scene scene;
    
    @FXML
    private Text firstNameText;
    @FXML
    private Text lastNameText;
    @FXML
    private Text dobText;
    @FXML
    private Text addressText;
    @FXML
    private Text zipText;
    @FXML
    private Text ssnText;
    @FXML
    private Text insuranceText;
    @FXML
    private Text physText;
    @FXML
    private Text heightText;
    @FXML
    private Text weightText;
    @FXML
    private Text vax1Text;
    @FXML
    private Text vax2Text;
    @FXML
    private Text symptomText;
    @FXML
    private Text medsText;
    @FXML
    private Text allergyText;
    @FXML
    private Text alcdrugText;
    @FXML
    private Text vitalsText;
    @FXML
    private Text nightsStayedText;
    @FXML
    private Text bloodPressureText;
    @FXML
    private Text admittanceText;
    @FXML
    private Text observationText;
    @FXML
    private Text pretreatmentText;  
    
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
        int vitals;
    int nightsStayed; 
    String bloodpressure;
    String admittance; 
    String observation; 
    String pretreatment;
    
    //Registrar r = new Registrar();
    
    //Nurse n = new Nurse();
    
     /*   
    public PatientFileDisplayController()
    {       
        firstNameText = new Text(r.nameFirst);
        
        lastNameText = new Text(r.nameLast);
        
        dobText = new Text(r.dob);
        
        addressText = new Text(r.address);
        
        zipText = new Text(r.zip);
        
        ssnText = new Text(r.ssn);
        
        insuranceText = new Text(r.insurance);
        
        physText = new Text(r.phys);
        
        heightText = new Text(Integer.toString(r.height));
        
        weightText = new Text(Integer.toString(r.weight));
        
        vax1Text = new Text(r.vax1);
       
        vax2Text = new Text(r.vax2);
        
        symptomText = new Text(r.symptom);
        
        medsText = new Text(r.meds);
        
        allergyText = new Text(r.allergy);
        
        alcdrugText = new Text(Boolean.toString(r.alcdrug));
        
        vitalsText = new Text(Integer.toString(n.vitals));
        
        nightsStayedText = new Text(Integer.toString(n.nightsStayed));
        
        bloodPressureText = new Text(n.bloodpressure);
        
        admittanceText = new Text(n.admittance);
        
        observationText = new Text(n.observation);
        
        pretreatmentText = new Text(n.pretreatment);  
    }
        
    */
//Patient File Display Controller
    @FXML
    private void editPatientData(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/PatientFileEdit.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Edit Patient File");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void returnToMainPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/NurseMainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Nurse Main Page");
        stage.setScene(scene);
        stage.show();
    }

    public void updateDisplayTable(){
        //fill the below lines with data based on from patientID

        //Registrar r = new Registrar();
        //Nurse n = new Nurse();
        
        //r.passInfo(n.nameFirst, n.nameLast, n.ssn);
        //n.passInfo();
        
        String i = "select * from Patient where firstName = '" + nameFirst + "' and lastName = '" + nameLast + "' and ssn = '" + ssn + "';";
        
        String j = "select vitals, nightsStayed, bloodpressure, admitted, observation, pretreatment nursePhysicianRecord where firstName = '" + nameFirst + "' and lastName = '" + nameLast + "' and ssn = '" + ssn + "';";
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/hospitalSystem", "root", "root");
            
            PreparedStatement prst = con.prepareStatement("select * from Patient where firstName = ? and lastName = ? and ssn = ?;");
            
            prst.setString(1, nameFirst);
            prst.setString(2, nameLast);
            prst.setString(3, ssn);
            
            ResultSet rs = prst.executeQuery();
            
            if(rs.next())
            {
                patientID = rs.getInt(1);
                 firstNameText.setText("First Name: " + rs.getString(2));
                //nameFirst = rs.getString(2);
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
            /*
           prst = con.prepareStatement("select vitals, nightsStayed, bloodpressure, admitted, observation, pretreatment nursePhysicianRecord where firstName = ? and lastName = ? and ssn = ?;");
            prst.setString(1, nameFirst);
            prst.setString(2, nameLast);
            prst.setString(3, ssn);
            
           rs = prst.executeQuery();
            
            if(rs.next())
            {
                vitals = rs.getInt(1);
                nightsStayed = rs.getInt(2);
                bloodpressure = rs.getString(3);
                admittance = rs.getString(4);
                observation = rs.getString(5);
                pretreatment = rs.getString(6);
            }*/
            firstNameText.setText("First Name: " + nameFirst);
        System.out.println(nameFirst + " 1");
        lastNameText.setText(nameLast);
        dobText.setText(dob);
        addressText.setText(address);
        zipText.setText(zip);
        ssnText.setText(ssn);
        insuranceText.setText(insurance);
        physText.setText(phys);
        heightText.setText(Integer.toString(height));
        weightText.setText(Integer.toString(weight));
        vax1Text.setText(vax1);
        vax2Text.setText(vax2);
        symptomText.setText(symptom);
        allergyText.setText(allergy);
        medsText.setText(meds);
        alcdrugText.setText(Boolean.toString(alcdrug));
        vitalsText.setText(Integer.toString(vitals));
        nightsStayedText.setText(Integer.toString(nightsStayed));
        bloodPressureText.setText(bloodpressure);
        admittanceText.setText(admittance);
        pretreatmentText.setText(pretreatment);
        observationText.setText(observation);
        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
        
        firstNameText.setText("First Name: " + nameFirst);
        System.out.println(nameFirst + " 1");
        lastNameText.setText(nameLast);
        dobText.setText(dob);
        addressText.setText(address);
        zipText.setText(zip);
        ssnText.setText(ssn);
        insuranceText.setText(insurance);
        physText.setText(phys);
        heightText.setText(Integer.toString(height));
        weightText.setText(Integer.toString(weight));
        vax1Text.setText(vax1);
        vax2Text.setText(vax2);
        symptomText.setText(symptom);
        allergyText.setText(allergy);
        medsText.setText(meds);
        alcdrugText.setText(Boolean.toString(alcdrug));
        vitalsText.setText(Integer.toString(vitals));
        nightsStayedText.setText(Integer.toString(nightsStayed));
        bloodPressureText.setText(bloodpressure);
        admittanceText.setText(admittance);
        pretreatmentText.setText(pretreatment);
        observationText.setText(observation);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateDisplayTable();
    }
}
