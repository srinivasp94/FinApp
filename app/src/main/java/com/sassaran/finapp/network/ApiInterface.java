package com.sassaran.finapp.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {

    @FormUrlEncoded
    @POST
    Call<Object> callPost(@Url String path, @FieldMap Object o);

    @FormUrlEncoded
    @GET
    Call<Object> callGet(@Url String path);

    @FormUrlEncoded
    @POST("/loyaltypg/public/payment/irctc/initiate")
    Call<Void> callInitiator( @Field("encdata") String encData);



}
