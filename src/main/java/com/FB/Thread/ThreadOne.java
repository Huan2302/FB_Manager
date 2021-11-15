package com.FB.Thread;

import com.FB.Dao.FindPhoneDao;
import com.FB.Model.FBAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadOne extends Thread{
     ShareData shareData;
    List<FBAccount> list= new ArrayList<>();

    public ThreadOne(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        synchronized (shareData){
            for (int i = 0 ; i < shareData.tables.length ; i++){
                if (shareData.running == true){
                    System.out.println("T1 start");
                    FindPhoneDao findPhoneDao = new FindPhoneDao();
                    list = findPhoneDao.findAll(shareData.tables[i]);
                    shareData.setList(list);
                    System.out.println("Get DB :" + shareData.tables[i]);
                    shareData.notifyAll();
//                    shareData.running=true;
                    try {
                        shareData.wait();
                    } catch (InterruptedException e) {
                        Logger.getLogger(ThreadOne.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
            }
        }
        System.out.println("T1 stop");
        synchronized(shareData) {
            shareData.notifyAll();
        }
    }
}
