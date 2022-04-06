import java.util.Scanner;

public class EmergencyRoom {
    
    public static void main(String[] args)
    {
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

        }

        else if (username.equals(ruser) && password.equals(rpass))
        {

        }

        else if (username.equals(puser) && password.equals(ppass))
        {

        }

        else if (username.equals(buser) && password.equals(bpass))
        {

        }

        else
        {
            exit(0);
        }
    }