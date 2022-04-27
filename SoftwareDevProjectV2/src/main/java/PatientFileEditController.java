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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PatientFileEditController implements Initializable {
    private Stage stage;
    private Scene scene;
        
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField dobTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField zipTextField;
    @FXML
    private TextField ssnTextField;
    @FXML
    private TextField insuranceTextField;
    @FXML
    private TextField physTextField;
    @FXML
    private TextField heightTextField;
    @FXML
    private TextField weightTextField;
    @FXML
    private TextField vax1TextField;
    @FXML
    private TextField vax2TextField;
    @FXML
    private TextField symptomTextField;
    @FXML
    private TextField medsTextField;
    @FXML
    private TextField allergyTextField;
    @FXML
    private CheckBox alcdrugCheckBox;
    
//Patient File Display Controller
    @FXML
    private void submitUpdates(ActionEvent event) throws IOException {
//this is missing something, I copied the code over from the Registrar page
//missing pieces for the Nurse's new data

//        String nameFirst = firstNameTextField.getText();
//        String nameLast = lastNameTextField.getText();
//        String dob = dobTextField.getText();
//        String address = addressTextField.getText();
//        String zip = zipTextField.getText();
//        String ssn = ssnTextField.getText();
//        String insurance = insuranceTextField.getText();
//        String phys = physTextField.getText();
//        int height = Integer.parseInt(heightTextField.getText());
//        int weight = Integer.parseInt(weightTextField.getText());
//        String vax1 = vax1TextField.getText();
//        String vax2 = vax2TextField.getText();
//        String symptom = symptomTextField.getText();
//        String allergy = medsTextField.getText();
//        String meds = allergyTextField.getText();
//        boolean alcdrug = alcdrugTextField.isSelected();
//        
//        Registrar r = new Registrar(nameFirst, nameLast, dob, address, zip, ssn, insurance, phys,
//            height, weight, vax1, vax2, symptom, allergy, meds, alcdrug);
//        r.insertPatient();



        Parent root = FXMLLoader.load(getClass().getResource("/fxml/NurseMainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Nurse Main Page");
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
    public void updateEditTable(String patientID){
        Nurse ns = new Nurse();
        String firstName = ns.getPatientFirstName();
        String lastName = ns.getPatientLastName();
        String dob = ns.getPatientDOB();
        boolean alcdrug = ns.getPatientAlcDrug();
        firstNameTextField.setText(firstName);
        lastNameTextField.setText(lastName);
        dobTextField.setText(dob);
        alcdrugCheckBox.setSelected(alcdrug);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateEditTable("PatientID");
    }
}
