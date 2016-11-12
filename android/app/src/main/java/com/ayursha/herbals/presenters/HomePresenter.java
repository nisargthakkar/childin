package com.ayursha.herbals.presenters;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import com.ayursha.herbals.models.ProductModel;
import com.ayursha.herbals.models.ProductsResponseModel;
import com.ayursha.herbals.ui.fragment.HomeFragment;
import com.ayursha.herbals.utils.Helper;

import static com.ayursha.herbals.utils.AppConstants.imageIds;

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
