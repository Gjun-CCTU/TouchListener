package com.angus.gjuntouch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout layout ;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (ConstraintLayout) findViewById(R.id.layout);
        tv1 = (TextView) findViewById(R.id.textView);

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                StringBuilder sb = new StringBuilder();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                sb.append(String.format("當前座標:(%.2f, %.1f)\n", x, y));
                sb.append("Touch State :\n");
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    sb.append("Touch Down\n");
                else if (motionEvent.getAction() == MotionEvent.ACTION_MOVE)
                    sb.append("Touch Move\n");
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP)
                    sb.append("Touch Up\n");

                int n = motionEvent.getPointerCount();
                for(int i = 0; i <  n; i++){
                    sb.append(String.format("第%d點: (%.2f, %.1f)\n", motionEvent.getPointerId(i)+1,motionEvent.getX(i),motionEvent.getY(i)));
                }
                tv1.setText(sb);
                return true;//Returns True if the listener has consumed the event, false otherwise.
            }
        });
    }
}
