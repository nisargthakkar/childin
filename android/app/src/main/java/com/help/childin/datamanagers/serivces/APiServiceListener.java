package com.help.childin.datamanagers.serivces;

import com.help.childin.models.NotificationModel;
import com.help.childin.utils.AppConstants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by Ramakrishna on 6/24/2015.
 */
public interface ApiServiceListener {


    @POST(AppConstants.CHILD_LIST)
    Call<NotificationModel>
    loadMyDonations(@Query("card_type") String cardType,
                    @Query("form_type") String formType);

    @GET("users/{user}/repos")
    Call<NotificationModel> listRepos(@Path("user") String user);

    //@POST("users/new")
    //Call<User> createUser(@Body User user);

}
