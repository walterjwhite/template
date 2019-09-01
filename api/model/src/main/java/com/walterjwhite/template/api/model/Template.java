package com.walterjwhite.template.api.model;

import com.walterjwhite.datastore.api.model.entity.AbstractNamedEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(doNotUseGetters = true)
@NoArgsConstructor
// @PersistenceCapable
@Entity
public class Template extends AbstractNamedEntity {
  @Column(nullable = false)
  protected String contents;

  public Template(String name) {
    super(name);
  }

  public Template withContents(String contents) {
    this.contents = contents;
    return this;
  }
}
