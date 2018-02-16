package com.walterjwhite.template.api.model;

import com.walterjwhite.datastore.api.model.entity.AbstractNamedEntity;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Template extends AbstractNamedEntity {
  @Column(nullable = false)
  protected String contents;

  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }
}
