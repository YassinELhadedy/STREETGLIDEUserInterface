package com.example.yassin.streetglide.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.yassin.streetglide.R;
import com.example.yassin.streetglide.RunnerDashbord;
import com.example.yassin.streetglide.adapter.DataAdapter;
import com.example.yassin.streetglide.model.Shipment;

import java.util.ArrayList;


public class DeliveryStatus extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View view;
    private RecyclerView recyclerView;
    private ArrayList<Shipment> pickUpList;
    private DataAdapter adapter;
    private LinearLayout pending,deliverd,undeliverd;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DeliveryStatus() {

    }


    public static DeliveryStatus newInstance(String param1, String param2) {
        DeliveryStatus fragment = new DeliveryStatus();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.fragment_delivery_status, container, false);
         recyclerView= (RecyclerView) view.findViewById(R.id.recycleviewh);
         pending=(LinearLayout)view.findViewById(R.id.pending);
         deliverd=(LinearLayout)view.findViewById(R.id.deliverd);
         undeliverd=(LinearLayout)view.findViewById(R.id.undeliverd);

        pending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_recycleview("#FEDD00");
                adapter.notifyDataSetChanged();

            }
        });
        deliverd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_recycleview("#43CD80");
                adapter.notifyDataSetChanged();
            }
        });
        undeliverd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_recycleview("#FF4500");
                adapter.notifyDataSetChanged();
            }
        });

        set_recycleview("#FEDD00");
        adapter.notifyDataSetChanged();


        return view;
    }
    public void set_recycleview(String color){

        pickUpList = new ArrayList<>();

        pickUpList.add(new Shipment("ISLAM NADER","EL-mohandseen",123456,"Total Collection 400$",color));
        pickUpList.add(new Shipment("ISLAM NADER","EL-mohandseen",123456,"Total Collection 400$",color));
        pickUpList.add(new Shipment("ISLAM NADER","EL-mohandseen",123456,"Total Collection 400$",color));
        pickUpList.add(new Shipment("ISLAM NADER","EL-mohandseen",123456,"Total Collection 400$",color));
        pickUpList.add(new Shipment("ISLAM NADER","EL-mohandseen",123456,"Total Collection 400$",color));
        pickUpList.add(new Shipment("ISLAM NADER","EL-mohandseen",123456,"Total Collection 400$",color));
        pickUpList.add(new Shipment("ISLAM NADER","EL-mohandseen",123456,"Total Collection 400$",color));
        adapter= new DataAdapter(pickUpList,getActivity());

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
