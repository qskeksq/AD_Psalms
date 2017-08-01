package com.example.administrator.psalms.Home;

/**
 * Created by Administrator on 2017-08-02.
 */

public class HomeDummy {

    int viewType;
    boolean shown = false;

    public HomeDummy(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }

    public boolean isShown() {
        return shown;
    }

    public void setShown(boolean shown) {
        this.shown = shown;
    }
}
