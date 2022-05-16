package edu.iuh.nhom19_appdatdoan.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import edu.iuh.nhom19_appdatdoan.R;
import edu.iuh.nhom19_appdatdoan.adapter.CakeAdapter;
import edu.iuh.nhom19_appdatdoan.entity.Cake;


public class    CartFragment extends Fragment {
    private EditText editSoLuong;
    TextView txtGia;
    ListView lvCake;
    CakeAdapter adapter;
    Integer tongTien=0;
    Button buttonDatHang;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        String txtName = getActivity().getIntent().getExtras().getString("name");
        String txtNote = getActivity().getIntent().getExtras().getString("note");
        String txtprice = getActivity().getIntent().getExtras().getString("price");
        String txtimg = getActivity().getIntent().getExtras().getString("img");
        String txtDanhGia = getActivity().getIntent().getExtras().getString("danhgia");
        lvCake = view.findViewById(R.id.listspGioHang);
        editSoLuong = view.findViewById(R.id.editSL);
        txtGia = view.findViewById(R.id.txtGiaThuc);
        lvCake.setAdapter(adapter);
        tongTien = Integer.valueOf(editSoLuong.getText().toString());
        buttonDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




        return view;
    }


}