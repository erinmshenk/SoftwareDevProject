package Controllers;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewPatientController implements Initializable {
    private Stage stage;
    private Scene scene;
        
    @FXML
    private TextField patientIDInput;
    @FXML
    private TextField firstNameInput;

//    @FXML
//    private TextField nameFirstInput;
//    @FXML
//    private TextField nameLast;
//    @FXML
//    private TextField dob;
//    @FXML
//    private TextField address;
//    @FXML
//    private TextField zip;
//    @FXML
//    private TextField ssn;
//    @FXML
//    private TextField insurance;
//    @FXML
//    private TextField phys;
//    @FXML
//    private TextField height;
//    @FXML
//    private TextField weight;
//    @FXML
//    private TextField vax1;
//    @FXML
//    private TextField vax2;
//    @FXML
//    private TextField symptom;
//    @FXML
//    private TextField allergy;
//    @FXML
//    private TextField meds;
//    @FXML
//    private CheckBox alcdrug;

    

    
//New Patient Form Controller
    @FXML
    private void submitNewForm(ActionEvent event) throws IOException {
        String patientID = patientIDInput.getText();
        String firstName = firstNameInput.getText();
        System.out.println(patientID);
        System.out.println(firstName);
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
        // TODO
    }    

}
