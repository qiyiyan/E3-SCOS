package es.source.code.activity;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import es.source.code.model.Food;

public class OrderDataFragment extends Fragment {
    public static final String ARGS_PAGE = "args_page";
    private int mPage;
    private final static String[] DishName0 = {
     "凉拌木耳","凉拌土豆丝","肉丝拉皮","拍黄瓜","凉拌苦瓜",
     "凉拌海带丝","菠菜拌粉丝","芹菜拌腐竹","糖醋萝卜丝"
    };
    private final static String[] DishPrice0 = {
            "10","12","15","10","20","13",
            "11","16","14"
    };
    private final static String[] DishName1 = {
            "番茄菜花","京酱肉丝","孜然羊肉","酱爆鸡丁","香酥鸡翅",
            "糖醋里脊","木耳炒山药","香辣鸡胗", "红烧肉"
    };
    private final static String[] DishPrice1 = {
            "20","35","50","28","30","35",
            "20","35","35"
    };
    private final static String[] DishName2 = {
            "香辣虾","腰果鱿鱼丝","葱香炒虾皮","清蒸带鱼","清蒸小龙虾",
            "海蛎煎","清蒸鲈鱼","爆炒花蛤","海鲜烘蛋"
    };
    private final static String[] DishPrice2 = {
            "35","45","25","35","45","45",
            "55","15","25"
    };
    private final static String[] DishName3 = {
             "青岛啤酒","哈尔滨啤酒","百威啤酒","燕京啤酒","五粮液","剑南春"
    };
    private final static String[] DishPrice3 = {
            "8","8","18","8","88","78",
    };
    ///private Boolean isSubmitDish;//是否提交订单
    public static OrderDataFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARGS_PAGE, page);
        OrderDataFragment fragment = new OrderDataFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARGS_PAGE);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_order_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final List<Food> list = new ArrayList<>();
        ListView lv2=(ListView)getView().findViewById(R.id.listView2);
        TextView textViewSum2=(TextView)getView().findViewById(R.id.textViewSum2);//总数
        final TextView textViewPrice2=(TextView)getView().findViewById(R.id.textViewPrice2);//总价
        final TextView textViewPrice3=(TextView)getView().findViewById(R.id.textViewPrice3);//总价
        Button buttonClick = (Button)getView().findViewById(R.id.buttonClick);//结账或提交订单
        //ListView
        MyOrderListViewAdapter myOrderListViewAdapter = new MyOrderListViewAdapter(getActivity(),list);
        lv2.setAdapter(myOrderListViewAdapter);
        Bundle bundle = getArguments();
        if(bundle!=null){
            int arg = bundle.getInt("arg");
            final Boolean oldUser = bundle.getBoolean("oldUser");
            SCOSDataBase scosDataBase = new SCOSDataBase(getContext());
            String clickDishString = scosDataBase.load();
            int TotalPrice=0;
            switch (arg){
                case 0://未下单菜
                    //加载未下单的菜品
                    for(int i=0;i<clickDishString.length();i=i+2)
                    {
                        if(clickDishString.charAt(i)=='0'){
                            list.add(new Food(""+DishName0[clickDishString.charAt(i+1)-0x30] ,""+DishPrice0[clickDishString.charAt(i+1)-0x30]));
                            TotalPrice=TotalPrice+Integer.parseInt(DishPrice0[clickDishString.charAt(i+1)-0x30]);
                        }else if(clickDishString.charAt(i)=='1'){
                            list.add(new Food(""+DishName1[clickDishString.charAt(i+1)-0x30] ,""+DishPrice1[clickDishString.charAt(i+1)-0x30]));
                            TotalPrice=TotalPrice+Integer.parseInt(DishPrice1[clickDishString.charAt(i+1)-0x30]);
                        }else if(clickDishString.charAt(i)=='2'){
                            list.add(new Food(""+DishName2[clickDishString.charAt(i+1)-0x30] ,""+DishPrice2[clickDishString.charAt(i+1)-0x30]));
                            TotalPrice=TotalPrice+Integer.parseInt(DishPrice2[clickDishString.charAt(i+1)-0x30]);
                        }else if(clickDishString.charAt(i)=='3'){
                            list.add(new Food(""+DishName3[clickDishString.charAt(i+1)-0x30] ,""+DishPrice3[clickDishString.charAt(i+1)-0x30]));
                            TotalPrice=TotalPrice+Integer.parseInt(DishPrice3[clickDishString.charAt(i+1)-0x30]);
                        }
                    }
                    myOrderListViewAdapter.notifyDataSetChanged();
                    textViewSum2.setText(""+clickDishString.length()/2);
                    textViewPrice2.setText(""+TotalPrice+"元");
                    buttonClick.setText("提交订单");
                    buttonClick.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SCOSDataBase sCOSDataBase = new SCOSDataBase(getContext());
                            sCOSDataBase.save(sCOSDataBase.load()+"S");
                            Toast.makeText(getContext(),"提交订单成功",Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case 1://已下单菜
                    scosDataBase = new SCOSDataBase(getContext());
                    clickDishString = scosDataBase.load();
                    //加载已下单的菜
                    if(clickDishString.length()>0){
                        if(clickDishString.charAt(clickDishString.length()-1)=='S'){
                            for(int i=0;i<clickDishString.length()-1;i=i+2)
                            {
                                if(clickDishString.charAt(i)=='0'){
                                    list.add(new Food(""+DishName0[clickDishString.charAt(i+1)-0x30] ,""+DishPrice0[clickDishString.charAt(i+1)-0x30]));
                                    TotalPrice=TotalPrice+Integer.parseInt(DishPrice0[clickDishString.charAt(i+1)-0x30]);
                                }else if(clickDishString.charAt(i)=='1'){
                                    list.add(new Food(""+DishName1[clickDishString.charAt(i+1)-0x30] ,""+DishPrice1[clickDishString.charAt(i+1)-0x30]));
                                    TotalPrice=TotalPrice+Integer.parseInt(DishPrice1[clickDishString.charAt(i+1)-0x30]);
                                }else if(clickDishString.charAt(i)=='2'){
                                    list.add(new Food(""+DishName2[clickDishString.charAt(i+1)-0x30] ,""+DishPrice2[clickDishString.charAt(i+1)-0x30]));
                                    TotalPrice=TotalPrice+Integer.parseInt(DishPrice2[clickDishString.charAt(i+1)-0x30]);
                                }else if(clickDishString.charAt(i)=='3'){
                                    list.add(new Food(""+DishName3[clickDishString.charAt(i+1)-0x30] ,""+DishPrice3[clickDishString.charAt(i+1)-0x30]));
                                    TotalPrice=TotalPrice+Integer.parseInt(DishPrice3[clickDishString.charAt(i+1)-0x30]);
                                }
                            }
                            textViewSum2.setText(""+clickDishString.length()/2);
                            textViewPrice2.setText(""+TotalPrice+"元");
                        }
                    }
                    myOrderListViewAdapter.notifyDataSetChanged();
                    ///textViewSum2.setText(""+clickDishString.length()/2);
                    ///textViewPrice2.setText(""+TotalPrice+"元");
                    final int total;
                    total=TotalPrice;
                    buttonClick.setText("结账");
                    buttonClick.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(oldUser){
                                Toast.makeText(getContext(),"您好，老顾客，本次你可以享受7折优惠",Toast.LENGTH_LONG).show();
                                textViewPrice2.setText(""+total+"元");
                                textViewPrice2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//加删除线
                                textViewPrice3.setText(""+(int)(total*0.7)+"元");//单击结账按钮后，价格自动改为原价的0.7倍
                            }
                            //清空数据库中已点的菜
                            SCOSDataBase sCOSDataBase = new SCOSDataBase(getContext());
                            sCOSDataBase.save("");
                        }
                    });
                    break;
                    default:
                        break;
            }
        }
    }
}
