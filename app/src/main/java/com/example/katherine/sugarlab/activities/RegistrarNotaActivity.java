package com.example.katherine.sugarlab.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.katherine.sugarlab.util.Constant;
import com.example.katherine.sugarlab.R;
import com.example.katherine.sugarlab.repositories.NoteRepository;

import java.util.Date;

public class RegistrarNotaActivity extends AppCompatActivity {

    public static final String TAG = RegistrarNotaActivity.class.getSimpleName();
    private String username;
    private EditText regnotatitleinput;
    private EditText regnotaregistarinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_nota);

        if (this.getIntent().getExtras() != null)
        {
            username = this.getIntent().getExtras().getString(Constant.CONSTANT_USERNAME);
        }

        regnotatitleinput = (EditText)findViewById(R.id.regnotatitle_input);
        regnotaregistarinput = (EditText)findViewById(R.id.regnotaregistar_input);
    }

    public void callRegisterNote(View view){

        String vregnotatitleinput = regnotatitleinput.getText().toString();
        String vregnotaregistarinput = regnotaregistarinput.getText().toString();

        if(vregnotatitleinput.isEmpty() || vregnotaregistarinput.isEmpty()){
            Toast.makeText(this, "Ingrese todos los Datos", Toast.LENGTH_SHORT).show();
            return;
        }

//        Log.d(TAG,"Create :" + username);
//        Log.d(TAG,"Create :" + vregnotatitleinput);
//        Log.d(TAG,"Create :" + vregnotaregistarinput);
//        Log.d(TAG,"Create :" + new Date());

        NoteRepository.create(username, vregnotatitleinput, vregnotaregistarinput,new Date(),false);
        setResult(Constant.CONSTANT_NOTASACTIVITY);
        finish();

    }

}
