package leoli.pattern.mediator;

/**
 * 抽象同事类
 *
 * @author leoli
 * @date 2020/7/31
 */
public abstract class AbstrackColleague {

    protected  AbstractMediator mediator;

    public AbstrackColleague(AbstractMediator _mediator) {
        this.mediator = _mediator;
    }

}
