package com.hfad.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    EditText mSendTo, mSubject, mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSendTo = findViewById(R.id.sendTo);
        mSubject = findViewById(R.id.subject);
        mText = findViewById(R.id.emailText);
        mButton = findViewById(R.id.send);


    }

    public void onSendMessage(View view)
    {
        String emailSend = mSendTo.getText().toString();
        String emailSubject = mSubject.getText().toString();
        String emailText = mText.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailSend});
        intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);

        intent.setType("message/rfc822");
        startActivity(intent);
    }
}