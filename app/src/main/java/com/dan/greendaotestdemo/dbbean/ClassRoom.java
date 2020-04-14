package com.dan.greendaotestdemo.dbbean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.dan.greendaotestdemo.db.DaoSession;
import com.dan.greendaotestdemo.db.StudyClassDao;
import com.dan.greendaotestdemo.db.ClassRoomDao;


@Entity
public class ClassRoom {
    @Id
    private Long id;
    @Property
    private String className;
    //一对多  ClassRoom 主键id指向StudyClass 的外键classRoomId
    @ToMany(referencedJoinProperty = "classRoomId")
    private List<StudyClass> studyClassesList;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 544346441)
    private transient ClassRoomDao myDao;
    @Generated(hash = 1672674739)
    public ClassRoom(Long id, String className) {
        this.id = id;
        this.className = className;
    }
    @Generated(hash = 437777384)
    public ClassRoom() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getClassName() {
        return this.className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 723732846)
    public List<StudyClass> getStudyClassesList() {
        if (studyClassesList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StudyClassDao targetDao = daoSession.getStudyClassDao();
            List<StudyClass> studyClassesListNew = targetDao
                    ._queryClassRoom_StudyClassesList(id);
            synchronized (this) {
                if (studyClassesList == null) {
                    studyClassesList = studyClassesListNew;
                }
            }
        }
        return studyClassesList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1155113632)
    public synchronized void resetStudyClassesList() {
        studyClassesList = null;
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
    @Generated(hash = 2071810320)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getClassRoomDao() : null;
    }

}
