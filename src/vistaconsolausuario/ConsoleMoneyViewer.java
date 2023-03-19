package vistaconsolausuario;

import model.Money;
import vistainteraccionusuario.MoneyViewer;

public class ConsoleMoneyViewer implements MoneyViewer{

	private Money money;

    public ConsoleMoneyViewer(Money money) {
        this.money = money;
    }

    public ConsoleMoneyViewer() {
    }

    @Override
    public void show() {
        System.out.println(money);
    }

    @Override
    public void setMoney(Money money) {
        this.money = money;
    }
}
