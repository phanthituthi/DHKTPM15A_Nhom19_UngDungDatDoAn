package edu.iuh.nhom19_appdatdoan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import edu.iuh.nhom19_appdatdoan.R;

public class MainActivity extends AppCompatActivity {
    ImageView imageVMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageVMain = findViewById(R.id.imgMain);

        imageVMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginRegister.class);
                startActivity(intent );
            }
        });

    }
}