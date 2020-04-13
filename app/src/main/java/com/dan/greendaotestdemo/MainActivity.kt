package com.dan.greendaotestdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dan.greendaotestdemo.db.GreenDaoHelper
import com.dan.greendaotestdemo.dbbean.Achievement
import com.dan.greendaotestdemo.dbbean.StudyClass

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //添加成绩表
        add_achievement.setOnClickListener {

            GreenDaoHelper.addAchievenment(Achievement(1,201401,"林1","数学"))
            GreenDaoHelper.addAchievenment(Achievement(2,201402,"林2","语文"))
            GreenDaoHelper.addAchievenment(Achievement(3,201403,"林3","英语"))
            GreenDaoHelper.addAchievenment(Achievement(4,201404,"林4","物理"))
        }
        //添加学生
        add_study.setOnClickListener {
            GreenDaoHelper.addStuden(StudyClass(201401,"林1","18"))
            GreenDaoHelper.addStuden(StudyClass(201402,"林2","18"))
            GreenDaoHelper.addStuden(StudyClass(201403,"林3","18"))
            GreenDaoHelper.addStuden(StudyClass(201404,"林4","18"))
        }
    }

}
