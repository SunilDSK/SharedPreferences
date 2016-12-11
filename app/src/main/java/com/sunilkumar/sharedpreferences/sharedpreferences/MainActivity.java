package com.sunilkumar.sharedpreferences.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //UI elements
    EditText email,password;
    Button login;
    TextView output_email,output_password;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //References of UI elements
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        output_email = (TextView) findViewById(R.id.outputemail);
        output_password = (TextView) findViewById(R.id.outputpassword);

        //Instance of shared preference
        sharedPreferences = getApplicationContext().getSharedPreferences("Login",MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em = email.getText().toString().trim();
                String pas = password.getText().toString().trim();
                if(!em.isEmpty() && !pas.isEmpty())
                    work_with_sharedpreference(em,pas);
                else
                    Toast.makeText(getApplicationContext(),"Please make sure that you enter email and password worrectly!",Toast.LENGTH_LONG).show();
            }
        });


    }


    private void work_with_sharedpreference(String email,String password) {

        //Create and editor for shred preference
        editor = sharedPreferences.edit();
        //Write data to shared preference
        editor.putString("EmailID",email);
        editor.putString("Password",password);
        //Commit the changes done by the editor
        editor.commit();

        //Read the data from shared preferences
        String output_em = sharedPreferences.getString("EmailID",null);
        String outpur_pass = sharedPreferences.getString("Password",null);

        //Display the data
        output_email.setText(output_em);
        output_password.setText(outpur_pass);

    }
}
