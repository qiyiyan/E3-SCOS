package es.source.code.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

import es.source.code.model.User;

public class FoodView extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> datas = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    private MyPagerAdapter adapter;
    private User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foot_view);
        Intent intent = getIntent();//获取user变量
        user = (User) intent.getSerializableExtra("user");//user获得传入的loginUser对象
        findViews();
        initDatas();
        initViews();
    }
    private void initDatas(){
        datas.add("冷菜");
        datas.add("热菜");
        datas.add("海鲜");
        datas.add("酒水");
    }
    private void findViews(){
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }
    private void initViews(){
        //循环注入标签
        for(String tab:datas){
            tabLayout.addTab(tabLayout.newTab().setText(tab));
        }
        //设置fragment
        for (int i = 0; i < 4; i++) {
            //fragments.add(DataFragment.newInstance(i));
            Fragment fragment = new DataFragment();//ViewPager的Fragment为DataFragment
            Bundle bundle = new Bundle();
            bundle.putInt("arg",i);
            fragment.setArguments(bundle);
            fragments.add(fragment);

        }
        tabLayout.addOnTabSelectedListener(this);
        adapter = new MyPagerAdapter(getSupportFragmentManager(), datas, fragments);
        viewPager.setAdapter(adapter);//配置ViewPager的适配器
        tabLayout.setupWithViewPager(viewPager);//为TabLayout配置ViewPager


    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }
    //以下为ActionBar选项定义
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.foodview_menu_actions,menu);//加载选项布局文件
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_menu1://当第一选项被选择时
                String data1="Order";
                Intent intent1= new Intent(FoodView.this,FoodOrderView.class);
                intent1.putExtra("extra_data",data1);
                intent1.putExtra("user",user);//传递user变量
                startActivity(intent1);
                return true;
            case R.id.action_menu2://当第二选项被选择时
                String data2="Check";
                Intent intent2= new Intent(FoodView.this,FoodOrderView.class);
                intent2.putExtra("extra_data",data2);
                intent2.putExtra("user",user);//传递user变量
                startActivity(intent2);
                return true;
            case R.id.action_menu3://当第三选项被选择时
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

}
