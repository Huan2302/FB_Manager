package com.FB.Thread;

import com.FB.Model.ResultModel;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) throws InterruptedException {
        List<String> a = new ArrayList<>();
        a.add("100004048401656");
        a.add("100006700771745");
        a.add("2");
        a.add("3");
        a.add("4");
        ShareData shareData= new ShareData(a);
        test abc = new test();
        abc.abc(shareData);
        System.out.println("da xong thred");

        List<ResultModel> rs = shareData.resultModel;
        for (ResultModel item: rs){
            for (String text:item.getResult()){
                System.out.println(text);
            }
        }



    }
    public void abc(ShareData shareData) throws InterruptedException {
        ThreadOne t1= new ThreadOne(shareData);
        ThreadTwo t2 = new ThreadTwo(shareData);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
