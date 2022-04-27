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

public class BillingSearchDisplayController implements Initializable {
    private Stage stage;
    private Scene scene;
    
    @FXML
    private Text medName, medPrice, testName, testPrice, nightsStayed, nightPrice;    
    
    public BillingSearchDisplayController(String nameFirst, String nameLast, String dob, String address, String zip, String ssn, String insurance, String phys,
            int height, int weight, String vax1, String vax2, String symptom, String allergy, String meds, boolean alcdrug)
    {
//        medNameText = new Text(medName);
//        medPriceText = new Text(nameLast);
//        testNameText = new Text(dob);
//        testPriceText = new Text(address);
//        zipText = new Text(zip);
//        ssnText = new Text(ssn);
//        insuranceText = new Text(insurance);
//        physText = new Text(phys);
//        heightText = new Text(Integer.toString(height));
//        weightText = new Text(Integer.toString(weight));
//        vax1Text = new Text(vax1);
//        vax2Text = new Text(vax2);
//        symptomText = new Text(symptom);
//        medsText = new Text(meds);
//        allergyText = new Text(allergy);
//        alcdrugText = new Text(Boolean.toString(alcdrug));
    }
    
    public BillingSearchDisplayController(int vitals, int nightsStayed, String bloodpressure, String admittance, String observation, String pretreatment)
    {
//        vitalsText = new Text(Integer.toString(vitals));
//        nightsStayedText = new Text(Integer.toString(nightsStayed));
//        bloodPressureText = new Text(bloodpressure);
//        admittanceText = new Text(admittance);
//        observationText = new Text(observation);
//        pretreatmentText = new Text(pretreatment);  
    }
    
    public BillingSearchDisplayController()
    {
        
    }
    
    
//Billing Search Display Controller (display bill)
    @FXML
    private void returnToMainPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/BillingMainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Nurse Main Page");
        stage.setScene(scene);
        stage.show();
    }

    public void updateDisplayTable(String patientID){
        //fill this with the same code from PatientFileDisplayController (nurse)
        //left empty for now
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateDisplayTable("patientID");
        Billing test = new Billing();
        test.printBill();
    }
}
