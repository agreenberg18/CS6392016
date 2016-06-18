package com.andrew.menuprojectv4;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.net.Uri;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.help){
            startActivity(new Intent(MainActivity.this, HelpActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sms = (Button) findViewById(R.id.buttonSms);
        Button phone = (Button) findViewById(R.id.phone);
        Button web = (Button) findViewById(R.id.web);
        Button map = (Button) findViewById(R.id.map);
        Button share = (Button) findViewById(R.id.share);
        Button act = (Button) findViewById(R.id.act);






        sms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSms();
            }
    });
        phone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                call();
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                web();
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                map();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                share();
            }
        });
        act.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                act();
            }
        });

}

    protected void sendSms(){
        final Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto: " + Uri.encode("8455585168")));
        intent.putExtra("sms_body", "hello");
        startActivity(intent);
    }
    protected void call(){
        final Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:845-558-5168"));
        startActivity(intent);
    }
    protected void web(){
        final Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.reddit.com"));
        startActivity(intent);
    }
    protected void map(){
        final Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:41.0959909,-73.9261131"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
    protected void share(){
        Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
        shareIntent.setType("");
        startActivity(Intent.createChooser(shareIntent,"Share the Love"));

    }


    protected void act(){
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }
}

