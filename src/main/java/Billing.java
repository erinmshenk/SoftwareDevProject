import java.util.Scanner;

public class Billing extends EmergencyRoom
{
    Scanner keyboard = new Scanner(System.in);
    
    //user input to search for patient
    String nameFirst = keyboard.nextLine();
    String nameLast = keyboard.nextLine();
    String ssn = keyboard.nextLine();
    
    public void searchBill()
    {
        String q = "SELECT testID from nursePhysicianRecord join Patient "
                + "on nursePhysicianRecord.patientID = Patient.patientID"
                + "WHERE firstName = " + nameFirst + " AND lastName = " + nameLast + " AND ssn = " + ssn + ";";
        
    }
            
}
