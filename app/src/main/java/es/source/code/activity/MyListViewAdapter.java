package es.source.code.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import es.source.code.model.Food;

public class MyListViewAdapter extends BaseAdapter
{
    private Context context;
    private List<Food> list;
    //构造函数
    public MyListViewAdapter(Context context, List<Food> list)
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ViewHolder vh;
        if(view==null){
            vh = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.list_simple,null);//加载列表布局文件
            vh.footName = (TextView) view.findViewById(R.id.textViewName);
            vh.footPrice = (TextView) view.findViewById(R.id.textViewM);
            vh.clickButton=(Button)view.findViewById(R.id.buttonClick);
            view.setTag(vh);
        }else {
            vh = (ViewHolder) view.getTag();
        }
        //定义菜品名称监听器
        vh.footName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //进入详情页
                Intent intent= new Intent(context,FoodDetailed.class);
                switch (vh.footName.getText().toString()){
                    case "凉拌木耳":
                    case "凉拌土豆丝":
                    case "肉丝拉皮":
                    case "拍黄瓜":
                    case "凉拌苦瓜":
                    case "凉拌海带丝":
                    case "菠菜拌粉丝":
                    case "芹菜拌腐竹":
                    case "糖醋萝卜丝":
                        intent.putExtra("page",i);
                        break;
                    case "番茄菜花":
                    case "京酱肉丝":
                    case "孜然羊肉":
                    case "酱爆鸡丁":
                    case "香酥鸡翅":
                    case "糖醋里脊":
                    case "木耳炒山药":
                    case "香辣鸡胗":
                    case "红烧肉":
                        intent.putExtra("page",9+i);
                        break;
                    case "香辣虾":
                    case "腰果鱿鱼丝":
                    case "葱香炒虾皮":
                    case "清蒸带鱼":
                    case "清蒸小龙虾":
                    case "海蛎煎":
                    case "清蒸鲈鱼":
                    case "爆炒花蛤":
                    case "海鲜烘蛋":
                        intent.putExtra("page",18+i);
                        break;
                    case "青岛啤酒":
                    case "哈尔滨啤酒":
                    case "百威啤酒":
                    case "燕京啤酒":
                    case "五粮液":
                    case "剑南春":
                        intent.putExtra("page",27+i);
                        break;
                }
                context.startActivity(intent);
            }
        });
        //定义菜品价格监听器
        vh.footPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,FoodDetailed.class);
                switch (vh.footName.getText().toString()){
                    case "凉拌木耳":
                    case "凉拌土豆丝":
                    case "肉丝拉皮":
                    case "拍黄瓜":
                    case "凉拌苦瓜":
                    case "凉拌海带丝":
                    case "菠菜拌粉丝":
                    case "芹菜拌腐竹":
                    case "糖醋萝卜丝":
                        intent.putExtra("page",i);
                        Toast.makeText(context,""+i,Toast.LENGTH_SHORT).show();
                        break;
                    case "番茄菜花":
                    case "京酱肉丝":
                    case "孜然羊肉":
                    case "酱爆鸡丁":
                    case "香酥鸡翅":
                    case "糖醋里脊":
                    case "木耳炒山药":
                    case "香辣鸡胗":
                    case "红烧肉":
                        intent.putExtra("page",9+i);
                        Toast.makeText(context,"9"+i,Toast.LENGTH_SHORT).show();
                        break;
                    case "香辣虾":
                    case "腰果鱿鱼丝":
                    case "葱香炒虾皮":
                    case "清蒸带鱼":
                    case "清蒸小龙虾":
                    case "海蛎煎":
                    case "清蒸鲈鱼":
                    case "爆炒花蛤":
                    case "海鲜烘蛋":
                        intent.putExtra("page",18+i);
                        Toast.makeText(context,"18"+i,Toast.LENGTH_SHORT).show();
                        break;
                    case "青岛啤酒":
                    case "哈尔滨啤酒":
                    case "百威啤酒":
                    case "燕京啤酒":
                    case "五粮液":
                    case "剑南春":
                        intent.putExtra("page",27+i);
                        Toast.makeText(context,"27"+i,Toast.LENGTH_SHORT).show();
                        break;
                }
                context.startActivity(intent);
            }
        });
        //定义点菜按钮监听器
        vh.clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vh.clickButton.getText().toString().compareTo("点菜")==0){
                    Toast.makeText(context,"点菜成功",Toast.LENGTH_SHORT).show();
                    vh.clickButton.setText("退点");
                    //存入数据库
                    SCOSDataBase sCOSDataBase = new SCOSDataBase(context);//获取数据库对象
                    switch (vh.footName.getText().toString()){
                        case "凉拌木耳":
                        case "凉拌土豆丝":
                        case "肉丝拉皮":
                        case "拍黄瓜":
                        case "凉拌苦瓜":
                        case "凉拌海带丝":
                        case "菠菜拌粉丝":
                        case "芹菜拌腐竹":
                        case "糖醋萝卜丝":
                            sCOSDataBase.save(sCOSDataBase.load()+"0"+i);//将已点菜品存入数据库
                            break;
                        case "番茄菜花":
                        case "京酱肉丝":
                        case "孜然羊肉":
                        case "酱爆鸡丁":
                        case "香酥鸡翅":
                        case "糖醋里脊":
                        case "木耳炒山药":
                        case "香辣鸡胗":
                        case "红烧肉":
                            sCOSDataBase.save(sCOSDataBase.load()+"1"+i);
                            break;
                        case "香辣虾":
                        case "腰果鱿鱼丝":
                        case "葱香炒虾皮":
                        case "清蒸带鱼":
                        case "清蒸小龙虾":
                        case "海蛎煎":
                        case "清蒸鲈鱼":
                        case "爆炒花蛤":
                        case "海鲜烘蛋":
                            sCOSDataBase.save(sCOSDataBase.load()+"2"+i);
                            break;
                        case "青岛啤酒":
                        case "哈尔滨啤酒":
                        case "百威啤酒":
                        case "燕京啤酒":
                        case "五粮液":
                        case "剑南春":
                            sCOSDataBase.save(sCOSDataBase.load()+"3"+i);
                            break;
                    }
                }else if (vh.clickButton.getText().toString().compareTo("退点")==0){
                    Toast.makeText(context,"退点成功",Toast.LENGTH_SHORT).show();
                    SCOSDataBase sCOSDataBase = new SCOSDataBase(context);//获取数据库对象
                    switch (vh.footName.getText().toString()){
                        case "凉拌木耳":
                        case "凉拌土豆丝":
                        case "肉丝拉皮":
                        case "拍黄瓜":
                        case "凉拌苦瓜":
                        case "凉拌海带丝":
                        case "菠菜拌粉丝":
                        case "芹菜拌腐竹":
                        case "糖醋萝卜丝":
                            sCOSDataBase.save(sCOSDataBase.load().replace("0"+i,""));//将已退点菜品从数据库中删除
                            break;
                        case "番茄菜花":
                        case "京酱肉丝":
                        case "孜然羊肉":
                        case "酱爆鸡丁":
                        case "香酥鸡翅":
                        case "糖醋里脊":
                        case "木耳炒山药":
                        case "香辣鸡胗":
                        case "红烧肉":
                            sCOSDataBase.save(sCOSDataBase.load().replace("1"+i,""));
                            break;
                        case "香辣虾":
                        case "腰果鱿鱼丝":
                        case "葱香炒虾皮":
                        case "清蒸带鱼":
                        case "清蒸小龙虾":
                        case "海蛎煎":
                        case "清蒸鲈鱼":
                        case "爆炒花蛤":
                        case "海鲜烘蛋":
                            sCOSDataBase.save(sCOSDataBase.load().replace("2"+i,""));
                            break;
                        case "青岛啤酒":
                        case "哈尔滨啤酒":
                        case "百威啤酒":
                        case "燕京啤酒":
                        case "五粮液":
                        case "剑南春":
                            sCOSDataBase.save(sCOSDataBase.load().replace("3"+i,""));
                            break;
                        }
                    vh.clickButton.setText("点菜");
                }
            }
        });
        Food food = list.get(i);
        vh.footName.setText(food.getFoodName());
        vh.footPrice.setText(food.getFoodPrice());
        return view;
    }

    public class ViewHolder{
        TextView footName;
        TextView footPrice;
        Button clickButton;
    }
}


