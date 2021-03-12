package com.pankaj.mobiustest.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pankaj.mobiustest.R;
import com.pankaj.mobiustest.Utils;
import com.pankaj.mobiustest.model.DataModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CouponListAdapter extends RecyclerView.Adapter<CouponListAdapter.ViewHolder> {

    private List<DataModel> dataModelList;
    private Context context;
    private SlabMinMaxAdapter slabMinMaxAdapter;
    private SlabWageAdapter slabWageAdapter;
    private SlabOtcAdapter slabOtcAdapter;

    public CouponListAdapter(Context context, List<DataModel> dataModelList) {
        this.context = context;
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_coupons, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataModel dataModel = dataModelList.get(position);

        //setting list item values from datamodel object
        if (dataModel != null) {
            initRecyclerView(holder, dataModel);
            initBonusRecyclerView(holder, dataModel);
            initPurchaseRecyclerView(holder, dataModel);

            holder.tv_code.setText(dataModel.getCode() != null ? dataModel.getCode() : "--");

            holder.tv_ribbon_msg.setText(dataModel.getRibbon_msg() != null ? dataModel.getRibbon_msg() : "--");

            SpannableStringBuilder spAmount = new SpannableStringBuilder();
            spAmount.append("Get ");
            int max_slab_wagered_percentage = getMaxSlabWagered_Percentage(dataModel.getSlabs(), true);
            int max_slab_otc_percentage = getMaxSlabOtc_Percentage(dataModel.getSlabs(), true);
            int percentage = max_slab_wagered_percentage + max_slab_otc_percentage;
            spAmount.append(percentage + "% upto ");
            int max_slab_wagered = getMaxSlabWagered_Percentage(dataModel.getSlabs(), false);
            int max_slab_otc_max = getMaxSlabOtc_Percentage(dataModel.getSlabs(), false);
            int max = max_slab_wagered + max_slab_otc_max;
            spAmount.append(context.getString(R.string.rs) + max);
            holder.tv_amount.setText(spAmount, TextView.BufferType.SPANNABLE);

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Valid till ");
            String valid_till = Utils.getDateAndTime(context, dataModel.getValid_until());
            stringBuilder.append(valid_till);
            holder.tv_validity.setText(stringBuilder.toString());

            SpannableStringBuilder spannableString = new SpannableStringBuilder();
            spannableString.append("Min. Deposit \n");
            int min_slab = getMinSlab(dataModel.getSlabs());
            spannableString.append(context.getString(R.string.rs) + String.valueOf(min_slab));
            SpannableString greenSpan = new SpannableString(" Applied");
            greenSpan.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.light_green)), 0, " Applied".length(), 0);
            spannableString.append(greenSpan);
            holder.tv_min_deposit.setText(spannableString, TextView.BufferType.SPANNABLE);


            int wager_to_release_ratio_numerator = dataModel.getWager_to_release_ratio_numerator();
            int wager_to_release_ratio_denominator = dataModel.getWager_to_release_ratio_denominator();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append("For every ");
            String every = context.getString(R.string.rs) + wager_to_release_ratio_numerator;
            SpannableString yellowSpannable = new SpannableString(every);
            yellowSpannable.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.dark_yellow)), 0, every.length(), 0);
            spannableStringBuilder.append(yellowSpannable);
            spannableStringBuilder.append(" bet ");
            String final_deno_num_msg = context.getString(R.string.rs) + (wager_to_release_ratio_denominator);
            SpannableString yellowSpan = new SpannableString(final_deno_num_msg);
            yellowSpan.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.dark_yellow)), 0, final_deno_num_msg.length(), 0);
            spannableStringBuilder.append(yellowSpan);
            spannableStringBuilder.append(" will be released from the bonus amount");
            holder.tv_wager_num_denom.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);

            SpannableStringBuilder spBuilder = new SpannableStringBuilder();
            spBuilder.append("Bonus expiry ");
            String bonus_expiry_days = String.valueOf(dataModel.getWager_bonus_expiry());
            SpannableString days = new SpannableString(bonus_expiry_days);
            days.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.dark_yellow)), 0, bonus_expiry_days.length(), 0);
            spBuilder.append(days);
            spBuilder.append(" days from the issue");
            holder.tv_bonus_expiry.setText(spBuilder, TextView.BufferType.SPANNABLE);


            //setting list values


        }

    }

    //this method will return max wage number percentage
    private int getMinSlab(List<DataModel.Slabs> slabs) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < slabs.size(); i++) {
            list.add(slabs.get(i).getMin());
        }
        Collections.sort(list);
        return list.get(0);
    }

    //this method will return max wage number percentage
    private int getMaxSlabWagered_Percentage(List<DataModel.Slabs> slabs, boolean percentage) {
        List<Integer> list = new ArrayList<>();
        if (percentage) {
            for (int i = 0; i < slabs.size(); i++) {
                list.add(slabs.get(i).getWagered_percent());
            }
        } else {
            for (int i = 0; i < slabs.size(); i++) {
                list.add(slabs.get(i).getWagered_max());
            }
        }

        Collections.sort(list);
        return list.get(list.size() - 1);
    }

    //this method will return max otc number percentage
    private int getMaxSlabOtc_Percentage(List<DataModel.Slabs> slabs, boolean percentage) {
        List<Integer> list = new ArrayList<>();
        if (percentage) {
            for (int i = 0; i < slabs.size(); i++) {
                list.add(slabs.get(i).getOtc_percent());
            }
        } else {
            for (int i = 0; i < slabs.size(); i++) {
                list.add(slabs.get(i).getOtc_max());
            }
        }
        Collections.sort(list);
        return list.get(list.size() - 1);
    }

    private void initRecyclerView(ViewHolder holder, DataModel dataModel) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.rv_purchase_amount.setLayoutManager(linearLayoutManager);
//        holder.rv_purchase_amount.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        slabMinMaxAdapter = new SlabMinMaxAdapter(context, dataModel.getSlabs());
        holder.rv_purchase_amount.setAdapter(slabMinMaxAdapter);

    }

    private void initBonusRecyclerView(ViewHolder holder, DataModel dataModel) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.rv_bonus_amount.setLayoutManager(linearLayoutManager);
//        holder.rv_bonus_amount.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        slabWageAdapter = new SlabWageAdapter(context, dataModel.getSlabs());
        holder.rv_bonus_amount.setAdapter(slabWageAdapter);
    }

    private void initPurchaseRecyclerView(ViewHolder holder, DataModel dataModel) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.rv_instant_cash.setLayoutManager(linearLayoutManager);
//        holder.rv_instant_cash.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        slabOtcAdapter = new SlabOtcAdapter(context, dataModel.getSlabs());
        holder.rv_instant_cash.setAdapter(slabOtcAdapter);
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_code, tv_ribbon_msg, tv_amount, tv_validity, tv_min_deposit, tv_wager_num_denom, tv_bonus_expiry;
        private RecyclerView rv_purchase_amount, rv_bonus_amount, rv_instant_cash;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_code = itemView.findViewById(R.id.tv_code);
            tv_ribbon_msg = itemView.findViewById(R.id.tv_ribbon_msg);
            tv_amount = itemView.findViewById(R.id.tv_amount);
            tv_validity = itemView.findViewById(R.id.tv_validity);
            tv_min_deposit = itemView.findViewById(R.id.tv_min_deposit);
            tv_wager_num_denom = itemView.findViewById(R.id.tv_wager_num_denom);
            tv_bonus_expiry = itemView.findViewById(R.id.tv_bonus_expiry);
            rv_purchase_amount = itemView.findViewById(R.id.rv_purchase_amount);
            rv_bonus_amount = itemView.findViewById(R.id.rv_bonus_amount);
            rv_instant_cash = itemView.findViewById(R.id.rv_instant_cash);


        }
    }
}
