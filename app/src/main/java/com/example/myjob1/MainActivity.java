package com.example.myjob1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Fragment news = new news();
    private Fragment friends = new friends();
    private Fragment address =new address();
    private Fragment setting = new setting();
    private  FragmentManager fragmentManager;
    private LinearLayout linearLayout_news,linearLayout_friends,linearLayout_setting,linearLayout_address;
    private ImageButton news_button,friends_button,address_button,setting_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        linearLayout_news=findViewById(R.id.weixin);
        linearLayout_friends=findViewById(R.id.tongxunlu);
        linearLayout_setting=findViewById(R.id.faxian);
        linearLayout_address=findViewById(R.id.wo);

        news_button = findViewById(R.id.weixin1);
        friends_button = findViewById(R.id.tongxunlu1);
        address_button = findViewById(R.id.faxian1);
        setting_button = findViewById(R.id.wo1);

        linearLayout_news.setOnClickListener(this);
        linearLayout_friends.setOnClickListener(this);
        linearLayout_setting.setOnClickListener(this);
        linearLayout_address.setOnClickListener(this);

        init_Fragment();

    }

    private void init_Fragment(){
        fragmentManager =getFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.Frame_container,news);
        fragmentTransaction.add(R.id.Frame_container,friends);
        fragmentTransaction.add(R.id.Frame_container,address);
        fragmentTransaction.add(R.id.Frame_container,setting);
        fragmentTransaction.commit();
        showFragment(0);
        news_button.setImageResource(R.drawable.setting);
    }

    private void hide_Fragment(FragmentTransaction fragmentTransaction)
    {
        fragmentTransaction.hide(news);
        fragmentTransaction.hide(friends);
        fragmentTransaction.hide(address);
        fragmentTransaction.hide(setting);
    }

    @Override
    public void onClick(View view) {
        resetButton();

        switch (view.getId()){
            case R.id.weixin:
                showFragment(0);
                news_button.setImageResource(R.drawable.news);
                break;
            case R.id.tongxunlu:
                showFragment(1);
                friends_button.setImageResource(R.drawable.friends);
                break;
            case R.id.faxian:
                showFragment(2);
                setting_button.setImageResource(R.drawable.setting);
                break;
            case R.id.wo:

                showFragment(3);
                address_button.setImageResource(R.drawable.address);
                break;
            default:
                break;

        }

    }

    private void showFragment(int i) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hide_Fragment(fragmentTransaction);
        switch (i){
            case 0:
                fragmentTransaction.show(news);
                break;
            case 1:
                fragmentTransaction.show(friends);
                break;
            case 2:
                fragmentTransaction.show(setting);
                break;
            case 3 :
                fragmentTransaction.show(address);
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }
    private void resetButton(){
        news_button.setImageResource(R.drawable.news);
        friends_button.setImageResource(R.drawable.friends);
        address_button.setImageResource(R.drawable.address);
        setting_button.setImageResource(R.drawable.setting);
    }


}