package com.example.yassin.streetglide.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yassin.streetglide.R;
import com.example.yassin.streetglide.model.HistoryShipment;

import java.util.ArrayList;

/**
 * Created by yassin on 7/16/17.
 */

public class HistoryAdapter  extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private ArrayList<HistoryShipment> pickUpList;
    private Context context;

    public HistoryAdapter(ArrayList<HistoryShipment> pickUpList, Context context){
        this.pickUpList= pickUpList;
        this.context=context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.historycard,parent,false);
        return new HistoryAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        HistoryShipment shipment=pickUpList.get(position);
        holder.tvSenderName.setText(shipment.getSender_name());
        holder.tvReciverName.setText(shipment.getConsignee_name());
        holder.tvAdress.setText(shipment.getConsignee_add());
        holder.tvPhoneNum.setText(shipment.getCosignee_number());
        holder.tvTotalCash.setText(shipment.getConsignee_cash());
        holder.tvStatus.setText(shipment.getConsignee_status());
        holder.tvStatus.setBackgroundColor(Color.parseColor(shipment.getFlagline()));
        holder.flagline.setBackgroundColor(Color.parseColor(shipment.getFlagline()));


    }

    @Override
    public int getItemCount() {
        return pickUpList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvSenderName,tvReciverName,tvAdress,tvPhoneNum,tvTotalCash,tvStatus;
            View flagline;
        public ViewHolder(final View view) {
            super(view);

            tvSenderName = view.findViewById(R.id.tvSenderName);
            tvReciverName = view.findViewById(R.id.tvReciverName);
            tvAdress = view.findViewById(R.id.tvAdress);
            tvPhoneNum=view.findViewById(R.id.tvPhoneNum);
            tvTotalCash=view.findViewById(R.id.tvTotalCash);
            tvStatus=view.findViewById(R.id.tvStatus);
            flagline=view.findViewById(R.id.flagline);




        }
    }
}