package es.source.code.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import es.source.code.model.User;

public class FoodOrderView extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> datas = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    private MyPagerAdapter adapter;
    private String data;
    private User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_order_view);
        Intent intent = getIntent();
        data = intent.getStringExtra("extra_data");
        user = (User) intent.getSerializableExtra("user");//user获得传入的loginUser对象
        findViews();
        initDatas();
        initViews();
    }
    private void initDatas(){
        datas.add("未下单菜");
        datas.add("已下单菜");
    }
    private void findViews(){
        tabLayout = (TabLayout) findViewById(R.id.tabLayout_order);
        viewPager = (ViewPager) findViewById(R.id.viewPager_order);
    }
    private void initViews(){
        //循环注入标签
        for(String tab:datas){
            tabLayout.addTab(tabLayout.newTab().setText(tab));
        }
        //设置fragment
        for (int i = 0; i < 2; i++) {
            //fragments.add(DataFragment.newInstance(i));
            Fragment fragment = new OrderDataFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("arg",i);
            if(user!=null) {
                bundle.putBoolean("oldUser", user.getOldUser());
            }else{
                bundle.putBoolean("oldUser", false);
            }
            ///bundle.putBoolean("arg1",isSubmitDish);
            //bundle.putIntArray("arg_menuData",menuData);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        tabLayout.addOnTabSelectedListener(this);
        adapter = new MyPagerAdapter(getSupportFragmentManager(), datas, fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        //根据不同反馈，进入不同界面
        if(data.compareTo("Order")==0)
            viewPager.setCurrentItem(0);
        else if (data.compareTo("Check")==0)
            viewPager.setCurrentItem(1);
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

}
