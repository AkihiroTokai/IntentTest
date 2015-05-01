package com.example.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URL;

public class MainActivity extends Activity {
    private EditText uiEditText;
    private Button uiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uiEditText = (EditText) findViewById(R.id.edittext_text);
        uiButton = (Button) findViewById(R.id.button_send);

        uiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // ボタンをクリックした時に呼ばれる
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://google.com/"));
                startActivity(intent);

            }
        });

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        //intent.setData(Uri.parse("http://twitter.com/intent?tweet?text="+uiEditText.getText()));
        intent.setData(Uri.parse("tel:123456789"));
        //intent.setData(Uri.parse("geo:0,0?q=Tokyo"));
        startActivity(intent);

        if(getIntent().getAction() != null
           && getIntent().getExtras() != null
           && getIntent().getAction().equals((Intent.ACTION_SEND))){

            Bundle extras = getIntent().getExtras();
            String sub = extras.getString(Intent.EXTRA_SUBJECT);
            String text = extras.getString(Intent.EXTRA_TEXT);
            uiEditText.setText(sub+""+ text);
        }

/*
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
    }*/

    }
}