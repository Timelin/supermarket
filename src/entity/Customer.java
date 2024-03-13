package entity;

import java.util.Date;

public class Customer {


    private String Id;
    /*
     * 名称
     */
    private String username;

    /*
     * 存款
     */
    private Double money;


    /*
     * 创建时间
     */
    private Date createTime;

    public Customer() {
    }

    public Customer(String id, String username, Double money, Date createTime) {
        Id = id;
        this.username = username;
        this.money = money;
        this.createTime = createTime;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
