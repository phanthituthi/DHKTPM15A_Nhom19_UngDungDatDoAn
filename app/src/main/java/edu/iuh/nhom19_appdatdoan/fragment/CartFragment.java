package edu.iuh.nhom19_appdatdoan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import edu.iuh.nhom19_appdatdoan.R;
import edu.iuh.nhom19_appdatdoan.adapter.CakeAdapter;
import edu.iuh.nhom19_appdatdoan.entity.Cake;
import edu.iuh.nhom19_appdatdoan.entity.HoaDon;


public class    CartFragment extends Fragment {

    GridView glList;
    CakeAdapter cakeCart;
    List<Cake> cakeCarts;
    int tongTien=0;
    HoaDon hoaDon;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        glList = view.findViewById(R.id.gvListCart);
  //      hoaDon = new HoaDon();
  //      cakeCart = new CakeAdapter(getActivity(), R.layout.item_cart, cakeCarts);
        glList.setAdapter(cakeCart);
        for (Cake cake : cakeCarts) {
            tongTien=tongTien+cake.getPriceCake();
        }
        return view;
    }
}