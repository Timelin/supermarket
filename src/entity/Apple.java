package entity;


import jdk.jfr.DataAmount;

import java.util.Date;

/*
* 苹果
* */
@DataAmount
public class Apple {


    private String Id;

    /*
     * 商品名称
     */
    private String goodsName;
    /*
     * 数量、重量
     */
    private Double quantity;
    /*
     * 价格
     */
    private Double price;


    /*
     * 创建时间
     */
    private Date createTime;

    public Apple() {
    }

    public Apple(String id, String goodsName, Double quantity, Double price, Date createTime) {
        Id = id;
        this.goodsName = goodsName;
        this.quantity = quantity;
        this.price = price;
        this.createTime = createTime;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }



    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
