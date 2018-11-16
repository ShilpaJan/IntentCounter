package com.example.paresh.intentcounter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    Button button3,btnBack;
    TextView counterValue3;
    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button button3=(Button)findViewById(R.id.button3);
        btnBack=(Button)findViewById(R.id.btnBack);
        counterValue3=(TextView)findViewById(R.id.counterValue3);
        SharedPreferences mycount=this.getSharedPreferences("MyCounter",Context.MODE_PRIVATE);
        counter=mycount.getInt("bount",0);
        counterValue3.setText(" " +counter);



        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                ++counter;
                startActivity(intent);
                counterValue3.setText(Integer.toString(counter));
                SharedPreferences mycount=getSharedPreferences("MyCounter",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=mycount.edit();
                editor.putInt("bount",counter);
                editor.commit();
                counterValue3.setText(" " +counter);



            }

        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThirdActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });





    }
}
