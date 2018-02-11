package com.ptp.phamtanphat.appnhacmp3.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TheLoai implements Parcelable {

@SerializedName("IdTheLoai")
@Expose
private String idTheLoai;
@SerializedName("IdKeyChuDe")
@Expose
private String idKeyChuDe;
@SerializedName("TenTheLoai")
@Expose
private String tenTheLoai;
@SerializedName("HinhTheLoai")
@Expose
private String hinhTheLoai;

    protected TheLoai(Parcel in) {
        idTheLoai = in.readString();
        idKeyChuDe = in.readString();
        tenTheLoai = in.readString();
        hinhTheLoai = in.readString();
    }

    public static final Creator<TheLoai> CREATOR = new Creator<TheLoai>() {
        @Override
        public TheLoai createFromParcel(Parcel in) {
            return new TheLoai(in);
        }

        @Override
        public TheLoai[] newArray(int size) {
            return new TheLoai[size];
        }
    };

    public String getIdTheLoai() {
return idTheLoai;
}

public void setIdTheLoai(String idTheLoai) {
this.idTheLoai = idTheLoai;
}

public String getIdKeyChuDe() {
return idKeyChuDe;
}

public void setIdKeyChuDe(String idKeyChuDe) {
this.idKeyChuDe = idKeyChuDe;
}

public String getTenTheLoai() {
return tenTheLoai;
}

public void setTenTheLoai(String tenTheLoai) {
this.tenTheLoai = tenTheLoai;
}

public String getHinhTheLoai() {
return hinhTheLoai;
}

public void setHinhTheLoai(String hinhTheLoai) {
this.hinhTheLoai = hinhTheLoai;
}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idTheLoai);
        dest.writeString(idKeyChuDe);
        dest.writeString(tenTheLoai);
        dest.writeString(hinhTheLoai);
    }
}
