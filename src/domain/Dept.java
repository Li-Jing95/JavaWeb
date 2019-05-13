package domain;

public class Dept {
    private int id;
    private String name;
    private String remark;
    private int localpay;

    public Dept() {
        super();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public int getLocalpay() {
        return localpay;
    }

    public void setLocalpay(int localpay) {
        this.localpay = localpay;
    }
}
