package com.help.childin.presenters;

import com.google.gson.Gson;
import com.help.childin.models.DonationResponseModel;
import com.help.childin.ui.fragment.MyDonationFragment;
import com.help.childin.utils.Helper;

import java.io.IOException;

/**
 * Created by ramakrishna on 10/30/16.
 */

public class MyDonationPresenter {

    MyDonationFragment myDonationFragment;

    public MyDonationPresenter(MyDonationFragment myDonationFragment) {
        this.myDonationFragment = myDonationFragment;
    }

    public void loadProducts(){
        Helper helper = new Helper(myDonationFragment.getActivity());
        try {
            String jsonString = helper.loadJsonFromAssets("donations_dummy.json");
            Gson gson = new Gson();
            DonationResponseModel donationResponseModel = gson.fromJson(jsonString, DonationResponseModel.class);
            if (donationResponseModel != null && donationResponseModel.donationModels != null){
                /*ArrayList<NotificationModel> notificationModels = new ArrayList<>();
                for (int i = 0; i < notificationModels.products.size(); i++) {
                    ProductModel productModel = notificationModels.products.get(i);
                    productModel.imageId = imageIds[i];
                    productModels.add(productModel);
                }*/
                myDonationFragment.onDonationsReceived(donationResponseModel.donationModels);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
