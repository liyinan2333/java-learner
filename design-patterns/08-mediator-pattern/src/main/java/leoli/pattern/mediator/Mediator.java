package leoli.pattern.mediator;

/**
 * 具体的中介者
 *
 * @author leoli
 * @date 2020/7/31
 */
public class Mediator extends AbstractMediator {

    // 中介者最重要的方法
    @Override
    public void execute(String str, Object... objects) {
        if("purchase.buy".equals(str)) {
            // 采购电脑
            this.buyComputer((Integer)objects[0]);
        } else if("sale.sell".equals(str)) {
            // 销售电脑
            this.sellComputer((Integer)objects[0]);
        } else if("sale.offsell".equals(str)) {
            //折价销售
            this.offSell();
        } else if("stock.clear".equals(str)) {
            // 清仓处理
            this.clearStock();
        }
    }

    private void buyComputer(Integer number) {
        int saleStatus = super.sale.getSaleStatus();
        if (saleStatus > 80) {
            // 销售状况良好
            System.out.println("采购IBM电脑：" + number + "台");
            stock.increase(number);
        } else {
            // 销售情况不好，折半采购
            int buyNumber = number / 2;
            System.out.println("采购IBM电脑：" + buyNumber + "台");
        }
    }

    // 销售电脑
    private void sellComputer(Integer number) {
        // 库存数量不够销售
        if (super.stock.getStockNumber() < number) {
            super.purchase.buyIBMComputer(number);
        }
        super.stock.decrease(number);
    }
    // 折价销售电脑
    private void offSell() {
        System.out.println("折价销售IBM电脑" + stock.getStockNumber() + "台");
    }

    // 清仓处理
    private void clearStock() {
        // 要求清仓销售
        super.sale.offSale();
        // 要求草狗人员不要采购
        super.purchase.refuseBuyIBM();
    }

}
