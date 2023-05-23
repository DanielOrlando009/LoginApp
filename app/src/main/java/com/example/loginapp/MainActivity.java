package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private boolean login = false;
    private String temp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView txtUsername = (TextView) findViewById(R.id.username);
        TextView txtPassword = (TextView) findViewById(R.id.password);

        MaterialButton btnLogin = (MaterialButton) findViewById(R.id.login);

        //admin and admin

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (txtUsername.getText().toString().equals("admin") && txtPassword.getText().toString().equals("admin")) {
//                    //correct password
//                    Toast.makeText(MainActivity.this, "LOGIN SUCCESS", Toast.LENGTH_SHORT).show();
//
//                    openLoggedAdminActivity();
//                } else if (txtUsername.getText().toString().equals("student") && txtPassword.getText().toString().equals("student")) {
//                    Toast.makeText(MainActivity.this, "LOGIN SUCCESS", Toast.LENGTH_SHORT).show();
//
//                    openLoggedStudentActivity();
//                } else {
//                    Toast.makeText(MainActivity.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
//                }

                getUserDetails();
            }
        });

    }

    public void openLoggedStudentActivity() {
        Intent intent = new Intent(this, LoggedStudentActivity.class);
        startActivity(intent);

    }

    public void openLoggedAdminActivity() {
        Intent intent = new Intent(this, LoggedAdminActivity.class);
        startActivity(intent);

    }


    private void getUserDetails() {
        GetUserDetailsTask task = new GetUserDetailsTask() {
            @Override
            protected void onPostExecute(Void result) {
                if(login)
                {
                    openLoggedStudentActivity();
                    Toast.makeText(MainActivity.this, temp, Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(MainActivity.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
                }

                //openLoggedStudentActivity();
            }
        };

        task.execute();
    }


    private class GetUserDetailsTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            String apiEndpoint = "http://169.0.125.182:44444/api/mobile/login/";
            //api/login/admin@uj/admin
            //api/student/login/studentno/pass(Stu NO)
            try {
                // Construct the API URL for user details
                //String userDetailsUrl = apiEndpoint + "/api/students";

                //api/mobile/login/(Admin Email/Stu No)/password


                TextView txtUsername = (TextView) findViewById(R.id.username);
                TextView txtPassword = (TextView) findViewById(R.id.password);

                apiEndpoint = apiEndpoint + txtUsername.getText() + "/" + txtPassword.getText();



                // Create a URL object with the constructed API URL
                URL url = new URL(apiEndpoint);

                // Open a connection to the API URL
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                //connection.setRequestProperty();

                // Set the request method to GET
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type", "application/json");

                // Check if the response code indicates success
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    //System.out.println("Success");

                    //openLoggedStudentActivity();
                    // Read the response from the API
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    StringBuilder response = new StringBuilder();

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();

                    // Process the response as needed
                    String userDetailsJson = response.toString();

                    JSONObject jObj = new JSONObject(userDetailsJson);

                    if(jObj.getBoolean("status"))
                    {

                    }




                    //jObj.getString("message");

                    jObj.getJSONObject("obj");
                    jObj.getBoolean("status");

                    System.out.println(jObj.getString("message"));
                    temp = userDetailsJson;
                    login = jObj.getBoolean("status");;

                } else {
                    System.out.println("Failed to retrieve user details. Response code: " + connection.getResponseCode());
                }

            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            // Perform network operation here
            // Make sure not to update UI elements directly from this method
            return null;
        }

    }

}

