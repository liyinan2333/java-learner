package leoli.pattern.observer.demo.observer;

/**
 * @author leoli
 * @date 2020/9/1
 */
public class WangSi implements Observer {

    //王斯，看到韩非子有活动
    public void update(String str) {
        System.out.println("王斯：观察到韩非子活动，自己也开始活动了...");
        this.cry(str);
        System.out.println("王斯：哭死了...\n");
    }

    //一看韩非子有活动，他就痛哭
    private void cry(String context) {
        System.out.println("王斯：因为" + context + "，--所以我悲伤呀！");
    }


}
