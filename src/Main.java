import entity.*;

import java.util.*;

public class Main {


    public static void main(String[] args) {


        System.out.println("需求一：超市，出售苹果和草莓。其中苹果 8 元/斤，草莓 13 元/斤。顾客A购买苹果、草莓所需的总价格");
        oneTest();
        System.out.println("===============================================================");
        System.out.println("需求二：超市增加了一种水果芒果，其定价为 20 元/斤。");
        twoTest();
        System.out.println("===============================================================");
        System.out.println("需求三：超市做促销活动，草莓限时打 8 折。");
        threeTest();
        System.out.println("===============================================================");
        System.out.println("需求四：促销活动效果明显，购物满 100 减 10 块,（打折加上满减促销）");
        fourTest();
        System.out.println("===============================================================");
        System.out.println("需求五：促销活动，购物满 100 减 10 块,（不打折只是满减促销）");
        fiveTest();


    }


    /*
     * 需求五：满减，但是不打折
     * */
    public static void  fiveTest() {

        //添加一种水果： 芒果
        Mango mango = addMango();

        Customer customer = new Customer("4", "顾客D", 200.00, new Date());

        //购买货物
        Map<String, Goods> goodsMap = date();
        Goods goodsApple = goodsMap.get("apple");
        Goods goodsStrawberry = goodsMap.get("strawberry");
        Apple apple = (Apple) goodsApple.getGoodsName();
        Strawberry strawberry = (Strawberry) goodsStrawberry.getGoodsName();

        //顾客A,购买5斤苹果，5斤草莓，芒果5斤
        Integer appleSum = 5;
        Integer strawberrySum = 5;
        Integer mangoSum = 5;

        //水果斤数为大于等于 0 的整数,
        Integer weight = appleSum + strawberrySum + mangoSum;
        if (weight > 0 || weight == 0) {

            //购买苹果金额
            Double appleMoney = apple.getPrice() * appleSum;
            //购买草莓金额,草莓打8折
            Double strawberryMoney = strawberry.getPrice() * strawberrySum ;
            //购买芒果金额
            Double mangoMoney = mango.getPrice() * mangoSum;
            //总价
            Double total = 0.00;
            total = appleMoney + strawberryMoney + mangoMoney;
            // 购满100减去10元
            Double suitMoney = 100.00;
            Double maxOutMoney = 10.00;
            if (total > suitMoney || total == suitMoney) {


                // 满减后合价
                Double money = total - maxOutMoney;

                //付款，找还剩下金额
                Double balance = customer.getMoney() - money;
                //输出
                System.out.println(customer.getUsername() + "购买商品为:");
                System.out.println("苹果：" + appleSum + "斤  |  每斤单价： " + apple.getPrice() + "元  |  合计为：" + appleMoney + "元;");
                System.out.println("草莓: " + strawberrySum + "斤  |  每斤单价： " + strawberry.getPrice() + "元  | 合价为:  " + strawberryMoney + "元;");
                System.out.println("芒果: " + mangoSum + "斤  |  每斤单价： " + mango.getPrice() + "元  | 合价为:  " + mangoMoney + "元;");



                System.out.println("货物总价格为： " + total + "元;");
                System.out.println("满减后总价格："+money+"元");

                System.out.println("实际支付金额：" + customer.getMoney() + "元，应找还余额：" + balance + "元。");

            }else {

                //付款，找还剩下金额
                Double balance = customer.getMoney() - total;
                //输出
                System.out.println(customer.getUsername() + "购买商品为:");
                System.out.println("苹果：" + appleSum + "斤  |  每斤单价： " + apple.getPrice() + "元  |  合计为：" + appleMoney + "元;");
                System.out.println("草莓: " + strawberrySum + "斤  |  每斤单价： " + strawberry.getPrice() + "元 | 合价为:  " + strawberryMoney + "元;");
                System.out.println("芒果: " + mangoSum + "斤  |  每斤单价： " + mango.getPrice() + "元  | 合价为:  " + mangoMoney + "元;");
                System.out.println("货物总价格为： " + total + "元;");
                System.out.println("实际支付金额：" + customer.getMoney() + "元，应找还余额：" + balance + "元。");

            }


        }
    }


    /*
     * 需求四：打折，加上满减
     * */
    public static void  fourTest() {

        //添加一种水果： 芒果
        Mango mango = addMango();

        Customer customer = new Customer("4", "顾客D", 200.00, new Date());

        //购买货物
        Map<String, Goods> goodsMap = date();
        Goods goodsApple = goodsMap.get("apple");
        Goods goodsStrawberry = goodsMap.get("strawberry");
        Apple apple = (Apple) goodsApple.getGoodsName();
        Strawberry strawberry = (Strawberry) goodsStrawberry.getGoodsName();

        //顾客A,购买5斤苹果，5斤草莓，芒果5斤
        Integer appleSum = 5;
        Integer strawberrySum = 5;
        Integer mangoSum = 5;

        // 折扣:80%
        Double discount = 0.80;
        //水果斤数为大于等于 0 的整数,
        Integer weight = appleSum + strawberrySum + mangoSum;
        if (weight > 0 || weight == 0) {

            //购买苹果金额
            Double appleMoney = apple.getPrice() * appleSum;
            //购买草莓金额,草莓打8折
            Double strawberryMoney = strawberry.getPrice() * strawberrySum * discount;
            //购买芒果金额
            Double mangoMoney = mango.getPrice() * mangoSum;
            //总价
            Double total = 0.00;
            total = appleMoney + strawberryMoney + mangoMoney;
            // 购满100减去10元
            Double suitMoney = 100.00;
            Double maxOutMoney = 10.00;
            if (total > suitMoney || total == suitMoney) {

                // 满减后合价
                Double money = total - maxOutMoney;

                //付款，找还剩下金额
                Double balance = customer.getMoney() - money;

                //输出
                System.out.println(customer.getUsername() + "购买商品为:");
                System.out.println("苹果：" + appleSum + "斤  |  每斤单价： " + apple.getPrice() + "元  |  合计为：" + appleMoney + "元;");
                System.out.println("草莓: " + strawberrySum + "斤  |  每斤单价： " + strawberry.getPrice() + "元,折扣率：" + discount + " | 合价为:  " + strawberryMoney + "元;");
                System.out.println("芒果: " + mangoSum + "斤  |  每斤单价： " + mango.getPrice() + "元  | 合价为:  " + mangoMoney + "元;");

                System.out.println("货物总价格为： " + total + "元;");
                System.out.println("满减后总价格："+money+"元");
                System.out.println("实际支付金额：" + customer.getMoney() + "元，应找还余额：" + balance + "元。");

            }else {

                //付款，找还剩下金额
                Double balance = customer.getMoney() - total;
                //输出
                System.out.println(customer.getUsername() + "购买商品为:");
                System.out.println("苹果：" + appleSum + "斤  |  每斤单价： " + apple.getPrice() + "元  |  合计为：" + appleMoney + "元;");
                System.out.println("草莓: " + strawberrySum + "斤  |  每斤单价： " + strawberry.getPrice() + "元,折扣率：" + discount + " | 合价为:  " + strawberryMoney + "元;");
                System.out.println("芒果: " + mangoSum + "斤  |  每斤单价： " + mango.getPrice() + "元  | 合价为:  " + mangoMoney + "元;");
                System.out.println("货物总价格为： " + total + "元;");
                System.out.println("实际支付金额：" + customer.getMoney() + "元，应找还余额：" + balance + "元。");

            }


        }
    }

    /*
     * 需求三：
     * */
    public static void  threeTest(){

        //添加一种水果： 芒果
        Mango mango = addMango();

        Customer customer = new Customer("3","顾客C",200.00,new Date());

        //购买货物
        Map<String, Goods> goodsMap = date();
        Goods goodsApple = goodsMap.get("apple");
        Goods goodsStrawberry = goodsMap.get("strawberry");
        Apple apple = (Apple) goodsApple.getGoodsName();
        Strawberry strawberry = (Strawberry) goodsStrawberry.getGoodsName();

        //顾客A,购买5斤苹果，5斤草莓，芒果5斤
        Integer appleSum = 5;
        Integer strawberrySum = 5;
        Integer mangoSum = 5;

        // 折扣:80%
        Double discount = 0.80;
        //水果斤数为大于等于 0 的整数,
        Integer weight = appleSum +strawberrySum+mangoSum;
        if (weight >0 || weight == 0){

            //购买苹果金额
            Double appleMoney = apple.getPrice() * appleSum;
            //购买草莓金额,草莓打8折
            Double strawberryMoney = strawberry.getPrice()*strawberrySum*discount;
            //购买芒果金额
            Double mangoMoney = mango.getPrice() * mangoSum;

            //总价
            Double total = 0.00;
            total = appleMoney +strawberryMoney + mangoMoney;
            //付款，找还剩下金额
            Double  balance= customer.getMoney()-total;
            //输出
            System.out.println(customer.getUsername()+"购买商品为:" );
            System.out.println("苹果："+appleSum+"斤  |  每斤单价： "+apple.getPrice()+"元  |  合计为："+appleMoney+"元;" );
            System.out.println( "草莓: "+strawberrySum+"斤  |  每斤单价： "+strawberry.getPrice()+"元,折扣率："+discount+" | 合价为:  "+strawberryMoney+"元;");
            System.out.println( "芒果: "+mangoSum+"斤  |  每斤单价： "+mango.getPrice()+"元  | 合价为:  "+mangoMoney+"元;");

            System.out.println("货物总价格为： " + total + "元;");
            System.out.println("实际支付金额："+customer.getMoney()+"元，应找还余额："+balance+"元。");
        }

    }
    /*
     * 需求二：
     * */
    public static void  twoTest(){

        //添加一种水果： 芒果
        Mango mango = addMango();

        Customer customer = new Customer("2","顾客B",500.00,new Date());

        //购买货物
        Map<String, Goods> goodsMap = date();
        Goods goodsApple = goodsMap.get("apple");
        Goods goodsStrawberry = goodsMap.get("strawberry");
        Apple apple = (Apple) goodsApple.getGoodsName();
        Strawberry strawberry = (Strawberry) goodsStrawberry.getGoodsName();

        //顾客A,购买5斤苹果，5斤草莓
        Integer appleSum = 5;
        Integer strawberrySum = 5;
        Integer mangoSum = 5;
        //水果斤数为大于等于 0 的整数,
        Integer weight = appleSum +strawberrySum+mangoSum;
        if (weight >0 || weight == 0){

            //购买苹果金额
            Double appleMoney = apple.getPrice() * appleSum;
            //购买草莓金额
            Double strawberryMoney = strawberry.getPrice()*strawberrySum;
            //购买芒果金额
            Double mangoMoney = mango.getPrice() * mangoSum;

            //总价
            Double total = 0.00;
            total = appleMoney +strawberryMoney + mangoMoney;
            //付款，找还剩下金额
            Double  balance= customer.getMoney()-total;
            //输出
            System.out.println(customer.getUsername()+"购买商品为:" );
            System.out.println("苹果："+appleSum+"斤  |  每斤单价： "+apple.getPrice()+"元  |  合计为："+appleMoney+"元;" );
            System.out.println( "草莓: "+strawberrySum+"斤  |  每斤单价： "+strawberry.getPrice()+"元  | 合价为:  "+strawberryMoney+"元;");
            System.out.println( "芒果: "+mangoSum+"斤  |  每斤单价： "+mango.getPrice()+"元  | 合价为:  "+mangoMoney+"元;");
            System.out.println("货物总价格为： " + total + "元;");
            System.out.println("实际支付金额："+customer.getMoney()+"元，应找还余额："+balance+"元。");
        }

    }

    /*
     * 需求一：
     * */
    public  static void  oneTest(){
        Map<String, Goods> goodsMap = date();
        Goods goodsApple = goodsMap.get("apple");
        Goods goodsStrawberry = goodsMap.get("strawberry");
        Apple apple = (Apple) goodsApple.getGoodsName();
        Strawberry strawberry = (Strawberry) goodsStrawberry.getGoodsName();
        //需求一
        Customer customerA = new Customer("1","顾客A",200.00,new Date());
        //水果斤数为大于等于 0 的整数
        Integer appleSum = 5;
        Integer strawberrySum = 5;
        Integer weight = appleSum +strawberrySum;
        if (weight >0 || weight == 0){
            //顾客A,购买5斤苹果，5斤草莓
            Double appleWeight = appleSum*500.00;
            Double strawberryWeight = strawberrySum*500.00;

            //购买苹果金额
            Double appleMoney = apple.getPrice() * appleSum;
            //购买草莓金额
            Double strawberryMoney = strawberry.getPrice()*strawberrySum;

            //总价
            Double total = 0.00;
            total = appleMoney +strawberryMoney;
            //付款，找还剩下金额
            Double  balance= customerA.getMoney()-total;
            //输出
            System.out.println(customerA.getUsername()+"购买商品为:" );
            System.out.println("苹果："+appleSum+"斤  |  每斤单价： "+apple.getPrice()+"元  |  合计为："+appleMoney+"元;" );
            System.out.println( "草莓: "+strawberrySum+"斤  |  每斤单价： "+strawberry.getPrice()+"元  | 合价为:  "+strawberryMoney+"元;");
            System.out.println("货物总价格为： " + total + "元;");
            System.out.println("实际支付金额："+customerA.getMoney()+"元，应找还余额："+balance+"元。");
        }

    }




    /*
     * 自动封装假数据
     * */
    public static  Map<String, Goods> date(){
        Date date = new Date();
        //添加苹果、草莓数据
        Apple apple = new Apple("1","苹果",100.00,8.00,date);
        Strawberry strawberry = new Strawberry("1","草莓",100.00,13.00,date);

        Map<String, Goods> goodsMap = new HashMap<>();
        Goods goodsApple = new Goods(apple);

        Goods goodsSafeVarargs = new Goods(strawberry);
        goodsMap.put("apple",goodsApple);
        goodsMap.put("strawberry",goodsSafeVarargs);

        return goodsMap;

    }


    /*
     * 添加水果：芒果
     * */
    public static Mango addMango(){
        Date date = new Date();
        Mango mango = new Mango("1", "芒果", 100.00, 20.00, date);
        return mango;
    }
}