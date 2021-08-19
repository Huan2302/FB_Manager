package com.FB.Controller;

import com.FB.Dao.FindPhoneDao;
import com.FB.Model.FBAccount;

import java.util.List;

public class abc {
    public static void main(String[] args) {
        List<FBAccount> list = new FindPhoneDao().findAll();
        for (FBAccount item:list){
            System.out.println(item.getId());
        }
    }
}
