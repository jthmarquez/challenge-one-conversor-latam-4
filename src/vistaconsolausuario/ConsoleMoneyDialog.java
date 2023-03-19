package vistaconsolausuario;

import java.util.Scanner;

import model.Currency;
import model.Money;
import model.Number;
import vistainteraccionusuario.CurrencyDialog;
import vistainteraccionusuario.MoneyDialog;

public class ConsoleMoneyDialog implements MoneyDialog{

	private Money money;

    @Override
    public void show() {
        System.out.println("Introduzca un número:");
        Scanner scanner = new Scanner(System.in);
        Number number = new Number(scanner.nextDouble());
        money = new Money(number, getCurrency());
    }

    @Override
    public Money getMoney() {
        return money;
    }

    private Currency getCurrency() {
        CurrencyDialog dialog = new ConsoleCurrencyDialog();
        dialog.show();
        return dialog.getCurrency();
    }
}
