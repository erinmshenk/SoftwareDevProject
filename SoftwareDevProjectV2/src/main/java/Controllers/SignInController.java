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
        if (user.equals("adam") && pass.equals("root")){
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/RegistrarMainPage.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (user.equals("nurse") && pass.equals("root")){
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/GeneralSearchPage.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

}
