package com.bacter.residemenu.menu.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.bacter.residemenu.R;
import com.bacter.residemenu.menu.activity.MenuActivity;
import com.special.ResideMenu.ResideMenu;

public class HomeFragment extends Fragment
{
    private View parentView;
    private ResideMenu resideMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        parentView = inflater.inflate(R.layout.home, container, false);
        setUpViews();
        return parentView;
    }
    private void setUpViews()
    {
        MenuActivity parentActivity = (MenuActivity)getActivity();
        resideMenu = parentActivity.getResideMenu();
    }
}