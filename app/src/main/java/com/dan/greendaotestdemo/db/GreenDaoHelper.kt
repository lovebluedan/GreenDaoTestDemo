package com.dan.greendaotestdemo.db

import android.database.sqlite.SQLiteDatabase
import com.dan.greendaotestdemo.App
import com.dan.greendaotestdemo.dbbean.Achievement
import com.dan.greendaotestdemo.dbbean.StudyClass
import com.dan.greendaotestdemo.db.DaoSession
import com.dan.greendaotestdemo.db.AchievementDao
import com.dan.greendaotestdemo.db.StudyClassDao
import com.dan.greendaotestdemo.dbbean.ClassRoom

/**
 * 封装好的一个数据句帮助类
 * create by 林丹荣 自己学习使用。
 */
class GreenDaoHelper {

    companion object {
        val DB_NAME = "music_db"
        //数据库帮助类，属于创建数据库 升级数据库
        private lateinit var mHelper: DaoMaster.DevOpenHelper
        //最终创建好的数据
        lateinit var mDb: SQLiteDatabase
        //管理数据库
        lateinit var mDaoMaster: DaoMaster
        lateinit var mDaoSeesion: DaoSession
        //        var encrypted: Boolean = false
        fun initDataBase(encrypted: Boolean) {
            //不支持数据升级保存的
//            mHelper = DaoMaster.DevOpenHelper(App.mApplication, DB_NAME)
//            mDb = mHelper.writableDatabase
            //支持数据库升级保存的
            mHelper = DBUpdateHelper(App.mApplication, DB_NAME)
            if (encrypted) {
                //数据加密
                mDaoMaster = DaoMaster(mHelper.getEncryptedWritableDb("password"))
            } else {
                //数据不加密
                mDb = mHelper.writableDatabase
                mDaoMaster = DaoMaster(mDb)
            }
            mDaoSeesion = mDaoMaster.newSession()
        }

        fun addStuden(studen: StudyClass) {
            mDaoSeesion.studyClassDao.insert(studen)
        }

        fun addAchievenment(achievement: Achievement) {
            mDaoSeesion.achievementDao.insert(achievement)
        }

        fun addClass(classRoom: ClassRoom) {
            mDaoSeesion.classRoomDao.insert(classRoom)
        }

        fun selectStudyAchievement(): List<Achievement> {
            return mDaoSeesion.achievementDao.queryBuilder().whereOr(
                AchievementDao.Properties.MName.eq("小林"),
                AchievementDao.Properties.MName.eq("小华")
            ).list()
        }

        fun selectClassAllStudents(): MutableList<ClassRoom> {
            return mDaoSeesion.classRoomDao.queryBuilder()
                .where(ClassRoomDao.Properties.Id.eq(2014014)).list()
        }
    }
}