package activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Entities.Person;
import Entities.Student;
import Entities.Teacher;
import Entities.Team;
import ch.cpnv.cpnvsports.R;


public class cpnvSportsHome extends Activity
    implements View.OnClickListener {

    private Button btn; // Handle on button
    private TextView output; // handle on output zone
    private EditText input; // handle on input text box
    private Context context; // For toasts
    private Team theTeam;
    private Teacher theTeacher;
    private Student theStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpnv_sports_home);

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

        // Application data

    }

    @Override
    public void onClick(View btn)
    {
        Button clicked = (Button)btn;
        switch (clicked.getId())
        {

            case R.id.cmdButton1:
                theStudent = new Student("Joe","Dalton","SI-T1a");
                theTeam = new Team("Dalton",theStudent);
                output.setText("Student team:\n"+theTeam.dump());
                break;
            case R.id.cmdButton2:
                theTeacher = new Teacher("Lucky","Luke","Marshall office");
                theTeam = new Team("Marshalls",theTeacher);
                output.setText("Teacher team:\n"+theTeam.dump());
                break;
            case R.id.cmdButton3:
                theStudent = new Student("Joe","Dalton","SI-T1a");
                theStudent.setPseudo("Joey");
                output.setText("Student participant\n"+theStudent.dump());
                break;
            case R.id.cmdButton4:
                theTeacher = new Teacher("Lucky","Luke","Marshall office");
                theTeacher.setPseudo("QuickDraw");
                output.setText("Teacher participant\n"+theTeacher.dump());
                break;

        }
    }
}
