package edu.iuh.nhom19_appdatdoan.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import edu.iuh.nhom19_appdatdoan.R;
import edu.iuh.nhom19_appdatdoan.entity.User;

public class UserInfo extends AppCompatActivity {
    Button btnUpdate, btnLogout;
    EditText edtName, edtAddr, edtPhone;
    TextView tvEmail;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        btnLogout = findViewById(R.id.btnLogoutProfile);
        btnUpdate = findViewById(R.id.btnUpdateProfile);
        edtName = findViewById(R.id.edtFullNameUser);
        edtAddr = findViewById(R.id.edtAddUser);
        edtPhone = findViewById(R.id.edtPhoneUser);
        tvEmail = findViewById(R.id.tvEmailProFile);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserInfo.this, LoginRegister.class);
                startActivity(intent);
                finish();
                Toast.makeText(UserInfo.this, "Succesfully Logout", Toast.LENGTH_SHORT).show();
            }
        });

//        setUserInformation();

        final DatabaseReference ref1 = database.getReference("User").
                child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        ref1.child("email").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String email = snapshot.getValue().toString();
                tvEmail.setText(email);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user == null){
            return;
        }
        edtPhone.setText(user.getPhoneNumber());
        edtAddr.setText(user.getEmail());

        ref1.child("name").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.getValue().toString();
                edtName.setText(name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
               if(user == null){
                   return;
               }

               String name1 = edtName.getText().toString().trim();
                UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder()
                        .setDisplayName(name1)
                        .build();

                user.updateProfile(profileChangeRequest)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(UserInfo.this, "Update Success", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


//        ref1.child("diaChi").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String diaChi = snapshot.getValue().toString();
//                if(diaChi == null){
//                   return;
//                }
//                edtAddr.setText(diaChi);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

//        ref1.child("sdt").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String sdt = snapshot.getValue().toString();
//                edtPhone.setText(sdt);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


//        setUserInformation();


    }

//    private void setUserInformation() {
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        if(user == null){
//            return;
//        }
//        edtName.setText(user.getDisplayName());
//        edtPhone.setText(user.getPhoneNumber());
//
//    }
}