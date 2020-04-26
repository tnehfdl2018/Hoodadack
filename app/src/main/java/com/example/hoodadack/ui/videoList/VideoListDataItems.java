package com.example.hoodadack.ui.videoList;

import android.graphics.drawable.Drawable;

public class VideoListDataItems {

    private Drawable thumneil;
    private String mainTitle;
    private String subTitle;
    private Drawable icon;


    public Drawable getThumneil() {
        return thumneil;
    }

    public void setThumneil(Drawable thumneil) {
        this.thumneil = thumneil;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}