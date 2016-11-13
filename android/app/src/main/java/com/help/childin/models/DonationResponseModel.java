package com.help.childin.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ramakrishna on 11/12/16.
 */

public class DonationResponseModel implements Serializable {

    @SerializedName("DonationData")
    public ArrayList<DonationModel> donationModels;

}
