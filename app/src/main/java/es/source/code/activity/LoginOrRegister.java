package es.source.code.activity;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Handler;
import android.os.RecoverySystem;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.util.regex.Pattern;

import es.source.code.model.User;

public class LoginOrRegister extends AppCompatActivity {

    Button mButtonLogin,mButtonBack,mButtonSign;
    ProgressBar mProgressBar;
    EditText mEditTextName,mEditTextPassword;
    private String NameStr,PasswordStr;
    private int index=0;
    private Handler handler = new Handler();
    private MyRunnable myRunnable = new MyRunnable();
    private Boolean isPauseHandler = false;
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{1,16}$";
    private int LoginRegisterFlag=0;
    class MyRunnable implements Runnable{
        @Override
        public void run() {
            if(!isPauseHandler){
                index++;
                if(index>99){
                    isPauseHandler = true;
                    mProgressBar.setVisibility(View.INVISIBLE);
                    handler.removeCallbacks(myRunnable);//移除线程
                    //正则表达式验证
                    Boolean namebl,passwordbl;
                    namebl=Pattern.matches(REGEX_PASSWORD, NameStr);
                    passwordbl=Pattern.matches(REGEX_PASSWORD, PasswordStr);
                    //如果验证通过
                    if( namebl && passwordbl ){
                        User loginUser = new User() ;
                        loginUser.setUserName(mEditTextName.getText().toString());//获取用户名
                        loginUser.setPassword(mEditTextPassword.getText().toString());//获取密码
                        String data;
                        if(LoginRegisterFlag==0){
                            loginUser.setOldUser(true);
                            data="LoginSuccess";
                        }else {
                            loginUser.setOldUser(false);
                            data="RegisterSuccess";
                        }
                        Intent intent= new Intent(LoginOrRegister.this,MainScreen.class);
                        intent.putExtra("extra_data",data);
                        intent.putExtra("user",loginUser);
                        startActivity(intent);
                    }else{
                        //未验证通过
                        if( !namebl && !passwordbl ){
                            mEditTextName.setError("输入格式错误");
                            mEditTextPassword.setError("输入格式错误");
                        }else if(namebl==false){
                            mEditTextName.setError("输入格式错误");
                        }else if(passwordbl==false){
                            mEditTextPassword.setError("输入格式错误");
                        }
                    }
                }
                mProgressBar.setProgress(index);
                handler.postDelayed(myRunnable,20);//20ms
            }

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);
        mButtonLogin=(Button)findViewById(R.id.button_login);
        mButtonBack=(Button)findViewById(R.id.button_back);
        mButtonSign=(Button)findViewById(R.id.button_sign);
        mProgressBar=(ProgressBar)findViewById(R.id.progressbar);
        mProgressBar.setIndeterminate(false);
        mProgressBar.setMax(100);
        mProgressBar.setProgress(10);
        mEditTextName=(EditText)findViewById(R.id.edittext_name);
        mEditTextPassword=(EditText)findViewById(R.id.edittext_password);
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//登录按钮监听器
                mProgressBar.setVisibility(View.VISIBLE);
                NameStr=mEditTextName.getText().toString();
                PasswordStr=mEditTextPassword.getText().toString();
                handler.postDelayed(myRunnable, 20);
                index=0;
                isPauseHandler = false;
                LoginRegisterFlag=0;//登录
            }
        });
        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//返回按钮监听器
                String data="Return";
                Intent intent= new Intent(LoginOrRegister.this,MainScreen.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        });
        mButtonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//注册按钮监听器
                mProgressBar.setVisibility(View.VISIBLE);
                NameStr=mEditTextName.getText().toString();
                PasswordStr=mEditTextPassword.getText().toString();
                handler.postDelayed(myRunnable, 20);
                index=0;
                isPauseHandler = false;
                LoginRegisterFlag=1;//注册
            }
        });
    }
}
