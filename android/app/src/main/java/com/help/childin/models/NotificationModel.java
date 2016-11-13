package com.help.childin.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ramakrishna on 11/12/16.
 */

public class NotificationModel implements Serializable {

    @SerializedName("NotificationId")
    public String notificaitonId;

    @SerializedName("NotificationMsg")
    public String notificationMsg;

    @SerializedName("NotificationBody")
    public String notificationBody;

}
