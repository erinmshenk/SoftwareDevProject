import java.io.IOException;
import java.net.URL;
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
    
    Registrar r = new Registrar();
    
    Nurse n = new Nurse();
    
    
    public PatientFileDisplayController()
    {
        //to get most up to date data
        r.passInfo();
        
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
    }
    
    public PatientFileDisplayController(int vitals, int nightsStayed, String bloodpressure, String admittance, String observation, String pretreatment)
    {
        vitalsText = new Text(Integer.toString(n.vitals));
        
        nightsStayedText = new Text(Integer.toString(n.nightsStayed));
        
        bloodPressureText = new Text(n.bloodpressure);
        
        admittanceText = new Text(n.admittance);
        
        observationText = new Text(n.observation);
        
        pretreatmentText = new Text(n.pretreatment);  
    }
    
    
    
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

    public void updateDisplayTable(String patientID){
        //fill the below lines with data based on from patientID
        
        Nurse ns = new Nurse();
        String firstName = ns.getPatientFirstName();
        String lastName = ns.getPatientLastName();
        String dob = ns.getPatientDOB();
        boolean alcdrug = ns.getPatientAlcDrug();

        firstNameText.setText(firstName);
        lastNameText.setText(lastName);
        dobText.setText(dob);
        alcdrugText.setText(Boolean.toString(alcdrug));
//        Registrar r = new Registrar();
//        Nurse n = new Nurse();
//        
//        r.passInfo();
//        n.passInfo();
//        addressText.setText(address);
//        zipText.setText(zip);
//        ssnText.setText(ssn);
//        insuranceText.setText(insurance);
//        physText.setText(phys);
//        heightText.setText(Integer.toString(height));
//        weightText.setText(Integer.toString(weight));
//        vax1Text.setText(vax1);
//        vax2Text.setText(vax2);
//        symptomText.setText(symptom);
//        allergyText.setText(allergy);
//        medsText.setText(meds);
//        alcdrugText.setText(Boolean.toString(alcdrug));
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateDisplayTable("patientID");
    }
}
