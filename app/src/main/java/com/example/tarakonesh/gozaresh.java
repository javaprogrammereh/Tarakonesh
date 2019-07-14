package com.example.tarakonesh;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class gozaresh extends Fragment {
    Button btnShowDaramad, btnShowHazineh;
    TextView priceDaramad, priceHazineh, priceAll;
    ListView listViewShow;
    ArrayList<Transaction> transactionsArrayList1,transactionsArrayList2;
    public static boolean flagClickButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gozaresh, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnShowDaramad = view.findViewById(R.id.btn_daramad);
        btnShowHazineh = view.findViewById(R.id.btn_hazineh);
        priceDaramad = view.findViewById(R.id.price_daramad);
        priceHazineh = view.findViewById(R.id.price_hazineh);
        priceAll = view.findViewById(R.id.price_all);
        listViewShow = view.findViewById(R.id.list_view_show);

        updateViewListUp();

        btnShowDaramad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listGozareshUpdateDaramad();
                flagClickButton=true;
                Database.gettransactionDaramad(getContext());
            }
        });
        btnShowHazineh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listGozareshUpdateHazineh();
                flagClickButton=false;
                Database.getTransactionHazineh(getContext());
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        listGozareshUpdateHazineh();
        listGozareshUpdateDaramad();
        updateViewListUp();
    }
    /////////////////////////////

    public void updateViewListUp(){
        /////////////////////listup
        String[] arrayListShowAllDramad = Database.getDatatransactionDaramad(getContext());
        String valueDaramad = String.valueOf(ConvertingArray.showAllDaramad(arrayListShowAllDramad));
        priceDaramad.setText(valueDaramad);

        String[] arrayListShowHazineh = Database.getDatatransactionHazineh(getContext());
        String valueHazineh = String.valueOf(ConvertingArray.showAllHazineh(arrayListShowHazineh));
        priceHazineh.setText(valueHazineh);

        Long subtractionMoney = ConvertingArray.subtractionValue(Long.parseLong(valueDaramad), Long.parseLong(valueHazineh));
        priceAll.setText(String.valueOf(subtractionMoney));

    }
    public void listGozareshUpdateDaramad(){
        transactionsArrayList1 = new ArrayList<>();
        transactionsArrayList1 = Database.gettransactionDaramad(getContext());
        final TransactionAdapter itemAdapter1 = new TransactionAdapter(getActivity(), R.layout.list_item_gozaresh, transactionsArrayList1);
        listViewShow.setAdapter(itemAdapter1);
    }
    public void listGozareshUpdateHazineh(){
        transactionsArrayList2 = new ArrayList<>();
        transactionsArrayList2 = Database.getTransactionHazineh(getContext());
        final TransactionAdapter itemAdapter2 = new TransactionAdapter(getActivity(), R.layout.list_item_gozaresh, transactionsArrayList2);
        listViewShow.setAdapter(itemAdapter2);
    }
}
