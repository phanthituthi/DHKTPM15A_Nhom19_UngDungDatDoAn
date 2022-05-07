package edu.iuh.nhom19_appdatdoan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import edu.iuh.nhom19_appdatdoan.R;
import edu.iuh.nhom19_appdatdoan.adapter.CakeAdapter;
import edu.iuh.nhom19_appdatdoan.entity.Cake;


public class HomeFragment extends Fragment {

    GridView glList;
    CakeAdapter adt;
    ArrayList<Cake> arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);



        arrayList = new ArrayList<>();
        glList = view.findViewById(R.id.gvList);

        arrayList.add(new Cake(4, R.drawable.cake1, "Chicken burger", "200 gr chicken + cheese Lettuce + tomato", 35));
        arrayList.add(new Cake(5, R.drawable.cake2, "Chese burger", "120 gr meat + Lettuce cheese + onion + tomato", 25));
        arrayList.add(new Cake(5, R.drawable.hamberger3, "Hot burger", "100 gr lamb + Olive oil cheese + tomato", 15));
        arrayList.add(new Cake(4, R.drawable.sandwich1, "Chicken sandwich", "310 gr meat + Lettuce cheese + onion + tomato", 20));
        arrayList.add(new Cake(3, R.drawable.sandwich2, "Hot sandswich", "240 gr beef + Lettuce vegetable + onion", 21));
        arrayList.add(new Cake(2, R.drawable.pizza, "Chese pizza", "100 gr pork + Lettuce carrot + onion + 100gr bread", 14));

//        adt = new CakeAdapter(HomeFragment.this, R.layout.gird_item, arrayList);
        adt = new CakeAdapter(getActivity(), R.layout.gird_item, arrayList);
        glList.setAdapter(adt);

        return view;

    }
}