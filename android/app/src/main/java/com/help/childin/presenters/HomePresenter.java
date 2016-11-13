package com.help.childin.presenters;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import com.help.childin.models.ProductModel;
import com.help.childin.models.ProductsResponseModel;
import com.help.childin.ui.fragment.HomeFragment;
import com.help.childin.utils.Helper;

import static com.help.childin.utils.AppConstants.imageIds;

/**
 * Created by ramakrishna on 10/30/16.
 */

public class HomePresenter {

    HomeFragment homeFragment;

    public HomePresenter(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
    }

    public void loadProducts(){
        Helper helper = new Helper(homeFragment.getActivity());
        try {
            String jsonString = helper.loadJsonFromAssets("ayursha_products.json");
            Gson gson = new Gson();
            ProductsResponseModel productsResponseModel = gson.fromJson(jsonString, ProductsResponseModel.class);
            if (productsResponseModel != null && productsResponseModel.products != null){
                ArrayList<ProductModel> productModels = new ArrayList<>();
                for (int i = 0; i < productsResponseModel.products.size(); i++) {
                    ProductModel productModel = productsResponseModel.products.get(i);
                    productModel.imageId = imageIds[i];
                    productModels.add(productModel);
                }
                homeFragment.onProductListReceived(productModels);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
