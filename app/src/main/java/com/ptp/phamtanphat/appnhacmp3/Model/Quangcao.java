package com.ptp.phamtanphat.appnhacmp3.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quangcao implements Parcelable{

    @SerializedName("IdQuangcao")
    @Expose
    private String idQuangcao;
    @SerializedName("Hinhanh")
    @Expose
    private String hinhanh;
    @SerializedName("Nodung")
    @Expose
    private String nodung;
    @SerializedName("IdBaihat")
    @Expose
    private String idBaihat;
    @SerializedName("TenBaiHat")
    @Expose
    private String tenBaiHat;
    @SerializedName("HinhBaiHat")
    @Expose
    private String hinhBaiHat;

    protected Quangcao(Parcel in) {
        idQuangcao = in.readString();
        hinhanh = in.readString();
        nodung = in.readString();
        idBaihat = in.readString();
        tenBaiHat = in.readString();
        hinhBaiHat = in.readString();
    }

    public static final Creator<Quangcao> CREATOR = new Creator<Quangcao>() {
        @Override
        public Quangcao createFromParcel(Parcel in) {
            return new Quangcao(in);
        }

        @Override
        public Quangcao[] newArray(int size) {
            return new Quangcao[size];
        }
    };

    public String getIdQuangcao() {
        return idQuangcao;
    }

    public void setIdQuangcao(String idQuangcao) {
        this.idQuangcao = idQuangcao;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getNodung() {
        return nodung;
    }

    public void setNodung(String nodung) {
        this.nodung = nodung;
    }

    public String getIdBaihat() {
        return idBaihat;
    }

    public void setIdBaihat(String idBaihat) {
        this.idBaihat = idBaihat;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getHinhBaiHat() {
        return hinhBaiHat;
    }

    public void setHinhBaiHat(String hinhBaiHat) {
        this.hinhBaiHat = hinhBaiHat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idQuangcao);
        dest.writeString(hinhanh);
        dest.writeString(nodung);
        dest.writeString(idBaihat);
        dest.writeString(tenBaiHat);
        dest.writeString(hinhBaiHat);
    }
}