package com.andrew.andrewgreenbergmidterm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    Button button;
    TextView result;
    String answer;
    double ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        result = (TextView)findViewById(R.id.textView2);

        button.setOnClickListener(
            new View.OnClickListener()
            {
                public void onClick(View view)
                {
                    answer = edit.getText().toString();
                    ans = Double.parseDouble(answer);
                    ans = ans * 439.36;
                    ans = Math.round(ans*100.0)/100.0;
                    answer = Double.toString(ans);
                    result.setText("$ " + answer);
                }
            });
        }

}
