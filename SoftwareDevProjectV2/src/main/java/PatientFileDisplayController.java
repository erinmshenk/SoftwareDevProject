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
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/NurseMainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Registrar Main Page");
        stage.setScene(scene);
        stage.show();
    }

    public void rewriteTable(String firstName, String lastName){
        firstNameText.setText(firstName);
        lastNameText.setText(lastName);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String name = "string in override";
        String last = "string in override";
        
        rewriteTable(name, last);
//        firstNameText.setText("replace text with variable");
//        lastNameText.setText("replace text with variable");
//        dobText.setText("replace text with variable");
//        addressText.setText("replace text with variable");
//        zipText.setText("replace text with variable");
//        ssnText.setText("replace text with variable");
//        insuranceText.setText("replace text with variable");
//        physText.setText("replace text with variable");
//        heightText.setText("replace text with variable");
//        weightText.setText("replace text with variable");
//        vax1Text.setText("replace text with variable");
//        vax2Text.setText("replace text with variable");
//        symptomText.setText("replace text with variable");
//        allergyText.setText("replace text with variable");
//        medsText.setText("replace text with variable");
//        alcdrugText.setText("replace text with variable");
    }
}
