package com.help.childin.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.help.childin.R;
import com.help.childin.utils.Helper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Registration extends AppCompatActivity {

    EditText editTextEmail;
    EditText editPassword;

    @BindView(R.id.btnRegister)
    Button buttonLogin;

    @BindView(R.id.btnLinkToDonateScreen)
    Button btnLinkToDonateScreen;

    @BindView(R.id.btnLinkToLoginScreen)
    Button btnLinkToLoginScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);

        editTextEmail = (EditText) findViewById(R.id.email);
        editPassword = (EditText) findViewById(R.id.password);

        editTextEmail.setTypeface(Helper.getMyTypeFace(Registration.this));
        editPassword.setTypeface(Helper.getMyTypeFace(Registration.this));
        btnLinkToLoginScreen.setTypeface(Helper.getMyTypeFace(Registration.this));
        btnLinkToDonateScreen.setTypeface(Helper.getMyTypeFace(Registration.this));
        buttonLogin.setTypeface(Helper.getMyTypeFace(Registration.this));

        btnLinkToLoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Registration.this, DonorActivity.class);
                startActivity(i);
            }
        });

        btnLinkToDonateScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.gotoDonoteLink(getApplicationContext());
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switchToDashBoard();
            }
        });
    }

    private void switchToDashBoard(){
        String strEmail = editTextEmail.getText().toString().trim();
        String strPass = editPassword.getText().toString().trim();

        if(!strEmail.isEmpty() && !strPass.isEmpty()){

            Intent i = new Intent(Registration.this, MainActivity.class);
            startActivity(i);

        }else{
            Toast.makeText(Registration.this, "Email and Password required", Toast.LENGTH_SHORT).show();
        }
    }
}
