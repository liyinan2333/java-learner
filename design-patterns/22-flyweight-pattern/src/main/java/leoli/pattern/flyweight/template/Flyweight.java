package leoli.pattern.flyweight.template;

/**
 * 抽象享元角色
 *
 * @author leoli
 * @date 2020/9/28
 */
public abstract class Flyweight {

    //内部状态
    private String intrinsic;
    //外部状态
    protected final String Extrinsic;

    //要求享元角色必须接受外部状态
    public Flyweight(String _Extrinsic){
        this.Extrinsic = _Extrinsic;
    }

    //定义业务操作
    public abstract void operate();

    //内部状态的getter/setter
    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}