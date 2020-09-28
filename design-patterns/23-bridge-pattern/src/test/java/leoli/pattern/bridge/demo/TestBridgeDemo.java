package leoli.pattern.bridge.demo;

import junit.framework.TestCase;
import leoli.pattern.bridge.demo.corp.Corp;
import leoli.pattern.bridge.demo.corp.HouseCorp;
import leoli.pattern.bridge.demo.corp.ShanZhaiCorp;
import leoli.pattern.bridge.demo.product.Clothes;
import leoli.pattern.bridge.demo.product.House;
import leoli.pattern.bridge.demo.product.IPod;
import leoli.pattern.bridge.demo.product.Product;
import org.junit.Test;

/**
 * 桥梁模式-Demo-演示
 *
 * @author leoli
 * @date 2020/9/28
 */
public class TestBridgeDemo extends TestCase {

    @Test
    public void testBridgeDemo() {

        House house = new House();
        System.out.println("-------房地产公司是这样运行的-------");

        //先找到房地产公司
        HouseCorp houseCorp = new HouseCorp(house);
        //看我怎么挣钱
        houseCorp.makeMoney();
        System.out.println("\n");

        //山寨公司生产的产品很多， 不过我只要指定产品就成了
        System.out.println("-------山寨公司是这样运行的-------");
        ShanZhaiCorp shanZhaiCorp = new ShanZhaiCorp(new IPod());
        shanZhaiCorp.makeMoney();

    }

    @Test
    public void testBridgeDemo2() {

        House house = new House();
        System.out.println("-------房地产公司是这样运行的-------");

        //先找到房地产公司
        HouseCorp houseCorp =new HouseCorp(house);
        //看我怎么挣钱
        houseCorp.makeMoney();
        System.out.println("\n");

        //山寨公司生产的产品很多， 不过我只要指定产品就成了
        System.out.println("-------山寨公司是这样运行的-------");
        ShanZhaiCorp shanZhaiCorp = new ShanZhaiCorp(new Clothes());
        shanZhaiCorp.makeMoney();

    }

}
