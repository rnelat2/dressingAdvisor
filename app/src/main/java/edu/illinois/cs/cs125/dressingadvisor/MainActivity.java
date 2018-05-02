package edu.illinois.cs.cs125.dressingadvisor;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static RequestQueue requestQueue = null;

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(requestQueue == null) {
            requestQueue = Volley.newRequestQueue(this);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        displaySelectedFragment(R.id.nav_adviser);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;//a
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_adviser_refresh) {
            startAPICall();
            return true;
        }


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about_help) {
            Toast.makeText(this, "FixME: Help screen of About goes here", Toast.LENGTH_LONG).show();
            return true;
        }

        if (id == R.id.action_zipcode_help) {
            Toast.makeText(this, "FixME: Help screen of ZipCode goes here", Toast.LENGTH_LONG).show();
            return true;
        }

        if (id == R.id.action_adviser_help) {
            Toast.makeText(this, "FixME: Help screen of Adviser goes here", Toast.LENGTH_LONG).show();
            return true;
        }

        if (id == R.id.action_tops_help) {
            Toast.makeText(this, "FixME: Help screen of Tops goes here", Toast.LENGTH_LONG).show();
            return true;
        }

        if (id == R.id.action_bottoms_help) {
            Toast.makeText(this, "FixME: Help screen of bottoms goes here", Toast.LENGTH_LONG).show();
            return true;
        }

        if (id == R.id.action_shoes_help) {
            Toast.makeText(this, "FixME: Help screen of shoes goes here", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void displaySelectedFragment(int id) {

        //creating fragment object
        fragment = null;
        if (id == R.id.nav_adviser) {
            fragment = new AdviserFragment();
        } else if (id == R.id.nav_zipcode) {
            fragment = new ZipCodeFragment();
        } else if (id == R.id.nav_about) {
            fragment = new AboutFragment();
        } else if (id == R.id.nav_tops) {

        } else if (id == R.id.nav_bottoms) {

        } else if (id == R.id.nav_shoes) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }


        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

    @SuppressWarnings("none")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        displaySelectedFragment(id);
        return true;
    }


    void startAPICall() {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "http://api.openweathermap.org/data/2.5/weather?zip=" + ZipCodeFragment.getZipCode() + ",us&appid=5143b4042b3c28c3414b828da69dcc80\n",
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {

                            try {
                                String jsonString = response.toString(2);
                                Log.d("Adviser", jsonString);

                                String tempStr = response.getJSONObject("main").getString("temp");
                                String weather = response.getJSONArray("weather").getJSONObject(0).getString("main");

                                double temperature = (((Double.parseDouble(tempStr) - 273) * 9/5) + 32);
                                DecimalFormat df = new DecimalFormat("#.##");

                                String tempF = df.format(temperature);

                                Log.d("Adviser", "Temperature = " + tempF);
                                Log.d("Adviser", "Weather     = " + weather);

                                if(fragment instanceof AdviserFragment) {
                                    AdviserFragment af = AdviserFragment.class.cast(fragment);
                                    af.updateTemperatureAndWeather(tempF, weather);
                                }
                            } catch (JSONException ignored) { }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(final VolleyError error) {
                    Log.e("Adviser", error.toString());
                }
            });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace(); //test push
        }
    }
}

/*

{
      "coord": {
        "lon": -122.09,
        "lat": 37.39
      },
      "weather": [
        {
          "id": 500,
          "main": "Rain",
          "description": "light rain",
          "icon": "10d"
        }
      ],
      "base": "stations",
      "main": {
        "temp": 280.44,
        "pressure": 1017,
        "humidity": 61,
        "temp_min": 279.15,
        "temp_max": 281.15
      },
      "visibility": 12874,
      "wind": {
        "speed": 8.2,
        "deg": 340,
        "gust": 11.3
      },
      "clouds": {
        "all": 1
      },
      "dt": 1519061700,
      "sys": {
        "type": 1,
        "id": 392,
        "message": 0.0027,
        "country": "US",
        "sunrise": 1519051894,
        "sunset": 1519091585
      },
      "id": 0,
      "name": "Mountain View",
      "cod": 200
    }


 */