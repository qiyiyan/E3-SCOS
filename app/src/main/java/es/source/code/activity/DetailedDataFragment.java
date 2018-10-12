package es.source.code.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.source.code.model.Food;

public class DetailedDataFragment extends Fragment {
    public static final String ARGS_PAGE = "args_page";
    private int mPage;
    public static DetailedDataFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARGS_PAGE, page);
        DetailedDataFragment fragment = new DetailedDataFragment();
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
        return inflater.inflate(R.layout.layout_detailed_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageView imageView=(ImageView)getView().findViewById(R.id.imageview_dish);
        TextView textViewN=(TextView) getView().findViewById(R.id.textView_dishName);
        TextView textViewM=(TextView) getView().findViewById(R.id.textView_dishPrice);
        Button button=(Button)getView().findViewById(R.id.button_dishstatus);
        Bundle bundle = getArguments();
        if(bundle!=null){
            int arg = bundle.getInt("arg");
            SCOSDataBase sCOSDataBase = new SCOSDataBase(getContext());//获取数据库
            switch (arg){//配置各个详情页
                case 0:
                    imageView.setImageResource(R.drawable.d1);
                    textViewN.setText("凉拌木耳");
                    textViewM.setText("10元");
                    if(sCOSDataBase.load().contains("00")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 1:
                    imageView.setImageResource(R.drawable.d2);
                    textViewN.setText("凉拌土豆丝");
                    textViewM.setText("12元");
                    if(sCOSDataBase.load().contains("01")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.d3);
                    textViewN.setText("肉丝拉皮");
                    textViewM.setText("15元");
                    if(sCOSDataBase.load().contains("02")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.d4);
                    textViewN.setText("拍黄瓜");
                    textViewM.setText("10元");
                    if(sCOSDataBase.load().contains("03")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.d5);
                    textViewN.setText("凉拌苦瓜");
                    textViewM.setText("20元");
                    if(sCOSDataBase.load().contains("04")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 5:
                    imageView.setImageResource(R.drawable.d6);
                    textViewN.setText("凉拌海带丝");
                    textViewM.setText("13元");
                    if(sCOSDataBase.load().contains("05")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 6:
                    imageView.setImageResource(R.drawable.d7);
                    textViewN.setText("菠菜拌粉丝");
                    textViewM.setText("11元");
                    if(sCOSDataBase.load().contains("06")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 7:
                    imageView.setImageResource(R.drawable.d8);
                    textViewN.setText("芹菜拌腐竹");
                    textViewM.setText("16元");
                    if(sCOSDataBase.load().contains("07")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 8:
                    imageView.setImageResource(R.drawable.d9);
                    textViewN.setText("糖醋萝卜丝");
                    textViewM.setText("14元");
                    if(sCOSDataBase.load().contains("08")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 9:
                    imageView.setImageResource(R.drawable.d10);
                    textViewN.setText("番茄菜花");
                    textViewM.setText("20元");
                    if(sCOSDataBase.load().contains("09")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 10:
                    imageView.setImageResource(R.drawable.d11);
                    textViewN.setText("京酱肉丝");
                    textViewM.setText("35元");
                    if(sCOSDataBase.load().contains("10")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 11:
                    imageView.setImageResource(R.drawable.d12);
                    textViewN.setText("孜然羊肉");
                    textViewM.setText("50元");
                    if(sCOSDataBase.load().contains("11")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 12:
                    imageView.setImageResource(R.drawable.d13);
                    textViewN.setText("酱爆鸡丁");
                    textViewM.setText("28元");
                    if(sCOSDataBase.load().contains("12")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 13:
                    imageView.setImageResource(R.drawable.d14);
                    textViewN.setText("香酥鸡翅");
                    textViewM.setText("30元");
                    if(sCOSDataBase.load().contains("13")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 14:
                    imageView.setImageResource(R.drawable.d15);
                    textViewN.setText("糖醋里脊");
                    textViewM.setText("35元");
                    if(sCOSDataBase.load().contains("14")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 15:
                    imageView.setImageResource(R.drawable.d16);
                    textViewN.setText("木耳炒山药");
                    textViewM.setText("20元");
                    if(sCOSDataBase.load().contains("15")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 16:
                    imageView.setImageResource(R.drawable.d17);
                    textViewN.setText("香辣鸡胗");
                    textViewM.setText("35元");
                    if(sCOSDataBase.load().contains("16")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 17:
                    imageView.setImageResource(R.drawable.d18);
                    textViewN.setText("红烧肉");
                    textViewM.setText("35元");
                    if(sCOSDataBase.load().contains("17")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 18:
                    imageView.setImageResource(R.drawable.d19);
                    textViewN.setText("香辣虾");
                    textViewM.setText("35元");
                    if(sCOSDataBase.load().contains("18")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 19:
                    imageView.setImageResource(R.drawable.d20);
                    textViewN.setText("腰果鱿鱼花");
                    textViewM.setText("45元");
                    if(sCOSDataBase.load().contains("19")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 20:
                    imageView.setImageResource(R.drawable.d21);
                    textViewN.setText("葱香炒虾皮");
                    textViewM.setText("25元");
                    if(sCOSDataBase.load().contains("20")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 21:
                    imageView.setImageResource(R.drawable.d22);
                    textViewN.setText("清蒸带鱼");
                    textViewM.setText("35元");
                    if(sCOSDataBase.load().contains("21")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 22:
                    imageView.setImageResource(R.drawable.d23);
                    textViewN.setText("清蒸小龙虾");
                    textViewM.setText("45元");
                    if(sCOSDataBase.load().contains("22")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 23:
                    imageView.setImageResource(R.drawable.d24);
                    textViewN.setText("海蛎煎");
                    textViewM.setText("45元");
                    if(sCOSDataBase.load().contains("23")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 24:
                    imageView.setImageResource(R.drawable.d25);
                    textViewN.setText("清蒸鲈鱼");
                    textViewM.setText("55元");
                    if(sCOSDataBase.load().contains("24")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 25:
                    imageView.setImageResource(R.drawable.d26);
                    textViewN.setText("爆炒花蛤");
                    textViewM.setText("15元");
                    if(sCOSDataBase.load().contains("25")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 26:
                    imageView.setImageResource(R.drawable.d27);
                    textViewN.setText("海鲜烘蛋");
                    textViewM.setText("25元");
                    if(sCOSDataBase.load().contains("26")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 27:
                    imageView.setImageResource(R.drawable.d28);
                    textViewN.setText("青岛啤酒");
                    textViewM.setText("8元");
                    if(sCOSDataBase.load().contains("27")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 28:
                    imageView.setImageResource(R.drawable.d29);
                    textViewN.setText("哈尔滨啤酒");
                    textViewM.setText("8元");
                    if(sCOSDataBase.load().contains("28")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 29:
                    imageView.setImageResource(R.drawable.d30);
                    textViewN.setText("百威啤酒");
                    textViewM.setText("18元");
                    if(sCOSDataBase.load().contains("29")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 30:
                    imageView.setImageResource(R.drawable.d31);
                    textViewN.setText("燕京啤酒");
                    textViewM.setText("8元");
                    if(sCOSDataBase.load().contains("30")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 31:
                    imageView.setImageResource(R.drawable.d32);
                    textViewN.setText("五粮液");
                    textViewM.setText("88元");
                    if(sCOSDataBase.load().contains("31")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                case 32:
                    imageView.setImageResource(R.drawable.d33);
                    textViewN.setText("剑南春");
                    textViewM.setText("78元");
                    if(sCOSDataBase.load().contains("32")){
                        button.setText("退点");
                    }else{
                        button.setText("点菜");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
