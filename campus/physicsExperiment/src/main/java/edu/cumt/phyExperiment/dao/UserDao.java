package edu.cumt.phyExperiment.dao;



import edu.cumt.phyExperiment.entity.Admin;
import edu.cumt.phyExperiment.entity.Student;
import edu.cumt.phyExperiment.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 将学生、教师、管理员抽象成为系统的用户
 */
public interface UserDao {

    /****************学生个人信息及账号相关SQL操作*****************************/
    /**
     * 根据学号查询学生
     * @param studentId
     * @return
     */
    Student queryStudentById(long studentId);

    /**
     * 根据姓名查询学生,可能会查出多个同名学生
     * @param studentName
     * @return
     */
    List<Student> queryStudentByName(String studentName);

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
    List<Student> queryCollegerBy(long collegeId);

    /**
     * 学生修改账号密码，要进行非空判断
     * 插入前一定要进行检查
     * @param studentId
     * @param newPassword
     * @return
     */
    int updateStudentPassword(@Param("studentId") long studentId, @Param("password") String newPassword);

    /**
     * 学生修改账号信息，如手机号、邮箱、等
     * 插入前对于一些非NULL的属性要进行判空，非空才能修改
     * @param student
     * @return
     */
    int updateStudentInfo(Student student);

    /**
     * 查询学生账号权限、状态
     * @param studentId
     * @return
     */
    int queryStudentAccountState(long studentId);

    /**
     * 修改学生账号权限、状态
     * @param studentId
     * @param state
     * @return
     */
    int updateStudentAccountState(@Param("studentId") long studentId, @Param("state") int state);


    /****************教师个人信息及账号相关SQL操作*****************************/
    /**
     * 根据工号查询教师
     * @param teacherId
     * @return
     */
    Teacher queryTeacherById(long teacherId);

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
    List<Teacher> queryCollegeTeacherBy(long collegeId);

    /**
     * 教师修改账号密码，要进行非空判断
     * @param teacherId
     * @param newPassword
     * @return
     */
    int updateTeacherPassword(@Param("teacherId") long teacherId, @Param("password") String newPassword);

    /**
     * 教师修改账号信息，如手机号、邮箱、等
     * 插入前对于一些非NULL的属性要进行判空，非空才能修改
     * @param teacher
     * @return
     */
    int updateTeacherInfo(Teacher teacher);

    /**
     * 查询教师账号权限、状态
     * @param teacherId
     * @return
     */
    int queryTeacherAccountState(long teacherId);

    /**
     * 修改教师账号权限、状态
     * @param teacherId
     * @param state
     * @return
     */
    int updateTeacherAccountState(@Param("teacherId") long teacherId, @Param("state") int state);


    /****************管理员个人信息及账号相关SQL操作*****************************/
    /**
     * 查找账号个数，用于创建管理员账号时保持唯一性
     * @param account
     * @return
     */
    int queryAccountCount(String account);

    /**
     * 查找账号对应管理员
     * @param account
     * @return
     */
    Admin queryAdminByAccount(String account);

    /**
     * 查找adminId对应管理员
     * @param adminId
     * @return
     */
    Admin queryAdminByAdminId(long adminId);

    /**
     * 新增一个管理员,需要进行判空存入
     * 如果不能为NULL的字段为NULL，会插入失败
     * @param admin
     * @return
     */
    int insertAdmin(Admin admin);

    /**
     * 修改管理员密码
     * @param account
     * @param password
     * @return
     */
    int updateAdminPassword(@Param("account") String account, @Param("password") String password);

    /**
     * 管理员修改账号信息，如手机号、邮箱、等
     * 插入前对于一些非NULL的属性要进行判空，非空才能修改
     * @param admin
     * @return
     */
    int updateAdminInfo(Admin admin);

    /**
     * 查询管理员账号权限
     * @param account
     * @return
     */
    int queryAdminAccountState(String account);

    /**
     * 修改管理员账户权限
     * @param account
     * @param state
     * @return
     */
    int updateAdminAccountState(@Param("account") String account, @Param("state") int state);

    /**
     * 删除账号对应管理员
     * @param account
     * @return
     */
    int deleteAdminByAccount(String account);
}
