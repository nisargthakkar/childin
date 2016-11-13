package com.help.childin.ui.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.help.childin.R;
import com.help.childin.models.DonationModel;
import com.help.childin.utils.Helper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyDonationsListAdapter extends RecyclerView.Adapter<MyDonationsListAdapter.ViewHolder> {

    private List<DonationModel> donationModels;
    private Context context;

    public MyDonationsListAdapter(Context context, ArrayList<DonationModel> donationModels) {
        this.donationModels = donationModels;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_donations_list,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        DonationModel donationModel = donationModels.get(position);
        viewHolder.txtStoryName.setText(donationModel.donationMsg);
        viewHolder.txtStoryName.setTypeface(Helper.getMyTypeFace(context));

        //viewHolder.imgProduct.setImageResource(storyModel.imageId);
        viewHolder.txtProductPrice.setText(donationModel.donationBody);
        viewHolder.txtProductPrice.setTypeface(Helper.getMyTypeFace(context));

        viewHolder.cardItemView.setTag(donationModel);

        viewHolder.cardItemView.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return donationModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.txt_story_name)
        TextView txtStoryName;

        @BindView(R.id.card_item_view)
        CardView cardItemView;

        @BindView(R.id.txt_product_price)
        TextView txtProductPrice;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //DonationModel donationModel = (DonationModel) view.getTag();
           // Intent intent = new Intent(context, TestActivity.class);
            //intent.putExtra(AppConstants.EXTRA_PRODUCT_MODEL,donationModel);
            //context.startActivity(intent);
        }
    };

}