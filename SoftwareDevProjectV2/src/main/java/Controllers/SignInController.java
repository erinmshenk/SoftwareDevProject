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

public class SignInController implements Initializable {
    private Stage stage;
    private Scene scene;
    
    @FXML
    private TextField usernameInput;
    @FXML
    private PasswordField passwordInput;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        String user = usernameInput.getText();
        String pass = passwordInput.getText();
        Parent root;
        if (user.equals("adam") && pass.equals("root")){
            root = FXMLLoader.load(getClass().getResource("/fxml/RegistrarMainPage.fxml"));
        }
        else if (user.equals("nurse") && pass.equals("root")){
            root = FXMLLoader.load(getClass().getResource("/fxml/NurseMainPage.fxml"));
        }
        else if (user.equals("physician") && pass.equals("root")){
            root = FXMLLoader.load(getClass().getResource("/fxml/PhysicianMainPage.fxml"));
        }
        else if (user.equals("billing") && pass.equals("root")){
            root = FXMLLoader.load(getClass().getResource("/fxml/BillingMainPage.fxml"));
        }
        else {
            root = FXMLLoader.load(getClass().getResource("/fxml/SignInPage.fxml"));            
        }
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
