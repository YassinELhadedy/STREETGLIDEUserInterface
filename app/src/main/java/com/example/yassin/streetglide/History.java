package com.example.yassin.streetglide;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yassin.streetglide.adapter.DataAdapter;
import com.example.yassin.streetglide.adapter.HistoryAdapter;
import com.example.yassin.streetglide.model.HistoryShipment;
import com.example.yassin.streetglide.model.Shipment;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<HistoryShipment>pickUpList;
    HistoryAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.historybar);

        recyclerView=(RecyclerView)findViewById(R.id.recycleviewhistory);


          set_recycleview();
//        adapter.notifyDataSetChanged();



    }

    public void set_recycleview(){

        pickUpList = new ArrayList<>();

        pickUpList.add(new HistoryShipment("ISLAM NADER","EL-Hadedy","EL-mohandseen","01063039159","Status: Delivered"," Total Collection 400$","#43CD80"));
        pickUpList.add(new HistoryShipment("ISLAM NADER","EL-Hadedy","EL-mohandseen","01063039159","Status: Rejected"," Total Collection 400$","#FF4500"));
        pickUpList.add(new HistoryShipment("ISLAM NADER","EL-Hadedy","EL-mohandseen","01063039159","Status: Delivered"," Total Collection 400$","#43CD80"));
        pickUpList.add(new HistoryShipment("ISLAM NADER","EL-Hadedy","EL-mohandseen","01063039159","Status: Damaged"," Total Collection 400$","#000000"));
        pickUpList.add(new HistoryShipment("ISLAM NADER","EL-Hadedy","EL-mohandseen","01063039159","Status: Delivered"," Total Collection 400$","#43CD80"));
        pickUpList.add(new HistoryShipment("ISLAM NADER","EL-Hadedy","EL-mohandseen","01063039159","Status: Rejected"," Total Collection 400$","#FF4500"));
        pickUpList.add(new HistoryShipment("ISLAM NADER","EL-Hadedy","EL-mohandseen","01063039159","Status: Delivered"," Total Collection 400$","#43CD80"));
        pickUpList.add(new HistoryShipment("ISLAM NADER","EL-Hadedy","EL-mohandseen","01063039159","Status: Delivered"," Total Collection 400$","#43CD80"));


        adapter= new HistoryAdapter(pickUpList, History.this);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(History.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


}
