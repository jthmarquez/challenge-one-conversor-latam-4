package vistabalanceusuario;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import model.Currency;
import model.CurrencySet;
import vistainteraccionusuario.CurrencyDialog;

public class CurrencyDialogPanel extends JPanel implements CurrencyDialog{

	 private Currency currency;

	    public CurrencyDialogPanel() {
	        super(new FlowLayout(FlowLayout.LEFT));
	    }

	    @Override
	    public void show() {
	        this.add(createComboBox());
	    }

	    private JComboBox createComboBox() {
	        final JComboBox comboBox = new JComboBox();
	        fillComboBox(comboBox);
	        setInitialItem(comboBox);
	        comboBox.addItemListener(new ItemListener() {
	            @Override
	            public void itemStateChanged(ItemEvent ie) {
	                if (ie.getStateChange() != ItemEvent.SELECTED) {
	                    currency = CurrencySet.getInstance().search((String) comboBox.getSelectedItem())[0];
	                }
	                return;
	            }
	        });
	        return comboBox;
	    }

	    @Override
	    public Currency getCurrency() {
	        return currency;
	    }

	    private void fillComboBox(JComboBox comboBox) {
	        for (Currency currency : CurrencySet.getInstance())
	            comboBox.addItem(currency.getCode());
	    }

	    private void setInitialItem(JComboBox comboBox) {
	        comboBox.setSelectedIndex(0);
	        currency = CurrencySet.getInstance().search((String) comboBox.getSelectedItem())[0];
	    }
}
