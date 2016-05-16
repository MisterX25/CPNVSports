package Entities;

/**
 * Created by Xavier on 11.05.16.
 */
public class Student extends Person
{
    private String className;

    public Student(String firstname, String lastname, String className)
    {
        super(firstname, lastname);
        this.className = className;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    @Override
    public String dump() {
        String res = "Elève: "+super.getFirstname()+" "+super.getLastname();
        if (pseudo != null)
            res += " (aka "+pseudo+")";
        res = res+", classe "+getClassName();
        return res;
    }
}
