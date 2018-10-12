package es.source.code.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.source.code.model.Food;
//DataFragment为FootView中用到的ViewPager的Fragment
public class DataFragment extends Fragment {
    public static final String ARGS_PAGE = "args_page";
    private int mPage;
    public static DataFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARGS_PAGE, page);
        DataFragment fragment = new DataFragment();
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
        return inflater.inflate(R.layout.layout_data_fragment, container, false);//加载布局文件
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final List<Food> list = new ArrayList<>();
        ListView lv1=(ListView)getView().findViewById(R.id.listView1);
        MyListViewAdapter myListViewAdapter = new MyListViewAdapter(getActivity(),list);//定义列表适配器
        lv1.setAdapter(myListViewAdapter);
        Bundle bundle = getArguments();//定义bundle
        if(bundle!=null){
            int arg = bundle.getInt("arg");//获取ViewPager传递的arg参数
            switch (arg){
                case 0://冷菜
                    list.add(new Food("凉拌木耳","10"));//添加列表
                    list.add(new Food("凉拌土豆丝","12"));
                    list.add(new Food("肉丝拉皮","15"));
                    list.add(new Food("拍黄瓜","10"));
                    list.add(new Food("凉拌苦瓜","20"));
                    list.add(new Food("凉拌海带丝","13"));
                    list.add(new Food("菠菜拌粉丝","11"));
                    list.add(new Food("芹菜拌腐竹","16"));
                    list.add(new Food("糖醋萝卜丝","14"));
                    myListViewAdapter.notifyDataSetChanged();
                    break;
                case 1://热菜
                    list.add(new Food("番茄菜花","20"));
                    list.add(new Food("京酱肉丝","35"));
                    list.add(new Food("孜然羊肉","50"));
                    list.add(new Food("酱爆鸡丁","28"));
                    list.add(new Food("香酥鸡翅","30"));
                    list.add(new Food("糖醋里脊","35"));
                    list.add(new Food("木耳炒山药","20"));
                    list.add(new Food("香辣鸡胗","35"));
                    list.add(new Food("红烧肉","35"));
                    myListViewAdapter.notifyDataSetChanged();
                    break;
                case 2://海鲜
                    list.add(new Food("香辣虾","35"));
                    list.add(new Food("腰果鱿鱼花","45"));
                    list.add(new Food("葱香炒虾皮","25"));
                    list.add(new Food("清蒸带鱼","35"));
                    list.add(new Food("清蒸小龙虾","45"));
                    list.add(new Food("海蛎煎","45"));
                    list.add(new Food("清蒸鲈鱼","55"));
                    list.add(new Food("爆炒花蛤","15"));
                    list.add(new Food("海鲜烘蛋","25"));
                    myListViewAdapter.notifyDataSetChanged();
                    break;
                case 3://酒水
                    list.add(new Food("青岛啤酒","8"));
                    list.add(new Food("哈尔滨啤酒","8"));
                    list.add(new Food("百威啤酒","18"));
                    list.add(new Food("燕京啤酒","8"));
                    list.add(new Food("五粮液","88"));
                    list.add(new Food("剑南春","78"));
                    myListViewAdapter.notifyDataSetChanged();
                    break;
                default:
                    break;
            }
        }

    }

}
