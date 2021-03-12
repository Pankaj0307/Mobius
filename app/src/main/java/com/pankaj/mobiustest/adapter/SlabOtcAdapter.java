package com.pankaj.mobiustest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pankaj.mobiustest.R;
import com.pankaj.mobiustest.model.DataModel;

import java.util.List;

public class SlabOtcAdapter extends RecyclerView.Adapter<SlabOtcAdapter.ViewHolder> {

    private List<DataModel.Slabs> dataModelList;
    private Context context;

    public SlabOtcAdapter(Context context, List<DataModel.Slabs> slabs) {
        this.context = context;
        this.dataModelList = slabs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_slabs, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DataModel.Slabs slab = dataModelList.get(position);
        if (slab != null) {
            String percentage = String.valueOf(slab.getOtc_percent()) + "%";
            StringBuilder sb = new StringBuilder();
            sb.append(percentage);
            sb.append("(Max. ");
            String max_amount = context.getResources().getString(R.string.rs) + slab.getOtc_max();
            sb.append(max_amount);
            sb.append(")");
            holder.tv_slab_value.setText(String.valueOf(sb));
        }

    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_slab_value;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_slab_value = itemView.findViewById(R.id.tv_slab_value);

        }
    }
}
