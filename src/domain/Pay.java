package domain;

public class Pay {
    private int id;
    private String name;
    private String dept;
    private String job;
    private String month;
    private double sum;
    private double wuxian;
    private double shuihou;
    private double realpay;

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getWuxian() {
        return wuxian;
    }

    public void setWuxian(double wuxian) {
        this.wuxian = wuxian;
    }

    public double getShuihou() {
        return shuihou;
    }

    public void setShuihou(double shuihou) {
        this.shuihou = shuihou;
    }

    public double getRealpay() {
        return realpay;
    }

    public void setRealpay(double realpay) {
        this.realpay = realpay;
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }


}
