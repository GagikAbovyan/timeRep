package com.example.student.week7homework2.threads;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.student.week7homework2.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class DownloadUsersThread implements Callable<ArrayList<User>>{

    private final Context context;
    public DownloadUsersThread(final Context context) {
        this.context =context;
    }

    @Override
    public ArrayList<User> call() throws Exception {
        final String url = "https://jsonplaceholder.typicode.com/photos";
        ArrayList<User> list  = getData(url);
        return list;
    }

    private ArrayList<User> getData(final String url) {
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        final ArrayList<User> list = new ArrayList<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        User user = new User();
                        user.setTitle(jsonObject.getString("title"));
                        user.setUrl(jsonObject.getString("url"));
                        user.setThumbnailUrl(jsonObject.getString("thumbnailUrl"));
                        list.add(user);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonArrayRequest);
        return list;
    }
}
