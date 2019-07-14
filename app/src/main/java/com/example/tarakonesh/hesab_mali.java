package com.example.tarakonesh;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class hesab_mali extends AppCompatActivity {
    private static final int notifyid = 1;
    public static EditText edtHesabMali;
    Button btnSave;
    Spinner spinner;
    public static String spinList;
    ArrayList<ListStore> arraySpin;
    FinacialAccount account = new FinacialAccount();
    ListView listView;
    ArrayList<FinacialAccount> finacialAccounts;
    Toolbar toolbar;
    MaliAdapter maliAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesab_mali);

        spinner = findViewById(R.id.spin_hesab_mali);
        edtHesabMali = findViewById(R.id.edt_hesab_mali);
        btnSave = findViewById(R.id.ok_hesab_mali);
        listView = findViewById(R.id.list_view_mali);
        toolbar = findViewById(R.id.toolbar);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            setSupportActionBar(toolbar);
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.tab3));
        }

        arraySpin = new ArrayList<>();
        arraySpin.add(new ListStore("0", "هزینه"));
        arraySpin.add(new ListStore("1", "درآمد"));
        ArrayAdapter<ListStore> arrayAdapterSpin = new ArrayAdapter<ListStore>(getApplicationContext(),
                R.layout.sppiner, arraySpin);
        spinner.setAdapter(arrayAdapterSpin);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position1, long id) {
                ListStore list = (ListStore) parentView.getSelectedItem();
                int spinnerId = Integer.parseInt(list.getId());
                String namespinner = list.getName();
                spinList = namespinner;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });


        Intent notificationIntent = new Intent(this, hesab_mali.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        String ns = Context.NOTIFICATION_SERVICE;
        final NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
        Notification.Builder builder = new Notification.Builder(hesab_mali.this);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        builder.setSmallIcon(R.drawable.notification_template_icon_bg)
                .setContentTitle(" ثبت تراکنش ")
                .setContentText("عملیات موفقیت آمیز بود")
                .setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        final Notification notification = builder.getNotification();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(hesab_mali.this);
                builder.setCancelable(false).setMessage(" آیا از عملیات اطمینان دارید؟؟")
                        .setPositiveButton(
                                "ثبت جدید؟ ", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        String firstValue = edtHesabMali.getText().toString();
                                        String secoundValue = spinList;
                                        if (!firstValue.equals("") && !secoundValue.equals("")) {
                                            account.setFinacialAccountName(edtHesabMali.getText().toString());
                                            account.setFinacialAccountType(spinList);
                                            Database.addFinacialAccountData(account.getFinacialAccountName(), account.getFinacialAccountType(), getApplicationContext());
                                            if (Database.flagMali == false) {
                                                Toast.makeText(hesab_mali.this, "اطلاعات قبلا ثبت شده!", Toast.LENGTH_SHORT).show();
                                            } else {
                                                mNotificationManager.notify(notifyid, notification);
                                                edtHesabMali.setText("");
                                                setItemListMali();
                                            }
                                        } else {
                                            Toast.makeText(hesab_mali.this, "اطلاعات کاربری خود را وارد کنید", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                        )
                        .setNegativeButton(" ویرایش اطلاعات؟ ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String firstValue = edtHesabMali.getText().toString();
                                String secoundValue = spinList;
//                                Log.i("secoundValue000000000",secoundValue);
                                if (!firstValue.equals("") && !secoundValue.equals("")) {
                                    Database.updateMali(firstValue, secoundValue, getApplicationContext());
                                    if(Database.flagMaliUpdate==true){
                                        edtHesabMali.setText("");
                                        setItemListMali();
                                    }
                                }
                                else {
                                    Toast.makeText(hesab_mali.this, "اطلاعات قبلا ثبت شده!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).setNeutralButton("خروج", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog _alert = builder.create();
                _alert.setTitle(" ");
                _alert.setIcon(R.drawable.ic_done);
                _alert.show();

            }
        });

        setItemListMali();
    }

    public void setItemListMali() {
        finacialAccounts = new ArrayList<>();
        finacialAccounts = Database.getMaliData(getApplicationContext());
        maliAdapter = new MaliAdapter(hesab_mali.this, R.layout.list_item_hesab_mali, finacialAccounts);
        listView.setAdapter(maliAdapter);
    }
}
