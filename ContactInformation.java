import java.util.ArrayList;


public class ContactInformation {

    public String firstName;
    public String lastName;
    public String phoneNumber;
    ArrayList <String> information = new ArrayList<String> ();

    public ContactInformation(String firstName, String lastName,
                              String phoneNumber, ArrayList<String> information) {
        super();
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