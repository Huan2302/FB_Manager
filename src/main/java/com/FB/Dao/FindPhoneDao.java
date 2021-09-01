package com.FB.Dao;

import com.FB.Model.FBAccount;
import com.FB.mapper.FBAccountMapper;

import java.util.List;

public class FindPhoneDao extends AbstractDao{
    public List<FBAccount> findAll(String table){
//        String sql = "SELECT * FROM "+table+" ORDER BY uid ASC";
        String sql = "SELECT * FROM "+table;
        return query(sql,new FBAccountMapper());
    }
}
