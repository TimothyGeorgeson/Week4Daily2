package com.example.consultants.week4daily2.model.data.local;

import android.os.Parcel;
import android.os.Parcelable;

public class MyRepo implements Parcelable {
    String name;
    String created;
    String branch;

    public MyRepo(String name, String created, String branch) {
        this.name = name;
        this.created = created;
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public MyRepo(Parcel parcel){
        name = parcel.readString();
        created = parcel.readString();
        branch = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(created);
        dest.writeString(branch);
    }

    public static final Parcelable.Creator<MyRepo> CREATOR = new Parcelable.Creator<MyRepo>(){

        @Override
        public MyRepo createFromParcel(Parcel parcel) {
            return new MyRepo(parcel);
        }

        @Override
        public MyRepo[] newArray(int size) {
            return new MyRepo[0];
        }
    };
}
