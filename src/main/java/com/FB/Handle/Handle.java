package com.FB.Handle;

import com.FB.Model.FBAccount;
import com.FB.Model.ResultModel;

import java.util.ArrayList;
import java.util.List;

public class Handle {

    private ResultModel rs = new ResultModel();
    private List<String> listPhone = new ArrayList<>();
    private List<String> next = new ArrayList<>();

    public ResultModel InterPolationSearch( List<FBAccount> listUid, int location, ArrayList<String> list, int start){
        int n = location;
        String item = list.get(start);
        for (int i = n; i < listUid.size();i++){
            FBAccount uid = listUid.get(i);
            if (uid.getFacebook_id().equals(item)) {
                listPhone.add(uid.getPhone());
                ++start;
                if (start == list.size()){
                    rs.setNext(next);
                    rs.setResult(listPhone);
                    return rs;
                }
                return InterPolationSearch(listUid,i,list,start);
            }
        }
        next.add(item);
        if (start + 1 == list.size()){
            rs.setNext(next);
            rs.setResult(listPhone);
            return rs;
        }
        return InterPolationSearch(listUid,n,list,start+1);
    }

    public ArrayList<String> Pretreatment(String[] lists){
        ArrayList<String> arrStr = new ArrayList<>();
        for (int i = 0; i< lists.length;i++){
            if (!arrStr.contains(lists[i])){
                arrStr.add(lists[i]);
            }
        }
        return arrStr;
    }
}
