package com.FB.Thread;

import java.util.ResourceBundle;

public class ShareData {
    String[] tables;

    ResourceBundle resourceBundle = ResourceBundle.getBundle("globals");

    private ShareData(){
        tables = new String[]{resourceBundle.getString("table_test")};
    }
}
