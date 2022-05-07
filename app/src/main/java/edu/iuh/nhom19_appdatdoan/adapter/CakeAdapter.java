package edu.iuh.nhom19_appdatdoan.adapter;

import static java.lang.Float.valueOf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.iuh.nhom19_appdatdoan.R;
import edu.iuh.nhom19_appdatdoan.entity.Cake;

public class CakeAdapter extends BaseAdapter {
    private Context ctx;
    private int layout;
    private ArrayList<Cake> arrayList;
    private List<Cake> listFilter;
    private int postitionSelect = -1;

    public CakeAdapter(Context ctx, int layout, ArrayList<Cake> arrayList) {
        this.ctx = ctx;
        this.layout = layout;
        this.arrayList = arrayList;
        this.listFilter = arrayList;
    }


    @Override
    public int getCount() {
        if(listFilter.size() !=0 && !listFilter.isEmpty()){
            return listFilter.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null){
            view = LayoutInflater.from(ctx).inflate(layout, viewGroup, false);

            viewHolder = new ViewHolder();

            viewHolder.tvdanhgia = view.findViewById(R.id.tvDanhGiaCake);
            viewHolder.imgvCake = view.findViewById(R.id.imgvCake);
            viewHolder.tvNameCake = view.findViewById(R.id.tvNameCake);
            viewHolder.tvNoteCake = view.findViewById(R.id.tvNoteCake);
            viewHolder.tvpriceCake = view.findViewById(R.id.tvPriceCake);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tvdanhgia.setText(String.valueOf(arrayList.get(i).getDanhgia()));
        viewHolder.imgvCake.setImageResource(arrayList.get(i).getImgCake());
        viewHolder.tvNameCake.setText(arrayList.get(i).getNameCake());
        viewHolder.tvNoteCake.setText(arrayList.get(i).getNoteCake());
        viewHolder.tvpriceCake.setText(String.valueOf(arrayList.get(i).getPriceCake()));
        return view;
    }

    private class ViewHolder{
        TextView tvdanhgia;
        ImageView imgvCake;
        TextView tvNameCake;
        TextView tvNoteCake;
        TextView tvpriceCake;
    }

}
