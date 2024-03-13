package entity;

public class Goods {


    public Goods() {
    }


    /*
    * 货物
    * */
    private  Object goodsName;

    public Goods(Object goodsName) {
        this.goodsName = goodsName;
    }

    public Object getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(Object goodsName) {
        this.goodsName = goodsName;
    }


}
