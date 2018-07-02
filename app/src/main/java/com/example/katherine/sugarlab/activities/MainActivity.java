package com.example.katherine.sugarlab.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.katherine.sugarlab.util.Constant;
import com.example.katherine.sugarlab.R;
import com.example.katherine.sugarlab.models.User;
import com.example.katherine.sugarlab.repositories.UserRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private EditText usernameInput;
    private EditText passwordInput;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = (EditText)findViewById(R.id.username_input);
        passwordInput = (EditText)findViewById(R.id.password_input);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String username = sharedPreferences.getString(Constant.CONSTANT_USERNAME,null);
        if (username != null) {
            usernameInput.setText(username);
            passwordInput.requestFocus();
        }

        if (sharedPreferences.getBoolean(Constant.CONSTANT_ISLOGGED,false))
        {
            Intent intent=new Intent(MainActivity.this,NotasActivity.class);
            startActivity(intent);
        }

    }

    public void callLogin(View view){

        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(username.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Ingresar sus credenciales...correctamente", Toast.LENGTH_SHORT).show();
            return;
        }

        // Login logic
        User user = UserRepository.login(username, password);

        if(user == null){
            Toast.makeText(this, "Username or password invalid", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constant.CONSTANT_USERNAME,user.getUsuario());
        editor.putBoolean(Constant.CONSTANT_ISLOGGED,true);
        editor.commit();

        Intent intent=new Intent(MainActivity.this,NotasActivity.class);
//        intent.putExtra(Constant.CONSTANT_USERNAME,user.getUsuario());
//        intent.putExtra(Constant.CONSTANT_FULLNAME,user.getFullname());
        startActivity(intent);
        finish();
        //Toast.makeText(this, "Welcome " + user.getFullname(), Toast.LENGTH_SHORT).show();
    }

    public  void callRegisterForm(View view)
    {
        startActivityForResult(new Intent(this, RegistrarActivity.class),Constant.CONSTANT_USERACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Constant.CONSTANT_USERACTIVITY) {


        }
        List<User> users = UserRepository.list();
        for (User user:users) {
            Log.d(TAG,"user" + user);
        }
    }
}
