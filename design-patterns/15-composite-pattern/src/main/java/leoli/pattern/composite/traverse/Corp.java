package leoli.pattern.composite.traverse;

/**
 * 抽象构件
 *
 * @author leoli
 * @date 2020/8/30
 */
public abstract class Corp {

    /**
     * 甭管是树枝节点还是树叶节点，在每个节点都增加了
     * 一个属性：父节点对象
     */

    //公司每个人都有名称
    private String name = "";
    //公司每个人都职位
    private String position = "";
    //公司每个人都有薪水
    private int salary = 0;
    //父节点是谁
    private Corp parent = null;

    public Corp(String _name, String _position, int _salary) {
        this.name = _name;
        this.position = _position;
        this.salary = _salary;
    }

    //获得员工信息
    public String getInfo() {
        String info = "";
        info = "姓名：" + this.name;
        info = info + "\t职位：" + this.position;
        info = info + "\t薪水：" + this.salary;
        return info;
    }

    //设置父节点
    protected void setParent(Corp _parent) {
        this.parent = _parent;
    }

    //得到父节点
    public Corp getParent() {
        return this.parent;
    }

}
