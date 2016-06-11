package com.example.yq.dangdemo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button, emailButton, phoneButton, switchButton;
    private TextView add;
    private Context context;
    private RelativeLayout linearLayout;
    private int width;
    private int count = 0;
    private Button grivaty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn);
        context = this;
        emailButton = (Button) findViewById(R.id.btn_email);
        phoneButton = (Button) findViewById(R.id.btn_phone);
        switchButton = (Button) findViewById(R.id.btn_switch);
        linearLayout = (RelativeLayout) findViewById(R.id.main);
        grivaty = (Button) findViewById(R.id.gravity);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(100
                , 50);
        //此处相当于布局文件中的Android:layout_gravity属性
        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        lp.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
//        grivaty.setGravity(Gravity.CENTER_HORIZONTAL);
        grivaty.setLayoutParams(lp);
        add = (TextView) findViewById(R.id.textview);
//        add = new TextView(this);
//        add.setBackgroundResource(R.color.colorAccent);
//        add.setHeight(px2dp(10));
        final int width = this.getWindowManager().getDefaultDisplay().getWidth();
//        add.setWidth(200);
//        linearLayout.addView(add);
        RelativeLayout.LayoutParams ll = new RelativeLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT
                , Dp2Px(2));
        ll.setMargins(width * count / 5, 0, 0, 0);
        add.setLayoutParams(ll);
        add.setWidth(width / 5);
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet set = new AnimationSet(true);
                TranslateAnimation animation = new TranslateAnimation(0, width / 5, 0, 0);
                animation.setDuration(1000);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        add.clearAnimation();
                        RelativeLayout.LayoutParams ll = new RelativeLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT
                                , Dp2Px(2));

                        ll.setMargins(width * count / 5, 0, 0, 0);
                        add.setGravity(Gravity.CENTER);
                        add.setLayoutParams(ll);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                set.addAnimation(animation);
                count++;
                add.startAnimation(set);

            }
        });
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:yanqi_330@163.com"));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "c测试邮件");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "邮件内容");
                startActivity(emailIntent);
            }
        });
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                phoneIntent.setData(Uri.parse("15210426925"));
//                startActivity(phoneIntent);


            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                View view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_alertdialog, null);
                builder.setView(view);
                builder.show();

            }
        });
    }

    public int px2dp(float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    public int Dp2Px(float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

}
