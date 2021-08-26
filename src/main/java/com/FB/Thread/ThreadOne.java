package com.FB.Thread;

import com.FB.Dao.FindPhoneDao;
import com.FB.Model.FBAccount;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadOne extends Thread{
     ShareData shareData;
     private FindPhoneDao findPhoneDao = new FindPhoneDao();

    public ThreadOne(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < shareData.tables.length ; i++){
            synchronized (shareData){
                System.out.println("T1 strat");
                List<FBAccount> list = findPhoneDao.findAll(shareData.tables[i]);
                shareData.setList(list);
                try {
                    shareData.notifyAll();
                    shareData.wait();
                } catch (InterruptedException e) {
                    Logger.getLogger(ThreadOne.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        System.out.println("T1 stop");
        synchronized(shareData) {
            shareData.notifyAll();
        }
    }
}
