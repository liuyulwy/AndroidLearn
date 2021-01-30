package com.ly.androiddemo;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        try {
//            test();
            test1();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void test() throws JSONException {
        String json = "{'name':'张三','age':18,'sex':true}";
        JSONObject jsonObject = new JSONObject(json);
        String name = jsonObject.getString("nam");
        Log.d("tag", name);

    }

    public void test1() throws JSONException {
        String json = "{'name':'张三','age':18,'sex':true,'obj': \"{'name':'张三','age':18,'sex':true}\"}";
        JSONObject jsonObject = new JSONObject(json);
        JSONObject obj = new JSONObject(jsonObject.getString("obj"));
        String name = obj.getString("name");
        Log.d("tag", name);
        Gson gson = new Gson();
        HashMap map = gson.fromJson(json, new TypeToken<HashMap<String,String>>(){}.getType());

        HashMap map1 = gson.fromJson(map.get("obj").toString(), new TypeToken<HashMap<String,String>>(){}.getType());
        Object o =map1.get("n");


    }
}