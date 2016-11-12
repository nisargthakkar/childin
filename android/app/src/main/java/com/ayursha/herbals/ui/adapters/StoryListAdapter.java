package com.ayursha.herbals.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.ayursha.herbals.R;
import com.ayursha.herbals.models.ProductModel;
import com.ayursha.herbals.ui.activity.StoryReaderActivity;
import com.ayursha.herbals.ui.activity.TestActivity;
import com.ayursha.herbals.utils.AppConstants;
import com.ayursha.herbals.utils.Helper;

public class StoryListAdapter extends RecyclerView.Adapter<StoryListAdapter.ViewHolder> {

    private List<ProductModel> storyModels;
    private Context context;

    public StoryListAdapter(Context context, List<ProductModel> storyModels) {
        this.storyModels = storyModels;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_story_list,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        ProductModel storyModel = storyModels.get(position);
        viewHolder.txtStoryName.setText(storyModel.name);
        viewHolder.txtStoryName.setTypeface(Helper.getMyTypeFace(context));

        viewHolder.imgProduct.setImageResource(storyModel.imageId);
        viewHolder.txtProductPrice.setText("Price: "+storyModel.price);
        viewHolder.txtProductPrice.setTypeface(Helper.getMyTypeFace(context));

        viewHolder.cardItemView.setTag(storyModel);

        viewHolder.cardItemView.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return storyModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.txt_story_name)
        TextView txtStoryName;

        @BindView(R.id.card_item_view)
        CardView cardItemView;

        @BindView(R.id.img_product)
        ImageView imgProduct;

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