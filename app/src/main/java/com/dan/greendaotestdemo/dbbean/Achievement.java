package com.dan.greendaotestdemo.dbbean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 成绩表 学号 姓名 数学 语文 英语
 */
@Entity
public class Achievement {
    @Id
    private Long mId;
    @Property
    private String mName;
    @Property
    private double mMathematics;
    @Property
    private double mChina;
    @Property
    private double mEnglish;
    @Property
    private double mphysics;
    @Generated(hash = 623521344)
    public Achievement(Long mId, String mName, double mMathematics, double mChina,
            double mEnglish, double mphysics) {
        this.mId = mId;
        this.mName = mName;
        this.mMathematics = mMathematics;
        this.mChina = mChina;
        this.mEnglish = mEnglish;
        this.mphysics = mphysics;
    }
    @Generated(hash = 1106222797)
    public Achievement() {
    }
    public Long getMId() {
        return this.mId;
    }
    public void setMId(Long mId) {
        this.mId = mId;
    }
    public String getMName() {
        return this.mName;
    }
    public void setMName(String mName) {
        this.mName = mName;
    }
    public double getMMathematics() {
        return this.mMathematics;
    }
    public void setMMathematics(double mMathematics) {
        this.mMathematics = mMathematics;
    }
    public double getMChina() {
        return this.mChina;
    }
    public void setMChina(double mChina) {
        this.mChina = mChina;
    }
    public double getMEnglish() {
        return this.mEnglish;
    }
    public void setMEnglish(double mEnglish) {
        this.mEnglish = mEnglish;
    }
    public double getMphysics() {
        return this.mphysics;
    }
    public void setMphysics(double mphysics) {
        this.mphysics = mphysics;
    }

}
