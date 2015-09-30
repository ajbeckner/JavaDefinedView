package com.ajbecknerapps.javadefinedview;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //DEFINE CONSTANTS BELOW

    //IDS
    private static final int ID_BUTTON = 1;
    private static final int ID_EDIT_TEXT = 2;
    // make view objects programatically
    private RelativeLayout myLayout;
    private Button buttonName;
    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myLayout = new RelativeLayout(this);
        buttonName = new Button(this);
        editTextName = new EditText(this);

        //DIMENSIONS != BALLS
        //this code converts dip to px for parameter value
        final int MARGIN_EDITTEXT_DIP = 8;
        final int MARGIN_EDITTEXT_PIXELS = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,MARGIN_EDITTEXT_DIP,getResources().getDisplayMetrics());
        final int WIDTH_EDITTEXT_DIP = 96;
        final int WIDTH_EDITEXT_PIXELS = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, WIDTH_EDITTEXT_DIP,getResources().getDisplayMetrics());

        //set properties in java
        //todo: change
        //myLayout.setBackgroundColor(Color.BLUE);
        //myButton.setBackgroundColor(Color.YELLOW);
        buttonName.setId(ID_BUTTON);
        buttonName.setId(ID_EDIT_TEXT);
        buttonName.setText("Do Stuff");
        editTextName.setWidth(WIDTH_EDITEXT_PIXELS);
        editTextName.setText("4");

        //set listeners for functionality
        buttonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = String.valueOf(editTextName.getText());
                int number = Integer.parseInt(text);
                if (number <= 5) {
                    for (int i = 0; i < number; i++) {
                        makeButton();
                    }
                }
            }
        });

        // make param objects for more java customization
        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        //add additional params
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.addRule(RelativeLayout.CENTER_VERTICAL);

        // make param objects for more java customization
        RelativeLayout.LayoutParams editTextParams = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        //add additional params
        editTextParams.addRule(RelativeLayout.ABOVE, buttonName.getId());
        editTextParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        editTextParams.setMargins(
                0,                      //left
                0,                      //top
                0,                      //right
                MARGIN_EDITTEXT_PIXELS);//bottom

        //set view hierarchy in java

        //w/o setting params
        //myLayout.addView(buttonName);
        //myLayout.addView(editTextName);

        //one way to set params
        myLayout.addView(buttonName, buttonParams);
        myLayout.addView(editTextName,editTextParams);

        //alternate way
        //myButton.setLayoutParams(buttonParams);
        //myLayout.addView(buttonName);
        //myButton.setLayoutParams(editTextParams);
        //myLayout.addView(editTextName);

        //sets view
        setContentView(myLayout);

    }

    private void makeButton(){
        Log.d("Test", "in makeButton()");
        Button dynamicButton = new Button(getApplicationContext());
        dynamicButton.setText("Button");
        RelativeLayout.LayoutParams dynamicButtonParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        dynamicButtonParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        dynamicButtonParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        //generate button coordinates

        //THIS APPROACH BECAME UNNECESSARY SINCE getDefaultDisplay().getWidth() (or height) etc RETURNS PIXELS
        //initialize random
//                        Random random = new Random();
//                        //set limits
//                        final int DYNAMIC_BUTTON_MARGINLEFT_MAX = 240;
//                        final int DYNAMIC_BUTTON_MARGINTOP_MAX = 480;
//                        //get random coordinates in dip (dp)
//                        int DYNAMIC_BUTTON_MARGINLEFT_DIP = random.nextInt(DYNAMIC_BUTTON_MARGINLEFT_MAX);
//                        int DYNAMIC_BUTTON_MARGINTOP_DIP = random.nextInt(DYNAMIC_BUTTON_MARGINTOP_MAX);
//                        //convert to pixels
//                        int DYNAMIC_BUTTON_MARGINLEFT_PIXELS = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,DYNAMIC_BUTTON_MARGINLEFT_DIP,getResources().getDisplayMetrics());
//                        int DYNAMIC_BUTTON_MARGINTOP_PIXELS = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,DYNAMIC_BUTTON_MARGINTOP_DIP,getResources().getDisplayMetrics());
        Random random = new Random();
        int DYNAMIC_BUTTON_MARGINLEFT_PIXELS = random.nextInt(getWindowManager().getDefaultDisplay().getWidth());
        int DYNAMIC_BUTTON_MARGINTOP_PIXELS = random.nextInt(getWindowManager().getDefaultDisplay().getHeight());

        dynamicButtonParams.setMargins(
                DYNAMIC_BUTTON_MARGINLEFT_PIXELS,
                DYNAMIC_BUTTON_MARGINTOP_PIXELS,
                0,
                0);
        myLayout.addView(dynamicButton,dynamicButtonParams);
        setContentView(myLayout);
    }



}
