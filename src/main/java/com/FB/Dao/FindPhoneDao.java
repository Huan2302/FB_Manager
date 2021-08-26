package com.FB.Dao;

import com.FB.Model.FBAccount;
import com.FB.mapper.FBAccountMapper;

import java.util.List;

public class FindPhoneDao extends AbstractDao{
    public List<FBAccount> findAll(String table){
        String sql = "SELECT * FROM "+table+" ORDER BY FACEBOOK_ID ASC";
        return query(sql,new FBAccountMapper());
    }
}
