package com.example.tarakonesh;

/*support telgram id =@javaprogrammer_eh
 * 24/03/1398
 * creted by elmira hossein zadeh*/

public class Transaction {
    private int id;
    private String finacialAccountFk;
    private String bankAccountFk;
    private String transactionType;
    private String date;
    private String time;
    private Long phoneNumber;
    private String  money;
    private String transNumber;
    private int reference;
    private String transResult;
    private String details;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Transaction(int id, String finacialAccountFk, String bankAccountFk, String transactionType, String date, String time, Long phoneNumber, String money, String transNumber, int reference, String transResult, String details) {
        this.id = id;
        this.finacialAccountFk = finacialAccountFk;
        this.bankAccountFk = bankAccountFk;
        this.transactionType = transactionType;
        this.date = date;
        this.time = time;
        this.phoneNumber = phoneNumber;
        this.money = money;
        this.transNumber = transNumber;
        this.reference = reference;
        this.transResult = transResult;
        this.details = details;
    }

    public Transaction(int id ,String bankAccountFk, String money, String finacialAccountFk, String transNumber, String date, String time) {
        this.id = id;
        this.finacialAccountFk = finacialAccountFk;
        this.bankAccountFk = bankAccountFk;
        this.date = date;
        this.time = time;
        this.money = money;
        this.transNumber = transNumber;
    }

    public Transaction() {
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getFinacialAccountFk() {
        return finacialAccountFk;
    }

    public void setFinacialAccountFk(String finacialAccountFk) {
        this.finacialAccountFk = finacialAccountFk;
    }

    public String getBankAccountFk() {
        return bankAccountFk;
    }

    public void setBankAccountFk(String bankAccountFk) {
        this.bankAccountFk = bankAccountFk;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getTransNumber() {
        return transNumber;
    }

    public void setTransNumber(String transNumber) {
        this.transNumber = transNumber;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getTransResult() {
        return transResult;
    }

    public void setTransResult(String transResult) {
        this.transResult = transResult;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

