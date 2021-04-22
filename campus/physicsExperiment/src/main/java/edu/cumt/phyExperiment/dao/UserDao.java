package edu.cumt.phyExperiment.dao;



import edu.cumt.phyExperiment.entity.Student;
import edu.cumt.phyExperiment.entity.Teacher;
import edu.cumt.phyExperiment.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /****************学生相关SQL操作*****************************/
    /**
     * 根据学号查询学生
     * @param studentId
     * @return
     */
    Student queryStudentById(int studentId);

    /**
     * 根据姓名查询学生,可能会查出多个同名学生
     * @param name
     * @return
     */
    List<Student> queryStudentByName(String name);

    /**
     * 查询所有学生
     * @return
     */
    List<Student> queryAllStudents();

    /**
     * 查询一个学院的所有学生
     * @param collegeId
     * @return
     */
    List<Student> queryCollegerBy(Integer collegeId);

    /**
     * 学生修改账号密码
     * @param studentId
     * @param newPassword
     * @return
     */
    int updateStudentPassword(@Param("studentId") Integer studentId, @Param("password") String newPassword);

    /****************教师相关SQL操作*****************************/
    /**
     * 根据工号查询教师
     * @param teacherId
     * @return
     */
    Teacher queryTeacherById(int teacherId);

    /**
     * 根据姓名查询教师,可能会查出多个同名教师
     * @param name
     * @return
     */
    List<Teacher> queryTeacherByName(String name);

    /**
     * 查询所有教师
     * @return
     */
    List<Teacher> queryAllTeachers();

    /**
     * 查询一个学院的所有老师
     * @param collegeId
     * @return
     */
    List<Teacher> queryCollegeTeacherBy(Integer collegeId);

    /**
     * 教师修改账号密码
     * @param teacherId
     * @param newPassword
     * @return
     */
    int updateTeacherPassword(@Param("teacherId") Integer teacherId, @Param("password") String newPassword);
}
