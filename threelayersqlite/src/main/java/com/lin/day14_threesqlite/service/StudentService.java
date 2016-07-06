package com.lin.day14_threesqlite.service;

import android.content.Context;
import android.database.Cursor;

import com.lin.day14_threesqlite.common.StudentSqliteOpenHelper;
import com.lin.day14_threesqlite.database_access_object.StudentDao;
import com.lin.day14_threesqlite.models.Student;

import java.util.HashMap;
import java.util.List;

/**
 * Created by my on 2016/6/25.
 * 学生业务逻辑层。
 * database access object
 */
public class StudentService {
    private StudentDao studentDao;

    public StudentService(Context context) {
        studentDao = new StudentDao(context);
    }

    /**
     * 添加数据
     */
    public boolean insert(Student student) {
        return studentDao.insert(student);
    }

    /**
     * 删除数据
     */
    public boolean delete(int stuNo) {
        return studentDao.delete(stuNo);
    }

    /**
     * 更新数据
     */
    public boolean update(Student newStu) {
        return studentDao.update(newStu);
    }

    /**
     * 获取所有学生的list集合
     */
    public List<Student> getAllStudentList() {
        return studentDao.getAllStudentList();
    }

    public Cursor getAllStudentCursor() {
        return studentDao.getAllStudentCursor();
    }

    public List<HashMap<String, Object>> getAllStudentmaplist() {
        return studentDao.getAllStudentmap();
    }

    public Student getStudentByiD(int stuNo) {
        return studentDao.getstudentBystuNo(stuNo);
    }

    public List<Student> getAllStudentListBypage(int pageSize, int pageindex) {
        return studentDao.getAllStudentListByPage(pageSize, pageindex);
    }
}
