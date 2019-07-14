package com.example.tarakonesh;

/*support telgram id =@javaprogrammer_eh
 * 24/03/1398
 * creted by elmira hossein zadeh*/

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;


public class Database {

    private static DatabaseHelper databaseHelper;

    private static final String user_app_table = "user_app";
    private static final String transaction_table = "`transaction`";
    private static final String finacial_account_table = "finacial_account";
    private static final String bank_accounts_table = "bank_accounts";

    private static final String _ID = "id";
    private static final String _Name = "account_name";
    private static final String _NameMali = "finacial_account_name";
    public static boolean flagBank, flagMali, flagBankDel, flagMaliDel, flagBankUpdate, flagMaliUpdate, flagTransDel,flaTransUpdate;

    public Database() {
    }

    public static SQLiteDatabase getInstance(Context context) {
        if (databaseHelper == null) {
            try {
                databaseHelper = new DatabaseHelper(context);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return databaseHelper.getWritableDatabase();
    }

    public static SQLiteDatabase getInstance2(Context context) {
        if (databaseHelper == null) {
            try {
                databaseHelper = new DatabaseHelper(context);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return databaseHelper.getReadableDatabase();
    }

    ///////////////////getdata trans
    public static ArrayList getTrans(Context context) {
        String selectQuery = "SELECT  * FROM " + transaction_table + " WHERE " + _ID + "=" + TransactionAdapter.idtrans;
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        while (cursor.moveToNext()) {
            list.add(new Transaction(cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("finacial_account_fk")),
                    cursor.getString(cursor.getColumnIndex("bank_account_fk")),
                    cursor.getString(cursor.getColumnIndex("transaction_type")),
                    cursor.getString(cursor.getColumnIndex("date")),
                    cursor.getString(cursor.getColumnIndex("time")),
                    cursor.getLong(cursor.getColumnIndex("phone_number")),
                    cursor.getString(cursor.getColumnIndex("money")),
                    cursor.getString(cursor.getColumnIndex("trans_number")),
                    cursor.getInt(cursor.getColumnIndex("reference")),
                    cursor.getString(cursor.getColumnIndex("trans_result")),
                    cursor.getString(cursor.getColumnIndex("details"))
            ));

            Log.i("", String.valueOf(cursor.getInt(cursor.getColumnIndex("id"))));
            Log.i("", cursor.getString(cursor.getColumnIndex("finacial_account_fk")) );
            Log.i("",  cursor.getString(cursor.getColumnIndex("bank_account_fk")));
            Log.i("", cursor.getString(cursor.getColumnIndex("transaction_type")));
            Log.i("",cursor.getString(cursor.getColumnIndex("date")));
            Log.i("",cursor.getString(cursor.getColumnIndex("time")));
            Log.i("", String.valueOf(cursor.getLong(cursor.getColumnIndex("phone_number"))));
            Log.i("",cursor.getString(cursor.getColumnIndex("money")));
            Log.i("",cursor.getString(cursor.getColumnIndex("trans_number")));
            Log.i("", String.valueOf(cursor.getInt(cursor.getColumnIndex("reference"))));
            Log.i("",cursor.getString(cursor.getColumnIndex("trans_result")));
            Log.i("",cursor.getString(cursor.getColumnIndex("details")));
        }
        cursor.close();
        getInstance2(context).close();
        return list;
    }

    //////////////////////
    public static ArrayList gettransactionDaramad(Context context) {
        String selectQuery = "SELECT  * FROM " + transaction_table + " WHERE transaction_type ='درآمد'";
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        while (cursor.moveToNext()) {
            list.add(new Transaction(cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("finacial_account_fk")),
                    cursor.getString(cursor.getColumnIndex("bank_account_fk")),
                    cursor.getString(cursor.getColumnIndex("transaction_type")),
                    cursor.getString(cursor.getColumnIndex("date")),
                    cursor.getString(cursor.getColumnIndex("time")),
                    cursor.getLong(cursor.getColumnIndex("phone_number")),
                    cursor.getString(cursor.getColumnIndex("money")),
                    cursor.getString(cursor.getColumnIndex("trans_number")),
                    cursor.getInt(cursor.getColumnIndex("reference")),
                    cursor.getString(cursor.getColumnIndex("trans_result")),
                    cursor.getString(cursor.getColumnIndex("details"))
            ));
            Log.i("", String.valueOf(cursor.getInt(cursor.getColumnIndex("id"))));
            Log.i("", cursor.getString(cursor.getColumnIndex("finacial_account_fk")) );
            Log.i("",  cursor.getString(cursor.getColumnIndex("bank_account_fk")));
            Log.i("", cursor.getString(cursor.getColumnIndex("transaction_type")));
            Log.i("",cursor.getString(cursor.getColumnIndex("date")));
            Log.i("",cursor.getString(cursor.getColumnIndex("time")));
            Log.i("", String.valueOf(cursor.getLong(cursor.getColumnIndex("phone_number"))));
            Log.i("",cursor.getString(cursor.getColumnIndex("money")));
            Log.i("",cursor.getString(cursor.getColumnIndex("trans_number")));
            Log.i("", String.valueOf(cursor.getInt(cursor.getColumnIndex("reference"))));
            Log.i("",cursor.getString(cursor.getColumnIndex("trans_result")));
            Log.i("",cursor.getString(cursor.getColumnIndex("details")));
        }
        cursor.close();
        getInstance2(context).close();
        return list;
    }

    public static ArrayList getTransactionHazineh(Context context) {
        String selectQuery = "SELECT  * FROM " + transaction_table + " WHERE transaction_type='هزینه'";
        ArrayList<Transaction> list = new ArrayList<Transaction>();
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        while (cursor.moveToNext()) {
            list.add(new Transaction(cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("finacial_account_fk")),
                    cursor.getString(cursor.getColumnIndex("bank_account_fk")),
                    cursor.getString(cursor.getColumnIndex("transaction_type")),
                    cursor.getString(cursor.getColumnIndex("date")),
                    cursor.getString(cursor.getColumnIndex("time")),
                    cursor.getLong(cursor.getColumnIndex("phone_number")),
                    cursor.getString(cursor.getColumnIndex("money")),
                    cursor.getString(cursor.getColumnIndex("trans_number")),
                    cursor.getInt(cursor.getColumnIndex("reference")),
                    cursor.getString(cursor.getColumnIndex("trans_result")),
                    cursor.getString(cursor.getColumnIndex("details"))
            ));
            Log.i("", String.valueOf(cursor.getInt(cursor.getColumnIndex("id"))));
            Log.i("", cursor.getString(cursor.getColumnIndex("finacial_account_fk")) );
            Log.i("",  cursor.getString(cursor.getColumnIndex("bank_account_fk")));
            Log.i("", cursor.getString(cursor.getColumnIndex("transaction_type")));
            Log.i("",cursor.getString(cursor.getColumnIndex("date")));
            Log.i("",cursor.getString(cursor.getColumnIndex("time")));
            Log.i("", String.valueOf(cursor.getLong(cursor.getColumnIndex("phone_number"))));
            Log.i("",cursor.getString(cursor.getColumnIndex("money")));
            Log.i("",cursor.getString(cursor.getColumnIndex("trans_number")));
            Log.i("", String.valueOf(cursor.getInt(cursor.getColumnIndex("reference"))));
            Log.i("",cursor.getString(cursor.getColumnIndex("trans_result")));
            Log.i("",cursor.getString(cursor.getColumnIndex("details")));
        }
        cursor.close();
        getInstance2(context).close();
        return list;
    }

    /////////////////////////get bank data
    public static ArrayList getBankData(Context context) {
        String selectQuery = "SELECT  * FROM " + bank_accounts_table;
        ArrayList<BankAccounts> list = new ArrayList<BankAccounts>();
        BankAccounts accounts = new BankAccounts();
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        while (cursor.moveToNext()) {
            list.add(new BankAccounts(cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("account_name")),
                    cursor.getLong(cursor.getColumnIndex("account_number"))
            ));
            accounts.setAccountName(cursor.getString(cursor.getColumnIndex("account_name")));
            String a = accounts.getAccountName();
            Log.i("Corsor1111111111", cursor.getString(cursor.getColumnIndex("account_name")));
            Log.i("Corsor1111111112", cursor.getString(cursor.getColumnIndex("account_number")));
            Log.i("String a= accounts", a);
        }
        cursor.close();
        getInstance2(context).close();
        return list;
    }
    //////////////////////get Mali Data

    public static ArrayList getMaliData(Context context) {
        String selectQuery = "SELECT  * FROM " + finacial_account_table;
        ArrayList<FinacialAccount> list = new ArrayList<FinacialAccount>();
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        while (cursor.moveToNext()) {
            list.add(new FinacialAccount(cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("finacial_account_name")),
                    cursor.getString(cursor.getColumnIndex("finacial_account_type"))));

            Log.i("Corsor1111111111", cursor.getString(cursor.getColumnIndex("finacial_account_name")));
            Log.i("Corsor1111111112", cursor.getString(cursor.getColumnIndex("finacial_account_type")));
        }
        cursor.close();
        getInstance2(context).close();
        return list;
    }

    //////////////////////////////
    public static String[] getDataBankAccounts(Context context) {
        String selectQuery = "SELECT  * FROM " + bank_accounts_table;
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString(cursor.getColumnIndexOrThrow("account_name"));
                spinnerContent.add(word);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray(allSpinner);
        return allSpinner;
    }

    public static String[] getDataFinacialAccountDaramad(Context context) {
        String selectQuery = "SELECT  * FROM " + finacial_account_table + " WHERE finacial_account_type='درآمد'";
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString(cursor.getColumnIndexOrThrow("finacial_account_name"));
                spinnerContent.add(word);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray(allSpinner);
        return allSpinner;
    }

    public static String[] getDataFinacialAccountHazineh(Context context) {
        String selectQuery = "SELECT  * FROM " + finacial_account_table + " WHERE finacial_account_type='هزینه'";
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString(cursor.getColumnIndexOrThrow("finacial_account_name"));
                spinnerContent.add(word);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray(allSpinner);
        return allSpinner;
    }

    public static String[] getDatatransactionDaramad(Context context) {
        String selectQuery = "SELECT  * FROM " + transaction_table + " WHERE transaction_type='درآمد'";
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString(cursor.getColumnIndexOrThrow("money"));
                Log.i("getDatatransaBBBBBBBBB", cursor.getString(cursor.getColumnIndex("money")));
                spinnerContent.add(word);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray(allSpinner);
        return allSpinner;
    }

    public static String[] getDataFinallyDaramadMoney(Context context) {
        String selectQuery = "SELECT * FROM " + transaction_table + " WHERE transaction_type='درآمد' ORDER BY id desc limit 0,3";
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String money = cursor.getString(cursor.getColumnIndexOrThrow("money"));
                //Log.i("getDataDaramadMoney", cursor.getString(cursor.getColumnIndex("money")));

                spinnerContent.add(money);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray(allSpinner);
        return allSpinner;
    }

    public static String[] getDataFinallyDaramadDate(Context context) {
        String selectQuery = "SELECT * FROM " + transaction_table + " WHERE transaction_type='درآمد' ORDER BY id desc limit 0,3";
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
                // Log.i("getDataDaramadDate", cursor.getString(cursor.getColumnIndex("date")));
                spinnerContent.add(date);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray(allSpinner);
        return allSpinner;
    }

    public static String[] getDataMoneyHazineh(Context context) {
        String selectQuery = "SELECT * FROM " + transaction_table + " WHERE transaction_type='هزینه' ORDER BY id desc limit 0,3";
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString(cursor.getColumnIndexOrThrow("money"));
                // Log.i("getDatatransactAAAAAAAA", cursor.getString(cursor.getColumnIndex("money")));
                spinnerContent.add(word);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray(allSpinner);
        return allSpinner;
    }

    public static String[] getDataDateHazineh(Context context) {
        String selectQuery = "SELECT * FROM " + transaction_table + " WHERE transaction_type='هزینه' ORDER BY id desc limit 0,3";
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
                /// Log.i("getDataHazinehDate", cursor.getString(cursor.getColumnIndex("date")));
                spinnerContent.add(date);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray(allSpinner);
        return allSpinner;
    }

    ////////bankName
    public static String[] getNameBankAccount(Context context) {
        String selectQuery = "SELECT * FROM " + bank_accounts_table + " ORDER BY id desc limit 0,3";
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString(cursor.getColumnIndexOrThrow("account_name"));
//                Log.i("getNameBankAccount11111", cursor.getString(cursor.getColumnIndex("account_name")));
                spinnerContent.add(word);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray(allSpinner);
        return allSpinner;
    }

    ////////////////////////bankNumber
    public static String[] getNumberBankAccount(Context context) {
        String selectQuery = "SELECT * FROM " + bank_accounts_table + " ORDER BY id desc limit 0,3";
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString(cursor.getColumnIndexOrThrow("account_number"));
//                Log.i("getNameBankAccount11111", cursor.getString(cursor.getColumnIndex("account_name")));
                spinnerContent.add(word);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray(allSpinner);
        return allSpinner;
    }

    ///////////////finacial
    public static String[] getDataDateFinacialName(Context context) {
        String selectQuery = "SELECT * FROM " + finacial_account_table + " ORDER BY id desc limit 0,3";
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String date = cursor.getString(cursor.getColumnIndexOrThrow("finacial_account_name"));
//                Log.i("getDataDateFinacialName", cursor.getString(cursor.getColumnIndex("finacial_account_name")));
                spinnerContent.add(date);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray(allSpinner);
        return allSpinner;
    }

    public static String[] getDataDateFinacialType(Context context) {
        String selectQuery = "SELECT * FROM " + finacial_account_table + " ORDER BY id desc limit 0,3";
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String date = cursor.getString(cursor.getColumnIndexOrThrow("finacial_account_type"));
//                Log.i("getDataDateFinacialType", cursor.getString(cursor.getColumnIndex("finacial_account_type")));
                spinnerContent.add(date);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray(allSpinner);
        return allSpinner;
    }

    //////////////
    public static String[] getDatatransactionHazineh(Context context) {
        String selectQuery = "SELECT  * FROM " + transaction_table + " WHERE transaction_type='هزینه'";
        Cursor cursor = getInstance2(context).rawQuery(selectQuery, null, null);
        ArrayList<String> spinnerContent = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String word = cursor.getString(cursor.getColumnIndexOrThrow("money"));
                Log.i("getDatatransactAAAAAAAA", cursor.getString(cursor.getColumnIndex("money")));
                spinnerContent.add(word);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray(allSpinner);
        return allSpinner;
    }

    public static void addLoginData(String userName, String passWord, Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_name", userName);
        contentValues.put("password", passWord);
        // Inserting Row
        getInstance(context).insert(user_app_table, null, contentValues);
        getInstance(context).close(); // Closing database connection
    }

    public static void addBankAccountsData(String accountName, long accountNumber, Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("account_name", accountName);
        contentValues.put("account_number", accountNumber);
        // Inserting Row
        Long value = getInstance(context).insert(bank_accounts_table, null, contentValues);
        if (String.valueOf(value).equals("-1")) {
            flagBank = false;
            getInstance(context).close(); // Closing database connection
//            Log.i(" Long value11111111111", String.valueOf(value));
//            Log.i(" flag value22222222222", String.valueOf(flagBank));
        } else if (!(String.valueOf(value).equals("-1"))) {
//            Log.i(" Long value33333333333", String.valueOf(value));
            flagBank = true;
//            Log.i(" flag value44444444444", String.valueOf(flagBank));
        }
        getInstance(context).close(); // Closing database connection
    }

    public static void addFinacialAccountData(String finacialAccountName, String finacialAccounType, Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("finacial_account_name", finacialAccountName);
        contentValues.put("finacial_account_type", finacialAccounType);

        // Inserting Row
        Long value = getInstance(context).insert(finacial_account_table, null, contentValues);
        if (String.valueOf(value).equals("-1")) {
            flagMali = false;
            getInstance(context).close(); // Closing database connection
            Log.i(" Long value11111111111", String.valueOf(value));
            Log.i(" flag value22222222222", String.valueOf(flagMali));
        } else if (!(String.valueOf(value).equals("-1"))) {
            Log.i(" Long value33333333333", String.valueOf(value));
            flagMali = true;
            Log.i(" flag value44444444444", String.valueOf(flagMali));
        }
        getInstance(context).close(); // Closing database connection
    }
//////////finacialAaccountFk, bankAccountFk, transActionType, date, time, phone_number,
// money, trans_number, reference, trans_result, details, getContext()
    public static void addTransactionData(String finacial_account_fk, String bank_account_fk,
                                          String transActionType, String date
                                        , String time, Long phone_number,
                                          String money, String trans_number, String reference,
                                          String trans_result, String details, Context context) {
        Long a=phone_number;
        ContentValues contentValues = new ContentValues();
        contentValues.put("finacial_account_fk", finacial_account_fk);
        contentValues.put("bank_account_fk", bank_account_fk);
        contentValues.put("transaction_type", transActionType);
        contentValues.put("date", date);
        contentValues.put("time", time);
        contentValues.put("phone_number", phone_number);
        contentValues.put("money", money);
        contentValues.put("trans_number", trans_number);
        contentValues.put("reference", reference);
        contentValues.put("trans_result", trans_result);
        contentValues.put("details", details);
        Log.i("phonenumberdatabase:)}}", String.valueOf(phone_number));
        // Inserting Row
        getInstance(context).insert(transaction_table, null, contentValues);
        getInstance(context).close(); // Closing database connection
    }

    /////////////deleted data
    public static void deleteTrans(Context context) {
        int valdel = getInstance(context).delete(transaction_table, _ID + " = ?", new String[]{"" + TransactionAdapter.idtrans});
        Log.i("deleteTrans", String.valueOf(valdel));
        Log.i("TransactiAdapterdelll", "" + TransactionAdapter.idtrans);
        if (!String.valueOf(valdel).equals("1")) {
            flagTransDel = false;
            getInstance(context).close(); // Closing database connection
            Log.i(" Int valdel", String.valueOf(valdel));
            Log.i(" flag flagBankDel", String.valueOf(flagTransDel));
        } else if ((String.valueOf(valdel).equals("1"))) {
            flagTransDel = true;
            Log.i(" int valdel", String.valueOf(valdel));
            Log.i(" flag flagBankDel", String.valueOf(flagTransDel));
        }
        getInstance(context).close();
    }

    ///////////////
    public static void deleteBank(Context context, String name) {
        int valdel = getInstance(context).delete(bank_accounts_table, _Name + " = ?", new String[]{"" + name});
//        Log.i("namenamenamenamename",String.valueOf(valdel));
        if (!String.valueOf(valdel).equals("1")) {
            flagBankDel = false;
            getInstance(context).close(); // Closing database connection
//            Log.i(" Int valdel", String.valueOf(valdel));
//            Log.i(" flag flagBankDel", String.valueOf(flagBankDel));
        } else if ((String.valueOf(valdel).equals("1"))) {
            flagBankDel = true;
//            Log.i(" int valdel", String.valueOf(valdel));
//            Log.i(" flag flagBankDel", String.valueOf(flagBankDel));
        }
        getInstance(context).close();
    }

    public static void deleteMali(Context context, String name) {
        int valdel = getInstance(context).delete(finacial_account_table,
                _NameMali + " = ?", new String[]{"" + name});
//        Log.i("namenamenamenamename",String.valueOf(valdel));
        if (!String.valueOf(valdel).equals("1")) {
            flagMaliDel = false;
            getInstance(context).close(); // Closing database connection
//            Log.i(" Int valdel", String.valueOf(valdel));
//            Log.i(" flag flagMaliDel", String.valueOf(flagBankDel));
        } else if ((String.valueOf(valdel).equals("1"))) {
            flagMaliDel = true;
//            Log.i(" int valdel", String.valueOf(valdel));
//            Log.i(" flag flagMaliDel", String.valueOf(flagBankDel));
        }
        getInstance(context).close();
    }
    ////////////// update data /////////////////////////

    public static void updateBanki(String name, Long number, Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("account_name", name);
        contentValues.put("account_number", number);
        int a = getInstance(context).update(bank_accounts_table,
                contentValues, _ID + " = ?", new String[]{"" + BankAdaptor.idaccount});
        if (!String.valueOf(a).equals("1")) {
            flagBankUpdate = false;
        } else if ((String.valueOf(a).equals("1"))) {
            flagBankUpdate = true;
            Log.i("updateBanki value11111", String.valueOf(a));
            Log.i("BankAdaptor.idaccount:)", "" + BankAdaptor.idaccount);
        }
        getInstance(context).close();
    }

    ///////////
    public static void updateMali(String name, String type, Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("finacial_account_name", name);
        contentValues.put("finacial_account_type", type);
        int a = getInstance(context).update(finacial_account_table,
                contentValues, _ID + " = ?", new String[]{"" + MaliAdapter.idMali});
        if (!String.valueOf(a).equals("1")) {
            flagMaliUpdate = false;
        } else if ((String.valueOf(a).equals("1"))) {
            flagMaliUpdate = true;
            Log.i("updateMali value11111", String.valueOf(a));
            Log.i("MaliAdaptor.idaccount:)", "" + MaliAdapter.idMali);
        }
        getInstance(context).close();
    }
    ///////////////////
    public static void updateTrans(String finacial_account_fk, String bank_account_fk,
                                   String transActionType, String date
                                   , String time, Long phone_number,
                                   String money, String trans_number, String reference,
                                   String trans_result, String details, Context context){
        ContentValues contentValues = new ContentValues();
        contentValues.put("finacial_account_fk", finacial_account_fk);
        contentValues.put("bank_account_fk", bank_account_fk);
        contentValues.put("transaction_type", transActionType);
        contentValues.put("date", date);
        contentValues.put("time", time);
        contentValues.put("phone_number", phone_number);
        contentValues.put("money", money);
        contentValues.put("trans_number", trans_number);
        contentValues.put("reference", reference);
        contentValues.put("trans_result", trans_result);
        contentValues.put("details", details);
        int a = getInstance(context).update(transaction_table,
                contentValues, _ID + " = ?", new String[]{"" + TransactionAdapter.idtrans});
        Log.i("UpdateAdapteridtrans", "" + TransactionAdapter.idtrans);
        Log.i("updateTrans value11111", String.valueOf(a));
        if (!String.valueOf(a).equals("1")) {
            flaTransUpdate = false;
        } else if ((String.valueOf(a).equals("1"))) {
            flaTransUpdate = true;
        }
        getInstance(context).close();
    }
}