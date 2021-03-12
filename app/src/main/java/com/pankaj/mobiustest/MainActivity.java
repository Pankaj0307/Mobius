package com.pankaj.mobiustest;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pankaj.mobiustest.adapter.CouponListAdapter;
import com.pankaj.mobiustest.model.DataModel;
import com.pankaj.mobiustest.viewmodel.DataViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_coupons_list;
    private LinearLayoutManager linearLayoutManager;
    private DataViewModel dataViewModel;
    private CouponListAdapter couponListAdapter;
    private ProgressBar progress_circular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

//        calling api to get the coupons list
        progress_circular.setVisibility(View.VISIBLE);
        dataViewModel.getCouponsList(this);

        dataViewModel.listMutableLiveData.observe(this, new Observer<List<DataModel>>() {
            @Override
            public void onChanged(List<DataModel> dataModels) {
                if (dataModels != null) {
                    progress_circular.setVisibility(View.GONE);
                    setListValues(dataModels);
                }
            }
        });

    }

    private void initViews() {
        progress_circular = findViewById(R.id.progress_circular);
        rv_coupons_list = findViewById(R.id.rv_coupons_list);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv_coupons_list.setLayoutManager(linearLayoutManager);
//        rv_coupons_list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    //set values in adapter
    private void setListValues(List<DataModel> dataModels) {
        couponListAdapter = new CouponListAdapter(this, dataModels);
        rv_coupons_list.setAdapter(couponListAdapter);
    }


}