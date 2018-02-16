package com.walterjwhite.template.providers.stringtemplate.service;

import com.google.inject.Injector;
import com.walterjwhite.google.guice.GuiceHelper;
import com.walterjwhite.google.guice.property.test.GuiceTestModule;
import com.walterjwhite.template.api.model.Template;
import com.walterjwhite.template.api.service.TemplateService;
import com.walterjwhite.template.providers.stringtemplate.StringTemplateModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringTemplateTemplateServiceTest {
  private static final Logger LOGGER =
      LoggerFactory.getLogger(StringTemplateTemplateServiceTest.class);

  protected Injector injector;
  protected TemplateService templateService;

  @Before
  public void onBefore() {
    GuiceHelper.addModules(
        new StringTemplateModule(),
        new GuiceTestModule(
            new Reflections(
                "com.walterjwhite",
                TypeAnnotationsScanner.class,
                SubTypesScanner.class,
                FieldAnnotationsScanner.class)));

    GuiceHelper.setup();
    injector = GuiceHelper.getGuiceInjector();
    templateService = injector.getInstance(TemplateService.class);
  }

  @Test
  public void basicTest() {
    Template template = new Template();
    template.setContents("Hi $ValueObject.name$");

    final ValueObject valueObject = new ValueObject();
    valueObject.setName("Fred");

    final String rendered = templateService.apply(template, valueObject);
    Assert.assertEquals("Hi Fred", rendered);

    LOGGER.info("rendered:" + rendered);
  }
}
