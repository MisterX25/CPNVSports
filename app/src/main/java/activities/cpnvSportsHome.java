package activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import Entities.Coach;
import Entities.DataSource;
import Entities.Team;
import ch.cpnv.cpnvsports.R;

public class cpnvSportsHome extends Activity
        implements View.OnClickListener {

    // infrastructure
    private Button btn; // Handle on button
    private TextView output; // handle on output zone
    private EditText input;

    // Application data
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
                            output.setText(output.getText()+"\n"+c.getFirstname() + " " + c.getLastname() + " coache " + t.getPseudo());
                            hasTeam=true;
                            break;
                        }
                    if (!hasTeam)
                        output.setText(output.getText()+"\n"+c.getFirstname() + " " + c.getLastname() + " ne coache aucune équipe");
                }
                break;
            case R.id.cmdButton4:
                if (input.getText().toString().isEmpty())
                    Toast.makeText(cpnvSportsHome.this, "Introduisez un nom!", Toast.LENGTH_SHORT).show();
                else
                {
                    String guy = data.getFullNameByLastName(input.getText().toString());
                    if (guy == null)
                        Toast.makeText(cpnvSportsHome.this, "Inconnu au bataillon!", Toast.LENGTH_SHORT).show();
                    else
                    {
                        boolean hasTeam = false;
                        for (Team t : data.getTeams())
                        {
                            Coach c = t.getCoach();
                            if ((c != null) && c.getLastname().toUpperCase().equals(input.getText().toString().toUpperCase()))
                            {
                                output.setText(guy + " coache " + t.getPseudo());
                                hasTeam = true;
                                break;
                            }
                        }
                        if (!hasTeam)
                            output.setText(guy + " ne coache aucune équipe");
                    }
                }

                break;
        }
    }

}
