package conversormonetario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import command.ActionListenerFactory;
import command.CalculateCommand;
import command.Command;
import command.CommandDictionary;
import controller.ConsoleChangeRateController;
import vistadepersistenca.ChangeRateLoader;
import vistadepersistenca.CurrencySetLoader;
import vistadepersistenca.FileCurrencySetLoader;
import vistadepersistenca.InternetChangeRateLoader;
import vistainteraccionusuario.CurrencyDialog;
import vistainteraccionusuario.MoneyDialog;
import vistainteraccionusuario.MoneyViewer;
import vistaconsolausuario.ConsoleCurrencyDialog;
import vistaconsolausuario.ConsoleMoneyDialog;
import vistaconsolausuario.ConsoleMoneyViewer;
import vistabalanceusuario.ApplicationFrame;

public class aplicacion extends AppMoney{

	 public static void main(String[] args) {

	 }

	    @SuppressWarnings("unused")
		private static void runAppUnderConsole(final String file) {
	        CurrencySetLoader currencySetLoader = new FileCurrencySetLoader(file);
	        ChangeRateLoader changeRateLoader = new InternetChangeRateLoader();
	        MoneyDialog moneyDialog = new ConsoleMoneyDialog();
	        MoneyViewer moneyViewer = new ConsoleMoneyViewer();
	        CurrencyDialog currencyDialog = new ConsoleCurrencyDialog();

	        ConsoleChangeRateController controller = new ConsoleChangeRateController(currencySetLoader, changeRateLoader,
	                moneyDialog, moneyViewer, currencyDialog);
	        controller.execute();
	    }

	    private static void AppMoney (String file) {
	        final CommandDictionary commandDictionary = new CommandDictionary();
	        CurrencySetLoader currencySetLoader = new FileCurrencySetLoader(file);
	        ChangeRateLoader changeRateLoader = new InternetChangeRateLoader();

	        currencySetLoader.load();;
	        ActionListenerFactory factory = new ActionListenerFactory() {

	            @Override
	            public ActionListener getAction(final String action) {
	                return new ActionListener() {

	                    @Override
	                    public void actionPerformed(ActionEvent ae) {
	                        commandDictionary.get(action).execute();
	                    }
	                };
	            }
	        };

	        final ApplicationFrame frame = new ApplicationFrame(factory);

	        commandDictionary.register("calculate", new CalculateCommand(
	                frame.getMoneyDialog(),
	                frame.getCurrencyDialog(),
	                frame.getDateDialog(),
	                frame.getMoneyViewer(),
	                changeRateLoader));
	        commandDictionary.register("exit", new Command() {

	            @Override
	            public void execute() {
	                frame.dispose();
	            }
	        });
	    }

}

