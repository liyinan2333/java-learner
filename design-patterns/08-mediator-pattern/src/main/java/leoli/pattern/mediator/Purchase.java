package leoli.pattern.mediator;

/**
 * 采购管理
 *
 * @author leoli
 * @date 2002/7/29
 */
public class Purchase extends AbstrackColleague {

    public Purchase(AbstractMediator _mediator) {
        super(_mediator);
    }

    // 采购IBM电脑
    public void buyIBMComputer(int number) {
        super.mediator.execute("purchase.buy", number);
    }

    // 不再采购IBM电脑
    public void refuseBuyIBM() {
        System.out.println("不再采购IBM电脑");
    }

}
