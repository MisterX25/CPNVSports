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

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Xavier on 29.05.16.
 */
public class DataSource
{
    private final String DSRC_WS_URL = "http://192.168.0.21/CPNVSports";

    private boolean ready = false; // Data has been loaded (XML parser initialized)
    private String fileContent=null;
    private String url;
    private Context context;

    // ================================== Constructors ==========================================

    /**
     *
     * @param context Application context
     */
    public DataSource (Context context,String fname)
    {
        this.context = context;
        url = DSRC_WS_URL+"/"+fname;
        reload();
    }

    public void reload()
    {
        asyncLoad();
    }

    public boolean isLoaded()
    {
        return (fileContent != null);
    }

    // doesn't work....
    public boolean syncLoad()
    {
        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest rq = new StringRequest(Request.Method.GET,url,future,future);
        RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());
        queue.add(rq);
        Log.i("DSRC","Synchronous request to "+url);
        try {
            fileContent = future.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            Log.i("DSRC","Timeout"+e.getMessage());
        }
        if (fileContent != null)
        {
            Log.i("DSRC","Success");
            return true;
        }
        else
            return false;
    }

    public void asyncLoad()
    {
        // Based on: https://developer.android.com/training/volley/simple.html
        Log.i ("DSRC","Asynchronous request to "+url);
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i ("DSRC","Success");
                        setFileContent(response);
                        ready = true;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("DSRC","ERROR: "+error.getMessage());
            }
        });
        // Add the request to the RequestQueue. /*/
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(stringRequest);
    }

    public boolean isReady()
    {
        return (ready);
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }
}
