package domain;

import java.util.ArrayList;

public class Employee {
    private int id;
    private int job_id;
    private int dept_id;
    private String dept;
    private String job;

    private String name;
    private String sex;
    private String nation;
    private String polic;
    private String born;
    private String tel;
    private String email;
    private String education;
    private String card_id;
    private String createdate;

    private String jobpay;
    private String localpay;
    private int sum;

    private int count;//男女比统计值

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPolic() {
        return polic;
    }

    public void setPolic(String polic) {
        this.polic = polic;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getJobpay() {
        return jobpay;
    }

    public void setJobpay(String jobpay) {
        this.jobpay = jobpay;
    }

    public String getLocalpay() {
        return localpay;
    }

    public void setLocalpay(String localpay) {
        this.localpay = localpay;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

}


