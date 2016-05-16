package activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import Entities.Person;
import Entities.Student;
import Entities.Teacher;
import Entities.Team;
import ch.cpnv.cpnvsports.R;


public class cpnvSportsHome extends Activity
    implements View.OnClickListener {

    // infrasctructure
    private Button btn; // Handle on button
    private TextView output; // handle on output zone
    private EditText input; // handle on input text box
    private Context context; // For toasts

    // application
    private Team theTeacherTeam;
    private Team theStudentTeam;
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private Random alea = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpnv_sports_home);

        // Application data
        teachers = new ArrayList<Teacher>();
        students = new ArrayList<Student>();

        // from generatedata.com
        teachers.add(new Teacher("Adria","Holt","Info"));
        teachers.add(new Teacher("Kasper","Booth","Info"));
        teachers.add(new Teacher("Samuel","Leach","Info"));
        teachers.add(new Teacher("Colton","Camacho","Info"));
        teachers.add(new Teacher("Chiquita","Armstrong","Info"));
        teachers.add(new Teacher("Travis","Carver","Info"));
        teachers.add(new Teacher("Brendan","Shannon","Info"));
        teachers.add(new Teacher("Irene","Hayden","Info"));
        teachers.add(new Teacher("Kadeem","Travis","Info"));
        teachers.add(new Teacher("Raya","Burgess","Info"));
        teachers.add(new Teacher("Marvin","Patterson","Info"));
        teachers.add(new Teacher("Barbara","Williams","Info"));
        teachers.add(new Teacher("Jada","Joyce","Info"));
        teachers.add(new Teacher("Anastasia","Bean","Poly"));
        teachers.add(new Teacher("Branden","Ware","Poly"));
        teachers.add(new Teacher("Mary","Lane","Poly"));
        teachers.add(new Teacher("Shelly","Love","Poly"));
        teachers.add(new Teacher("Isaiah","Mccall","Poly"));
        teachers.add(new Teacher("Alana","Hinton","Poly"));
        teachers.add(new Teacher("Sigourney","Rosa","Poly"));
        teachers.add(new Teacher("Rogan","Briggs","Poly"));
        teachers.add(new Teacher("Medge","Trevino","Poly"));
        teachers.add(new Teacher("Nevada","Vazquez","Poly"));
        teachers.add(new Teacher("Dane","Slater","Poly"));
        teachers.add(new Teacher("Craig","Obrien","Poly"));
        teachers.add(new Teacher("Piper","Moran","Poly"));
        teachers.add(new Teacher("Barclay","Suarez","Poly"));
        teachers.add(new Teacher("Yoko","Perez","Poly"));
        teachers.add(new Teacher("Colorado","Dixon","Poly"));
        teachers.add(new Teacher("Laith","Macdonald","Poly"));
        teachers.add(new Teacher("Isabella","Fry","Poly"));
        teachers.add(new Teacher("Kane","Conrad","Poly"));
        teachers.add(new Teacher("Kasper","Mcdonald","Media"));
        teachers.add(new Teacher("Ifeoma","Austin","Media"));
        teachers.add(new Teacher("Deanna","Baird","Media"));
        teachers.add(new Teacher("Erasmus","Middleton","Media"));
        teachers.add(new Teacher("Zane","Mcleod","Media"));
        students.add(new Student("Inga","Flowers","Media"));
        students.add(new Student("Wesley","Gallagher","Media"));
        students.add(new Student("Linus","Goodwin","Media"));
        students.add(new Student("Elton","Drake","Media"));
        students.add(new Student("Justine","Whitfield","Media"));
        students.add(new Student("Kaseem","Chambers","Media"));
        students.add(new Student("Melinda","Fitzpatrick","Media"));
        students.add(new Student("Thaddeus","Cherry","Media"));
        students.add(new Student("Sarah","Hunt","Media"));
        students.add(new Student("Holly","Ratliff","Media"));
        students.add(new Student("Xanthus","Watson","Media"));
        students.add(new Student("Jarrod","Thomas","Info"));
        students.add(new Student("Sybil","Paul","Info"));
        students.add(new Student("Brenna","Hale","Info"));
        students.add(new Student("Lee","Sanders","Info"));
        students.add(new Student("Irma","Gardner","Info"));
        students.add(new Student("Tiger","Butler","Info"));
        students.add(new Student("Kyle","Reid","Info"));
        students.add(new Student("Yoko","Perry","Info"));
        students.add(new Student("Alden","Brennan","Info"));
        students.add(new Student("Tana","Whitney","Info"));
        students.add(new Student("Vivien","Allison","Info"));
        students.add(new Student("Arsenio","Pugh","Info"));
        students.add(new Student("Nissim","Chan","Info"));
        students.add(new Student("Kasimir","Eaton","Info"));
        students.add(new Student("Nicholas","Stone","Info"));
        students.add(new Student("Jada","Underwood","Info"));
        students.add(new Student("Honorato","Lyons","Info"));
        students.add(new Student("Montana","Benjamin","Info"));
        students.add(new Student("Winifred","Keith","Info"));
        students.add(new Student("Xander","Mckinney","Info"));
        students.add(new Student("Benedict","Ferrell","Info"));
        students.add(new Student("Kylan","Noble","Info"));
        students.add(new Student("Wilma","Warren","Info"));
        students.add(new Student("Paloma","Stokes","Info"));
        students.add(new Student("Jacob","Phillips","Info"));
        students.add(new Student("Raya","Whitaker","Info"));
        students.add(new Student("Constance","Fleming","Poly"));
        students.add(new Student("Wilma","Fitzpatrick","Poly"));
        students.add(new Student("Charissa","Vincent","Poly"));
        students.add(new Student("Lisandra","Burch","Poly"));
        students.add(new Student("Rae","George","Poly"));
        students.add(new Student("Vladimir","Hurst","Poly"));
        students.add(new Student("Beatrice","Mercer","Poly"));
        students.add(new Student("Ferdinand","Mccoy","Poly"));
        students.add(new Student("Ulric","Joyner","Poly"));
        students.add(new Student("Marshall","Leon","Poly"));
        students.add(new Student("Whitney","Patton","Poly"));
        students.add(new Student("Ryder","Serrano","Poly"));
        students.add(new Student("Lani","Oliver","Poly"));
        students.add(new Student("Jena","Logan","Poly"));
        students.add(new Student("Wallace","Stafford","Poly"));
        students.add(new Student("Isaac","Winters","Poly"));
        students.add(new Student("Elaine","Combs","Poly"));
        students.add(new Student("Francis","Hansen","Poly"));
        students.add(new Student("Oliver","Acevedo","Poly"));
        students.add(new Student("Cooper","Walters","Media"));
        students.add(new Student("Venus","Molina","Media"));
        students.add(new Student("Ivan","Rich","Media"));
        students.add(new Student("Noble","Walsh","Media"));
        students.add(new Student("Grady","Rowe","Media"));
        students.add(new Student("Eugenia","Vega","Media"));

        // two teams
        theTeacherTeam = new Team("X Men",teachers.get(alea.nextInt(teachers.size())));
        int tsize = alea.nextInt(3)+2; // pick a team size between 2 and 4
        for (int i=0; i< tsize; i++)
            theTeacherTeam.newPlayer(teachers.get(alea.nextInt(teachers.size())));

        theStudentTeam = new Team("Iron Men",students.get(alea.nextInt(students.size())));
        tsize = alea.nextInt(3)+2; // pick a team size between 2 and 4
        for (int i=0; i< tsize; i++)
            theStudentTeam.newPlayer(students.get(alea.nextInt(students.size())));

        // Initialize handles
        output = (TextView)findViewById(R.id.txtOutput);
        input = (EditText)findViewById(R.id.txtInputText);
        context = getApplicationContext(); // This can go in the constructor because it does not depend on the view content

        // define event handlers
        btn=(Button)findViewById(R.id.cmdButton1);
        btn.setOnClickListener(this);
        btn=(Button)findViewById(R.id.cmdButton2);
        btn.setOnClickListener(this);
        btn=(Button)findViewById(R.id.cmdButton3);
        btn.setOnClickListener(this);
        btn=(Button)findViewById(R.id.cmdButton4);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View btn)
    {

        Button clicked = (Button)btn;
        switch (clicked.getId())
        {

            case R.id.cmdButton1:
                output.setText("Student team:\n"+theStudentTeam.dump());
                break;
            case R.id.cmdButton2:
                output.setText("Teacher team:\n"+theTeacherTeam.dump());
                break;
            case R.id.cmdButton3:
                if (theTeacherTeam.swapCaptain(teachers.get(alea.nextInt(teachers.size()))))
                    output.setText("Teacher team:\n(Very lucky change of captain)\n"+theTeacherTeam.dump());
                else
                    output.setText("Teacher team:\n(Failed change of captain)\n"+theTeacherTeam.dump());
                break;
            case R.id.cmdButton4:
                int rsize = theTeacherTeam.getRoster().size(); // number of players in the team
                Person newCaptain = theTeacherTeam.getRoster().get(alea.nextInt(rsize)); // pick one at random
                if (theTeacherTeam.swapCaptain(newCaptain))
                    output.setText("Teacher team:\n(Successful change of captain)\n"+theTeacherTeam.dump());
                else
                    output.setText("BUG !!!!!");
                break;

        }
    }
}
