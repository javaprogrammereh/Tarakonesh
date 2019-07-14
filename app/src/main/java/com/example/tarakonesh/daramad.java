package com.example.tarakonesh;

/*support telgram id =@javaprogrammer_eh
 * 24/03/1398
 * creted by elmira hossein zadeh*/

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import ir.hamsaa.persiandatepicker.Listener;
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;

public class daramad extends Fragment {
    public static EditText edtdate, edtphone_number, edtmoney, edttrans_number, edtreference, edtdetails, edtTime;
    Button btnSaveDaramad;
    Spinner spin_finacial_account, spin_bank_accounts, spin_trans_result;
    ArrayList<ListStore> arraySpin_trans_result;
    public static String spinList1, spinList2, spinlist3;
    private PersianDatePickerDialog picker;
    public static String time, date, firstDate, secondDate, timeStr1, timeStr2, firstTime, clearTime, firstTimeStr1, secondTimeStr2;
    public static boolean flagEdtDaramad,flagListDaramad;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_daramad, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ///set id
        btnSaveDaramad = view.findViewById(R.id.btn_save_daramad);
        spin_finacial_account = view.findViewById(R.id.spin_finacial_account);
        spin_bank_accounts = view.findViewById(R.id.spin_bank_account);
        spin_trans_result = view.findViewById(R.id.spin_trans_result);
        edtdate = view.findViewById(R.id.edt_date_daramad);
        edtTime = view.findViewById(R.id.edt_time_daramad);
        edtphone_number = view.findViewById(R.id.edt_phoneNumber_daramad);
        edtmoney = view.findViewById(R.id.edt_money_daramad);
        edttrans_number = view.findViewById(R.id.edt_trans_number_daramad);
        edtreference = view.findViewById(R.id.edt_reference_daramad);
        edtdetails = view.findViewById(R.id.edt_detail_daramad);

        ///////////DaramadShow
        if (flagEdtDaramad == true) {
            edtTime.setText(TransactionAdapter.strtime);
            edtdate.setText(TransactionAdapter.strdate);
            edtphone_number.setText(TransactionAdapter.strPhone);
            Log.i("DARAMAD _strPhone:????",TransactionAdapter.strPhone);
            edtmoney.setText(TransactionAdapter.strmoney);
            edtreference.setText(TransactionAdapter.strRefer);
            edttrans_number.setText(TransactionAdapter.strtransNumber);
            edtdetails.setText(TransactionAdapter.strDetail);
            flagEdtDaramad = false;
        }
        ///////////// set arrayspin_finacial_account

        String[] arraySpin_finacial_account = Database.getDataFinacialAccountDaramad(getContext());
        ArrayAdapter<String> arrayAdapterSpin_finacial_account = new ArrayAdapter<String>(getContext(),
                R.layout.sppiner, arraySpin_finacial_account);
        spin_finacial_account.setAdapter(arrayAdapterSpin_finacial_account);

        /////////////////////////////////////set spin_bank_accounts

        String[] arraySpin_bank_accounts = Database.getDataBankAccounts(getContext());
        ArrayAdapter<String> arrayAdapterSpin_bank_accounts = new ArrayAdapter<String>(getContext(),
                R.layout.sppiner, arraySpin_bank_accounts);
        spin_bank_accounts.setAdapter(arrayAdapterSpin_bank_accounts);

        /////////////////////////set arraySpin_trans_result
        arraySpin_trans_result = new ArrayList<>();
        arraySpin_trans_result.add(new ListStore("0", "تراکنش موفق"));
        arraySpin_trans_result.add(new ListStore("1", "تراکنش ناموفق"));
        arraySpin_trans_result.add(new ListStore("2", "تراکنش معلق"));
        ArrayAdapter<ListStore> arrayAdapterSpin_trans_result = new ArrayAdapter<ListStore>(getContext(),
                R.layout.sppiner, arraySpin_trans_result);
        spin_trans_result.setAdapter(arrayAdapterSpin_trans_result);

        /////////////////////////// spin_finacial_account setOnItemSelectedListener

        spin_finacial_account.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView1, View selectedItemView1, int position1, long id1) {
                String list1 = (String) parentView1.getSelectedItem();
                // Log.i("namespinFinacialAccount",list1);
                spinList1 = list1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
        /////////////////////   arraySpin_bank_accounts   setOnItemSelectedListener
        spin_bank_accounts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView1, View selectedItemView1, int position1, long id1) {
                String list2 = (String) parentView1.getSelectedItem();
                //  Log.i("nameSpin_bank_accounts ",list2);
                spinList2 = list2;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
        ///////////////////// setOnItemSelectedListener  setOnItemSelectedListener
        spin_trans_result.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView1, View selectedItemView1, int position1, long id1) {
                ListStore list1 = (ListStore) parentView1.getSelectedItem();
                int spinner1Id = Integer.parseInt(list1.getId());
                String namespinner3 = list1.getName();
                spinlist3 = namespinner3;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
        /////////////////////
        btnSaveDaramad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(false).setMessage(" آیا از عملیات اطمینان دارید؟؟")
                        .setPositiveButton(
                                "ثبت جدید؟ ", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        String finacialAaccountFk = spinList1;
                                        String bankAccountFk = spinList2;
                                        String transActionType = tabs.Transaction_type;
                                        String date = edtdate.getText().toString();
                                        String time = edtTime.getText().toString();
                                        Long phone_number = Long.parseLong(edtphone_number.getText().toString());
                                        String money = edtmoney.getText().toString();
                                        String trans_number = edttrans_number.getText().toString();
                                        String reference = edtreference.getText().toString();
                                        String trans_result = spinlist3;
                                        String details = edtdetails.getText().toString();

                                        if (!transActionType.equals("") && !date.equals("")
                                                && !time.equals("") && !phone_number.equals("")
                                                && !money.equals("") && !trans_number.equals("")
                                                && !reference.equals("") && !details.equals("")) {
                                            Database.addTransactionData(finacialAaccountFk, bankAccountFk, transActionType, date, time, phone_number, money, trans_number, reference, trans_result, details, getContext());
                                            Toast.makeText(getContext(), "ثبت اطلاعات تراکنش", Toast.LENGTH_SHORT).show();
                                            getActivity().finish();
                                        } else {
                                            Toast.makeText(getContext(), "لطفا اطلاعات را کامل کنید!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                        )
                        .setNegativeButton(" ویرایش اطلاعات ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String finacialAaccountFk = spinList1;
                                String bankAccountFk = spinList2;
                                String transActionType = TransactionAdapter.strType;
                                String date = edtdate.getText().toString();
                                String time = edtTime.getText().toString();
                                Long phone_number = Long.parseLong(edtphone_number.getText().toString());
                                String money = edtmoney.getText().toString();
                                String trans_number = edttrans_number.getText().toString();
                                String reference = edtreference.getText().toString();
                                String trans_result = spinlist3;
                                String details = edtdetails.getText().toString();

                                if (!transActionType.equals("") && !date.equals("")
                                        && !time.equals("") && !phone_number.equals("")
                                        && !money.equals("") && !trans_number.equals("")
                                        && !reference.equals("") && !details.equals("")) {
                                    Database.updateTrans(finacialAaccountFk, bankAccountFk, transActionType, date, time, phone_number, money, trans_number, reference, trans_result, details, getContext());
                                    if (Database.flaTransUpdate == true) {
                                        getActivity().finish();

                                    } else {
                                        Toast.makeText(getContext(), "اطلاعات قبلا ثبت شده!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }).setNeutralButton("خروج", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        getActivity().finish();
                    }
                });
                AlertDialog _alert = builder.create();
                _alert.setTitle(" ");
                _alert.setIcon(R.drawable.ic_done);
                _alert.show();


            }
        });
////////////////////
        edtdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picker = new PersianDatePickerDialog(getContext())
                        .setPositiveButtonString("باشه")
                        .setNegativeButton("بیخیال")
                        .setTodayButton("امروز")
                        .setTodayButtonVisible(true)
                        .setMinYear(1300)
                        .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
//                        .setInitDate(initDate)
                        .setActionTextColor(Color.GRAY)
//                        .setTypeFace(typeface)
                        .setListener(new Listener() {
                            @Override
                            public void onDateSelected(PersianCalendar persianCalendar) {
//                                Toast.makeText(getContext(), persianCalendar.getPersianYear() + "/" + persianCalendar.getPersianMonth() + "/" + persianCalendar.getPersianDay(), Toast.LENGTH_SHORT).show();
                                edtdate.setText(persianCalendar.getPersianYear() + "/" + persianCalendar.getPersianMonth() + "/" + persianCalendar.getPersianDay());
                            }

                            @Override
                            public void onDismissed() {

                            }
                        });
                picker.show();
            }
        });
        edtdate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
//                date = edtdate.getText().toString();
//                Log.i("rrrrrrrrrr", date);
//                if (date.length() == 8) {
//                    String firstNameChars = "";
//                    String secondNameChars = "";
//                    String thirdNameChars = "";
//                    firstNameChars = date.substring(0, 4);
//                    secondNameChars = date.substring(4, 6);
//                    thirdNameChars = date.substring(6, 8);
//                    Log.i("11111111111", firstNameChars);
//                    Log.i("22222222222", secondNameChars);
//                    Log.i("44444444444", thirdNameChars);
//                    String format = "%s/%s/%s";
//                    String timeStr = String.format(format, firstNameChars, secondNameChars, thirdNameChars);
//                    edtdate.setText(timeStr);
//                } else if (date.length() < 8) {
//                    Toast.makeText(getContext(), "تا هشت رقم وارد کنید!", Toast.LENGTH_SHORT).show();
//                }

//                ///////////////test
//                date = edtdate.getText().toString();
//                Log.i("11111111111", date);
//                if (date.length() == 4) {
//                    firstDate = date.substring(0, 4);
//                    Log.i("22222222firstDate", firstDate);
//                    String format = "%s/";
//                    timeStr1 = String.format(format, firstDate);
//                    edtdate.setText(timeStr1);
//                    edtdate.setSelection(edtdate.getText().length());
//                }
//                else if (date.length() == 7) {
//                    secondDate = date.substring(5,7);
//                    Log.i("3333333secondDate", firstDate+secondDate);
//                    String format = "%s/%s/";
//                    timeStr2 = String.format(format,firstDate ,secondDate);
//                    edtdate.setText(timeStr2);
//                    edtdate.setSelection(edtdate.getText().length());
//                }
////                else if (date.length() ==10) {
////                    thirdDate = date.substring(8,10);
//////                    String format = "%s/%s/%s";
////                    Log.i("444444444thirdDate", thirdDate);
////                    timeStr3 = String.format(firstDate ,secondDate,thirdDate);
////                    edtdate.setText(timeStr3);
////                }
//                if (date.length() < 10) {
//                    Toast.makeText(getContext(), "تا هشت رقم وارد کنید!", Toast.LENGTH_SHORT).show();
//                }
            }
        });
        /////////////////
        edtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        edtTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
//                time = edtTime.getText().toString();
//                if (time.length() == 4) {
//                    String firstNameChars = "";
//                    String secoundNameChars = "";
//                    firstNameChars = time.substring(0, 2);
//                    secoundNameChars = time.substring(2, 4);
//                    String format = "%s:%s";
//                    String timeStr = String.format(format, firstNameChars, secoundNameChars);
//                    edtTime.setText(timeStr);
//                } else if (time.length() < 4) {
//                    Toast.makeText(getContext(), "تا چهار رقم وارد کنید!", Toast.LENGTH_SHORT).show();
//                }
                ///////////////////////////////
//                time = edtTime.getText().toString();
//                Log.i("firstTime1111111", time);
//                if (time.length() == 2) {
//                    firstTime = time.substring(0, 2);
//                    Log.i("firstTime2222", firstTime);
//                    String format = "%s:";
//                    firstTimeStr1 = String.format(format, firstTime);
//                    edtTime.setText(firstTimeStr1);
//                    edtTime.setSelection(edtTime.getText().length());
//                }
//                else if(time.length()==4)
//                {
//                    clearTime=time.substring(0,4);
//                    Log.i("clearTime3333333", clearTime);
//                   int b= time.lastIndexOf(":",3);
////                    Log.i("OkkkkkkkkklastIndexOf11", String.valueOf(b));
//                    if(b==2){
//                       String a= clearTime.replace(":","");
//                        Log.i("aaaaaaaaaaa", a);
//                        edtTime.setText(a);
//                        edtTime.setSelection(edtTime.getText().length());
//                    }
//                    else{
//                        Log.i("NOOOOOOOlastIndexOf22", String.valueOf(b));
//                    }
////                }
//                else if ((edtTime.length()) < 4) {
//                    Toast.makeText(getContext(), "تا چهار رقم وارد کنید!", Toast.LENGTH_SHORT).show();
//                }


            }
        });
    }

}
