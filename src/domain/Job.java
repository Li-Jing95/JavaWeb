package domain;

public class Job {
    private int id;
    private String name;
    private String remark;
    private int jobpay;

    public Job() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getJobpay() {
        return jobpay;
    }

    public void setJobpay(int jobpay) {
        this.jobpay = jobpay;
    }

}
