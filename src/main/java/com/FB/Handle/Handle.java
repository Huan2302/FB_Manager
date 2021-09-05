package com.FB.Handle;

import com.FB.Model.FBAccount;
import com.FB.Model.ResultModel;

import java.util.ArrayList;
import java.util.List;

public class Handle {

    private ResultModel rs = new ResultModel();
    private List<String> listPhone = new ArrayList<>();
    private List<FBAccount> accounts = new ArrayList<>();

    public ResultModel InterPolationSearch( List<FBAccount> listUid, int location, List<String> list, int start){
        int n = location;
        String item = list.get(start);
        for (int i = n; i < listUid.size();i++){
            FBAccount uid = listUid.get(i);
            if (uid.getFacebook_id().equals(item)) {
                listPhone.add(uid.getPhone());
                accounts.add(uid);
                list.remove(start);
                if (start == list.size()){
                    rs.setNext(list);
                    rs.setResult(listPhone);
                    rs.setAccounts(accounts);
                    return rs;
                }
                return InterPolationSearch(listUid,i,list,start);
            }
            if (start + 1 == list.size()){
                rs.setNext(list);
                rs.setResult(listPhone);
                rs.setAccounts(accounts);
                return rs;
            }
            if (item.compareTo(uid.getFacebook_id())<0){
                return InterPolationSearch(listUid,i,list,start+1);
            }
        }
        rs.setNext(list);
        rs.setResult(listPhone);
        rs.setAccounts(accounts);
        return rs;
////        if (start + 1 == list.size()){
////            rs.setNext(list);
////            rs.setResult(listPhone);
////            rs.setAccounts(accounts);
////            return rs;
////        }
//        return InterPolationSearch(listUid,n,list,start+1);
    }

    public List<String> Pretreatment(String[] lists){
        List<String> arrStr = new ArrayList<>();
        for (int i = 0; i< lists.length;i++){
            if (!arrStr.contains(lists[i])){
                arrStr.add(lists[i]);
            }
        }
        return arrStr;
    }
}
