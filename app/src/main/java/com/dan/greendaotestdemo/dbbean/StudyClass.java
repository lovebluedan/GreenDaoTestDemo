package com.dan.greendaotestdemo.dbbean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.dan.greendaotestdemo.db.DaoSession;
import com.dan.greendaotestdemo.db.AchievementDao;
import com.dan.greendaotestdemo.db.StudyClassDao;


/**
 * @Id 表示该字段是id，注意该字段的数据类型为包装类型Long
 * @Property 则表示该属性将作为表的一个字段，其中nameInDb看名字就知道这个属性在数据库中对应的数据名称。
 * @Transient 该注解表示这个属性将不会作为数据表中的一个字段。
 * @NotNull 表示该字段不可以为空
 * @Unique 表示该字段唯一
 */
@Entity
public class StudyClass {
    @Id
    @NotNull
    private long idCard;
    @Property
    private String name;
    @Property
    private String age;
    @ToOne(joinProperty = "idCard")
    private Achievement achievement;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1063709672)
    private transient StudyClassDao myDao;
    @Generated(hash = 1846394631)
    public StudyClass(long idCard, String name, String age) {
        this.idCard = idCard;
        this.name = name;
        this.age = age;
    }
    @Generated(hash = 437751645)
    public StudyClass() {
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
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    @Generated(hash = 1350650098)
    private transient Long achievement__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1436519875)
    public Achievement getAchievement() {
        long __key = this.idCard;
        if (achievement__resolvedKey == null
                || !achievement__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AchievementDao targetDao = daoSession.getAchievementDao();
            Achievement achievementNew = targetDao.load(__key);
            synchronized (this) {
                achievement = achievementNew;
                achievement__resolvedKey = __key;
            }
        }
        return achievement;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 745167140)
    public void setAchievement(@NotNull Achievement achievement) {
        if (achievement == null) {
            throw new DaoException(
                    "To-one property 'idCard' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.achievement = achievement;
            idCard = achievement.getId();
            achievement__resolvedKey = idCard;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 350155747)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudyClassDao() : null;
    }
}
