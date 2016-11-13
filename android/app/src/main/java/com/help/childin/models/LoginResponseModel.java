package com.help.childin.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Chitti Venkat on 11/13/2016.
 */

public class LoginResponseModel implements Serializable {

    @SerializedName("success")
    public boolean isSuccess;

    @SerializedName("Message")
    public String strGender;
}
