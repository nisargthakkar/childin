package com.help.childin.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ramakrishna on 11/12/16.
 */

public class DonationModel implements Serializable {

    @SerializedName("DonationId")
    public String donationId;

    @SerializedName("DonationMsg")
    public String donationMsg;

    @SerializedName("DonationBody")
    public String donationBody;

}
