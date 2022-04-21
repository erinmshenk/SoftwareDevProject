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


    
//New Patient Form Controller
    @FXML
    private void submitNewForm(ActionEvent event) throws IOException {
        String patientID = patientIDInput.getText();
        String fistName = firstNameInput.getText();
        System.out.println(patientID);

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/NewPatientForm.fxml"));
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
