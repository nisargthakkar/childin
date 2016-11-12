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
import com.help.childin.models.NotificationModel;
import com.help.childin.models.ProductModel;
import com.help.childin.presenters.NotificationPresenter;
import com.help.childin.ui.adapters.MyDonationsListAdapter;
import com.help.childin.ui.adapters.NotificationListAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationFragment extends Fragment {

	private OnFragmentInteractionListener listener;
	private NotificationPresenter notificationPresenter;

    @BindView(R.id.recycler_category)
    RecyclerView recyclerCategory;

	public static NotificationFragment newInstance() {
		return new NotificationFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_notification, container, false);
        ButterKnife.bind(this,view);
		notificationPresenter = new NotificationPresenter(this);
		return view;
	}

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        notificationPresenter.loadProducts();
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

	public void onNotificationsReceived(ArrayList<NotificationModel> notificationModels) {
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
		recyclerCategory.setLayoutManager(linearLayoutManager);
		NotificationListAdapter notificationListAdapter = new NotificationListAdapter(getActivity(), notificationModels);
		recyclerCategory.setAdapter(notificationListAdapter);
	}

	public interface OnFragmentInteractionListener {
	}

}
