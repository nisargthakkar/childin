package com.help.childin.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Chitti Venkat on 11/13/2016.
 */

public class LoginRequestModel implements Serializable {

    @SerializedName("Email")
    public String strEmail;

    @SerializedName("Password")
    public String strPassword;

}
