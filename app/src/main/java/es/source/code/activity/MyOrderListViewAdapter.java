package es.source.code.activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import es.source.code.model.Food;

public class MyOrderListViewAdapter extends BaseAdapter
{
    private Context context;
    private List<Food> list;
    public MyOrderListViewAdapter(Context context, List<Food> list)
    {
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object getItem(int i) {
        return list.get(i);
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder vh;
        if(view==null){
            vh = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.orderlist_simple,null);
            vh.orderFootName = (TextView) view.findViewById(R.id.textViewOrderName);
            vh.orderFootPrice = (TextView) view.findViewById(R.id.textViewOrderM);
            vh.orderFoodQuantity=(TextView) view.findViewById(R.id.textViewOrderQuantity);
            view.setTag(vh);
        }else {
            vh = (ViewHolder) view.getTag();
        }
        Food food = list.get(i);
        vh.orderFootName.setText(food.getFoodName());
        vh.orderFootPrice.setText(food.getFoodPrice());
        vh.orderFoodQuantity.setText("1");
        return view;
    }
    public class ViewHolder{
        TextView orderFootName;
        TextView orderFootPrice;
        TextView orderFoodQuantity;
    } }

