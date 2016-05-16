package Entities;

/**
 * Created by Xavier on 11.05.16.
 */
public class Teacher extends Person
{

    private String faculty;

    public Teacher(String firstname, String lastname, String faculty)
    {
        super(firstname, lastname);
        this.faculty = faculty;
    }

    @Override
    public String dump()
    {
        String res = "Prof: "+super.getFirstname()+" "+super.getLastname();
        if (pseudo != null)
            res += " (aka "+pseudo+")";
        res = res+", filière "+getFaculty();
        return res;
    }

    public String getFaculty()
    {
        return faculty;
    }

    public void setFaculty(String faculty)
    {
        this.faculty = faculty;
    }
}
