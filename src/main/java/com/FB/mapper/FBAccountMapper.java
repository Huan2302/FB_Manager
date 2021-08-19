package com.FB.mapper;

import com.FB.Model.FBAccount;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FBAccountMapper implements RowMapper{
    @Override
    public Object mapRow(ResultSet rs) {
        try {
            FBAccount fb = new FBAccount();
            fb.setId(rs.getLong("id"));
            fb.setFacebook_id(rs.getString("FACEBOOK_ID"));
            fb.setPhone(rs.getString("phone"));
            return fb;
        }catch (SQLException e) {
            return null;
        }
    }
}
