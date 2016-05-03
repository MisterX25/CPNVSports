package ch.cpnv.cpnvsports;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class cpnvSportsHome extends Activity
    implements View.OnClickListener {

    private Button btn; // Handle on button
    private TextView output; // handle on output zone
    private int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpnv_sports_home);

        // Initialize handles
        output = (TextView)findViewById(R.id.txtOutput);

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
                output.setText(output.getText()+"\nLe "+i++ +"eme click était sur le bouton 1");
                break;
            case R.id.cmdButton2:
                output.setText(output.getText()+"\nLe "+i++ +"eme click était sur le bouton 2");
                break;
            case R.id.cmdButton3:
                output.setText(output.getText()+"\nLe "+i++ +"eme click était sur le bouton 3");
                break;
            case R.id.cmdButton4:
                output.setText(output.getText()+"\nLe "+i++ +"eme click était sur le bouton 4");
                break;
        }
    }
}
