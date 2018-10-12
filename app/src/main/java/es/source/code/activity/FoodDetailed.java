package es.source.code.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FoodDetailed extends AppCompatActivity {

    private ViewPager viewPager;
    private List<String> datas = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    private MyPagerAdapter adapter;
    private int Page;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_detailed);
        Intent intent =getIntent();
        Page=intent.getIntExtra("page",0);
        findViews();
        initViews();
    }
    private void findViews(){
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }
    private void initViews(){
        //设置fragment
        for (int i = 0; i < 33; i++) {
            //fragments.add(DataFragment.newInstance(i));
            Fragment fragment = new DetailedDataFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("arg",i);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        adapter = new MyPagerAdapter(getSupportFragmentManager(), datas, fragments);
        viewPager.setAdapter(adapter);
        //根据不同反馈，进入不同界面
        viewPager.setCurrentItem(Page);
    }
}
