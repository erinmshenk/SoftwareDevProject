
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
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8888/hospitalSystem", "root", "root");
            Statement stmt = con.createStatement();
            
            //creates the database *only run this section once*
            /**
            stmt.executeUpdate("CREATE DATABASE hospitalSystem");
            stmt.executeUpdate("""
                               CREATE TABLE `Patient` (
                                 `patientID` int(11) NOT NULL AUTO_INCREMENT,
                                 `firstName` varchar(45) DEFAULT NULL,
                                 `lastName` varchar(45) DEFAULT NULL,
                                 `dob` varchar(45) DEFAULT NULL,
                                 `address` varchar(45) DEFAULT NULL,
                                 `zip` varchar(45) DEFAULT NULL,
                                 `ssn` varchar(45) DEFAULT NULL,
                                 `insurance` varchar(45) DEFAULT NULL,
                                 `primaryPhys` varchar(45) DEFAULT NULL,
                                 `height` int(11) DEFAULT NULL,
                                 `weight` int(11) DEFAULT NULL,
                                 `vax1` varchar(45) DEFAULT NULL,
                                 `vax2` varchar(45) DEFAULT NULL,
                                 `symptom` varchar(150) DEFAULT NULL,
                                 `allergy` varchar(45) DEFAULT NULL,
                                 `meds` varchar(45) DEFAULT NULL,
                                 `alcdrug` varchar(45) DEFAULT NULL,
                                 PRIMARY KEY (`patientID`)
                               )""");
            stmt.executeUpdate("""
                               CREATE TABLE `tests` (
                                 `testID` int(11) NOT NULL AUTO_INCREMENT,
                                 `testName` varchar(45) DEFAULT NULL,
                                 `price` int(11) DEFAULT NULL,
                                 PRIMARY KEY (`testID`)
                               ) """);
            stmt.executeUpdate("""
                               CREATE TABLE `nursePhysicianRecord` (
                                 `patientID` int(11) NOT NULL,
                                 `vitals` varchar(45) DEFAULT NULL,
                                 `height` int(11) DEFAULT NULL,
                                 `weight` int(11) DEFAULT NULL,
                                 `nightsStayed` int(11) DEFAULT NULL,
                                 `bloodpressure` varchar(45) DEFAULT NULL,
                                 `admitted` varchar(45) DEFAULT NULL,
                                 `observation` varchar(45) DEFAULT NULL,
                                 `pretreatment` varchar(45) DEFAULT NULL,
                                 `testID` int(11) DEFAULT NULL,
                                 `symptoms` varchar(45) DEFAULT NULL,
                                 `discharge` varchar(45) DEFAULT NULL,
                                 `medication` varchar(45) DEFAULT NULL,
                                 `diagnosis` varchar(45) DEFAULT NULL,
                                 PRIMARY KEY (`patientID`),
                                 KEY `testID` (`testID`),
                                 CONSTRAINT `patientID` FOREIGN KEY (`patientID`) REFERENCES `Patient` (`patientID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                                 CONSTRAINT `testID` FOREIGN KEY (`testID`) REFERENCES `tests` (`testID`) ON DELETE NO ACTION ON UPDATE NO ACTION
                               ) """);
            stmt.executeUpdate("""
                               CREATE TABLE `diagnosis` (
                                 `conditionID` int(11) NOT NULL AUTO_INCREMENT,
                                 `condition` varchar(45) DEFAULT NULL,
                                 `medication` varchar(45) DEFAULT NULL,
                                 `price` int(11) DEFAULT NULL,
                                 PRIMARY KEY (`conditionID`)
                               ) """);
            stmt.executeUpdate("""
                               INSERT INTO `hospitalSystem`.`diagnosis`
                               (`conditionID`,
                               `condition`,
                               `medication`,
                               `price`)
                               VALUES
                               (AUTO_INCREMENT,
                               'diabetes',
                               'insulin',
                               100),
                               (AUTO_INCREMENT,
                               'heart disease',
                               'pravastatin',
                               200),
                               (AUTO_INCREMENT,
                               'high blood pressure',
                               'asprin',
                               50),
                               (AUTO_INCREMENT,
                               'acid reflux',
                               'omeprazole',
                               50),
                               (AUTO_INCREMENT,
                               'pulled muscle',
                               'tramadol',
                               300),
                               (AUTO_INCREMENT,
                               'ibs',
                               'miralax',
                               150);""");
            stmt.executeUpdate("""
                               INSERT INTO `hospitalSystem`.`tests`
                               (`testID`,
                               `testName`,
                               `price`)
                               VALUES
                               (AUTO_INCREMENT,
                               'red blood cell',
                               200),
                               (AUTO_INCREMENT,
                               'white blood cell',
                               200),
                               (AUTO_INCREMENT,
                               'liver function',
                               300),
                               (AUTO_INCREMENT,
                               'renal function',
                               450),
                               (AUTO_INCREMENT,
                               'electrolyte',
                               150),
                               (AUTO_INCREMENT,
                               'x ray',
                               350),
                               (AUTO_INCREMENT,
                               'computed tomography',
                               575),
                               (AUTO_INCREMENT,
                               'magnetic resonance image',
                               600),
                               (AUTO_INCREMENT,
                               'urinary test',
                               200),
                               (AUTO_INCREMENT,
                               'stool test',
                               175);""");
            **/
        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}
        
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

        if (username.equals(nuser) && password.equals(npass))
        {
            //call nurse gui
        }

        else if (username.equals(ruser) && password.equals(rpass))
        {
            //call registrar gui
        }

        else if (username.equals(puser) && password.equals(ppass))
        {
            //call physician gui
        }

        else if (username.equals(buser) && password.equals(bpass))
        {
            //call billing gui
        }

        else
        {
            exit(0);
        }
    }

}
