package com.dan.greendaotestdemo.dbbean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class Achievement {
    @Id
    @NotNull
    private long id;
    @Property
    private long idCard;
    @Property
    private String name;
    @Property
    private String achievement;
    @Generated(hash = 735680482)
    public Achievement(long id, long idCard, String name, String achievement) {
        this.id = id;
        this.idCard = idCard;
        this.name = name;
        this.achievement = achievement;
    }
    @Generated(hash = 1106222797)
    public Achievement() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getIdCard() {
        return this.idCard;
    }
    public void setIdCard(long idCard) {
        this.idCard = idCard;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAchievement() {
        return this.achievement;
    }
    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

}
