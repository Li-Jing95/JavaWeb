package dao;

import domain.Dept;
import domain.Job;
import domain.ordUser;

import java.util.ArrayList;

public interface ordinaryDao {
    boolean ordLogin(String loginname, String password);

    ArrayList<Dept> ordFindDeptAll();//查所有部门

    ArrayList<Job> ordFindJobAll();//岗位

    boolean miMaUpdate(String psd, String name);//员工修改密码

    ArrayList<ordUser> ordPsdFindAll();

    boolean ordMiMaUpdate(String name, String password, int id);

    boolean deleteOrdMiMa(int id);//管理员删除密码

}
