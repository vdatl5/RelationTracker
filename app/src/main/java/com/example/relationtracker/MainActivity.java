package com.example.relationtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    ViewGroup grp_root;
/*    ImageView act_view;
    ViewGroup grp_root; //special view that can contain other views inside, parent of RelativeLayout
    private int xDelta;
    private int yDelta;*/

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grp_root = (ViewGroup) findViewById(R.id.root);

        moveableShape movableShape = new moveableShape(this, grp_root);
        moveableShape movableShape1 = new moveableShape(this, grp_root);
        moveableShape movableShape2 = new moveableShape(this, grp_root);

        final Button cancelButton = (Button) findViewById(R.id.add_new_person_temp);

        //on click, go to add person activity
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //declare a new intent to launch the other activity
                Intent  launch_addPerson = new Intent(getApplicationContext(), addPerson.class);
                startActivity(launch_addPerson);
            }
        });



/*        grp_root = (ViewGroup) findViewById(R.id.root); //upcast RelativeLayout to ViewGroup
        //create a new text view that we will manipulate

        act_view = new ImageView(this);
        act_view.setImageResource(R.drawable.ic_launcher);
        //act_view.setColorFilter(Color.BLUE);

        //LayoutParams specifies how a view is positioned within a ViewGroup
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150 , 150);
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
        grp_root.addView(act_view);*/

    }

/*    @Override
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
    }*/

}


