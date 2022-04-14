
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/SignInPage.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

        //connect to database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8888/", "root", "root");
            Statement stmt = con.createStatement();

            //creates the database *only run this section once*
            /**
            stmt.executeUpdate("CREATE DATABASE hospitalSystem");
            stmt.executeUpdate(" CREATE TABLE `Patient` (\n" +
"                                 `patientID` int(11) NOT NULL AUTO_INCREMENT,\n" +
"                                 `firstName` varchar(45) DEFAULT NULL,\n" +
"                                 `lastName` varchar(45) DEFAULT NULL,\n" +
"                                 `dob` varchar(45) DEFAULT NULL,\n" +
"                                 `address` varchar(45) DEFAULT NULL,\n" +
"                                 `zip` varchar(45) DEFAULT NULL,\n" +
"                                 `ssn` varchar(45) DEFAULT NULL,\n" +
"                                 `insurance` varchar(45) DEFAULT NULL,\n" +
"                                 `primaryPhys` varchar(45) DEFAULT NULL,\n" +
"                                 `height` int(11) DEFAULT NULL,\n" +
"                                 `weight` int(11) DEFAULT NULL,\n" +
"                                 `vax1` varchar(45) DEFAULT NULL,\n" +
"                                 `vax2` varchar(45) DEFAULT NULL,\n" +
"                                 `symptom` varchar(150) DEFAULT NULL,\n" +
"                                 `allergy` varchar(45) DEFAULT NULL,\n" +
"                                 `meds` varchar(45) DEFAULT NULL,\n" +
"                                 `alcdrug` varchar(45) DEFAULT NULL,\n" +
"                                 PRIMARY KEY (`patientID`)\n" +
"                               );");
            stmt.executeUpdate("CREATE TABLE `tests` (\n" +
"                                 `testID` int(11) NOT NULL AUTO_INCREMENT,\n" +
"                                 `testName` varchar(45) DEFAULT NULL,\n" +
"                                 `price` int(11) DEFAULT NULL,\n" +
"                                 PRIMARY KEY (`testID`)\n" +
"                               );");
            stmt.executeUpdate("                               CREATE TABLE `nursePhysicianRecord` (\n" +
"                                 `patientID` int(11) NOT NULL,\n" +
"                                 `vitals` varchar(45) DEFAULT NULL,\n" +
"                                 `height` int(11) DEFAULT NULL,\n" +
"                                 `weight` int(11) DEFAULT NULL,\n" +
"                                 `nightsStayed` int(11) DEFAULT NULL,\n" +
"                                 `bloodpressure` varchar(45) DEFAULT NULL,\n" +
"                                 `admitted` varchar(45) DEFAULT NULL,\n" +
"                                 `observation` varchar(45) DEFAULT NULL,\n" +
"                                 `pretreatment` varchar(45) DEFAULT NULL,\n" +
"                                 `testID` int(11) DEFAULT NULL,\n" +
"                                 `symptoms` varchar(45) DEFAULT NULL,\n" +
"                                 `discharge` varchar(45) DEFAULT NULL,\n" +
"                                 `medication` varchar(45) DEFAULT NULL,\n" +
"                                 `diagnosis` varchar(45) DEFAULT NULL,\n" +
"                                 PRIMARY KEY (`patientID`),\n" +
"                                 KEY `testID` (`testID`),\n" +
"                                 CONSTRAINT `patientID` FOREIGN KEY (`patientID`) REFERENCES `Patient` (`patientID`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
"                                 CONSTRAINT `testID` FOREIGN KEY (`testID`) REFERENCES `tests` (`testID`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
"                               );");
            stmt.executeUpdate(" CREATE TABLE `diagnosis` (\n" +
"                                 `conditionID` int(11) NOT NULL AUTO_INCREMENT,\n" +
"                                 `condition` varchar(45) DEFAULT NULL,\n" +
"                                 `medication` varchar(45) DEFAULT NULL,\n" +
"                                 `price` int(11) DEFAULT NULL,\n" +
"                                 PRIMARY KEY (`conditionID`)\n" +
"                               );");
            stmt.executeUpdate(" INSERT INTO `hospitalSystem`.`diagnosis`\n" +
"                               (`conditionID`,\n" +
"                               `condition`,\n" +
"                               `medication`,\n" +
"                               `price`)\n" +
"                               VALUES\n" +
"                               (AUTO_INCREMENT,\n" +
"                               'diabetes',\n" +
"                               'insulin',\n" +
"                               100),\n" +
"                               (AUTO_INCREMENT,\n" +
"                               'heart disease',\n" +
"                               'pravastatin',\n" +
"                               200),\n" +
"                               (AUTO_INCREMENT,\n" +
"                               'high blood pressure',\n" +
"                               'asprin',\n" +
"                               50),\n" +
"                               (AUTO_INCREMENT,\n" +
"                               'acid reflux',\n" +
"                               'omeprazole',\n" +
"                               50),\n" +
"                               (AUTO_INCREMENT,\n" +
"                               'pulled muscle',\n" +
"                               'tramadol',\n" +
"                               300),\n" +
"                               (AUTO_INCREMENT,\n" +
"                               'ibs',\n" +
"                               'miralax',\n" +
"                               150);");
            stmt.executeUpdate("   INSERT INTO `hospitalSystem`.`tests`\n" +
"                               (`testID`,\n" +
"                               `testName`,\n" +
"                               `price`)\n" +
"                               VALUES\n" +
"                               (AUTO_INCREMENT,\n" +
"                               'red blood cell',\n" +
"                               200),\n" +
"                               (AUTO_INCREMENT,\n" +
"                               'white blood cell',\n" +
"                               200),\n" +
"                               (AUTO_INCREMENT,\n" +
"                               'liver function',\n" +
"                               300),\n" +
"                               (AUTO_INCREMENT,\n" +
"                               'renal function',\n" +
"                               450),\n" +
"                               (AUTO_INCREMENT,\n" +
"                               'electrolyte',\n" +
"                               150),\n" +
"                               (AUTO_INCREMENT,\n" +
"                               'x ray',\n" +
"                               350),\n" +
"                               (AUTO_INCREMENT,\n" +
"                               'computed tomography',\n" +
"                               575),\n" +
"                               (AUTO_INCREMENT,\n" +
"                               'magnetic resonance image',\n" +
"                               600),\n" +
"                               (AUTO_INCREMENT,\n" +
"                               'urinary test',\n" +
"                               200),\n" +
"                               (AUTO_INCREMENT,\n" +
"                               'stool test',\n" +
"                               175);");
               **/
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        Scanner keyboard = new Scanner(System.in);

        String username = keyboard.nextLine();
        keyboard.nextLine();

        String password = keyboard.nextLine();

        //usernames for all parties that can log in
        String nuser = "nurse";
        String ruser = "registrar";
        String puser = "physician";
        String buser = "billing";

        //passwords for all parties that can log in
        String npass = "123!";
        String rpass = "456!";
        String ppass = "789!";
        String bpass = "010!";

        if (username.equals(nuser) && password.equals(npass)) {
            //call nurse gui
        } else if (username.equals(ruser) && password.equals(rpass)) {
            //call registrar gui
        } else if (username.equals(puser) && password.equals(ppass)) {
            //call physician gui
        } else if (username.equals(buser) && password.equals(bpass)) {
            //call billing gui
        } else {
            exit(0);
        }
    }

}
