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

public class PatientFileDisplayController implements Initializable {
    private Stage stage;
    private Scene scene;
        
    @FXML
    private TextField lastNameInput;
    @FXML
    private TextField dateOfBirthInput;
    @FXML
    private TextField addressInput;
    @FXML
    private TextField zipInput;
    @FXML
    private TextField ssnInput;
    @FXML
    private TextField insuranceInput;
    @FXML
    private TextField primaryPhysicianInput;
    @FXML
    private TextField heightInput;
    @FXML
    private TextField weightInput;
    @FXML
    private TextField vax1Input;
    @FXML
    private TextField vax2Input;
    @FXML
    private TextField symptomsInput;
    @FXML
    private TextField medicinesInput;
    @FXML
    private TextField allergiesInput;
    @FXML
    private CheckBox alcdrugInput;

    @FXML
    private Text firstNameText;
    
//Patient File Display Controller
    @FXML
    private void submitNewForm(ActionEvent event) throws IOException {
        String nameLast = lastNameInput.getText();
        String dob = dateOfBirthInput.getText();
        String address = addressInput.getText();
        String zip = zipInput.getText();
        String ssn = ssnInput.getText();
        String insurance = insuranceInput.getText();
        String phys = primaryPhysicianInput.getText();
        int height = Integer.parseInt(heightInput.getText());
        int weight = Integer.parseInt(weightInput.getText());
        String vax1 = vax1Input.getText();
        String vax2 = vax2Input.getText();
        String symptom = symptomsInput.getText();
        String allergy = medicinesInput.getText();
        String meds = allergiesInput.getText();
        boolean alcdrug = alcdrugInput.isSelected();
        
        
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/RegistrarMainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Registrar Main Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cancelNewForm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/RegistrarMainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Registrar Main Page");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        firstNameText.setText("I'm a Label.");
        // TODO
    }    

}
