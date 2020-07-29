package leoli.pattern.prototype;

/**
 * 邮件类
 *
 * @author leoli
 * @date 2020/7/29
 */
public class Mail implements Cloneable {

    // 收件人
    private String receiver;
    // 邮件名称
    private String subject;
    // 称谓
    private String name;
    // 邮件内容
    private String context;
    // 邮件的尾部，一般都是加上“xxx版权所有”等信息
    private String tail;

    // 构造函数
    public Mail(AdvTemplate advTemplate) {
        this.subject = advTemplate.getAdvSubject();
        this.context = advTemplate.getAdvContext();
    }

    @Override
    public Mail clone() throws CloneNotSupportedException {
        Mail mail = null;
        mail = (Mail) super.clone();
        return mail;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }
}
