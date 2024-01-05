package com.example.myappfive.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserData {

    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("per_page")
    @Expose
    private int per_page;

    @SerializedName("total")
    @Expose
    private int total;
    @SerializedName("data")
    @Expose
    private ArrayList<UserDataList> userDataList;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<UserDataList> getUserDataList() {
        return userDataList;
    }

    public void setUserDataList(ArrayList<UserDataList> userDataList) {
        this.userDataList = userDataList;
    }

    public UserData(int page, int per_page, int total, ArrayList<UserDataList> userDataList) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.userDataList = userDataList;
    }
}
