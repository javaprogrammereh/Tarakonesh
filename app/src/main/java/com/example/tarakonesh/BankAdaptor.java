package com.example.tarakonesh;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class BankAdaptor extends ArrayAdapter {

    ImageView imageViewDelete, imageViewUpdate;
    public int resourceId;
    public Activity activity;
    public ArrayList<BankAccounts> data;
    public static String bankNameValue,bankNumberValue;
    public static boolean flagDelAdapter;
    public static int idaccount;
    public BankAdaptor(Activity activity, int resourceId, ArrayList<BankAccounts> object) {
        super(activity, resourceId, object);
        this.resourceId = resourceId;
        this.activity = activity;
        this.data = object;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        view = this.activity.getLayoutInflater().inflate(this.resourceId, null);
///////////////////////////////////update&deleted
        imageViewDelete = view.findViewById(R.id.imageView_delete);
        imageViewUpdate = view.findViewById(R.id.imageView_update);
        ///////////////////////
        final TextView bankName = view.findViewById(R.id.txt_bank);
        final TextView bankNumber = view.findViewById(R.id.txt_hesab);
        BankAccounts accounts = data.get(position);
//        idaccount  = accounts.getId();
        bankName.setText(accounts.getAccountName());
        bankNumber.setText(String.valueOf(accounts.getAccountNumber()));
        ImageView imageView = view.findViewById(R.id.img_bank);
        ///////////
        imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(false).setMessage(" آیا از عملیات اطمینان دارید؟؟")
                        .setPositiveButton(
                        "حذف؟ ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                bankNameValue = bankName.getText().toString();
                Database.deleteBank(getContext(), bankNameValue);
                if(Database.flagBankDel==true){
                    Toast.makeText(getContext(), "اطلاعات بدرستی حذف شد!", Toast.LENGTH_SHORT).show();
                    flagDelAdapter=true;
                    if(flagDelAdapter == true){
                      data.remove(position);
                      notifyDataSetChanged();
                    }
                }
                else {
                    Toast.makeText(getContext(), "عدم موفقیت در عملیات!", Toast.LENGTH_SHORT).show();
                    flagDelAdapter=false;
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
//
            }
        });
        imageViewUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idaccount=data.get(position).getId();
                bankNameValue = data.get(position).getAccountName();
                bankNumberValue=String.valueOf(data.get(position).getAccountNumber());
//                Log.i("bankNameValue", bankNameValue);
//                Log.i("bankNumberValue", bankNumberValue);
                hesab_banki.edttypeHesabBanki.setText(bankNameValue);
                hesab_banki.edtnumberHesabBanki.setText(bankNumberValue);
            }
        });
        ////////////////////////////////////setImageBank
        String txtBank = bankNumber.getText().toString();
        int meli = txtBank.lastIndexOf("603799", 7);
        int melat = txtBank.lastIndexOf("610433", 7);
        int tejarat = txtBank.lastIndexOf("627353", 7);
        int sepah = txtBank.lastIndexOf("589210", 7);
        int keshavarzi = txtBank.lastIndexOf("603770", 7);
        int maskan = txtBank.lastIndexOf("628023", 7);
        int saderat = txtBank.lastIndexOf("603769", 7);
        if (meli == 0) {
            imageView.setImageResource(R.drawable.melli);
        } else if (melat == 0) {
            imageView.setImageResource(R.drawable.mellat);
        } else if (tejarat == 0) {
            imageView.setImageResource(R.drawable.tejarat);
        } else if (sepah == 0) {
            imageView.setImageResource(R.drawable.sepah);
        } else if (keshavarzi == 0) {
            imageView.setImageResource(R.drawable.keshavarzi);
        } else if (maskan == 0) {
            imageView.setImageResource(R.drawable.maskan);
        } else if (saderat == 0) {
            imageView.setImageResource(R.drawable.saderat);
        } else {
            imageView.setImageResource(R.drawable.mellat);
        }
        return view;

    }

}
