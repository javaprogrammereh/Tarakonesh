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

public class hazine extends Fragment {
    EditText edtdate,edttime, edtphone_number, edtmoney, edttrans_number, edtreference, edtdetails;
    Button btnSaveHazineh;
    Spinner spin_finacial_account, spin_bank_accounts, spin_trans_result;
    ArrayList<ListStore> arraySpin_trans_result;
    public static String spinList1, spinList2, spinlist3;
    private PersianDatePickerDialog picker;
    public static String time,firstTime,firstTimeStr1;
    public static boolean flagEdtHazineh,flagListHazineh;
    gozaresh gozaresh = new gozaresh();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hazine, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ///set id
        btnSaveHazineh = view.findViewById(R.id.btn_save_hazineh);
        spin_finacial_account = view.findViewById(R.id.spin_finacial_accounts);
        spin_bank_accounts = view.findViewById(R.id.spin_bank_accounts);
        spin_trans_result = view.findViewById(R.id.spin_trans_results);
        edtdate = view.findViewById(R.id.edt_date_hazineh);
        edttime = view.findViewById(R.id.edt_times_hazineh);
        edtphone_number = view.findViewById(R.id.edt_phoneNumbers_hazineh);
        edtmoney = view.findViewById(R.id.edt_money_hazineh);
        edttrans_number = view.findViewById(R.id.edt_trans_number__hazineh);
        edtreference = view.findViewById(R.id.edt_reference_hazineh);
        edtdetails = view.findViewById(R.id.edt_detail_hazineh);
////////////////hazinehShow
        if(flagEdtHazineh==true){
            edttime.setText(String.valueOf(TransactionAdapter.strtime));
            edtdate.setText(String.valueOf(TransactionAdapter.strdate));
            edtphone_number.setText(String.valueOf(TransactionAdapter.strPhone));
            edtmoney.setText(String.valueOf(TransactionAdapter.strmoney));
            edtreference.setText(String.valueOf(TransactionAdapter.strRefer));
            edttrans_number.setText(String.valueOf(TransactionAdapter.strtransNumber));
            edtdetails.setText(String.valueOf(TransactionAdapter.strDetail));
            flagEdtHazineh=false;
        }
        ///////////// set arrayspin_finacial_account

        String[] arraySpin_finacial_account = Database.getDataFinacialAccountHazineh(getContext());
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
        btnSaveHazineh.setOnClickListener(new View.OnClickListener() {
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
                                        String transActionType =  tabs.Transaction_type;
                                        String date = edtdate.getText().toString();
                                        String time = edttime.getText().toString();
                                        Long phone_number = Long.parseLong(edtphone_number.getText().toString());
                                        String money = edtmoney.getText().toString();
                                        String trans_number = edttrans_number.getText().toString();
                                        String reference = edtreference.getText().toString();
                                        String trans_result = spinlist3;
                                        String details = edtdetails.getText().toString();

                                        if (!transActionType.equals("")&& !date.equals("")
                                                && !time.equals("")&& !phone_number.equals("")
                                                && !money.equals("")&& !trans_number.equals("")
                                                && !reference.equals("")&& !details.equals("")){
                                            Database.addTransactionData(finacialAaccountFk, bankAccountFk, transActionType, date, time, phone_number, money, trans_number, reference, trans_result, details, getContext());
                                            Toast.makeText(getContext(), "ثبت اطلاعات تراکنش", Toast.LENGTH_SHORT).show();
                                            getActivity().finish();
                                        } else {
                                            Toast.makeText(getContext(), "لطفا اطلاعات را کامل کنید!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                        )
                        .setNegativeButton(" ویرایش اطلاعات؟ ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String finacialAaccountFk = spinList1;
                                String bankAccountFk = spinList2;
                                String transActionType =  tabs.Transaction_type;
                                String date = edtdate.getText().toString();
                                String time = edttime.getText().toString();
                                Long phone_number = Long.parseLong(edtphone_number.getText().toString());
                                String money = edtmoney.getText().toString();
                                String trans_number = edttrans_number.getText().toString();
                                String reference = edtreference.getText().toString();
                                String trans_result = spinlist3;
                                String details = edtdetails.getText().toString();

                                if (!transActionType.equals("")&& !date.equals("")
                                        && !time.equals("")&& !phone_number.equals("")
                                        && !money.equals("")&& !trans_number.equals("")
                                        && !reference.equals("")&& !details.equals("")){
                                    Database.updateTrans(finacialAaccountFk, bankAccountFk, transActionType, date, time, phone_number, money, trans_number, reference, trans_result, details, getContext());
                                    if(Database.flaTransUpdate==true){
                                        getActivity().finish();
                                    }
                                    else {
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
        /////////////
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
        edttime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
//                time = edttime.getText().toString();
//                Log.i("11111111111", time);
//                if (time.length() == 2) {
//                    firstTime = time.substring(0, 2);
//                    Log.i("22222222firstTime", firstTime);
//                    String format = "%s:";
//                    firstTimeStr1 = String.format(format, firstTime);
//                    edttime.setText(firstTimeStr1);
//                    edttime.setSelection(edttime.getText().length());
//                }
//                else if ((edttime.length()) < 4) {
//                    Toast.makeText(getContext(), "تا چهار رقم وارد کنید!", Toast.LENGTH_SHORT).show();
//                }

            }
        });
    }

}
