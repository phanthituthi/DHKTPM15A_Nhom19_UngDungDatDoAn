package edu.iuh.nhom19_appdatdoan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import edu.iuh.nhom19_appdatdoan.R;

public class LoginAcitivity extends AppCompatActivity {
    //email: food@gmail.com
    // pass: 123456

    private FirebaseAuth mAuth;
    private EditText editEmail, editPass;
    private Button butLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_login);

        mAuth = FirebaseAuth.getInstance();

        editEmail = findViewById(R.id.txtEmail);
        editPass = findViewById(R.id.txtPassLogin);
        butLogin = findViewById(R.id.btnLogin);



        butLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        String email, password;
        email = editEmail.getText().toString();
        password = editPass.getText().toString();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Vui lòng nhập email !!!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Vui lòng nhập password!!!", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("User");

                    Toast.makeText(LoginAcitivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginAcitivity.this, HomePage.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginAcitivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

