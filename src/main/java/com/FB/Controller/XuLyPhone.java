package com.FB.Controller;

import com.FB.Dao.FindPhoneDao;
import com.FB.Handle.Handle;
import com.FB.Model.FBAccount;
import com.FB.Model.ResultModel;
import com.FB.Thread.ShareData;
import com.FB.Thread.ThreadOne;
import com.FB.Thread.ThreadTwo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(value = "/xu-ly")
public class XuLyPhone extends HttpServlet {

    private FindPhoneDao findPhoneDao = new FindPhoneDao();

    ResourceBundle resourceBundle = ResourceBundle.getBundle("globals");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("html/text");
        resp.setCharacterEncoding("UTF-8");

        Handle handle= new Handle();
        String uid = req.getParameter("uid");
        String[] uids = uid.split("\\r?\\n");
        List<String> lists = handle.Pretreatment(uids);
        Collections.sort(lists);

        ShareData shareData= new ShareData(lists);
        List<ResultModel> rs = abc(shareData);

////        thread
//        String tables[] = resourceBundle.getString("table_test").split(",");
//
//        System.out.println(tables[0]);

//        xử lý trả về phone
//        List<FBAccount> list_uid = findPhoneDao.findAll(tables[0]);
//        ResultModel rs = handle.InterPolationSearch(list_uid,0,lists,0);

        req.setAttribute("listPhone",rs);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    public List<ResultModel> abc(ShareData shareData ) {

        ThreadOne t1= new ThreadOne(shareData);
        ThreadTwo t2 = new ThreadTwo(shareData);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return shareData.resultModel;
    }

}



