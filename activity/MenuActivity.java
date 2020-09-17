package com.bacter.residemenu.menu.activity;


import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bacter.residemenu.R;
import com.bacter.residemenu.menu.fragments.CalendarFragment;
import com.bacter.residemenu.menu.fragments.CebuCityCouncil;
import com.bacter.residemenu.menu.fragments.HomeFragment;
import com.bacter.residemenu.menu.fragments.ProfileFragment;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

import java.util.concurrent.Executor;

public class MenuActivity extends FragmentActivity implements View.OnClickListener
{
    Executor executor;
    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    private ResideMenu resideMenu;
    private MenuActivity mContext;
    private ResideMenuItem itemHome;
    private ResideMenuItem itemCebuCityCouncil;
    private ResideMenuItem itemProfile;
    private ResideMenuItem itemCalendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(this, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(MenuActivity.this,errString,Toast.LENGTH_LONG).show();
                MenuActivity.this.finish();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(MenuActivity.this,"Authentication Successful!",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(MenuActivity.this,"Authentication FAILED",Toast.LENGTH_LONG).show();
            }
        });
        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Triskelion App")
                .setSubtitle("Fingerprint ID Required")
                .setDescription("Touch Fingerprint Sensor")
                .setNegativeButtonText("EXIT")
                .build();
        biometricPrompt.authenticate(promptInfo);

        mContext = this;
        setUpMenu();
        if (savedInstanceState == null)

            changeFragment(new HomeFragment());
    }
    private void setUpMenu()
    {
        // ATTACH TO CURRENT ACTIVITY //
        resideMenu = new ResideMenu(this);
        resideMenu.setBackground(R.drawable.cpc);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);
        resideMenu.setScaleValue(0.6f);

        // CREATE MENU ITEMS //
        itemHome = new ResideMenuItem(this, R.drawable.home_dex, "Home");
        itemCebuCityCouncil = new ResideMenuItem(this, R.drawable.home_dex,"CCC Group Page");
        itemProfile = new ResideMenuItem(this, R.drawable.home_dex, "About");
        itemCalendar = new ResideMenuItem(this, R.drawable.home_dex, "Calendar");

        // SET ON CLICK LISTENERS //
        itemHome.setOnClickListener(this);
        itemCebuCityCouncil.setOnClickListener(this);
   //     itemCebuProvCounci.setOnClickListener(this);
        itemProfile.setOnClickListener(this);
        itemCalendar.setOnClickListener(this);

        // ON CLICKED ITEMS MENU DIRECTION //
        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemCebuCityCouncil, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemProfile, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemCalendar, ResideMenu.DIRECTION_RIGHT);

        // ERROR IF CONVERTED TO LAMBDA //
        findViewById(R.id.title_bar_left_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
        findViewById(R.id.title_bar_right_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
            }
        });
    }
    public boolean dispatchTouchEvent(MotionEvent ev)
    {
        return resideMenu.dispatchTouchEvent(ev);
    }
    @Override
    public void onClick(View view)
    {
        if (view == itemHome)
        {
            changeFragment(new HomeFragment());

        }else if(view == itemProfile)
        {
            changeFragment(new ProfileFragment());
        }else if (view == itemCalendar)
        {
            changeFragment(new CalendarFragment());
        }else if (view == itemCebuCityCouncil)
        {
            changeFragment(new CebuCityCouncil());
        }
        resideMenu.closeMenu();
    }
    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu(){}
        @Override
        public void closeMenu(){}

    };
    private void changeFragment(Fragment targetFragment)
    {
        resideMenu.clearIgnoredViewList();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment,targetFragment,"fragment")
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
    public ResideMenu getResideMenu()
    {
        return resideMenu;
    }
    public void onBackPressed()
    {
        MenuActivity.this.finish();
    }
}