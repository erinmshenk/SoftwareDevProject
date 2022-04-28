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

public class BillingMainController implements Initializable {
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField patientSSNSearch;
    @FXML
    private TextField firstNameSearch;
    @FXML
    private TextField lastNameSearch;
    @FXML
    private Text patientSearchError;
    
    Billing bi = new Billing();
    
    
//Nurse Main Page Controller
    @FXML
    public void nurseSearchButton(ActionEvent event) throws IOException {
        
        
        
        String patientID = patientSSNSearch.getText();
        String firstName = firstNameSearch.getText();
        //bi.setNameF(firstNameSearch.getText());
        String lastName = lastNameSearch.getText();
        
        System.out.println(firstName);

        //I believe the below code could be moved to the Billing.java file
        //Billing bi = new Billing(firstName, lastName, patientID);
        
        boolean patientFound = bi.searchPatient("Erin", lastName, patientID);
        bi.setNameF(firstName);
        System.out.println("sending " + firstName);
        
        patientFound = true;
        
        if (patientFound == true){
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/BillingSearchDisplay.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Billing Search Display");
            stage.show();
        }
        else{
            patientSearchError.setText("Error in the Search Terms");
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