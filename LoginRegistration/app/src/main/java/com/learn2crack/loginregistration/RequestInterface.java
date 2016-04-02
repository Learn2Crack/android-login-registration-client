package com.learn2crack.loginregistration;

import com.learn2crack.loginregistration.models.ServerRequest;
import com.learn2crack.loginregistration.models.ServerResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RequestInterface {

    @POST("login_register/")
    Call<ServerResponse> operation(@Body ServerRequest request);

}
