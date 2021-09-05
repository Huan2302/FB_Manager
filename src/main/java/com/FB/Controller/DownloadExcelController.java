package com.FB.Controller;

import com.FB.Excel.WriteExcel;
import com.FB.Model.FBAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

@MultipartConfig
@WebServlet(value = "/download")
public class DownloadExcelController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("html/text");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        List<FBAccount> fbAccounts = (List<FBAccount>) session.getAttribute("listExcel");

//        Create file excel
        final  String dirPathName = req.getServletContext().getRealPath("/download");
        File dirFile = new File(dirPathName);
        if (!dirFile.exists()){
            dirFile.mkdir();
        }
        String fileName = "fbaccount.xlsx";
        String filePathName = dirPathName + File.separator + fileName; //duong đẫn thư mục
        WriteExcel write = new WriteExcel();
        write.writeExcel(fbAccounts,filePathName);

        try(OutputStream out = resp.getOutputStream()){
            resp.setContentType("APPLICATION/OCTET-STREAM");

//            force to download
            resp.setHeader("Content-Disposition",
                    "attachment; filename=fbaccount.xlsx");

            FileInputStream in = new FileInputStream(filePathName);

            int i;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
            in.close();
            out.flush();
            File oldFile = new File(filePathName);
            if (oldFile.exists()){
                oldFile.delete();
            }
        }
        return;
    }
}
