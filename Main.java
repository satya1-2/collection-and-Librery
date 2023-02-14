
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;


 public class ContactInformation {

    public String firstName;
    public String lastName;
    public String phoneNumber;
    ArrayList <String> information = new ArrayList<String> ();

    public ContactInformation(String firstName, String lastName,
                              String phoneNumber, ArrayList<String> information) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.information = information;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
public class Main{

    public Main(String firstName, String lastName, String phoneNumber, ArrayList<String> information) {
        super(firstName, lastName, phoneNumber, information);
    }

    public static void main(String[] args) {
        firstActions();
    }

    static String firstName;
    static String lastName;
    static String phoneNumber;
    static String search = null;
    static public int choice = 0;
    static Scanner input = new Scanner (System.in);
    static ContactInformation contact;
    static ArrayList<String> information = new ArrayList<String>();

    public static void firstActions()

    {
        System.out.println("Address Book Menu: What would you like to do? 1) Input data. 2) Search data. 3) Close.");
        choice = input.nextInt();
        switch (choice) {
            case 1:
                inputData();
            case 2:
                System.out.println("Search by: 1) First Name 2) Last Name 3) Phone Number 4) Zip Code.");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        searchName();
                        break;
                    case 2:
                        searchLastName();
                    case 3:
                        searchPhoneNumber();
                    case 4:
                        //execute search by Zip Code
                    default:
                        System.out.println("Please compile again.");
                        break;
                }
                break;
            case 3:
                System.out.println("Application terminated.");
                System.exit(0);
            default:
                System.out.println("Please compile again.");
                break;
        }

    }
    public static void inputData ()
    {
        information = new ArrayList<String>();
        contact = new ContactInformation(firstName, lastName, phoneNumber, information);
        System.out.println("What is your first name?");
        contact.setFirstName(input.next());
        information.add(contact.getFirstName());
        System.out.println("What is your last name?");
        contact.setLastName(input.next());
        information.add(contact.getLastName());
        System.out.println("What is your phone number?");
        contact.setPhoneNumber(input.next());
        information.add(contact.getPhoneNumber());
        System.out.println("Saved.");
        System.out.println("What would you like to do next?");
        firstActions();
    }
    public static void searchName()
    {
        System.out.println("What is the first name you are looking for?");
        search = input.next();
        if (search.equals(information.get(0)))
        {
            System.out.println(information);
            System.out.println("What would you like to do next?");
            firstActions();
        }
        else
        {
            System.out.println("This person is not saved in the address book. Please try again.");
            firstActions();
        }
    }
    public static void searchLastName()
    {
        System.out.println("What is the last name you are looking for?");
        search = input.next();
        if (search.equals(information.get(1)))
        {
            System.out.println(information);
            firstActions();
        }
        else
        {
            System.out.println("This person is not saved in the address book. Please try again.");
            firstActions();
        }
    }
    public static void searchPhoneNumber()
    {
        System.out.println("What is the last name you are looking for?");
        search = input.next();
        if (search.equals(information.get(2)))
        {
            System.out.println(information);
            firstActions();
        }
        else
        {
            System.out.println("This person is not saved in the address book. Please try again.");
            firstActions();
        }
    }
}