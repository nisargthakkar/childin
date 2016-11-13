package com.help.childin.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.help.childin.R;
import com.help.childin.models.AboutModel;
import com.help.childin.presenters.AboutPresenter;
import com.help.childin.utils.Helper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutFragment extends Fragment {

	private OnFragmentInteractionListener listener;
	AboutPresenter aboutPresenter = null;

	@BindView(R.id.txt_content)
	TextView txtContent;

	@BindView(R.id.img_content)
	ImageView imgContent;


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
		txtContent.setTypeface(Helper.getMyTypeFace(getActivity()));
		Glide.with(this).load(aboutModel.imgUrl).into(imgContent);
        txtContent.setText(aboutModel.aboutUsContent);
	}

	public interface OnFragmentInteractionListener {
	}
}
