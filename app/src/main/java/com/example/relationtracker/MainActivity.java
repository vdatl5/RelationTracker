package com.example.relationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    drawClass act_view;
    ViewGroup grp_root; //special view that can contain other views inside, parent of RelativeLayout
    private int xDelta;
    private int yDelta;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grp_root = (ViewGroup) findViewById(R.id.root); //upcast RelativeLayout to ViewGroup

        //create a new text view that we will manipulate
        act_view = new drawClass(this);

        //LayoutParams specifies how a view is positioned within a ViewGroup
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(60, 50);
        //specify the size of the layoutparams

        //specify the position of layoutparams on the screen
        layoutParams.topMargin = 50;
        layoutParams.bottomMargin = -250;
        layoutParams.leftMargin = 50;
        layoutParams.rightMargin = -250;

        //bind the layout params to textview /??/
        act_view.setLayoutParams(layoutParams);

        //set the on touch listener on the text view
        act_view.setOnTouchListener(this);

        //add the view to the relative layout
        grp_root.addView(act_view);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        //get where the motion event happened, the first touch
        final int X = (int) motionEvent.getRawX();
        final int Y = (int) motionEvent.getRawY();

        switch(motionEvent.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
                //in case a pressure gesture has started

                //get the layout params associated with this view
                //??/ is this the testview or the relativeLayout
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                xDelta = X - lParams.leftMargin;
                yDelta = Y - lParams.topMargin;
                break;
            case MotionEvent.ACTION_UP:
                break;

            case MotionEvent.ACTION_MOVE:
                //move the LayoutParams by the amount of the action move
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                layoutParams.leftMargin = X - xDelta;
                layoutParams.topMargin = Y - yDelta;

                //we are holding one end constant, and moving the other corner
                layoutParams.rightMargin = -250;
                layoutParams.bottomMargin = -250;

                view.setLayoutParams(layoutParams);
                break;
            default:
                return false;

        }
        //force the view to draw
        grp_root.invalidate();
        return true;
    }
}


