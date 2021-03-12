package com.pankaj.mobiustest.viewmodel;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pankaj.mobiustest.model.DataModel;
import com.pankaj.mobiustest.network.ApiClient;
import com.pankaj.mobiustest.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataViewModel extends ViewModel {

    public MutableLiveData<List<DataModel>> listMutableLiveData = new MutableLiveData<List<DataModel>>();


    public void getCouponsList(Context context) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<DataModel>> dataModelCall = apiInterface.getCouponsList();

        dataModelCall.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                if (response.body() != null) {
                    listMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                Toast.makeText(context, "Error while getting response", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
