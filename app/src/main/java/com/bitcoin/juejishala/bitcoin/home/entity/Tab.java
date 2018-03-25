package com.bitcoin.juejishala.bitcoin.home.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 主页tab实体类
 * Created by yinyayue on 2018/3/16.
 */

public class Tab implements Parcelable {
    /**
     * 文字
     */
    private int title;
    /**
     * 图标
     */
    private int icon;
    /**
     * 对应的fragment
     */
    private Class fragment;

    public Tab(Class fragment, int title, int icon) {
        this.title = title;
        this.icon = icon;
        this.fragment = fragment;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.title);
        dest.writeInt(this.icon);
        dest.writeSerializable(this.fragment);
    }

    public Tab() {
    }

    protected Tab(Parcel in) {
        this.title = in.readInt();
        this.icon = in.readInt();
        this.fragment = (Class) in.readSerializable();
    }

    public static final Creator<Tab> CREATOR = new Creator<Tab>() {
        @Override
        public Tab createFromParcel(Parcel source) {
            return new Tab(source);
        }

        @Override
        public Tab[] newArray(int size) {
            return new Tab[size];
        }
    };
}
