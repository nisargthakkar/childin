package com.help.childin.presenters;

import com.google.gson.Gson;
import com.help.childin.models.NotificationModel;
import com.help.childin.models.NotificationResponseModel;
import com.help.childin.models.ProductModel;
import com.help.childin.models.ProductsResponseModel;
import com.help.childin.ui.fragment.HomeFragment;
import com.help.childin.ui.fragment.MyDonationFragment;
import com.help.childin.utils.Helper;

import java.io.IOException;
import java.util.ArrayList;

import static com.help.childin.utils.AppConstants.imageIds;

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
            NotificationResponseModel notificationResponseModel = gson.fromJson(jsonString, NotificationResponseModel.class);
            if (notificationResponseModel != null && notificationResponseModel.notificationModels != null){
                /*ArrayList<NotificationModel> notificationModels = new ArrayList<>();
                for (int i = 0; i < notificationModels.products.size(); i++) {
                    ProductModel productModel = notificationModels.products.get(i);
                    productModel.imageId = imageIds[i];
                    productModels.add(productModel);
                }*/
                myDonationFragment.onNotificationsReceived(notificationResponseModel.notificationModels);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
