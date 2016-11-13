package com.help.childin.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Chitti Venkat on 11/13/2016.
 */

public class RegisterRequestModel implements Serializable{

    @SerializedName("name")
    public String strName;

    @SerializedName("gender")
    public String strGender;

    @SerializedName("dob")
    public String strDob;

    @SerializedName("address")
    public String strAddress;

    @SerializedName("mobile")
    public String strMobile;

    @SerializedName("email")
    public String strEmail;

}
