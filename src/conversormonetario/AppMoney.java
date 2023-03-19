package conversormonetario;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AppMoney {

	 static double FetchAPI(String localCurrency,String foreignCurrency) throws ParseException, IOException {
	        String link = String.format("https://v6.exchangerate-api.com/v6/f6495a38298023f4e0d50b89/latest/%s", localCurrency);
	        URL url = new URL(link);

	       
	        HttpURLConnection request = (HttpURLConnection) url.openConnection();
	        request.setRequestMethod("GET");
	        request.connect();

	        int responseCode = request.getResponseCode();

	        
	        if (responseCode != 200) {
	            throw new RuntimeException("API Connection failed: " + responseCode);
	        }

	        
	        StringBuilder info = new StringBuilder();
	        Scanner scanner = new Scanner(url.openStream());

	        while (scanner.hasNext()) {
	            info.append(scanner.nextLine());
	        }

	        
	        scanner.close();

	        
	        JSONParser parse = new JSONParser();
	        String singleString = info.toString();
	        JSONObject json = (JSONObject) parse.parse(singleString);

	        
	        JSONObject json2 = (JSONObject) json.get("conversion_rates");

	        double val = (double) json2.get(foreignCurrency);
	        return val;
	    }
	    public static void main(String[] args) throws Exception {
	        
	       
	        JFrame f = new JFrame(); 
	        JButton b = new JButton("click"); 
	        Image icon = Toolkit.getDefaultToolkit().getImage("img\\coin.png");
	        JLabel l = new JLabel();
	        JTextField tf = new JTextField();

	        l.setBounds(110,10,200,20);
	        l.setText("Introduce a value to convert:");
	        l.setForeground(Color.black);
	        f.add(l);

	        tf.setBounds(115,40, 150,20);
	        tf.setHorizontalAlignment(JTextField.CENTER);
	        f.add(tf);

	        b.setBounds(140,70,100, 25);  
	        b.setText("Ok");
	        f.add(b); 

	        f.setTitle("Currency Converter");
	        f.setIconImage(icon);
	        f.setSize(400,150);
	        f.setLocationRelativeTo(null);
	        f.setResizable(false);
	        f.setBackground(Color.black);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setLayout(null); 

	        f.setVisible(true);

	        b.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    String value = tf.getText();
	                    double val = Double.parseDouble(value);
	                    double res;
	                    double ratio;
	                    f.setVisible(false);
	                    
	                    String[] options = {"ARS to USD", "USD to ARS", "ARS to EUR", "EUR to ARS", "ARS to GBP", "GBP to ARS", "ARS to JPY", "JPY to ARS", "ARS to KRW", "KRW to ARS"};

	                    ImageIcon icon = new ImageIcon("img\\coin.png");

	                    String n = (String) JOptionPane.showInputDialog(null, "Select your value conversion",
	                    "Conversion Values", JOptionPane.QUESTION_MESSAGE, icon, options, options[2]);

	                    switch (n) {
	                        case "ARS to USD":
	                            ratio = FetchAPI("ARS","USD");
	                            res = val * ratio;
	                            JOptionPane.showMessageDialog(null,  String.format("%.2f ARS equals to %.2f USD.", val, res));

	                            f.setVisible(true);
	                            break;
	                        case "USD to ARS":
	                            ratio = FetchAPI("USD","ARS");
	                            res = val * ratio;
	                            JOptionPane.showMessageDialog(null,  String.format("%.2f USD equals to %.2f ARS.", val, res));

	                            f.setVisible(true);
	                            break;
	                        case "ARS to EUR":
	                            ratio = FetchAPI("ARS","EUR");
	                            res = val * ratio;
	                            JOptionPane.showMessageDialog(null,  String.format("%.2f ARS equals to %.2f EUR.", val, res));

	                            f.setVisible(true);
	                            break;
	                        case "EUR to ARS":
	                            ratio = FetchAPI("EUR","ARS");
	                            res = val * ratio;
	                            JOptionPane.showMessageDialog(null,  String.format("%.2f EUR equals to %.2f ARS.", val, res));

	                            f.setVisible(true);
	                            break;
	                        case "ARS to GBP":
	                            ratio = FetchAPI("ARS","GBP");
	                            res = val * ratio;
	                            JOptionPane.showMessageDialog(null,  String.format("%.2f ARS equals to %.2f GBP.", val, res));

	                            f.setVisible(true);
	                            break;
	                        case "GBP to ARS":
	                            ratio = FetchAPI("GBP","ARS");
	                            res = val * ratio;
	                            JOptionPane.showMessageDialog(null,  String.format("%.2f GBP equals to %.2f ARS.", val, res));

	                            f.setVisible(true);
	                            break;
	                        case "ARS to JPY":
	                            ratio = FetchAPI("ARS","JPY");
	                            res = val * ratio;
	                            JOptionPane.showMessageDialog(null,  String.format("%.2f ARS equals to %.2f JPY.", val, res));

	                            f.setVisible(true);
	                            break;
	                        case "JPY to ARS":
	                            ratio = FetchAPI("JPY","ARS");
	                            res = val * ratio;
	                            JOptionPane.showMessageDialog(null,  String.format("%.2f JPY equals to %.2f ARS.", val, res));

	                            f.setVisible(true);
	                            break;
	                        case "ARS to KRW":
	                            ratio = FetchAPI("ARS","KRW");
	                            res = val * ratio;
	                            JOptionPane.showMessageDialog(null,  String.format("%.2f ARS equals to %.2f KRW.", val, res));

	                            f.setVisible(true);
	                            break;
	                        case "KRW to ARS":
	                            ratio = FetchAPI("KRW","ARS");
	                            res = val * ratio;
	                            JOptionPane.showMessageDialog(null,  String.format("%.2f KRW equals to %.2f ARS.", val, res));

	                            f.setVisible(true);
	                            break;
	                        default:
	                            f.dispose();
	                            break;
	                    }
	                } catch (Exception ex) {
	                    JOptionPane.showMessageDialog(null, "Please type numbers only!");
	                }
	            }
	        }); 
	    }
	}
