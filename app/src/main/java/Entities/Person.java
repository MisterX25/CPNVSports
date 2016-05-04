package Entities;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Xavier on 03.05.16.
 */
public class Person {

    //=========================================== Attributes =======================================
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private GregorianCalendar birthDate;

    //=========================================== Constructors =====================================
    /**
     * Constructor
     * @param firstname
     * @param lastname
     * @param birthDate
     */
    public Person(String firstname, String lastname, GregorianCalendar birthDate)
    {
        this.firstname=firstname;
        this.lastname=lastname;
        this.birthDate=birthDate;
    }

    //=========================================== Methods ==========================================
    public String getFullname()
    {
        return firstname+" "+lastname;
    }

    /**
     * Sets the firstname and lastname of a person in one shot.
     * @param fname Format must be "firstname lastname", only one space. In case of errors, firstname and lastname are set to "?"
     * @return true if fname was successfully parsed
     */
    public boolean setFullname(String fname)
    {
        String[] names = fname.split(" ");
        if (names.length == 2)
        {
            firstname=names[0];
            lastname=names[1];
            return true;
        }
        else
        {
            firstname="?";
            lastname="?";
            return false;
        }
    }

    /**
     * Creates a textual representation of the person
     * @return a 3-line string: fullname, birthdate, phone
     */
    public String vCard()
    {
        // Format birth date
        SimpleDateFormat fmt = new SimpleDateFormat("dd MMM yyyy");
        fmt.setCalendar(birthDate);
        String dateFormatted = fmt.format(birthDate.getTime());

        // Compute age
        GregorianCalendar now = new GregorianCalendar();
        int age = (int)((now.getTimeInMillis()-birthDate.getTimeInMillis())/1000/60/60/24/365.25);
        return getFullname()+"\n"+dateFormatted+" ("+age+" ans)\n"+getPhoneNumber();
    }

    //=========================================== Getters/Setters ==================================
    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getPhoneNumber()
    {
        if (phoneNumber == null)
            return "(inconnu)";
        else
            return phoneNumber;
    }

    /**
     * Sets the person's phone number
     * @param phoneNumber Must be a swiss-style phone number: +41 12 456 78 90
     * @return true if the format was correct
     */
    public boolean setPhoneNumber(String phoneNumber)
    {
        String pattern = "^(\\+?)(\\d{2,4})(\\s?)(\\-?)((\\(0\\))?)(\\s?)(\\d{2})(\\s?)(\\-?)(\\d{3})(\\s?)(\\-?)(\\d{2})(\\s?)(\\-?)(\\d{2})";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(phoneNumber);
        if (m.matches())
        {
            this.phoneNumber = phoneNumber;
            return true;
        }
        else
        {
            this.phoneNumber = "(inconnu)";
            return false;
        }
    }

    public GregorianCalendar getBirthDate()
    {
        return birthDate;
    }


}
