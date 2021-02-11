package com.priyanka.videoview;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    VideoView vid;
    MediaController m;
    private String mJSONURLString ;
    private Context mContext;
    String videoUrl;
    ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        pDialog = new ProgressDialog(MainActivity.this);

        //AIzaSyBgiGWqbQnzeGKUDKNo8RKIqBPj83U1W7Y

        //vid = (VideoView)findViewById(R.id.simpleVideoView);

        m = new MediaController(this);
        mContext = getApplicationContext();

    }

    public void playVideo(View v) {


        startActivity(new Intent(this, CustomPlayerControlActivity.class));

       /* MediaController m = new MediaController(this);
        vid.setMediaController(m);

        mJSONURLString ="https://player.vimeo.com/video/396426809/config";

        RequestQueue requestQueue = Volley.newRequestQueue(mContext);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, mJSONURLString,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject mainObject = new JSONObject(response);
                    Log.d("mainObject", ""+response);
                    JSONObject requestObject = mainObject.getJSONObject("request");
                    JSONObject fileObject = requestObject.getJSONObject("files");
                    JSONArray mArray = fileObject.getJSONArray("progressive");

                    for (int i=0; i< mArray.length(); i++)
                    {
                        JSONObject jsonObject = mArray.getJSONObject(i);
                        videoUrl = jsonObject.getString("url");
                        Log.d("videoUrl", ""+videoUrl);
                    }

                    MediaController mediaController = new MediaController(MainActivity.this);
                    mediaController.setAnchorView(vid);
                    vid.setVisibility(View.VISIBLE);;
                    vid.setVideoURI(Uri.parse(videoUrl));
                    vid.setMediaController(mediaController);
                    vid.requestFocus();
                    vid.start();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse networkResponse = error.networkResponse;
                if (networkResponse != null && networkResponse.data != null) {
                    String jsonError = new String(networkResponse.data);
                    Log.d("ERR",jsonError);

                    try {
                        JSONObject obj=new JSONObject(jsonError);
                        String title=obj.getString("title");
                        Log.d("title",title);
                        String msg=obj.getString("message");
                        Log.d("titlemessage",msg);
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                        alertDialog.setTitle(title);
                        alertDialog.setMessage(msg);

                        alertDialog.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });

                        alertDialog.show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                pDialog.setIndeterminate(false);
                pDialog.setCancelable(false);
                Toast.makeText(getApplicationContext(),"Sorry, this video cannot be played here",Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);*/
    }
}
