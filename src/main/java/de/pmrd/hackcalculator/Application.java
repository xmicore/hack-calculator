package de.pmrd.hackcalculator;

import de.pmrd.hackcalculator.presenter.converter.HistoryConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application implements WebMvcConfigurer {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(new HistoryConverter());
  }
}
