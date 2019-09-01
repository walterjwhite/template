package com.walterjwhite.template.providers.stringtemplate;

import com.google.inject.AbstractModule;
import com.walterjwhite.template.api.service.TemplateService;
import com.walterjwhite.template.providers.stringtemplate.service.StringTemplateTemplateService;

public class StringTemplateModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(TemplateService.class).to(StringTemplateTemplateService.class);
  }
}
