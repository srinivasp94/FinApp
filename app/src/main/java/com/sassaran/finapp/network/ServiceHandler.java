package com.sassaran.finapp.network;

import android.app.Dialog;
import android.content.Context;
import android.widget.Toast;


import com.sassaran.finapp.base.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceHandler<T> {

    Dialog progressDialog;

    public ServiceHandler() {
    }

    public void request(
            final Context mContext,
            final int requestId,
            final boolean showProgress,
            Call<T> call,
            final ISuccessCallBack<T> mSuccessHandler

    ) {


        if (!Utils.isInternetAvailable(mContext)) {
            Toast.makeText(mContext, "Internet not available,Please check internet connections", Toast.LENGTH_SHORT).show();
            return;
        }
        if (showProgress) {

            progressDialog =  Utils.showProgressDialog( mContext);
           
        }


        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                 Utils.dismissProgressDialog(progressDialog);

                if (response.isSuccessful()) {

                    mSuccessHandler.onResponseSuccess(response.body(), requestId, response.headers());

                } else {

                 /*   ErrorModel model = new Gson().fromJson(response.errorBody().charStream(),ErrorModel.class);
                    if (model.message == null) {
                        mFailureHandler.failureResponse(requestId, model.errorDesc);
                    } else {
                        mFailureHandler.failureResponse(requestId, model.message);
                    }*/
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {

                Utils.dismissProgressDialog(progressDialog);

                mSuccessHandler.onResponseFailure(requestId, t.toString());
            }
        });
    }

}
