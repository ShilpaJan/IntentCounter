package com.example.paresh.intentcounter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1,btnBack;
    TextView counterValue;
    int counter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1=(Button)findViewById(R.id.button1);
        btnBack=(Button)findViewById(R.id.btnBack);
        counterValue=(TextView)findViewById(R.id.counterValue);
        SharedPreferences mycount=this.getSharedPreferences("MyCounter",Context.MODE_PRIVATE);
        counter=mycount.getInt("count",0);
        counterValue.setText("  " +counter);





        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                ++counter;
                startActivity(intent) ;
                counterValue.setText(Integer.toString(counter));
                SharedPreferences mycount=getSharedPreferences("MyCounter",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=mycount.edit();
                editor.putInt("count",counter);
                editor.commit();

                counterValue.setText("  " +counter);


            }

        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}
