package leoli.pattern.bridge.demo.corp;

import leoli.pattern.bridge.demo.product.House;

/**
 * 房地产公司
 *
 * @author leoli
 * @date 2020/9/28
 */
public class HouseCorp extends Corp {

    //定义传递一个House产品进来
    public HouseCorp(House house) {
        super(house);
    }

    //房地产公司很High了， 赚钱， 计算利润
    public void makeMoney() {
        super.makeMoney();
        System.out.println("房地产公司赚大钱了...");
    }
}