package com.example.stocksearchapp;

import android.os.Parcel;
import android.os.Parcelable;

public class MyParcelable implements Parcelable {
    private int mData;

    /* everything below here is for implementing Parcelable */

    // 99.9% of the time you can just ignore this
    public int describeContents() {
        return 0;
    }

    // write your object's data to the passed-in Parcel
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mData);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<MyParcelable> CREATOR = new Parcelable.Creator<MyParcelable>() {
        public MyParcelable createFromParcel(Parcel in) {
            return new MyParcelable(in);
        }

        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private MyParcelable(Parcel in) {
        mData = in.readInt();
    }
}