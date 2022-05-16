package edu.iuh.nhom19_appdatdoan.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import edu.iuh.nhom19_appdatdoan.R;
import edu.iuh.nhom19_appdatdoan.activity.CartActivity;
import edu.iuh.nhom19_appdatdoan.activity.HomePage;
import edu.iuh.nhom19_appdatdoan.activity.UserInfo;
import edu.iuh.nhom19_appdatdoan.adapter.CakeAdapter;
import edu.iuh.nhom19_appdatdoan.entity.Cake;


public class HomeFragment extends Fragment {

    GridView glList;
    CakeAdapter adt;
    ArrayList<Cake> arrayList;
    Button btnBugger, btnSandSwich, btnPizza;
    EditText edtSearch;

    ImageView imgView;
    TextView tvNameAvavatar;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        arrayList = new ArrayList<>();
        glList = view.findViewById(R.id.gvListCart);

        btnBugger = view.findViewById(R.id.btnBuger);
        btnSandSwich = view.findViewById(R.id.btnSandSwich);
        btnPizza = view.findViewById(R.id.btnPizza);
        edtSearch = view.findViewById(R.id.edtSearch);

        imgView = view.findViewById(R.id.imgvAvatar);
        tvNameAvavatar = view.findViewById(R.id.tvNameAvatar);
        final DatabaseReference ref1 = database.getReference("User").
                child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        ref1.child("name").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.getValue().toString();
                tvNameAvavatar.setText("hi, "+name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        arrayList.add(new Cake(4, R.drawable.cake1, "Chicken burger", "200 gr chicken + cheese Lettuce + tomato", 35));
        arrayList.add(new Cake(5, R.drawable.cake2, "Chese burger", "120 gr meat + Lettuce cheese + onion + tomato", 25));
        arrayList.add(new Cake(5, R.drawable.hamberger3, "Hot burger", "100 gr lamb + Olive oil cheese + tomato", 15));
        arrayList.add(new Cake(4, R.drawable.sandwich1, "Chicken sandwich", "310 gr meat + Lettuce cheese + onion + tomato", 20));
        arrayList.add(new Cake(3, R.drawable.sandwich2, "Hot sandwich", "240 gr beef + Lettuce vegetable + onion", 21));
        arrayList.add(new Cake(2, R.drawable.pizza, "Chese pizza", "100 gr pork + Lettuce carrot + onion + 100gr bread", 14));

//        adt = new CakeAdapter(HomeFragment.this, R.layout.gird_item, arrayList);
        adt = new CakeAdapter(getActivity(), R.layout.gird_item, arrayList);
        glList.setAdapter(adt);



//        final DatabaseReference ref1 = database.getReference("User").
//                child(FirebaseAuth.getInstance().getCurrentUser().getUid());
//        ref1.child("name").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String name = snapshot.getValue().toString();
//                tvNameAvavatar.setText("Hi, " + name);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });



        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), UserInfo.class);
                startActivity(intent);
            }
        });

        btnBugger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adt.filterBugger();
                adt.setActiveButton(btnBugger, btnPizza, btnSandSwich);
            }
        });

        btnSandSwich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adt.fileterSandSwich();
                adt.setActiveButton(btnSandSwich, btnBugger, btnPizza);
            }
        });

        btnPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adt.filterPizza();
                adt.setActiveButton(btnPizza, btnBugger, btnSandSwich);
            }
        });
        glList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(String.valueOf(CartFragment.class));
                Bundle b = new Bundle();
                b.putString("name", arrayList.get(i).getNameCake());
                b.putString("note", arrayList.get(i).getNoteCake());
                b.putInt("price", arrayList.get(i).getPriceCake());
                b.putInt("img", arrayList.get(i).getImgCake());
                intent.putExtras(b);

                startActivity(intent);
            }
        });




        return view;


    }
}