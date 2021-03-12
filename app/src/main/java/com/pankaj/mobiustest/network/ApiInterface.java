package com.pankaj.mobiustest.network;

import com.pankaj.mobiustest.Constants;
import com.pankaj.mobiustest.model.DataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET(Constants.list_url)
    Call<List<DataModel>> getCouponsList();
}
