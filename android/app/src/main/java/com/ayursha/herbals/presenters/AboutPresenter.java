package com.ayursha.herbals.presenters;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import com.ayursha.herbals.models.AboutModel;
import com.ayursha.herbals.models.ProductModel;
import com.ayursha.herbals.models.ProductsResponseModel;
import com.ayursha.herbals.ui.fragment.AboutFragment;
import com.ayursha.herbals.utils.Helper;

import static com.ayursha.herbals.utils.AppConstants.imageIds;

/**
 * Created by ramakrishna on 10/30/16.
 */

public class AboutPresenter {

    private AboutFragment aboutFragment;

    public AboutPresenter(AboutFragment aboutFragment){
        this.aboutFragment = aboutFragment;
    }

    public void loadAboutData(){
        Helper helper = new Helper(aboutFragment.getActivity());
        try {
            String jsonString = helper.loadJsonFromAssets("ayursha_contact.json");
            Gson gson = new Gson();
            AboutModel aboutModel = gson.fromJson(jsonString, AboutModel.class);
            if (aboutModel != null ){
                aboutFragment.onAboutDataReceived(aboutModel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
