package org.fireking.meitukong.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wangg on 16/1/3.
 */
public class MainCategoryBean implements Parcelable {

    private String category;
    private String name;

    public MainCategoryBean() {
    }

    public MainCategoryBean(String category, String name) {
        this.category = category;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.category);
        dest.writeString(this.name);
    }

    protected MainCategoryBean(Parcel in) {
        this.category = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<MainCategoryBean> CREATOR = new Parcelable.Creator<MainCategoryBean>() {
        public MainCategoryBean createFromParcel(Parcel source) {
            return new MainCategoryBean(source);
        }

        public MainCategoryBean[] newArray(int size) {
            return new MainCategoryBean[size];
        }
    };
}
