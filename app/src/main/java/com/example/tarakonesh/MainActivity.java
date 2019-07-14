package com.example.tarakonesh;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout lnr_expense, lnr_prelude, lnr_bank_Account, lnr_financial_account;
    ImageView up_daramadi, up_expense, up_bank_Account, up_financial_account, add_prelude, add_expense, add_bank_Account, add_financial_account;
    Boolean flag_dropDpwn = false;
    userApp user = new userApp();
    TextView alldaramad, allHazineh, alladd, daramadPrice1, daramadPrice2, daramadPrice3, daramadDate1, daramadDate2, daramadDate3,
            hazinehPrice1, hazinehPrice2, hazinehPrice3, hazinehDate1, hazinehDate2, hazinehDate3,
            bankName1, bankName2, bankName3,bankNumber1,bankNumber2,bankNumber3,
            finacialName1, finacialName2, finacialName3, finacialType1, finacialType2, finacialType3,txtGozareshClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtGozareshClick=findViewById(R.id.txt_gozaresh_click);
        alldaramad = findViewById(R.id.price_daramad_main);
        allHazineh = findViewById(R.id.price_hazineh_main);
        alladd = findViewById(R.id.price_all_main);
        daramadPrice1 = findViewById(R.id.item1_price_daramad);
        daramadPrice2 = findViewById(R.id.item2_price_daramad);
        daramadPrice3 = findViewById(R.id.item3_price_daramad);
        daramadDate1 = findViewById(R.id.item1_date_daramad);
        daramadDate2 = findViewById(R.id.item2_date_daramad);
        daramadDate3 = findViewById(R.id.item3_date_daramad);
        hazinehPrice1 = findViewById(R.id.item1_price_hazineh);
        hazinehPrice2 = findViewById(R.id.item2_price_hazineh);
        hazinehPrice3 = findViewById(R.id.item3_price_hazineh);
        hazinehDate1 = findViewById(R.id.item1_date_hazineh);
        hazinehDate2 = findViewById(R.id.item2_date_hazineh);
        hazinehDate3 = findViewById(R.id.item3_date_hazineh);
        bankName1 = findViewById(R.id.item1_price_bank_Account);
        bankName2 = findViewById(R.id.item2_price_bank_Account);
        bankName3 = findViewById(R.id.item3_price_bank_Account);
        bankNumber1=findViewById(R.id.item1_shomare_hesab);
        bankNumber2=findViewById(R.id.item2_shomare_hesab);
        bankNumber3=findViewById(R.id.item3_shomare_hesab);
        finacialName1 = findViewById(R.id.item1_price_financial_account);
        finacialName2 = findViewById(R.id.item2_price_financial_account);
        finacialName3 = findViewById(R.id.item3_price_financial_account);
        finacialType1 = findViewById(R.id.item1_date_financial_account);
        finacialType2 = findViewById(R.id.item2_date_financial_account);
        finacialType3 = findViewById(R.id.item3_date_financial_account);

        lnr_expense = findViewById(R.id.lnr_expense);
        lnr_bank_Account = findViewById(R.id.lnr_bank_Account);
        lnr_prelude = findViewById(R.id.lnr_prelude);
        lnr_financial_account = findViewById(R.id.lnr_financial_account);

        up_daramadi = findViewById(R.id.up_prelude);
        up_expense = findViewById(R.id.up_expense);
        up_bank_Account = findViewById(R.id.up_bank_Account);
        up_financial_account = findViewById(R.id.up_financial_account);

        add_prelude = findViewById(R.id.add_prelude);
        add_expense = findViewById(R.id.add_expense);
        add_bank_Account = findViewById(R.id.add_bank_Account);
        add_financial_account = findViewById(R.id.add_financial_account);

        add_prelude.setImageResource(R.drawable.ic_add);
        add_expense.setImageResource(R.drawable.ic_add);
        add_bank_Account.setImageResource(R.drawable.ic_add);
        add_financial_account.setImageResource(R.drawable.ic_add);

        up_daramadi.setImageResource(R.drawable.ic_up);
        up_expense.setImageResource(R.drawable.ic_up);
        up_bank_Account.setImageResource(R.drawable.ic_up);
        up_financial_account.setImageResource(R.drawable.ic_up);

        ///////////////////
        txtGozareshClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabs.flagtabGzaresh=true;
                tabs.flagTab=false;
                startActivity(new Intent(MainActivity.this, tabs.class));
            }
        });
        //////////////////
        up_daramadi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lnr_prelude.getVisibility() == View.GONE) {
                    lnr_prelude.setVisibility(View.VISIBLE);
                } else {
                    lnr_prelude.setVisibility(View.GONE);
                }


                if (!flag_dropDpwn) {
                    up_daramadi.setImageResource(R.drawable.ic_down);
                    flag_dropDpwn = true;
                } else {
                    up_daramadi.setImageResource(R.drawable.ic_up);
                    flag_dropDpwn = false;
                }
            }
        });
        up_expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lnr_expense.getVisibility() == View.GONE) {
                    lnr_expense.setVisibility(View.VISIBLE);
                } else {
                    lnr_expense.setVisibility(View.GONE);
                }
                if (!flag_dropDpwn) {
                    up_expense.setImageResource(R.drawable.ic_down);
                    flag_dropDpwn = true;
                } else {
                    up_expense.setImageResource(R.drawable.ic_up);
                    flag_dropDpwn = false;

                }
            }
        });
        up_bank_Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lnr_bank_Account.getVisibility() == View.GONE) {
                    lnr_bank_Account.setVisibility(View.VISIBLE);
                } else {
                    lnr_bank_Account.setVisibility(View.GONE);
                }


                if (!flag_dropDpwn) {
                    up_bank_Account.setImageResource(R.drawable.ic_down);
                    flag_dropDpwn = true;
                } else {
                    up_bank_Account.setImageResource(R.drawable.ic_up);
                    flag_dropDpwn = false;

                }
            }
        });
        up_financial_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lnr_financial_account.getVisibility() == View.GONE) {
                    lnr_financial_account.setVisibility(View.VISIBLE);
                } else {
                    lnr_financial_account.setVisibility(View.GONE);
                }


                if (!flag_dropDpwn) {
                    up_financial_account.setImageResource(R.drawable.ic_down);
                    flag_dropDpwn = true;
                } else {
                    up_financial_account.setImageResource(R.drawable.ic_up);
                    flag_dropDpwn = false;

                }

            }
        });
        add_prelude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabs.flagTab=false;
                tabs.flagtabGzaresh=false;
                startActivity(new Intent(MainActivity.this, tabs.class));
            }
        });


        add_expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabs.flagTab=true;
                tabs.flagtabGzaresh=false;
                startActivity(new Intent(MainActivity.this, tabs.class));
            }
        });
        add_financial_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, hesab_mali.class));
            }
        });
        add_bank_Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, hesab_banki.class));
            }
        });

////////////////////////// SharedPreference
        final SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(this);
        user = sharedPreferencesManager.get_shared_preferences();
        if (user.getFirst_time_run() == true) {
            Toast.makeText(this, "اطلاعات کاربری خود را وارد کنید", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, login.class));
            MainActivity.this.finish();
            user.setFirst_time_run(true);
            sharedPreferencesManager.set_false_first_time(user);
        } else {
            Toast.makeText(this, "کاربر سیستم خوش آمدید", Toast.LENGTH_SHORT).show();
        }
/////////////////////////////////////get data for list text view
        showListsData();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showListsData();
    }

    public void showListsData() {

        ////////////////////show Top
        String[] arrayListShowAllDramad = Database.getDatatransactionDaramad(getApplicationContext());
        String valueDaramad = String.valueOf(ConvertingArray.showAllDaramad(arrayListShowAllDramad));
        alldaramad.setText(valueDaramad);

        String[] arrayListShowHazineh = Database.getDatatransactionHazineh(getApplicationContext());
        String valueHazineh = String.valueOf(ConvertingArray.showAllHazineh(arrayListShowHazineh));
        allHazineh.setText(valueHazineh);

        Long subtractionMoney = ConvertingArray.subtractionValue(Long.parseLong(valueDaramad), Long.parseLong(valueHazineh));
        alladd.setText(String.valueOf(subtractionMoney));
////////////////////////// llistData

        String[] val1 = Database.getDataFinallyDaramadMoney(getApplicationContext());
        String[] val2 = Database.getDataFinallyDaramadDate(getApplicationContext());
        if (val1.length >= 0 && val2.length >= 0) {
            ConvertingArray.ArrayToStringDaramad(val1, val2);
            daramadPrice1.setText(ConvertingArray.Money1);
            daramadPrice2.setText(ConvertingArray.Money2);
            daramadPrice3.setText(ConvertingArray.Money3);
            daramadDate1.setText(ConvertingArray.date1);
            daramadDate2.setText(ConvertingArray.date2);
            daramadDate3.setText(ConvertingArray.date3);
            // Toast.makeText(getApplicationContext(), "OK data Daramad!", Toast.LENGTH_SHORT).show();

        } else {
            // Toast.makeText(getApplicationContext(), "error data Daramad!", Toast.LENGTH_SHORT).show();
        }
        String[] val3 = Database.getDataMoneyHazineh(getApplicationContext());
        String[] val4 = Database.getDataDateHazineh(getApplicationContext());
        if (val3.length >= 0 && val4.length >= 0) {
            ConvertingArray.ArrayToStringHazineh(val3, val4);
            hazinehPrice1.setText(ConvertingArray.Money4);
            hazinehPrice2.setText(ConvertingArray.Money5);
            hazinehPrice3.setText(ConvertingArray.Money6);
            hazinehDate1.setText(ConvertingArray.date4);
            hazinehDate2.setText(ConvertingArray.date5);
            hazinehDate3.setText(ConvertingArray.date6);
            //Toast.makeText(getApplicationContext(), "OK data Hazineh!", Toast.LENGTH_SHORT).show();
        } else {
            // Toast.makeText(getApplicationContext(), "error data Hazineh!", Toast.LENGTH_SHORT).show();
        }

        String[] val5 = Database.getNameBankAccount(getApplicationContext());
        String[] val8 = Database.getNumberBankAccount(getApplicationContext());
        if (val5.length >= 3 && val8.length >= 3) {
            ConvertingArray.ArrayToStringBank(val5,val8);
            bankName1.setText(ConvertingArray.bankName1);
            bankName2.setText(ConvertingArray.bankName2);
            bankName3.setText(ConvertingArray.bankName3);
            bankNumber1.setText(ConvertingArray.bankNumber1);
            bankNumber2.setText(ConvertingArray.bankNumber2);
            bankNumber3.setText(ConvertingArray.bankNumber3);

//            Toast.makeText(getApplicationContext(), "OK data Bank!", Toast.LENGTH_SHORT).show();
        } else {
//             Toast.makeText(getApplicationContext(), "error data Bank!", Toast.LENGTH_SHORT).show();
        }

        String[] val6 = Database.getDataDateFinacialName(getApplicationContext());
        String[] val7 = Database.getDataDateFinacialType(getApplicationContext());
        if (val6.length >= 3 && val7.length >= 3) {
            ConvertingArray.ArrayToStringFinacial(val6, val7);
            finacialName1.setText(ConvertingArray.finName1);
            finacialName2.setText(ConvertingArray.finName2);
            finacialName3.setText(ConvertingArray.finName3);
            finacialType1.setText(ConvertingArray.finType1);
            finacialType2.setText(ConvertingArray.finType2);
            finacialType3.setText(ConvertingArray.finType3);
//            Toast.makeText(getApplicationContext(), "OK data Finacial!", Toast.LENGTH_SHORT).show();
        } else {
//             Toast.makeText(getApplicationContext(), "error data Finacial!", Toast.LENGTH_SHORT).show();
        }
    }
}
