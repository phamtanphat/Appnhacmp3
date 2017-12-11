package com.ptp.phamtanphat.appnhacmp3.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quangcao {

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

}