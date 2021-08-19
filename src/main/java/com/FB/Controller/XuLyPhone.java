package com.FB.Controller;

import com.FB.Dao.FindPhoneDao;
import com.FB.Model.FBAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(value = "/xu-ly")
public class XuLyPhone extends HttpServlet {
    private FindPhoneDao findPhoneDao = new FindPhoneDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("html/text");
        resp.setCharacterEncoding("UTF-8");

        String uid = req.getParameter("uid");
        String[] uids = uid.split("\\r?\\n");
        System.out.println();
        ArrayList<String> lists = Pretreatment(uids);

        System.out.println(uids.length);
        System.out.println(lists.size());

        List<FBAccount> list = findPhoneDao.findAll();
        StringBuffer listPhone = new StringBuffer();
        String phone;
        for (String item : lists){
            phone = InterPolationSearch(list,item);
            System.out.println(phone);
            if (phone!=null){
                listPhone.append(item+" || "+phone);
            }
        }
        System.out.println(listPhone.toString());
        req.setAttribute("listPhone",listPhone.toString());
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

//    public String InterPolationSearch(List<FBAccount> listUid,long left,long right, String uid ){
//        int id = Integer.parseInt(uid);
//        if (right>=1){
//            long mid = left + (right - 1)/2;
//            if (Integer.parseInt(listUid.get((int)mid).getFacebook_id()) == id){
//                return listUid.get((int)mid).getPhone();
//            }
//            if (Integer.parseInt(listUid.get((int)mid).getFacebook_id()) > id){
//                return InterPolationSearch(listUid,left,mid - 1,uid);
//            }
//            return InterPolationSearch(listUid,mid +1 ,right,uid);
//        }
//        return null;
//    }

    public String InterPolationSearch(List<FBAccount> listUid, String uid ){
        for (FBAccount item:listUid){
            if (uid.equals(item.getFacebook_id())){
                return item.getPhone();
            }
        }
        return null;
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
