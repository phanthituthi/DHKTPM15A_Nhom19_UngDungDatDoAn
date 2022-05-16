package edu.iuh.nhom19_appdatdoan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import edu.iuh.nhom19_appdatdoan.R;

public class UserInfo extends AppCompatActivity {
    Button btnUpdate, btnLogout;
    EditText edtName, edtAdd, edtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
    }
}