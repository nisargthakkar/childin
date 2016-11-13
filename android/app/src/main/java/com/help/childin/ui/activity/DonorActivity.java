package com.help.childin.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.help.childin.R;
import com.help.childin.models.RegisterRequestModel;
import com.help.childin.utils.Helper;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DonorActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    @BindView(R.id.name)
    EditText editTextName;

    @BindView(R.id.address)
    EditText editAddress;

    @BindView(R.id.mobile)
    EditText editMobile;

    @BindView(R.id.email)
    EditText editEmail;

    @BindView(R.id.dob)
    Button buttonDate;

    @BindView(R.id.btnRegister)
    Button buttonReg;

    @BindView(R.id.gender)
    Button buttonGender;

    @BindView(R.id.btnLinkToDonateScreen)
    Button buttonDonate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor);
        ButterKnife.bind(this);

        //buttonReg.setTextColor(getApplication().getResources().getColor(R.color.input_register_hint));
        //buttonGender.setTextColor(getApplication().getResources().getColor(R.color.input_register_hint));

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToDashBoard();
                finish();
            }
        });

        buttonDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.gotoDonoteLink(getApplicationContext());
            }
        });


        buttonGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(DonorActivity.this)
                        .title("Gender")
                        .items(R.array.entryvalues_list_gender)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                if(text.length() > 0){
                                    buttonGender.setText(text.toString());
                                }
                            }
                        }).show();
            }
        });

        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        DonorActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Date");
            }
        });

    }


    private void switchToDashBoard(){
        String strName = editTextName.getText().toString().trim();
        String strGender = buttonGender.getText().toString().trim();
        String strDob = buttonDate.getText().toString().trim();
        String strAddress = editAddress.getText().toString().trim();
        String strMobile = editMobile.getText().toString().trim();
        String strEmail = editEmail.getText().toString().trim();


        if(!strName.isEmpty() && !strAddress.isEmpty() && !strMobile.isEmpty() && !strEmail.isEmpty()){

            RegisterRequestModel rrm = new RegisterRequestModel();

            rrm.strName = strName;
            rrm.strGender = strGender;
            rrm.strDob = strDob;
            rrm.strAddress = strAddress;
            rrm.strMobile = strMobile;
            rrm.strEmail = strEmail;

            Intent i = new Intent(DonorActivity.this, MainActivity.class);
            startActivity(i);

        }else{
            Toast.makeText(DonorActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = ""+dayOfMonth+"/"+(++monthOfYear)+"/"+year;
        buttonDate.setText(date);
    }
}
