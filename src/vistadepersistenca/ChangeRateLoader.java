package vistadepersistenca;

import java.util.Date;

import model.Currency;
import model.ExchangeRate;

public interface ChangeRateLoader {

	public ExchangeRate load(Currency fromCurrency, Currency toCurrency, Date date);

    public ExchangeRate load(Currency fromCurrency, Currency toCurrency);

}
