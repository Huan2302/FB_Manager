package com.FB.Thread;

import com.FB.Model.FBAccount;
import com.FB.Model.ResultModel;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ShareData {
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("globals");

    String[] tables = resourceBundle.getString("table_test").split(",");
    private List<String> listUid;
    private List<FBAccount> list;
    public List<ResultModel> resultModel = new ArrayList<>();


    public List<FBAccount> getList() {
        return list;
    }

    public void setList(List<FBAccount> list) {
        this.list = list;
    }

    public ShareData(List<String> listUid) {
        this.listUid = listUid;
    }

    public List<String> getListUid() {
        return listUid;
    }

    public void setListUid(List<String> listUid) {
        this.listUid = listUid;
    }
}
