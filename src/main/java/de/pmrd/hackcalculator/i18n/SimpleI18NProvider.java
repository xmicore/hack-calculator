package de.pmrd.hackcalculator.i18n;

import com.vaadin.flow.i18n.I18NProvider;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class SimpleI18NProvider implements I18NProvider {

  private Logger log = LoggerFactory.getLogger(SimpleI18NProvider.class);

  public static final String BUNDLE_PREFIX = "translate";

  @Override
  public List<Locale> getProvidedLocales() {
    return List.of(Locale.GERMAN);
  }

  @Override
  public String getTranslation(String key, Locale locale, Object... params) {
    Assert.notNull(key, "Got lang request for key with null value!");
    String value;
    try {
      ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_PREFIX, locale);
      value = MessageFormat.format(bundle.getString(key), params);
    } catch (MissingResourceException e) {
      log.warn("Missing resource", e);
      value = key;
    }
    return value;
  }
}
