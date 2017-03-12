package com.eric.bean;
import java.util.List;
/**
 * Created by run on 16/7/13.
 */
public class Theme {
    public int limit;
    public List<String> subscribed;
    public List<Others> others;

    public Theme(int limit, List<String> subscribed, List<Others> others) {
        this.limit = limit;
        this.subscribed = subscribed;
        this.others = others;
    }

    public int getLimit() {

        return limit;
    }

    public Theme setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public List<String> getSubscribed() {
        return subscribed;
    }

    public Theme setSubscribed(List<String> subscribed) {
        this.subscribed = subscribed;
        return this;
    }

    public List<Others> getOthers() {
        return others;
    }

    public Theme setOthers(List<Others> others) {
        this.others = others;
        return this;
    }
}
