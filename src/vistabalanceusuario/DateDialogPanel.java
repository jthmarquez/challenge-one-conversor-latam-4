package vistabalanceusuario;

import com.toedter.calendar.JDateChooser;
import java.awt.FlowLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import javax.swing.JPanel;
import vistainteraccionusuario.DateDialog;

public class DateDialogPanel extends JPanel implements DateDialog{

	private Date date;

    public DateDialogPanel() {
        super(new FlowLayout(FlowLayout.LEFT));
        date = new Date();
    }

    @Override
    public void show() {
        this.add(createDataChooser());
    }

    private JDateChooser createDataChooser() {
        final JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDate(new Date());
        dateChooser.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent e) {
                        if ("date".equals(e.getPropertyName()))
                            date = (Date) e.getNewValue();
                    }
                });

        return dateChooser;
    }
    @Override
    public Date getDate() {
        return date;
    }

}
