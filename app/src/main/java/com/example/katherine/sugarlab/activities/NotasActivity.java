package com.example.katherine.sugarlab.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.katherine.sugarlab.models.User;
import com.example.katherine.sugarlab.repositories.UserRepository;
import com.example.katherine.sugarlab.util.Constant;
import com.example.katherine.sugarlab.R;
import com.example.katherine.sugarlab.adapters.NoteAdapter;
import com.example.katherine.sugarlab.models.Note;
import com.example.katherine.sugarlab.repositories.NoteRepository;

import java.util.List;

public class NotasActivity extends AppCompatActivity {

    public static final String TAG = NotasActivity.class.getSimpleName();
    private String username;
    private String fullname;

    private TextView txtnoteusername;
    private RecyclerView notesList;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        // Configure ReciclerView
        notesList = (RecyclerView) findViewById(R.id.notes_list);
        txtnoteusername = (TextView) findViewById(R.id.txt_note_user_name);
        notesList.setLayoutManager(new LinearLayoutManager(this));

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        username = sharedPreferences.getString(Constant.CONSTANT_USERNAME,null);

        /*if (this.getIntent().getExtras() != null)
        {
            username = this.getIntent().getExtras().getString(Constant.CONSTANT_USERNAME);
            fullname = this.getIntent().getExtras().getString(Constant.CONSTANT_FULLNAME);

            txtnoteusername.setText(txtnoteusername.getText().toString() + fullname);

            // Set Data Adapter to ReciclerView
            List<Note> notes = NoteRepository.listuser(username);
            notesList.setAdapter(new NoteAdapter(notes));
        }*/

        if (username != null)
        {
            User user = UserRepository.getUser(username);

            fullname = user.getFullname();

            txtnoteusername.setText(txtnoteusername.getText().toString() + fullname);

            // Set Data Adapter to ReciclerView
            List<Note> notes = NoteRepository.listuser(username);
            notesList.setAdapter(new NoteAdapter(notes));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.cerrar_sesion :
                callLogaut();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void callLogaut() {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(Constant.CONSTANT_ISLOGGED,false);
        editor.commit();

        startActivity(new Intent(NotasActivity.this,MainActivity.class));

        finish();

    }

    public void callRegistrarNotes(View view)
    {
        Intent intent = new Intent(NotasActivity.this,RegistrarNotaActivity.class);
        intent.putExtra(Constant.CONSTANT_USERNAME,username);
        startActivityForResult(intent,Constant.CONSTANT_NOTASACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        NoteAdapter adapter = (NoteAdapter) notesList.getAdapter();

        List<Note> notes = NoteRepository.listuser(username);
        adapter.setNotas(notes);
        adapter.notifyDataSetChanged();

    }
}
