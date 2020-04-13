package com.dan.greendaotestdemo.db

import android.database.sqlite.SQLiteDatabase
import com.dan.greendaotestdemo.App
import com.dan.greendaotestdemo.dbbean.Achievement
import com.dan.greendaotestdemo.dbbean.StudyClass
import com.dan.greendaotestdemo.db.DaoSession
import com.dan.greendaotestdemo.db.AchievementDao
import com.dan.greendaotestdemo.db.StudyClassDao

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

        fun initDataBase() {
            mHelper = DaoMaster.DevOpenHelper(App.mApplication, DB_NAME)
            mDb = mHelper.writableDatabase
            mDaoMaster = DaoMaster(mDb)
            mDaoSeesion = mDaoMaster.newSession()
        }

        fun addStuden(studen: StudyClass) {
            mDaoSeesion.studyClassDao.insert(studen)
        }

        fun addAchievenment(achievement: Achievement) {
            mDaoSeesion.achievementDao.insert(achievement)
        }
    }
}