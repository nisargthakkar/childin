package com.help.childin.ui.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.help.childin.R;
import com.help.childin.utils.Helper;
import com.help.childin.utils.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ramakrishna on 11/6/16.
 */

public class ContactFragment extends DialogFragment {

    @BindView(R.id.btn_send_request)
    Button btnSendRequest;

    @BindView(R.id.txt_call_msg)
    TextView txtCallMsg;

    @BindView(R.id.edt_name)
    EditText edtName;

    @BindView(R.id.edt_mobile)
    EditText edtMobile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dialog_contact, container, false);
        //getDialog().setTitle(null);
        ButterKnife.bind(this,rootView);
        //Grab the window of the dialog, and change the width
        //WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        //Window window = getDialog().getWindow();
        //lp.copyFrom(window.getAttributes());
//This makes the dialog take up the full width
        //lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //window.setAttributes(lp);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        txtCallMsg.setTypeface(Helper.getMyTypeFace(getActivity()));
        edtName.setTypeface(Helper.getMyTypeFace(getActivity()));
        edtMobile.setTypeface(Helper.getMyTypeFace(getActivity()));
        btnSendRequest.setTypeface(Helper.getMyBoldTypeFace(getActivity()));
    }

    @OnClick(R.id.btn_send_request)
    public void onSendRequestClicked(){
        String name = StringUtils.changeToString(edtName.getText().toString());
        String mobile = StringUtils.changeToString(edtMobile.getText().toString());
        if (!name.equals("") && !mobile.equals("")) {
            Toast.makeText(getActivity(), "Thank you.Your request sent successfully.We will call you soon.", Toast.LENGTH_LONG).show();
            getDialog().onBackPressed();
        }else {
            Toast.makeText(getActivity(), "Please enter credintials", Toast.LENGTH_SHORT).show();
        }
    }
}
