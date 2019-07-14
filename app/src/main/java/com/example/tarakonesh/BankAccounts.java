package com.example.tarakonesh;

/*support telgram id =@javaprogrammer_eh
 * 24/03/1398
 * creted by elmira hossein zadeh*/

public class BankAccounts {
    private int id;
    private String accountName;
    private Long accountNumber;

    public BankAccounts() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public BankAccounts(String accountName, Long accountNumber) {
//        this.accountName = accountName;
//        this.accountNumber = accountNumber;
//    }

    public BankAccounts(int id, String accountName, Long accountNumber) {
        this.id = id;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }
}
