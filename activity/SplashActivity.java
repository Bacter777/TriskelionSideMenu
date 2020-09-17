package com.bacter.residemenu.menu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bacter.residemenu.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ImageView splash_img = findViewById(R.id.splash_img);
        TextView splash_text = findViewById(R.id.splash_txt);
        Animation bacterAnim1 = AnimationUtils.loadAnimation(splash_text.getContext(), R.anim.fade_in);
        Animation bacterAnim2 = AnimationUtils.loadAnimation(splash_img.getContext(), R.anim.fade_out);

        splash_img.startAnimation(bacterAnim2);
        splash_text.startAnimation(bacterAnim1);

        final Intent intent = new Intent(this,MenuActivity.class);
        Thread timer = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(3000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    startActivity(intent);
                    splash_img.setVisibility(View.VISIBLE);
                    finish();
                }
            }
        };
        timer.start();
    }
}