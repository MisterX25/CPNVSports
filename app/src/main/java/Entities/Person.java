package Entities;

/**
 * Created by Xavier on 03.05.16.
 */
public class Person {

    private String firstname;
    private String lastname;

    public Person(String firstname, String lastname)
    {
        this.firstname=firstname;
        this.lastname=lastname;
    }

    public String getFullname()
    {
        return firstname+" "+lastname;
    }

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
}
