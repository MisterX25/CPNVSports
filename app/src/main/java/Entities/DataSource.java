package Entities;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import ch.cpnv.cpnvsports.R;

/**
 * Dummy class whos only purpose is to provide hardcoded application data
 */
public class DataSource
{
    private ArrayList<Person> people;
    private ArrayList<Team> teams;
    private ArrayList<Participant> contenders;
    private ArrayList<Court> courts;

    public DataSource()
    {
        R.xml.courts
    }
}
