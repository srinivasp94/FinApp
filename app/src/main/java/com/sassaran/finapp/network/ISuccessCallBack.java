package com.sassaran.finapp.network;

import okhttp3.Headers;

public interface ISuccessCallBack<T> {

    void onResponseSuccess(T mResponse, int RequestCode, Headers headers);

    void onResponseFailure( int RequestCode,String failureCode);
}
