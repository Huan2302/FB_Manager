package com.FB.Controller;

import com.FB.Handle.Handle;
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
import java.util.Collections;
import java.util.List;

@WebServlet(value = "/xu-ly")
public class XuLyPhone extends HttpServlet {

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
        List<ResultModel> rs = handle(shareData);

        req.setAttribute("listPhone",rs);
        req.getRequestDispatcher("/table-phone.jsp").forward(req,resp);
    }

    public List<ResultModel> handle(ShareData shareData ) {

        ThreadOne t1= new ThreadOne(shareData);
        ThreadTwo t2 = new ThreadTwo(shareData);

        t2.start();
        t1.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return shareData.resultModel;
    }

}



