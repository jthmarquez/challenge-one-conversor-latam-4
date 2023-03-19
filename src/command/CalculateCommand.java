package command;

import model.ExchangeRate;
import model.Money;
import model.MoneyExchanger;
import vistadepersistenca.ChangeRateLoader;
import vistainteraccionusuario.CurrencyDialog;
import vistainteraccionusuario.DateDialog;
import vistainteraccionusuario.MoneyDialog;
import vistainteraccionusuario.MoneyViewer;

public class CalculateCommand extends Command {

	  private final MoneyDialog moneyDialog;
	  private final CurrencyDialog currencyDialog;
	  private final DateDialog dateDialog;
	  private final MoneyViewer moneyViewer;
	  private final ChangeRateLoader changeRateLoader;
	  
	  public CalculateCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, DateDialog dateDialog, MoneyViewer moneyViewer, ChangeRateLoader changeRateLoader) {
		    this.moneyDialog = moneyDialog;
		    this.currencyDialog = currencyDialog;
		    this.changeRateLoader = changeRateLoader;
		    this.dateDialog = dateDialog;
		    this.moneyViewer = moneyViewer;
	  }
		    
		    @Override
		    public void execute() {
		        Money money = moneyDialog.getMoney();
		        ExchangeRate rate = changeRateLoader.load(money.getCurrency(), currencyDialog.getCurrency(), dateDialog.getDate());
		        Money resultingMoney = MoneyExchanger.exchange(money.getAmount(), rate);
		        moneyViewer.setMoney(resultingMoney);
		        moneyViewer.show();
		    }
}
