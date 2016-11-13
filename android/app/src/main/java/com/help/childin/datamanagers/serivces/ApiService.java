package com.help.childin.datamanagers.serivces;

import com.help.childin.models.NotificationModel;
import com.help.childin.utils.Helper;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by Ramakrishna on 6/24/2015.
 */
public class ApiService {

    private final static String TAG = ApiService.class.getSimpleName();

    public void addDiscountCardTask(NotificationModel notificationModel, Call<NotificationModel> callback) {

        Retrofit retrofit = Helper.getRetrofitObj();


        /*AddDiscountCardServiceListener addDiscountCardServiceListener = retrofit.create(AddDiscountCardServiceListener.class);

        Call<CommonResponseModel> call = addDiscountCardServiceListener.addDiscountCard(

        );
        call.enqueue(callback);*/

    }


}
