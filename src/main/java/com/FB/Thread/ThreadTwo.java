package com.FB.Thread;

import com.FB.Handle.Handle;
import com.FB.Model.ResultModel;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadTwo extends Thread{
    ShareData shareData;

    public ThreadTwo(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        for (int i=0 ; i < shareData.tables.length ; i++){
            synchronized (shareData){
                System.out.println("T2 start");
                System.out.println("size:"+shareData.getListUid().size());
                if (shareData.getListUid().isEmpty()){
                    System.out.println("đã rỗng");
                }
                Handle handle = new Handle();
                try{
                    ResultModel rs = handle.InterPolationSearch(shareData.getList(),0,shareData.getListUid(),0);
                    shareData.setListUid(rs.getNext());
                    shareData.resultModel.add(rs);
                }catch (Exception e){

                }
                try {
                    shareData.notifyAll();
                    shareData.wait();
                } catch (InterruptedException e) {
                    Logger.getLogger(ThreadOne.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        System.out.println("T2 stop");
        synchronized(shareData) {
            shareData.notifyAll();
        }
    }
}
