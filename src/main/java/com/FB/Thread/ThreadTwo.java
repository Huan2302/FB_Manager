package com.FB.Thread;

import com.FB.Handle.Handle;
import com.FB.Model.ResultModel;

import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadTwo extends Thread{
    ShareData shareData;

    public ThreadTwo(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        synchronized (shareData){
            for (int i=0 ; i < shareData.tables.length ; i++){
                if (shareData.running == true){
                    try {
                        shareData.notifyAll();
                        shareData.wait();
                    } catch (InterruptedException e) {
                        Logger.getLogger(ThreadTwo.class.getName()).log(Level.SEVERE, null, e);
                    }
                    System.out.println("T2 start");
                    try{
                        Handle handle = new Handle();
                        Collections.sort(shareData.getList());
                        System.out.println("DB đã được sắp xếp");
                        ResultModel rs = handle.expoSearch(shareData.getList(),0,shareData.getListUid(),0);
                        System.out.println("Xử lý xong");
                        shareData.setListUid(rs.getNext());
                        if (shareData.getListUid().isEmpty()){
                            System.out.println("Đã rỗng");
                            System.out.println("Dừng cuộc chơi");
                            shareData.running=false;
                        }
                        shareData.resultModel.add(rs);
                    }catch (Exception e){
                        shareData.running=false;
                        e.getMessage();
                    }
                }
            }
        }
        System.out.println("T2 stop");
        synchronized(shareData) {
            shareData.notifyAll();
        }
    }
}
