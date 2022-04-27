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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NurseMainController implements Initializable {
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField patientSsnSearch;
    @FXML
    private TextField firstNameSearch;
    @FXML
    private TextField lastNameSearch;
    @FXML
    private Text patientSearchError;
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
    
    
    public NurseMainController(String nameFirst, String nameLast, String dob, String address, String zip, String ssn, String insurance, String phys,
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
    
    public NurseMainController()
    {
        
    }
    
    
//Nurse Main Page Controller
    @FXML
    public void nurseSearchButton(ActionEvent event) throws IOException {
        

        String patientSsn = patientSsnSearch.getText();
        String firstName = firstNameSearch.getText();
        String lastName = lastNameSearch.getText();
        
        //sends search info to nurse
        Nurse n = new Nurse(firstName, lastName, patientSsn);


        System.out.println(patientSsn);
        System.out.println(firstName);
        System.out.println(lastName);
        
        //check patient ID match
        //check patient first name match
        //check patient last name match
        

        //if the searched patient exists, set the below variables to true
        //if the search does not exist, set them to false
        boolean patientFound;
        patientFound = n.searchPatient();


        if (patientFound == true){
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/PatientFileDisplay.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Display Patient File");
            stage.show();
        }
        else{
            patientSearchError.setText("Error in the Search Term");
        }
    }

    @FXML
    private void signOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/SignInPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Sign In Page");
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}