package com.ptp.phamtanphat.appnhacmp3.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChuDe implements Parcelable {

    @SerializedName("IdChuDe")
    @Expose
    private String idChuDe;
    @SerializedName("TenChuDe")
    @Expose
    private String tenChuDe;
    @SerializedName("HinhChuDe")
    @Expose
    private String hinhChuDe;

    protected ChuDe(Parcel in) {
        idChuDe = in.readString();
        tenChuDe = in.readString();
        hinhChuDe = in.readString();
    }

    public static final Creator<ChuDe> CREATOR = new Creator<ChuDe>() {
        @Override
        public ChuDe createFromParcel(Parcel in) {
            return new ChuDe(in);
        }

        @Override
        public ChuDe[] newArray(int size) {
            return new ChuDe[size];
        }
    };

    public String getIdChuDe() {
        return idChuDe;
    }

    public void setIdChuDe(String idChuDe) {
        this.idChuDe = idChuDe;
    }

    public String getTenChuDe() {
        return tenChuDe;
    }

    public void setTenChuDe(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }

    public String getHinhChuDe() {
        return hinhChuDe;
    }

    public void setHinhChuDe(String hinhChuDe) {
        this.hinhChuDe = hinhChuDe;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idChuDe);
        dest.writeString(tenChuDe);
        dest.writeString(hinhChuDe);
    }
}
