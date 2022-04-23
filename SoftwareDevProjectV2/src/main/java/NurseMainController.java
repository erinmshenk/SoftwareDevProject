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
    
//Nurse Main Page Controller
    @FXML
    private void nurseSearchButton(ActionEvent event) throws IOException {
        //take patient data
        
        //need to load the data into the variables listed below
        
        String nameFirst = "adam";
        String nameLast = "adam";
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

        //check patient ID match
        //check patient first name match
        //check patient last name match
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/PatientFileDisplay.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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