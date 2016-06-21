package com.andrew.asynctaskproject;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.theImage);
        LoadImage loading = new LoadImage();
        loading.execute();


    }

    public class LoadImage extends AsyncTask<String, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... params) {
            // TODO Auto-generated method stub

            try {
                URL url = new URL("https://github.com/agreenberg18/CS6392016/blob/master/ASyncTaskProject/sloth.jpg?raw=true");
                InputStream is = url.openConnection().getInputStream();
                Bitmap bitMap = BitmapFactory.decodeStream(is);
                return bitMap;

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            iv.setImageBitmap(result);
        }

    }
}
