package com.FB.Dao;

import com.FB.Model.FBAccount;
import com.FB.mapper.FBAccountMapper;

import java.util.ArrayList;
import java.util.List;

public class FindPhoneDao extends AbstractDao{
    public List<FBAccount> findAll(){
        String sql = "SELECT * FROM fbaccount ORDER BY id ASC";
        return query(sql,new FBAccountMapper());
//        return list.isEmpty() ? null : list.get(0);
    }
}
