package com.help.childin.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.help.childin.R;
import com.help.childin.models.NotificationModel;
import com.help.childin.models.ProductModel;
import com.help.childin.ui.activity.TestActivity;
import com.help.childin.utils.AppConstants;
import com.help.childin.utils.Helper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyDonationsListAdapter extends RecyclerView.Adapter<MyDonationsListAdapter.ViewHolder> {

    private List<NotificationModel> notificationModels;
    private Context context;

    public MyDonationsListAdapter(Context context, ArrayList<NotificationModel> notificationModels) {
        this.notificationModels = notificationModels;
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

        NotificationModel notificationModel = notificationModels.get(position);
        viewHolder.txtStoryName.setText(notificationModel.notificationMsg);
        viewHolder.txtStoryName.setTypeface(Helper.getMyTypeFace(context));

        //viewHolder.imgProduct.setImageResource(storyModel.imageId);
        viewHolder.txtProductPrice.setText(notificationModel.notificationBody);
        viewHolder.txtProductPrice.setTypeface(Helper.getMyTypeFace(context));

        viewHolder.cardItemView.setTag(notificationModel);

        viewHolder.cardItemView.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return notificationModels.size();
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
            ProductModel productModel = (ProductModel) view.getTag();
            Intent intent = new Intent(context, TestActivity.class);
            intent.putExtra(AppConstants.EXTRA_PRODUCT_MODEL,productModel);
            context.startActivity(intent);
        }
    };

}