package com.ilyascilingir.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int number;
    Runnable runnable; // Bir işi birden fazla kez belirttiğimiz periyotta ve sayıda yapmamıza olanak sağlayan bir arayüz.
    Handler handler;  // Runnable ı ele aldığımız bir arayüz.
    Button startButton,stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        startButton=findViewById(R.id.startButton);
        stopButton=findViewById(R.id.stopButton);

        number = 0;
        stopButton.setEnabled(false);
    }


    public void start(View view){

            handler = new Handler();
            runnable = new Runnable() {
                @Override
                public void run() {
                    textView.setText("Time: " + number);
                    number++;
                    textView.setText("Time: " + number);
                    handler.postDelayed(runnable,1000);
                }
            };

            handler.post(runnable);
            stopButton.setEnabled(true);
            startButton.setEnabled(false);

    }


    public void stop(View view){

        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        number=0;
        handler.removeCallbacks(runnable);
        textView.setText("Time: "+number);

    }

}