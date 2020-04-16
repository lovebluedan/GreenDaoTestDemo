package com.dan.greendaotestdemo

import android.app.Application
import android.content.Context
import com.dan.greendaotestdemo.db.GreenDaoHelper

class App : Application() {

    companion object {
        lateinit var mApplication: Context
    }

    override fun onCreate() {
        super.onCreate()
        mApplication = applicationContext
        initDB()
    }

    fun initDB() {
        GreenDaoHelper.initDataBase(true)
    }

    override fun getApplicationContext(): Context {
        return super.getApplicationContext()
    }
}