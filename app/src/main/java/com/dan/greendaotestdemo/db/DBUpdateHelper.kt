package com.dan.greendaotestdemo.db

import android.content.Context

import org.greenrobot.greendao.database.Database

class DBUpdateHelper : DaoMaster.DevOpenHelper {
    constructor(context: Context, name: String) : super(context, name) {}

    override fun onUpgrade(db: Database?, oldVersion: Int, newVersion: Int) {
        super.onUpgrade(db, oldVersion, newVersion)
    }

}
