package activities;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import Entities.Court;
import Entities.DataSource;
import Entities.Game;
import Entities.Participant;
import Entities.Student;
import Entities.Teacher;
import Entities.Team;
import ch.cpnv.cpnvsports.R;


public class cpnvSportsHome extends Activity
        implements View.OnClickListener {

    // infrastructure
    private Button btn; // Handle on button
    private TextView output; // handle on output zone
    private EditText input; // handle on input text box
    private Context context; // For toasts

    // application
    DataSource data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpnv_sports_home);

        // Initialize handles
        output = (TextView) findViewById(R.id.txtOutput);
        input = (EditText) findViewById(R.id.txtInputText);

        // define event handlers
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
    public void onClick(View btn) {

        Button clicked = (Button) btn;
        switch (clicked.getId())
        {
            case R.id.cmdButton1:
                break;
            case R.id.cmdButton2:
                output.setText(input.getText()+" a participé aux matches suivants:");
                break;
            case R.id.cmdButton3:
                break;
            case R.id.cmdButton4:
                output.setText(input.getText()+" est le coach de l'équipe:");
                break;
        }
    }

}
