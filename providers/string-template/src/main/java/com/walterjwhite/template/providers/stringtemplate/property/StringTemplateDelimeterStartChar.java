package com.walterjwhite.template.providers.stringtemplate.property;

import com.walterjwhite.google.guice.property.property.DefaultValue;
import com.walterjwhite.google.guice.property.property.GuiceProperty;

public interface StringTemplateDelimeterStartChar extends GuiceProperty {
  @DefaultValue char Default = '$';
}
