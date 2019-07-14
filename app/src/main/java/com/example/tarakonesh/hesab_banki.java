package com.example.tarakonesh;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class hesab_banki extends AppCompatActivity {

    private static final int notifyid = 1;
    public static EditText edttypeHesabBanki, edtnumberHesabBanki;
    Button btnSave;
    BankAccounts accounts = new BankAccounts();
    Toolbar toolbar;
    ListView listViewShow;
    ArrayList<BankAccounts> bankAccounts;
    BankAdaptor bankAdaptor;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesab_banki);
        toolbar = findViewById(R.id.toolbar);


        /////////////////////////////statusebar
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            setSupportActionBar(toolbar);
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.tab2));
        }
/////////////////////////////////////////////
        listViewShow = findViewById(R.id.list_view_banki);
        edttypeHesabBanki = findViewById(R.id.account_name);
        edtnumberHesabBanki = findViewById(R.id.account_number);
        btnSave = findViewById(R.id.ok_bankAccount);

        Intent notificationIntent = new Intent(this, hesab_banki.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        String ns = Context.NOTIFICATION_SERVICE;
        final NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
        Notification.Builder builder = new Notification.Builder(hesab_banki.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(hesab_banki.this);
                builder.setCancelable(false).setMessage(" آیا از عملیات اطمینان دارید؟؟")
                        .setPositiveButton(
                                "ثبت جدید؟ ", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        String firstValue = edttypeHesabBanki.getText().toString();
                                        String secoundValue = edtnumberHesabBanki.getText().toString();
                                        if (!firstValue.equals("") && !secoundValue.equals("")) {
                                            accounts.setAccountName(edttypeHesabBanki.getText().toString());
                                            accounts.setAccountNumber(Long.parseLong(edtnumberHesabBanki.getText().toString()));
                                            Database.addBankAccountsData(accounts.getAccountName(), accounts.getAccountNumber(), getApplicationContext());
                                            if (Database.flagBank == false) {
                                                Toast.makeText(hesab_banki.this, "اطلاعات قبلا ثبت شده!", Toast.LENGTH_SHORT).show();
                                            } else {
                                                mNotificationManager.notify(notifyid, notification);
                                                edttypeHesabBanki.setText("");
                                                edtnumberHesabBanki.setText("");
                                                setItemList();
                                            }

                                        } else {
                                            Toast.makeText(hesab_banki.this, "اطلاعات کاربری خود را وارد کنید", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                        )
                        .setNegativeButton(" ویرایش اطلاعات؟ ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String firstValue = edttypeHesabBanki.getText().toString();
                                Long secoundValue = Long.parseLong(edtnumberHesabBanki.getText().toString());
                                if (!firstValue.equals("")&& !secoundValue.equals("")) {
                                    Database.updateBanki(firstValue,secoundValue, getApplicationContext());
                                    if(Database.flagBankUpdate==true){
                                        edttypeHesabBanki.setText("");
                                        edtnumberHesabBanki.setText("");
                                        setItemList();
                                    }
                                    else {
                                        Toast.makeText(hesab_banki.this, "اطلاعات قبلا ثبت شده!", Toast.LENGTH_SHORT).show();
                                    }
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

        setItemList();
    }

    public void setItemList() {
        bankAccounts = new ArrayList<>();
        bankAccounts = Database.getBankData(getApplicationContext());
        bankAdaptor = new BankAdaptor(hesab_banki.this, R.layout.list_item_hesab_banki, bankAccounts);
        listViewShow.setAdapter(bankAdaptor);
    }
}
