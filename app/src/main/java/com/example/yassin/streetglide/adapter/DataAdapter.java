package com.example.yassin.streetglide.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yassin.streetglide.R;
import com.example.yassin.streetglide.model.Shipment;

import java.util.ArrayList;

/**
 * Created by yassin on 6/15/17.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<Shipment> pickUpList;
    private Context context;

    public DataAdapter(ArrayList<Shipment> pickUpList, Context context){
        this.pickUpList= pickUpList;
        this.context=context;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shipments,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Shipment shipment=pickUpList.get(position);
        holder.consignee_name.setText(shipment.getCosignee_name());
        holder.consignee_add.setText(shipment.getConsignee_add());
        holder.shipment_id.setText(""+shipment.getShipment_id());
        holder.cost.setText(shipment.getCost());
        holder.flagline.setBackgroundColor(Color.parseColor(shipment.getFlagline()));


    }

    @Override
    public int getItemCount() {
        return pickUpList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView consignee_name,consignee_add,cost,shipment_id;
        View flagline;
        public ViewHolder(final View view) {
            super(view);

            consignee_name = view.findViewById(R.id.consigneename);
            consignee_add = view.findViewById(R.id.consigneeadd);
            cost = view.findViewById(R.id.cost);
            shipment_id=view.findViewById(R.id.shipmentid);
            flagline=view.findViewById(R.id.flagline);


        }
    }
}