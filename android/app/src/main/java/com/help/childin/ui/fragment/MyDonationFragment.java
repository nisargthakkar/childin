package com.help.childin.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.help.childin.R;
import com.help.childin.models.DonationModel;
import com.help.childin.presenters.MyDonationPresenter;
import com.help.childin.ui.adapters.MyDonationsListAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyDonationFragment extends Fragment {

	private OnFragmentInteractionListener listener;
	private MyDonationPresenter myDonationPresenter;

    @BindView(R.id.recycler_category)
    RecyclerView recyclerCategory;

	public static MyDonationFragment newInstance() {
		return new MyDonationFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_donations, container, false);
        ButterKnife.bind(this,view);
		myDonationPresenter = new MyDonationPresenter(this);
		return view;
	}

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myDonationPresenter.loadProducts();
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

	public void onDonationsReceived(ArrayList<DonationModel> donationModels) {
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
		recyclerCategory.setLayoutManager(linearLayoutManager);
		MyDonationsListAdapter myDonationsListAdapter = new MyDonationsListAdapter(getActivity(), donationModels);
		recyclerCategory.setAdapter(myDonationsListAdapter);
	}

	public interface OnFragmentInteractionListener {
	}

}
