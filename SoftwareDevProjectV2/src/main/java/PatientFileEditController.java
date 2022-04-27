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
    private CheckBox alcdrugTextField;
    
//Patient File Display Controller
    @FXML
    private void editPatientData(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/NurseMainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Registrar Main Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void returnToMainPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/RegistrarMainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Registrar Main Page");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Nurse ns = new Nurse();
        String firstName = ns.getPatientFirstName();
        String lastName = ns.getPatientLastName();
        String dob = ns.getPatientDOB();
        firstNameTextField.setText(firstName);
        lastNameTextField.setText(lastName);
        dobTextField.setText(dob);

    }
}
