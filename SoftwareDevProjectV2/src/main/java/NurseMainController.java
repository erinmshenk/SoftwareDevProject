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
    private TextField patientIDSearch;
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

    
    
//Nurse Main Page Controller
    @FXML
    public void nurseSearchButton(ActionEvent event) throws IOException {
        
        String patientID = patientIDSearch.getText();
        String firstName = firstNameSearch.getText();
        String lastName = lastNameSearch.getText();

        System.out.println(patientID);
        System.out.println(firstName);
        System.out.println(lastName);
        
        //check patient ID match
        //check patient first name match
        //check patient last name match

        //if the searched patient exists, set the below variables to true
        //if the search does not exist, set them to false
        boolean patientFound = true;
        
        //need to load the data into the variables listed below
        //sample data
        String dob = "adam";
        String address = "adam";
        String zip = "adam";
        String ssn = "adam";
        String insurance = "adam";
        String phys = "adam";
        int height = 10;
        int weight = 10;
        String vax1 = "adam";
        String vax2 = "adam";
        String symptom = "adam";
        String allergy = "adam";
        String meds = "adam";
        boolean alcdrug = true;

        if (patientFound == true){
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/PatientFileDisplay.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
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
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}