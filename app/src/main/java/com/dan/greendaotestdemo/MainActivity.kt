package com.dan.greendaotestdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dan.greendaotestdemo.db.GreenDaoHelper
import com.dan.greendaotestdemo.dbbean.Achievement
import com.dan.greendaotestdemo.dbbean.ClassRoom
import com.dan.greendaotestdemo.dbbean.StudyClass

import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

//https://blog.csdn.net/crazymo_/article/details/54629916
/**
 * 因为增加了主键外键等约束条件导致如果乱写入数据会报错！！！
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //添加成绩表
        add_achievement.setOnClickListener {
            GreenDaoHelper.addAchievenment(Achievement().also {
                it.mId = 201463069
                it.mChina = 80.5
                it.mEnglish = 80.5
                it.mMathematics = 80.0
                it.mName = "小林"
            })
            GreenDaoHelper.addAchievenment(Achievement().also {
                it.mId = 201463070
                it.mChina = 90.5
                it.mEnglish = 90.5
                it.mMathematics = 90.0
                it.mName = "小蔡"
            })
            GreenDaoHelper.addAchievenment(Achievement().also {
                it.mId = 201463071
                it.mChina = 36.5
                it.mEnglish = 24.5
                it.mMathematics = 80.0
                it.mName = "小黄"
            })
            GreenDaoHelper.addAchievenment(Achievement().also {
                it.mId = 201463072
                it.mChina = 74.5
                it.mEnglish = 53.5
                it.mMathematics = 22.0
                it.mName = "小华"
            })
        }
        //添加学生
        add_study.setOnClickListener {
            GreenDaoHelper.addStuden(StudyClass().apply {
                mId = 201463069
                mAge = "17"
                mName = "小林"
                classRoomId = 2014014
            })
            GreenDaoHelper.addStuden(StudyClass().apply {
                mId = 201463070
                mAge = "18"
                mName = "小蔡"
                classRoomId = 2014014
            })
            GreenDaoHelper.addStuden(StudyClass().apply {
                mId = 201463071
                mAge = "19"
                mName = "小黄"
                classRoomId = 2014015
            })
            GreenDaoHelper.addStuden(StudyClass().apply {
                mId = 201463072
                mAge = "20"
                mName = "小华"
                classRoomId = 2014015
            })
        }
        //添加班级
        add_class.setOnClickListener {
            GreenDaoHelper.addClass(ClassRoom().apply {
                id = 2014014
                className = "软件142班"
            })
            GreenDaoHelper.addClass(ClassRoom().apply {
                id = 2014015
                className = "软件141班"
            })
        }
        select_study_achievement.setOnClickListener {
            val list = GreenDaoHelper.selectStudyAchievement()
            var str = ""
            if (list.isNotEmpty()) {
                list.forEach {
                    str += "${it.mId} ${it.mName} 语文:${it.mChina} 数学:${it.mMathematics} 英语:${it.mEnglish}" + "\n"
                }
            }
            textView.text = str
        }
        select_class_study.setOnClickListener {
            val list = GreenDaoHelper.selectClassAllStudents()
            if (list.size > 0){
            var str = ""
            if (list[0].studyClassesList.isNotEmpty()) {
                list[0].studyClassesList.forEach {
                    str += "${it.mId} ${it.mName} ${it.mAge}" + "\n"
                }
            }
            textView.text = str
            }
        }
    }

}
