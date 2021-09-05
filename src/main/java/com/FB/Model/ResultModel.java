package com.FB.Model;

import java.util.List;

public class ResultModel {
    private List<String> result;
    private List<String> next;
    private List<FBAccount> accounts;

    public List<FBAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<FBAccount> accounts) {
        this.accounts = accounts;
    }

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }

    public List<String> getNext() {
        return next;
    }

    public void setNext(List<String> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "result=" + result +
                ", next=" + next +
                ", accounts=" + accounts +
                '}';
    }
}
