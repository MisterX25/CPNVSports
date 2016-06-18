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

import Entities.Coach;
import Entities.Court;
import Entities.DataSource;
import Entities.Game;
import Entities.Participant;
import Entities.Person;
import Entities.Student;
import Entities.Teacher;
import Entities.Team;
import ch.cpnv.cpnvsports.R;

public class cpnvSportsHome extends Activity
        implements View.OnClickListener {

    // Constants
    private final int nbStudentTeams = 8;
    private final int nbTeacherTeams = 2;

    // infrastructure
    private Button btn; // Handle on button
    private TextView output; // handle on output zone
    private EditText input;
    private Context context; // For toasts

    // application
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<Participant> teams;
    private ArrayList<Participant> individuals;
    private ArrayList<Game> games;

    Court myCourt = new Court();

    private Random alea = new Random();
    DataSource data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpnv_sports_home);

        // Initialize handles
        output = (TextView) findViewById(R.id.txtOutput);
        input = (EditText) findViewById(R.id.txtInputText);
        btn = (Button) findViewById(R.id.cmdButton1);
        btn.setOnClickListener(this);
        btn = (Button) findViewById(R.id.cmdButton2);
        btn.setOnClickListener(this);
        btn = (Button) findViewById(R.id.cmdButton3);
        btn.setOnClickListener(this);
        btn = (Button) findViewById(R.id.cmdButton4);
        btn.setOnClickListener(this);

        // Application data
        data = new DataSource(this);
    }

    @Override
    public void onClick(View v) {
        Button clicked = (Button)v;
        switch (clicked.getId()) {
            case R.id.cmdButton1:
                output.setText("Equipes:");
                for (Team t:data.getTeams())
                    output.setText(output.getText()+"\n"+t.dumpShort());
                break;
            case R.id.cmdButton2:
                if (input.getText().toString().isEmpty())
                    Toast.makeText(cpnvSportsHome.this, "Introduisez un nom!", Toast.LENGTH_SHORT).show();
                else
                {
                    String guy = data.getFullNameByLastName(input.getText().toString());
                    if (guy == null)
                        Toast.makeText(cpnvSportsHome.this, "Inconnu au bataillon!", Toast.LENGTH_SHORT).show();
                    else
                    {
                        String games = data.gamesOf(input.getText().toString());
                        if (games != null)
                            output.setText(guy + " a participé aux matches suivants:"+games);
                        else
                            output.setText(guy + " n'a participé à aucun match");
                    }
                }

                break;
            case R.id.cmdButton3:
                output.setText("Coachs:");
                for (Coach c:data.getCoaches())
                {
                    boolean hasTeam = false;
                    for (Team t:data.getTeams())
                        if (t.getCoach() == c)
                        {
                            output.setText(c.getFirstname() + " " + c.getLastname() + " coache " + t.getPseudo());
                            hasTeam=true;
                            break;
                        }
                    if (!hasTeam)
                        output.setText(c.getFirstname() + " " + c.getLastname() + " ne coache aucune équipe");
                }
                break;
            case R.id.cmdButton4:
                if (input.getText().toString().isEmpty())
                    Toast.makeText(cpnvSportsHome.this, "Introduisez un nom!", Toast.LENGTH_SHORT).show();
                else
                {
                    String guy = data.getCoachFullNameByLastName(input.getText().toString());
                    if (guy == null)
                        Toast.makeText(cpnvSportsHome.this, "Inconnu au bataillon!", Toast.LENGTH_SHORT).show();
                    else
                    {
                        boolean hasTeam = false;
                        for (Team t : data.getTeams())
                            if (t.getCoach().getLastname().toUpperCase().equals(input.getText().toString().toUpperCase()))
                            {
                                output.setText(guy + " coache " + t.getPseudo());
                                hasTeam = true;
                                break;
                            }
                        if (!hasTeam)
                            output.setText(guy + " ne coache aucune équipe");
                    }
                }

                break;
        }
    }

}
