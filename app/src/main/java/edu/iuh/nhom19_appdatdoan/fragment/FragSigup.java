package edu.iuh.nhom19_appdatdoan.fragment;

import android.content.Intent;
import android.os.Bundle;
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
import com.google.firebase.database.FirebaseDatabase;

import edu.iuh.nhom19_appdatdoan.R;
import edu.iuh.nhom19_appdatdoan.activity.HomePage;
import edu.iuh.nhom19_appdatdoan.activity.RegisterActivity;
import edu.iuh.nhom19_appdatdoan.entity.User;

public class FragSigup extends Fragment {

    private EditText edtEmail, edtPass1, edtPass2, edtName;
    private Button butRegister;
    private FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_sigup, container, false);

        mAuth = FirebaseAuth.getInstance();

        edtName = view.findViewById(R.id.txtFullName);
        edtEmail = view.findViewById(R.id.txtEmailRe);
        edtPass1 = view.findViewById(R.id.txtPass);
        edtPass2 = view.findViewById(R.id.txtConPass);
        butRegister = view.findViewById(R.id.btnRe);

        butRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });



        return view;
    }

    private void register() {
        String email, name;
        String pass1, pass2;

        name = edtName.getText().toString();
        email = edtEmail.getText().toString();
        pass1 = edtPass1.getText().toString();
        pass2 = edtPass2.getText().toString();

        if(edtName.getText().length() == 0){
            edtName.setError("Vui lòng nhập tên đầy đủ của bạn!");
        }
        else if(edtEmail.getText().length() == 0){
            edtEmail.setError("Vui lòng nhập email của bạn!");
        }else if(edtPass1.getText().length() == 0){
            edtPass1.setError("Vui lòng nhập mật khẩu");
        }else if(edtPass2.getText().length() == 0){
            edtPass2.setError("Nhập lại mật khẩu lần 2");
        }else if(pass1.equals(pass2)){
            mAuth.createUserWithEmailAndPassword(email, pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){

//                        User user = new User();
                        User user = new User(name, email);
                        FirebaseDatabase.getInstance().getReference("User").
                                child(FirebaseAuth.getInstance().getCurrentUser().getUid()).
                                setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getActivity(), "Đăng kí thành tài khoản thành công", Toast.LENGTH_SHORT).show();

                                    edtEmail.setText("");
                                    edtName.setText("");
                                    Intent intent = new Intent(getActivity(), HomePage.class);
                                    startActivity(intent);
                                }else {
                                    Toast.makeText(getActivity(), "Đăng kí thất bại!!!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            });
        }else{
            Toast.makeText(getActivity(), "Nhập lại mật khẩu lần 2 khớp với lần 1", Toast.LENGTH_SHORT).show();
        }
    }
}
