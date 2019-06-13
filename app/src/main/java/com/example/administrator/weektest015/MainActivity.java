package com.example.administrator.weektest015;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

/**
 * 演示点击标签切换对应的界面
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private RadioButton rb_home,rb_share,rb_gift,rb_order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.content_layout,new CowFragment());
        transaction.commit();
        initView();
    }

    //初始化视图
    public void initView(){
        rb_home = findViewById(R.id.rb_home);
        rb_share = findViewById(R.id.rb_share);
        rb_gift = findViewById(R.id.rb_gift);
        rb_order = findViewById(R.id.rb_order);

        rb_home.setOnClickListener(this);
        rb_share.setOnClickListener(this);
        rb_gift.setOnClickListener(this);
        rb_order.setOnClickListener(this);
    }

    /**
     * 点击RadioButton触发的事件
     */
    @Override
    public void onClick(View view) {
        transaction = manager.beginTransaction();
        switch (view.getId()){
            case R.id.rb_home:
                transaction.replace(R.id.content_layout,new CowFragment());
                break;
            case R.id.rb_share:
                transaction.replace(R.id.content_layout,new SheepFragment());
                break;
            case R.id.rb_gift:
                transaction.replace(R.id.content_layout,new PigFragment());
                break; }
        transaction.commit();
    }
}
