package es.source.code.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.source.code.model.User;

public class MainScreen extends AppCompatActivity {

    GridView mGridView;
    public int[] ids = new int[]{
            R.drawable.order,R.drawable.check,
            R.drawable.login,R.drawable.help
    };
    public String[] names=new String[]{
            "点菜","查看菜单","登录/注册","系统帮助"
    };
    User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);//加载布局文件
        Intent intent = getIntent();//获取LoginOrRegister传输的intent
        String data = intent.getStringExtra("extra_data");

        List<Map<String,Object>>griddata=new ArrayList<Map<String,Object>>();//定义GridView数据

        if(data.compareTo("FromEntry")==0){//当从SCOS进入时
            user = null;
            for(int i=0;i<4;i++){//四个全部加载
                Map<String,Object>map=new HashMap<String, Object>();
                map.put("id",ids[i]);
                map.put("name",names[i]);
                griddata.add(map);
            }
        }else if(data.compareTo("LoginSuccess")==0){//当登录成功后
            Toast.makeText(MainScreen.this,"登录成功",Toast.LENGTH_LONG).show();
            user = (User) intent.getSerializableExtra("user");//user获得传入的loginUser对象
            for(int i=0;i<4;i++){
                Map<String,Object>map=new HashMap<String, Object>();
                map.put("id",ids[i]);
                map.put("name",names[i]);
                griddata.add(map);
            }
        }else if(data.compareTo("RegisterSuccess")==0){//当注册成功后
            Toast.makeText(MainScreen.this,"欢迎您成为SCOS新用户",Toast.LENGTH_LONG).show();
            user = (User) intent.getSerializableExtra("user");//user获得传入的loginUser对象
            for(int i=0;i<4;i++){//四个全部加载
                Map<String,Object>map=new HashMap<String, Object>();
                map.put("id",ids[i]);
                map.put("name",names[i]);
                griddata.add(map);
            }
        }else{
            user = null;
            for(int i=0;i<2;i++){//只加载后两个
                Map<String,Object>map=new HashMap<String, Object>();
                map.put("id",ids[i+2]);
                map.put("name",names[i+2]);
                griddata.add(map);
            }
        }

        mGridView=(GridView)findViewById(R.id.gridview);
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this,
                griddata,
                R.layout.item,
                new String[] {"id","name"},
                new int[] {R.id.item_image,R.id.item_text}
        );
        mGridView.setAdapter(simpleAdapter);//配置GridView的适配器
        mGridView.setOnItemClickListener(new ItemClickListener());//配置GridView的项目点击监听器
    }
    class ItemClickListener implements AdapterView.OnItemClickListener {

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            HashMap<String, Object> item=(HashMap<String, Object>) parent.getItemAtPosition(position);
            if(item.get("name").toString().compareTo("登录/注册")==0){
                Intent intent= new Intent(MainScreen.this,LoginOrRegister.class);//跳转至LoginOrRegister
                startActivity(intent);
            }else if(item.get("name").toString().compareTo("点菜")==0){
                Intent intent= new Intent(MainScreen.this,FoodView.class);//跳转至FoodView
                intent.putExtra("user",user);//传递user变量
                startActivity(intent);
            }
        }
    }
}
