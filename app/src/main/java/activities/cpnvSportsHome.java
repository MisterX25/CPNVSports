package activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.GregorianCalendar;

import Entities.Person;
import ch.cpnv.cpnvsports.R;


public class cpnvSportsHome extends Activity
    implements View.OnClickListener {

    private Button btn; // Handle on button
    private TextView output; // handle on output zone
    private EditText input; // handle on input text box
    private Context context; // For toasts
    private Person toto;

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
        toto=new Person("Toto","Lahoupette", new GregorianCalendar(1991,5,6));
    }

    @Override
    public void onClick(View btn)
    {
        Button clicked = (Button)btn;
        switch (clicked.getId())
        {
            case R.id.cmdButton1:
                output.setText(toto.vCard());
                break;
            case R.id.cmdButton2:
                if (toto.setFullname(input.getText().toString()))
                    output.setText("----- Carte mise à jour -----\n"+toto.vCard());
                else
                {
                    Toast toast = Toast.makeText(context, "Format de nom invalide", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;
            case R.id.cmdButton3:
                if (toto.setPhoneNumber(input.getText().toString()))
                    output.setText(output.getText()+"\n----- Carte mise à jour -----\n"+toto.vCard());
                else
                {
                    Toast toast = Toast.makeText(context, "Format de numéro de téléphone invalide", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;
            case R.id.cmdButton4:
                output.setText("");
                break;
        }
    }
}
