package com.example.pc_brestby.criminalintent;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private SimpleDateFormat mDateFormat;
    private boolean mSolved;




    public Crime(){
        mId = UUID.randomUUID();
        mDate=new Date();
       // mDateFormat=DateFormat.getDateInstance(DateFormat.LONG);
        mDateFormat=new SimpleDateFormat("MMM E dd yyyy");
        mDateFormat.format(mDate.getDate());


    }

    public DateFormat getDateFormat() {
        return mDateFormat;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
