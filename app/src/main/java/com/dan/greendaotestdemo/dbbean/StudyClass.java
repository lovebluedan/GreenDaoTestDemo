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
    @Id //必须使用包装类对象类型Long，而非基本类型long
    private Long mId;
    @Property
    private String mName;
    @Property
    private String mAge;
    @Property
    @NotNull
    private Long classRoomId;
    //一对一关系 1：1 @ToOne
    @ToOne(joinProperty = "mId")
    private Achievement achievement;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1063709672)
    private transient StudyClassDao myDao;
    @Generated(hash = 1406068635)
    public StudyClass(Long mId, String mName, String mAge,
            @NotNull Long classRoomId) {
        this.mId = mId;
        this.mName = mName;
        this.mAge = mAge;
        this.classRoomId = classRoomId;
    }
    @Generated(hash = 437751645)
    public StudyClass() {
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
    public String getMAge() {
        return this.mAge;
    }
    public void setMAge(String mAge) {
        this.mAge = mAge;
    }
    public Long getClassRoomId() {
        return this.classRoomId;
    }
    public void setClassRoomId(Long classRoomId) {
        this.classRoomId = classRoomId;
    }
    @Generated(hash = 1350650098)
    private transient Long achievement__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1172202018)
    public Achievement getAchievement() {
        Long __key = this.mId;
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
    @Generated(hash = 48591934)
    public void setAchievement(Achievement achievement) {
        synchronized (this) {
            this.achievement = achievement;
            mId = achievement == null ? null : achievement.getMId();
            achievement__resolvedKey = mId;
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
