package com.dan.greendaotestdemo.db

import android.content.Context

import org.greenrobot.greendao.database.Database
import com.github.yuweiguocn.library.greendao.MigrationHelper



/**
 * 用于做数据库的升级保存原来的数据
 * 思想：
 * 先创建一个临时表将数据存储，再将临时表的数据存到新表
 */
class DBUpdateHelper : DaoMaster.DevOpenHelper {
    constructor(context: Context, name: String) : super(context, name) {}

    override fun onUpgrade(db: Database?, oldVersion: Int, newVersion: Int) {
        MigrationHelper.migrate(db, object : MigrationHelper.ReCreateAllTableListener {

            override fun onCreateAllTables(db: Database, ifNotExists: Boolean) {
                DaoMaster.createAllTables(db, ifNotExists)
            }

            override fun onDropAllTables(db: Database, ifExists: Boolean) {
                DaoMaster.dropAllTables(db, ifExists)
            }
        },AchievementDao::class.java, ClassRoomDao::class.java, StudyClassDao::class.java)
    }

}
