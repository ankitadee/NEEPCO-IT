package com.example.neepco;

import androidx.annotation.NonNull;

public class NewUserdata {

    private  String mName, mIssue, mFeed, mPhone, mDate;

    public NewUserdata(String mName, String mIssue, String mFeed, String mPhone, String mDate) {
        this.mName = mName;
        this.mIssue = mIssue;
        this.mFeed = mFeed;
        this.mPhone = mPhone;
        this.mDate = mDate;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmIssue() {
        return mIssue;
    }

    public void setmIssue(String mIssue) {
        this.mIssue = mIssue;
    }

    public String getmFeed() {
        return mFeed;
    }

    public void setmFeed(String mFeed) {
        this.mFeed = mFeed;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mName = mName;
    }

    @NonNull
    @Override
    public String toString() {
        return "NewUserdata{" +
                "mName= '" + mName+ '\'' +
                "mIssue= '" + mIssue+ '\'' +
                "mFeed= '" + mFeed+ '\'' +
                "mPhone= '" + mPhone+ '\'' +
                "mDate= '"+ mDate+ '\''+
                '}';

    }

}
