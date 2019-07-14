package com.example.tarakonesh;

/*support telgram id =@javaprogrammer_eh
 * 24/03/1398
 * creted by elmira hossein zadeh*/

import android.content.Context;
import android.util.Log;

public class ConvertingArray {

    public static String Money1, Money2, Money3, Money4, Money5, Money6,
            date1, date2, date3, date4, date5, date6,
            bankName1, bankName2, bankName3, bankNumber1, bankNumber2, bankNumber3, finName1, finName2, finName3, finType1, finType2, finType3;

    public static int SumWithenhanceFor(int[] array) {
        int sum = 0;
        for (int data : array) {
            sum += data;
        }
        //    Log.i("sumsumsumsumsumsummmmm", String.valueOf(sum));
        return sum;
    }

    public static Long SumWithenhanceForLong(Long[] array) {
        Long sum = 0L;
        for (Long data : array) {
            sum += data;
        }
        // Log.i("sumsumsumsumsumsummmmm", String.valueOf(sum));
        return sum;
    }

    //    public static int SumWithFor(int[] array){
//        int sum=0;
//        for (int i = 0; i < array.length; i++) {
//            sum+=array[i];
//        }
//
//        return sum;
//    }
    public static int[] strArrayToIntArray(String[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = Integer.parseInt(a[i]);
        }

        return b;
    }

    public static Long[] strArrayToLongArray(String[] a) {
        Long[] b = new Long[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = Long.parseLong(a[i]);
        }

        return b;
    }

    public static Long subtractionValue(Long daramad, Long hazineh) {
        Long daramadValue, hazinehValue, sumValue;
        daramadValue = daramad;
        hazinehValue = hazineh;
        sumValue = daramadValue - hazinehValue;
        return sumValue;
    }

    public static Long showAllDaramad(String[] arrayList) {
        Long[] integerArray = strArrayToLongArray(arrayList);
        Long daramad = SumWithenhanceForLong(integerArray);
        return daramad;
    }

    public static Long showAllHazineh(String[] arrayList) {
        Long[] integerArray = ConvertingArray.strArrayToLongArray(arrayList);
        Long hazineh = ConvertingArray.SumWithenhanceForLong(integerArray);
        return hazineh;
    }

    public static boolean ArrayToStringDaramad(String[] array1, String[] array2) {
        boolean flag = false;
        if (array1.length >= 3 && array2.length >= 3) {
            Money1 = array1[0];
            Money2 = array1[1];
            Money3 = array1[2];
            date1 = array2[0];
            date2 = array2[1];
            date3 = array2[2];
            flag = true;
        } else {
            flag = false;
//            Log.i("flag11111", String.valueOf(flag));
        }
        return flag;
    }

    public static boolean ArrayToStringHazineh(String[] array1, String[] array2) {
        boolean flag = false;
        if (array1.length >= 3 && array2.length >= 3) {
            Money4 = array1[0];
            Money5 = array1[1];
            Money6 = array1[2];
            date4 = array2[0];
            date5 = array2[1];
            date6 = array2[2];
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public static void ArrayToStringBank(String[] array1, String[] array2) {
        bankName1 = array1[0];
        bankName2 = array1[1];
        bankName3 = array1[2];
        bankNumber1 = array2[0];
        bankNumber2 = array2[1];
        bankNumber3 = array2[2];
    }

    public static void ArrayToStringFinacial(String[] array1, String[] array2) {
        finName1 = array1[0];
        finName2 = array1[1];
        finName3 = array1[2];
        finType1 = array2[0];
        finType2 = array2[1];
        finType3 = array2[2];
    }
}