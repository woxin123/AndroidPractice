package com.example.uiwidgettest;

import android.app.Dialog;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.edit_text);
        imageView = (ImageView)findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        button.setOnClickListener(this);


//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // 在此处添加逻辑
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
//                imageView.setImageResource(R.drawable.img_2);
//                if (progressBar.getVisibility() == view.GONE) {
//                    progressBar.setVisibility(View.VISIBLE);
//                } else {
//                    progressBar.setVisibility(View.GONE);
//                }
//                int progress = progressBar.getProgress();
//                progress = progress + 10;
//                progressBar.setProgress(progress);
//                int progress = progressBar.getProgress();
//                for (int i = 0; i  < 100; i++) {
//                    try {
//                        Thread.currentThread().sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    progress += 1;
//                    progressBar.setProgress(progress);
//              }
//                AlertDialog.Builder  dialog = new AlertDialog.Builder(MainActivity.this);
//                dialog.setMessage("This is Dialog");
//                dialog.setTitle("Something important");
//                /**
//                 * void setCancelable (boolean flag)
//                 * 设置该对话框是否可以被BACK键撤销
//                 */
//                dialog.setCancelable(false);
//                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface diolog,  int which) {
//
//                    }
//                });
//                dialog.show();
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is  ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.show();

                break;
            default:
                break;
        }
    }
}
