package com.example.paresh.intentcounter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    Button button2,btnBack;
    TextView counterValue2;
    int counter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button2=(Button)findViewById(R.id.button2);
        btnBack=(Button)findViewById(R.id.btnBack);
        counterValue2=(TextView)findViewById(R.id.counterValue2);
        SharedPreferences mycount=this.getSharedPreferences("MyCounter",Context.MODE_PRIVATE);
        counter=mycount.getInt("mount",0);
        counterValue2.setText(" " +counter);



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                ++counter;
                startActivity(intent);

                counterValue2.setText(Integer.toString(counter));

                SharedPreferences mycount=getSharedPreferences("MyCounter",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=mycount.edit();
                editor.putInt("mount",counter);
                editor.commit();
                counterValue2.setText(" " +counter);



            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
