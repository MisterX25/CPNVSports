package Entities;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Person is abstract, specialized into Students and Teachers
 */
public abstract class Person extends Participant
{

    //=========================================== Attributes =======================================
    private String firstname;
    private String lastname;
    private String phoneNumber;

    //=========================================== Constructors =====================================
    /**
     * Constructor
     * @param firstname
     * @param lastname
     */
    public Person(String firstname, String lastname)
    {
        this.firstname=firstname;
        this.lastname=lastname;
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

}
