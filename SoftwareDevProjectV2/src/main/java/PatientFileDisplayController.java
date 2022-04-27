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
    
    public PatientFileDisplayController(String nameFirst, String nameLast, String dob, String address, String zip, String ssn, String insurance, String phys,
            int height, int weight, String vax1, String vax2, String symptom, String allergy, String meds, boolean alcdrug)
    {
        firstNameText = new Text(nameFirst);
        
        lastNameText = new Text(nameLast);
        
        dobText = new Text(dob);
        
        addressText = new Text(address);
        
        zipText = new Text(zip);
        
        ssnText = new Text(ssn);
        
        insuranceText = new Text(insurance);
        
        physText = new Text(phys);
        
        heightText = new Text(Integer.toString(height));
        
        weightText = new Text(Integer.toString(weight));
        
        vax1Text = new Text(vax1);
       
        vax2Text = new Text(vax2);
        
        symptomText = new Text(symptom);
        
        medsText = new Text(meds);
        
        allergyText = new Text(allergy);
        
        alcdrugText = new Text(Boolean.toString(alcdrug));
    }
    
    public PatientFileDisplayController(int vitals, int nightsStayed, String bloodpressure, String admittance, String observation, String pretreatment)
    {
        vitalsText = new Text(Integer.toString(vitals));
        
        nightsStayedText = new Text(Integer.toString(nightsStayed));
        
        bloodPressureText = new Text(bloodpressure);
        
        admittanceText = new Text(admittance);
        
        observationText = new Text(observation);
        
        pretreatmentText = new Text(pretreatment);  
    }
    
    public PatientFileDisplayController()
    {
        
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

    public void updateTable(String patientID){
        //fill the below lines with data based on from patientID
        
        Nurse ns = new Nurse();
        String firstName = ns.getPatientFirstName();
        String lastName = ns.getPatientLastName();
        String dob = ns.getPatientDOB();

        firstNameText.setText(firstName);
        lastNameText.setText(lastName);
        dobText.setText(dob);
        
        
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
        updateTable("patientID");
    }
}
