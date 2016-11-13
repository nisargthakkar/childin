package com.help.childin.presenters;

import com.google.gson.Gson;
import com.help.childin.models.AboutModel;
import com.help.childin.ui.fragment.AboutFragment;
import com.help.childin.utils.Helper;

import java.io.IOException;

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
            String jsonString = helper.loadJsonFromAssets("about_us.json");
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
