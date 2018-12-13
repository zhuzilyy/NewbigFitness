package com.example.gufei.bigfitness.com.GuFei.Ui.UpdateVersion;

public class UpdateBean {
    private int Ret;
    private String Msg;
    private UpdateInfo rows;
    public int getRet() {
        return Ret;
    }

    public void setRet(int ret) {
        Ret = ret;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public UpdateInfo getRows() {
        return rows;
    }

    public void setRows(UpdateInfo rows) {
        this.rows = rows;
    }
}
