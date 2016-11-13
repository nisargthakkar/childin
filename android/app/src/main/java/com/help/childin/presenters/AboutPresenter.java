package com.help.childin.presenters;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import com.help.childin.models.AboutModel;
import com.help.childin.models.ProductModel;
import com.help.childin.models.ProductsResponseModel;
import com.help.childin.ui.fragment.AboutFragment;
import com.help.childin.utils.Helper;

import static com.help.childin.utils.AppConstants.imageIds;

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
