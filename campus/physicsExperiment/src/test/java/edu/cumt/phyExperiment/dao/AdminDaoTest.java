package edu.cumt.phyExperiment.dao;

import edu.cumt.phyExperiment.BaseTest;
import edu.cumt.phyExperiment.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class AdminDaoTest extends BaseTest {

    @Autowired
    AdminDao adminDao;

    @Test
    public void queryAccountCount() {
        String account = "doug";
        int result = adminDao.queryAccountCount(account);
        System.out.println(result);
    }

    @Test
    public  void queryAdminByAccount() {
        String account = "doug";
        Admin admin = adminDao.queryAdminByAccount(account);
        System.out.println(admin);
    }

    @Test
    public void queryAdminByAdminId() {
        int adminId = 22;
        Admin admin = adminDao.queryAdminByAdminId(adminId);
        System.out.println(admin);
    }

    @Test
    public void insertAdmin() {
//        Admin adminOne = new Admin();
//        adminOne.setAccount("doug");
//        adminOne.setName("Doug Wilson");
//        adminOne.setPassword("090900");
//        adminOne.setRegistryTime(new Date());
        Admin adminTwo = new Admin();
        adminTwo.setAccount("darby");
        adminTwo.setPassword("090900");
        adminTwo.setName("Darby Jones");
        adminTwo.setRegistryTime(new Date());
//        adminDao.insertAdmin(adminOne);
        adminDao.insertAdmin(adminTwo);
    }

    @Test
    public void updateAdminPassword() {
        int adminId = 22;
        String newPassword = "testtest";
        adminDao.updateAdminPassword(adminId, newPassword);
        Admin admin = adminDao.queryAdminByAdminId(adminId);
        System.out.println(admin.getPassword());
        adminDao.updateAdminPassword(adminId, "090900");
    }

    @Test
    public void updateAdminName() {
        int adminId = 22;
        String newName = "testtest";
        adminDao.updateAdminName(adminId, newName);
        Admin admin = adminDao.queryAdminByAdminId(adminId);
        System.out.println(admin.getName());
        adminDao.updateAdminName(adminId, "Darby Jones");
    }

    @Test
    public void deleteAminByAdminId() {
        int result = adminDao.deleteAminByAdminId(22);
        System.out.println(result);
    }
}
