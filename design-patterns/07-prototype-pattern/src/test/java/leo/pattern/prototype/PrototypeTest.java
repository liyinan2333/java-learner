package leo.pattern.prototype;

import leoli.pattern.prototype.AdvTemplate;
import leoli.pattern.prototype.Mail;
import org.junit.Test;

import java.util.Random;

/**
 * 原型模式测试类
 *
 * @author leoli
 * @date 2020/7/29
 */
public class PrototypeTest {

    // 发送账单的数量，这个值是从数据库中获得
    private static int MAX_COUNT = 6;

    @Test
    public void testPrototypePattern() throws CloneNotSupportedException {

        // 模拟发送邮件
        int i = 0;
        // 把模板定义出来，这个是从数据库中获得
        Mail mail = new Mail(new AdvTemplate());
        mail.setTail("xx银行版权所有");
        while (i++ < MAX_COUNT) {
            Mail cloneMail = mail.clone();
            // 以下是每封邮件不同的地方
            cloneMail.setName(getRandString(5) + " 先生（女士）");
            cloneMail.setReceiver(getRandString(5) + "@" + getRandString(8) + ".com");
            // 发送邮件
            sendMail(cloneMail);
        }

    }

    // 发送邮件
    private void sendMail(Mail mail) {

        System.out.println("标题：" + mail.getSubject() + "\t收件人：" + mail.getReceiver() + "\t... 发送成功！");

    }

    // 获得指定长度的随机字符串
    private String getRandString(int maxLength) {

        String source = "abcedfghijklmnopqrskuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < maxLength; i++) {
            sb.append(source.charAt(random.nextInt(source.length())));
        }
        return sb.toString();

    }

}
