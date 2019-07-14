package com.example.tarakonesh;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TransactionAdapter extends ArrayAdapter {
    ImageView imageViewDelete, imageViewUpdate;
    public int resourceId;
    public Activity activity;
    public ArrayList<Transaction> data;
    public static int idtrans;
    public static boolean flagDelAdapterTrans;
    public static Transaction transaction;
    public static String strPhone, strmoney, strRefer, strtransNumber, strtime, strdate, strDetail, strType;

    public TransactionAdapter(Activity activity, int resourceId, ArrayList<Transaction> object) {
        super(activity, resourceId, object);
        this.resourceId = resourceId;
        this.activity = activity;
        this.data = object;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        view = this.activity.getLayoutInflater().inflate(this.resourceId, null);

        imageViewDelete = view.findViewById(R.id.delete_gozaresh);
        imageViewUpdate = view.findViewById(R.id.update_gozaresh);

        final TextView bankName = view.findViewById(R.id.txt_bank_name);
        TextView money = view.findViewById(R.id.txt_money);
        TextView finasial = view.findViewById(R.id.txt_finacial);
        TextView transNumber = view.findViewById(R.id.txt_trans_number);
        TextView time = view.findViewById(R.id.txt_time);
        final TextView date = view.findViewById(R.id.txt_date);
//////////////
        transaction = data.get(position);
//        idtrans = transaction.getId();
        bankName.setText(transaction.getBankAccountFk());
        money.setText(transaction.getMoney());
        finasial.setText(transaction.getFinacialAccountFk());
        transNumber.setText(transaction.getTransNumber());
        time.setText(transaction.getTime());
        date.setText(transaction.getDate());

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                data.get(position).getId();
//                Log.i("data.get(position)getId", String.valueOf(data.get(position).getId()));
//            }
//        });
/////////////
        imageViewDelete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                idtrans= data.get(position).getId();
                Log.i("(idtrans)dellll :))))", String.valueOf(idtrans));
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(false).setMessage(" آیا از عملیات اطمینان دارید؟؟")
                        .setPositiveButton(
                                "حذف؟ ", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Database.deleteTrans(getContext());
                                        if (Database.flagTransDel == true) {
                                            Toast.makeText(getContext(), "اطلاعات بدرستی حذف شد!", Toast.LENGTH_SHORT).show();
                                            flagDelAdapterTrans = true;
                                            if (flagDelAdapterTrans == true) {
                                                data.remove(position);
                                                notifyDataSetChanged();
                                            }
                                        } else {
                                            Toast.makeText(getContext(), "عدم موفقیت در عملیات!", Toast.LENGTH_SHORT).show();
                                            flagDelAdapterTrans = false;
                                        }
                                    }
                                }
                        ).setNegativeButton(" خروج ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog _alert = builder.create();
                _alert.setTitle(" ");
                _alert.setIcon(R.drawable.ic_delete);
                _alert.show();


            }
        });
        //////////
        imageViewUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               idtrans= data.get(position).getId();
                Log.i("(idtrans)update :))))", String.valueOf(idtrans));
                data.get(position).getFinacialAccountFk();
                data.get(position).getBankAccountFk();
                strdate = data.get(position).getDate();
                strtime = data.get(position).getTime();
                strDetail = data.get(position).getDetails();
                strmoney = data.get(position).getMoney();
                strPhone = String.valueOf(data.get(position).getPhoneNumber());
                Log.i("( PHOOOOOOOOOONE :))))", String.valueOf(data.get(position).getPhoneNumber()));

                strRefer = String.valueOf(data.get(position).getReference());
                strtransNumber = data.get(position).getTransNumber();
                strType = data.get(position).getTransactionType();
                Log.i("getTransactionType////",data.get(position).getTransactionType());

                if(gozaresh.flagClickButton==true){
                    tabs.flagTab=false;
                    daramad.flagEdtDaramad=true;
                    getContext().startActivity(new Intent(getContext(), tabs.class));
                }
                else if(gozaresh.flagClickButton==false){
                    tabs.flagTab=true;
                    hazine.flagEdtHazineh=true;
                    getContext().startActivity(new Intent(getContext(), tabs.class));
                }
            }
        });
        return view;
    }
}
