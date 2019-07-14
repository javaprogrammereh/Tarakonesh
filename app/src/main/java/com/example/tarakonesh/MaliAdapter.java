package com.example.tarakonesh;

import android.app.Activity;
import android.content.Context;
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

public class MaliAdapter extends ArrayAdapter {
    ImageView imageViewDelete, imageViewUpdate;

    public static boolean flagDelAdapter;
    public int resourceId;
    public Activity activity;
    public ArrayList<FinacialAccount> data;
    public static String MaliNameValue,MaliTypeerValue;
    public static int idMali;
    FinacialAccount accounts;
    public MaliAdapter(Activity activity, int resourceId, ArrayList<FinacialAccount> object) {
        super(activity, resourceId, object);
        this.resourceId = resourceId;
        this.activity = activity;
        this.data = object;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        view = this.activity.getLayoutInflater().inflate(this.resourceId, null);
        final TextView MaliName = view.findViewById(R.id.txt_name_mali);
        final TextView MaliNumber = view.findViewById(R.id.txt_type_mali);
        accounts = data.get(position);
//        idMali  = accounts.getId();
        MaliName.setText(accounts.getFinacialAccountName());
        MaliNumber.setText(accounts.getFinacialAccountType());

        ///////////////////////////////////update&deleted
        imageViewDelete = view.findViewById(R.id.delete_mali);
        imageViewUpdate = view.findViewById(R.id.update_mali);
        ///////////////////////
        imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(false).setMessage(" آیا از عملیات اطمینان دارید؟؟")
                        .setPositiveButton(
                                "حذف؟ ", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        MaliNameValue = MaliName.getText().toString();
                                        Database.deleteMali(getContext(), MaliNameValue);
                                        if (Database.flagMaliDel == true) {
                                            Toast.makeText(getContext(), "اطلاعات بدرستی حذف شد!", Toast.LENGTH_SHORT).show();
                                            flagDelAdapter = true;
                                            if (flagDelAdapter == true) {
                                                data.remove(position);
                                                notifyDataSetChanged();
                                            }
                                        } else {
                                            Toast.makeText(getContext(), "عدم موفقیت در عملیات!", Toast.LENGTH_SHORT).show();
                                            flagDelAdapter = false;
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
                idMali=data.get(position).getId();
                MaliNameValue =data.get(position).getFinacialAccountName();
                MaliTypeerValue=data.get(position).getFinacialAccountType();
                Log.i("getId:))))))))))))", String.valueOf(data.get(position).getId()));
//                Log.i("bankNumberValue", MaliTypeerValue);
                hesab_mali.edtHesabMali.setText(MaliNameValue);
            }
        });


        return view;
    }
}
