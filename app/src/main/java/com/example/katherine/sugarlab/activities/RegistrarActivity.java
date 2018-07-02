package com.example.katherine.sugarlab.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.katherine.sugarlab.util.Constant;
import com.example.katherine.sugarlab.R;
import com.example.katherine.sugarlab.repositories.UserRepository;

public class RegistrarActivity extends AppCompatActivity {

    private EditText regusernameinput;
    private EditText regfullnameinput;
    private EditText regemailinput;
    private EditText regpasswordinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        regusernameinput = (EditText)findViewById(R.id.regusername_input);
        regfullnameinput = (EditText)findViewById(R.id.regfullname_input);
        regemailinput = (EditText)findViewById(R.id.regemail_input);
        regpasswordinput = (EditText)findViewById(R.id.regpassword_input);
    }

    public void callRegister(View view){
        String vregusernameinput = regusernameinput.getText().toString();
        String vregfullnameinput = regfullnameinput.getText().toString();
        String vregemailinput = regemailinput.getText().toString();
        String vregpasswordinput = regpasswordinput.getText().toString();

        if(vregusernameinput.isEmpty() || vregfullnameinput.isEmpty() || vregemailinput.isEmpty()|| vregpasswordinput.isEmpty()){
            Toast.makeText(this, "Ingresar todos los datos", Toast.LENGTH_SHORT).show();
            return;
        }

        UserRepository.create(vregusernameinput, vregfullnameinput, vregemailinput,vregpasswordinput);
        setResult(Constant.CONSTANT_USERACTIVITY);
        finish();

    }

}
