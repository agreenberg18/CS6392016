package com.andrew.cs639firebase;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.andrew.cs639firebase.Data.Person;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText idEditText, nameEditText;
    Button submitBtn;
    ArrayList<String> ids = new ArrayList<>();
    ListView lv;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //initialize and setting up firebase/retreive data
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        this.retreiveData();

        idEditText = (EditText) findViewById(R.id.idEditText);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        submitBtn = (Button) findViewById(R.id.submitButton);
        lv = (ListView) findViewById(R.id.listView);

        submitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            addData(idEditText.getText().toString(), nameEditText.getText().toString());

                idEditText.setText("");
                nameEditText.setText("");
            }
        });

    }

    private void addData(String id, String name){
        Person p = new Person();
        p.setId(id);
        p.setName(name);

        myRef.child("Person").push().setValue(p);
    }

    //Retrieve Data

    private void retreiveData(){
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void getUpdates(DataSnapshot ds){
        ids.clear();
        for(DataSnapshot data : ds.getChildren()) {
            Person p = new Person();
            p.setId(data.getValue(Person.class).getId());
            p.setName(data.getValue(Person.class).getName());

            ids.add("Name: " + p.getName() + "     " + "id: " + p.getId());
        }
        if(ids.size()>0){
            ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, ids);
            lv.setAdapter(adapter);
        }else{
            Toast.makeText(MainActivity.this, "No data found",  Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
