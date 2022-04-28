import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class PhysicianPatientFileDisplayController implements Initializable {
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
//Physician Patient File Display Controller
    @FXML
    private void editPatientData(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/PhysicianPatientFileEdit.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Physician Edit Patient File");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void returnToMainPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/PhysicianMainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Physician Main Page");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        firstNameText.setText("Adam");
        lastNameText.setText("Culver");
    }
}
