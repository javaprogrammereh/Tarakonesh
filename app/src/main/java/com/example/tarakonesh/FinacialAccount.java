package com.example.tarakonesh;

/*support telgram id =@javaprogrammer_eh
 * 24/03/1398
 * creted by elmira hossein zadeh*/

public class FinacialAccount {
    private int id;
    private String finacialAccountName;
    private String finacialAccountType;
    public FinacialAccount() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FinacialAccount(int id, String finacialAccountName, String finacialAccountType) {
        this.id = id;
        this.finacialAccountName = finacialAccountName;
        this.finacialAccountType = finacialAccountType;
    }
//    public FinacialAccount(String finacialAccountName, String finacialAccountType) {
//        this.finacialAccountName = finacialAccountName;
//        this.finacialAccountType = finacialAccountType;
//    }

    public String getFinacialAccountName() {
        return finacialAccountName;
    }

    public void setFinacialAccountName(String finacialAccountName) {
        this.finacialAccountName = finacialAccountName;
    }

    public String getFinacialAccountType() {
        return finacialAccountType;
    }

    public void setFinacialAccountType(String finacialAccountType) {
        this.finacialAccountType = finacialAccountType;
    }
}
