package com.bacter.residemenu.menu.activity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.bacter.residemenu.R;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.Transition;

public class BacterBurnsAhukActivity extends AppCompatActivity
{
    private KenBurnsView bacter_ahuk_burns;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        bacter_ahuk_burns = findViewById(R.id.bacter_ahuk_burns);
        bacter_ahuk_burns.setFadingEdgeLength(2000);

        bacter_ahuk_burns.setTransitionListener(new KenBurnsView.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {
            }
            @Override
            public void onTransitionEnd(Transition transition) {
            }
        });
    }
}
