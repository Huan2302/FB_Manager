package com.FB.Controller;

import com.FB.Excel.ReadExcel;
import com.FB.Handle.Handle;
import com.FB.Model.FBAccount;
import com.FB.Model.ResultModel;
import com.FB.Thread.ShareData;
import com.FB.Thread.ThreadOne;
import com.FB.Thread.ThreadTwo;
import com.FB.Util.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@MultipartConfig
@WebServlet(value = "/xu-ly")
public class XuLyPhone extends HttpServlet {

//    @Override
//    public void init() throws ServletException {
//        try{
//
//        }
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("html/text");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        if (session.getAttribute("listExcel")!=null){
            session.removeAttribute("listExcel");
        }

        Part filePart = req.getPart("fileUID");
        final  String dirPathName = req.getServletContext().getRealPath("/excel");

        String uid = req.getParameter("uid");
        System.out.println(filePart.getContentType());
        Handle handle = new Handle();
        if (filePart.getContentType().equals("application/octet-stream")){
            String[] uids = uid.split("\\r?\\n");
            List<String> lists = handle.Pretreatment(uids);
            Collections.sort(lists);

            ShareData shareData= new ShareData(lists);
            List<ResultModel> rs = handle(shareData);

            req.setAttribute("listPhone",rs);
        }else {
            List<FBAccount> accounts = handleExcel(filePart,dirPathName);
            if (accounts.size()==0){
                resp.sendRedirect(req.getContextPath()+"/home");
                return;
            }else {
                session.setAttribute("listExcel",accounts);
            }
        }
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
        System.out.println("======================");
        return shareData.resultModel;
    }

    public List<FBAccount> handleExcel(Part filePart,String dirPathName) throws IOException {
        List<FBAccount> accounts = new ArrayList<>();
        File dirFile = new File(dirPathName);
        if (!dirFile.exists()){
            dirFile.mkdir();
        }
        String fileName = FileUtil.getName(filePart);
        String filePathName = dirPathName + File.separator + fileName;
        if (!fileName.isEmpty()){
            filePart.write(filePathName);
        }
        try{
            ReadExcel read = new ReadExcel();
            accounts = read.readExcel(filePathName);
            List<String> list = new ArrayList<>();
            for (FBAccount item : accounts){
                list.add(item.getFacebook_id());
            }
            Collections.sort(list);

            ShareData shareData= new ShareData(list);

            List<ResultModel> rs = handle(shareData);
            for (ResultModel item:rs){
                List<FBAccount> fb = item.getAccounts();
                for (FBAccount item1:fb){
                    for (FBAccount item2 : accounts){
                        if (item1.getFacebook_id().equals(item2.getFacebook_id())){
                            item2.setPhone(item1.getPhone());
                        }
                    }
                }
            }

            File oldFile = new File(filePathName);
            if (oldFile.exists()){
                oldFile.delete();
            }
        }catch (Exception e){
            File oldFile = new File(filePathName);
            if (oldFile.exists()){
                oldFile.delete();
            }
        }
        return accounts;
    }

}



