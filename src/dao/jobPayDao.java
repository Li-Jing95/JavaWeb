package dao;

import domain.Job;

import java.util.ArrayList;

public interface jobPayDao {
    boolean jobPayUpdate(int jobPay, int id);//改

    ArrayList<Job> findjobPayAll();//查

    ArrayList<Job> findjobPayName(String name);//按部门名字查
}
