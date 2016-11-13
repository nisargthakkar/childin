package com.help.childin.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.help.childin.R;
import com.help.childin.models.ProductModel;
import com.help.childin.presenters.HomePresenter;
import com.help.childin.ui.activity.HomeActions;
import com.help.childin.ui.adapters.StoryListAdapter;
import com.help.childin.utils.Helper;

import org.w3c.dom.Text;

public class HomeFragment extends Fragment implements View.OnClickListener{

	private OnFragmentInteractionListener listener;
	private HomePresenter homePresenter;

    //@BindView(R.id.recycler_category)
   // RecyclerView recyclerCategory;

	@BindView(R.id.llNotifications)
	LinearLayout linearLayoutNot;
	@BindView(R.id.llDonations)
	LinearLayout linearLayoutDon;
	@BindView(R.id.llChildren)
	LinearLayout linearLayoutChild;

	@BindView(R.id.textViewNotifications)
	TextView textViewNotifications;
	@BindView(R.id.textViewDonations)
	TextView textViewDontions;
	@BindView(R.id.textViewMyChildren)
	TextView textViewChildren;

	public static HomeFragment newInstance() {
		return new HomeFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);
		homePresenter = new HomePresenter(this);

		textViewNotifications.setTypeface(Helper.getMyTypeFace(getActivity()));
		textViewDontions.setTypeface(Helper.getMyTypeFace(getActivity()));
		textViewChildren.setTypeface(Helper.getMyTypeFace(getActivity()));

		linearLayoutNot.setOnClickListener(this);
		linearLayoutDon.setOnClickListener(this);
		linearLayoutChild.setOnClickListener(this);

		return view;
	}

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        homePresenter.loadProducts();
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

	@Override
	public void onClick(View view) {
		int id = view.getId();
		switch (id){
			case R.id.llNotifications:
				switchActivity(0);
				break;
			case R.id.llDonations:
				switchActivity(1);
				break;
			case R.id.llChildren:
				switchActivity(2);
				break;
		}
	}

	public void switchActivity(int index){
		Intent i ;
		if(index==0){
			i = new Intent(getActivity(), HomeActions.class);
			i.putExtra(HomeActions.KEY_ACTION_NOTE, "notifications");
		}else if(index==1){
			i = new Intent(getActivity(), HomeActions.class);
			i.putExtra(HomeActions.KEY_ACTION_DON, "donations");
		}else{
			i = new Intent(getActivity(), HomeActions.class);
			i.putExtra(HomeActions.KEY_ACTION_CH, "childrens");
		}
		getActivity().startActivity(i);
	}

	public interface OnFragmentInteractionListener {
	}

	public void onProductListReceived(ArrayList<ProductModel> storyModels){
		/*LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
		recyclerCategory.setLayoutManager(linearLayoutManager);
		StoryListAdapter storyListAdapter = new StoryListAdapter(getActivity(), storyModels);
		recyclerCategory.setAdapter(storyListAdapter);*/
	}
}
