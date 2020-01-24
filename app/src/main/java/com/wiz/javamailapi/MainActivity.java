package com.wiz.javamailapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn_send = (Button)findViewById(R.id.btn_sendMail);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog please_wait = new ProgressDialog(MainActivity.this);
                please_wait.show();
                new Thread();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            MailSender sender = new MailSender("testminet@gmail.com",
                                    "minet2019");
                            sender.sendMail("This is a test subject", "This is the test body content",
                                    "testminet@gmail.com", "samnjoroge6035@gmail.com");

                            Toast.makeText(MainActivity.this, "SUCCESS", Toast.LENGTH_SHORT).show();
                            please_wait.hide();
                        } catch (Exception e) {
                            Log.e("SendMail", e.getMessage(), e);
                            Toast.makeText(MainActivity.this, "FAILED", Toast.LENGTH_SHORT).show();
                            please_wait.hide();
                        }
                    }

                }).start();
            }
        });

    }


}

