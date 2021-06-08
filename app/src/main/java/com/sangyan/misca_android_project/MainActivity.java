package com.sangyan.misca_android_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

List<Country> item ;
RecyclerView recycler_view;
CountryAdapter adapter;
    public  static  String url= "https://restcountries.eu/rest/v2/region/asia";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler_view = recycler_view.findViewById(R.id.recycler_view);
        item = new ArrayList<>();
        fetchData();







    }
    private void fetchData(){

        RequestQueue q =  Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {


            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {


                        JSONObject countryObject = response.getJSONObject(i);
                        Country c = new Country();
                        c.setName(countryObject.getString("name"));
                        c.setName(countryObject.getString("capital"));
                       // c.setName(countryObject.getString("flag").toString());
                        item.add(c);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recycler_view.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new CountryAdapter(getApplicationContext(),item);
                recycler_view.setAdapter(adapter);
            }

        }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse: ");
            }
        });
         q.add(jsonArrayRequest);

    }}