package com.ayursha.herbals.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import com.ayursha.herbals.R;
import com.ayursha.herbals.models.AboutModel;
import com.ayursha.herbals.presenters.AboutPresenter;
import com.ayursha.herbals.utils.AppConstants;
import com.ayursha.herbals.utils.Helper;

public class AboutFragment extends Fragment {

	private OnFragmentInteractionListener listener;
	AboutPresenter aboutPresenter = null;

	@BindView(R.id.txt_name)
	TextView txtName;

	@BindView(R.id.txt_address)
	TextView txtAddress;

	@BindView(R.id.txt_mobile)
	TextView txtMobile;

	@BindView(R.id.txt_fb_url)
	TextView txtFbName;

	@BindView(R.id.layout_fb_url)
	LinearLayout layoutFbUrl;

	@BindView(R.id.layout_call)
	LinearLayout layoutCall;

	@BindView(R.id.layout_address)
	LinearLayout layoutAddress;

	AboutModel aboutModel = null;


	public static AboutFragment newInstance() {
		return new AboutFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_about, container, false);
		ButterKnife.bind(this,view);
		aboutPresenter = new AboutPresenter(this);
		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		aboutPresenter.loadAboutData();

		layoutFbUrl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (aboutModel != null){
					Intent fbIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(aboutModel.fburl));
					startActivity(fbIntent);
				}
			}
		});

		layoutCall.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (aboutModel != null){
					Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + aboutModel.phone));
					startActivity(intent);
				}
			}
		});

		layoutAddress.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (aboutModel != null){
					Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
							Uri.parse("http://maps.google.com/maps?daddr="+AppConstants.Lat+","+AppConstants.Lon));
					startActivity(intent);
				}
			}
		});
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof OnFragmentInteractionListener) {
			listener = (OnFragmentInteractionListener) context;
		} else {
			throw new RuntimeException(context.toString()
					+ " must implement OnFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		listener = null;
	}

	public void onAboutDataReceived(AboutModel aboutModel) {
		txtName.setTypeface(Helper.getMyTypeFace(getActivity()));
		txtAddress.setTypeface(Helper.getMyTypeFace(getActivity()));
		txtMobile.setTypeface(Helper.getMyTypeFace(getActivity()));
		txtFbName.setTypeface(Helper.getMyTypeFace(getActivity()));

		this.aboutModel = aboutModel;
		txtName.setText(aboutModel.name);
		txtAddress.setText(aboutModel.address);
		txtMobile.setText(aboutModel.phone);
		txtFbName.setText(aboutModel.fbname);
	}

	public interface OnFragmentInteractionListener {
	}
}
