package com.pankaj.mobiustest.adapter;

import android.annotation.SuppressLint;
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

public class SlabMinMaxAdapter extends RecyclerView.Adapter<SlabMinMaxAdapter.ViewHolder> {

    private List<DataModel.Slabs> dataModelList;
    private Context context;

    public SlabMinMaxAdapter(Context context, List<DataModel.Slabs> slabs) {
        this.context = context;
        this.dataModelList = slabs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_slabs, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DataModel.Slabs slab = dataModelList.get(position);
        if (slab != null) {
            if (slab.getMin() > 0 && slab.getMax() == 0) {
                holder.tv_slab_value.setText("<" + String.valueOf(slab.getMin()));
            } else if (slab.getMin() > 0 && slab.getMax() > 0) {
                holder.tv_slab_value.setText(">=" + String.valueOf(slab.getMin() + " & <" + String.valueOf(slab.getMax())));
            } else if (slab.getMin() == 0 && slab.getMax() > 0) {
                holder.tv_slab_value.setText(">=" + String.valueOf(slab.getMax()));

            }
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
