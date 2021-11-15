package com.FB.Handle;

import com.FB.Model.FBAccount;
import com.FB.Model.ResultModel;

import java.util.ArrayList;
import java.util.List;

public class Handle {

    private ResultModel rs = new ResultModel();
    private List<String> listPhone = new ArrayList<>();
    private List<FBAccount> accounts = new ArrayList<>();

//    public ResultModel InterPolationSearch( List<FBAccount> listUid, int location, List<String> list, int start){
//        int n = location;
//        String item = list.get(start);
//        for (int i = n; i < listUid.size();i++){
//            FBAccount uid = listUid.get(i);
//            if (uid.getFacebook_id().equals(item)) {
//                listPhone.add(uid.getPhone());
//                accounts.add(uid);
//                list.remove(start);
//                if (start == list.size()){
//                    rs.setNext(list);
//                    rs.setResult(listPhone);
//                    rs.setAccounts(accounts);
//                    return rs;
//                }
//                return InterPolationSearch(listUid,i,list,start);
//            }
//            if (start + 1 == list.size()){
//                rs.setNext(list);
//                rs.setResult(listPhone);
//                rs.setAccounts(accounts);
//                return rs;
//            }
//            if (item.compareTo(uid.getFacebook_id())<0){
//                return InterPolationSearch(listUid,i,list,start+1);
//            }
//        }
//        rs.setNext(list);
//        rs.setResult(listPhone);
//        rs.setAccounts(accounts);
//        return rs;
//    }

    public List<String> Pretreatment(String[] lists){
        System.out.println("Tiền xữ lý dữ liệu");
        List<String> arrStr = new ArrayList<>();
        for (int i = 0; i< lists.length;i++){
            if (!arrStr.contains(lists[i])){
                arrStr.add(lists[i]);
            }
        }
        return arrStr;
    }

    public int binarySearchRecursive(List<FBAccount> list, int l, int r, String target){
        int mid = (l+r)/2;

        if (r-l<0){
            return -1;
        }

        if (target.equals(list.get(mid).getFacebook_id())){
            return mid;
        }
        else if(target.compareTo(list.get(mid).getFacebook_id())>0){
            return binarySearchRecursive(list,mid+1,r,target);
        }else {
            return binarySearchRecursive(list,l,mid-1,target);
        }
    }

//    public int InterPolationSearch(List<FBAccount> list,int l,int r,String target){
//        int left = l;
//        int right = r -1;
//        while (left <= right && target.compareTo(list.get(left).getFacebook_id()) >= 0
//                && target.compareTo(list.get(right).getFacebook_id()) <=0 ){
//            double val1 = (double) ()
//        }
//    }

    public ResultModel expoSearch(List<FBAccount> listUid, int location, List<String> list, int start){
        while (start <= list.size()){
            int bound = 1;
            int temp = 0;
            int n = temp + bound;
            String item = list.get(start);
            while (n < listUid.size() && item.compareTo(listUid.get(n).getFacebook_id()) > 0){
                bound *= 2;
                n = temp + bound;
            }
            int left_bound = temp + bound/2;
            int right_bound = Math.min(n, listUid.size()-1);
            int answer = binarySearchRecursive(listUid,left_bound,right_bound,item);
            if (answer > 0) {
                temp = answer;
                listPhone.add(listUid.get( answer).getPhone());
                accounts.add(listUid.get( answer));
                list.remove(start);
//                System.out.println("thành công:"+start);
//                System.out.println(list.size());
                if (start==list.size()){
                    rs.setNext(list);
                    rs.setAccounts(accounts);
                    rs.setResult(listPhone);
                    return rs;
                }
            }else {
                start++;
//                System.out.println(start);
                if (start+1==list.size()){
                    rs.setNext(list);
                    rs.setAccounts(accounts);
                    rs.setResult(listPhone);
                    return rs;
                }
            }
        }
        rs.setNext(list);
        rs.setAccounts(accounts);
        rs.setResult(listPhone);
        return rs;
    }

}


