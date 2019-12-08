package com.shandycasteel.diderot.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name  = "role_id")
  private int id;

  @Column(name = "role")
  @NotEmpty
  private String role;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return role;
  }

  public void setName(String name) {
    this.role = name;
  }

}
