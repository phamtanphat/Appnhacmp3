package com.ptp.phamtanphat.appnhacmp3.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Album implements Parcelable{

    @SerializedName("IdAlbum")
    @Expose
    private String idAlbum;
    @SerializedName("TenAlbum")
    @Expose
    private String tenAlbum;
    @SerializedName("TencasiAlbum")
    @Expose
    private String tencasiAlbum;
    @SerializedName("HinhanhAlbum")
    @Expose
    private String hinhanhAlbum;

    protected Album(Parcel in) {
        idAlbum = in.readString();
        tenAlbum = in.readString();
        tencasiAlbum = in.readString();
        hinhanhAlbum = in.readString();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    public String getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getTenAlbum() {
        return tenAlbum;
    }

    public void setTenAlbum(String tenAlbum) {
        this.tenAlbum = tenAlbum;
    }

    public String getTencasiAlbum() {
        return tencasiAlbum;
    }

    public void setTencasiAlbum(String tencasiAlbum) {
        this.tencasiAlbum = tencasiAlbum;
    }

    public String getHinhanhAlbum() {
        return hinhanhAlbum;
    }

    public void setHinhanhAlbum(String hinhanhAlbum) {
        this.hinhanhAlbum = hinhanhAlbum;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idAlbum);
        dest.writeString(tenAlbum);
        dest.writeString(tencasiAlbum);
        dest.writeString(hinhanhAlbum);
    }
}