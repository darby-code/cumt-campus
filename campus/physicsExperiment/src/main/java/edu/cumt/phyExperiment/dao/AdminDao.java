package edu.cumt.phyExperiment.dao;

import edu.cumt.phyExperiment.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
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
    Admin queryAdminByAdminId(int adminId);

    /**
     * 新增一个管理员
     * @param admin
     * @return
     */
    int insertAdmin(Admin admin);

    /**
     * 修改管理员密码
     * @param adminId
     * @param password
     * @return
     */
    int updateAdminPassword(@Param("adminId") int adminId, @Param("password") String password);

    /**
     * 修改管理员姓名
     * @param adminId
     * @param newName
     * @return
     */
    int updateAdminName(@Param("adminId") int adminId, @Param("name") String newName);

    /**
     * 删除adminId对应管理员
     * @param adminId
     * @return
     */
    int deleteAminByAdminId(int adminId);
}
