package edu.iuh.nhom19_appdatdoan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import edu.iuh.nhom19_appdatdoan.R;
import edu.iuh.nhom19_appdatdoan.activity.HomePage;
import edu.iuh.nhom19_appdatdoan.activity.LoginAcitivity;

public class FragLogin extends Fragment{
    Button btnLogin;
    private FirebaseAuth mAuth;
    private EditText editEmail, editPass;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_login, container, false);

        mAuth = FirebaseAuth.getInstance();

        editEmail = view.findViewById(R.id.txtEmail);
        editPass = view.findViewById(R.id.txtPassLogin);
        btnLogin = view.findViewById(R.id.btnLogin);



        btnLogin = view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), HomePage.class);
//                startActivity(intent );
                login();
            }
        });



        return view;
    }

    private void login() {
        String email, password;
        email = editEmail.getText().toString();
        password = editPass.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(getActivity(), "Vui lòng nhập email !!!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(getActivity(), "Vui lòng nhập password!!!", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("User");

                    Toast.makeText(getActivity(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), HomePage.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getActivity(), "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
