package com.ajinkyad.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * This is the launching Activity
 */
public class FirstActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //Handle the click for button "Open Second Activity"
        findViewById(R.id.btnSecondActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Navigates the User to Second Activity
                startActivity(new Intent(FirstActivity.this, SecondActivity.class));
            }
        });
    }
}
