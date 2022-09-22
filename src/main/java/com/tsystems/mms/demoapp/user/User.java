package com.tsystems.mms.demoapp.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Email;

import com.tsystems.mms.demoapp.organizational_unit.OrganizationalUnit;

import java.io.Serializable;

@Entity
@Table(name = "demo_user")
public class User implements Serializable {

  private static final long serialVersionUID = 1715994813284718249L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  protected Long id;

  @Column(name = "email", nullable = false)
  @Email
  @NotBlank
  private String email;
  
  @ManyToOne
  private OrganizationalUnit organizationalUnit;
  
  @Column(name = "first_name", nullable = false)
  private String firtsName;
  
  @Column(name = "surname", nullable = false)
  private String surname;
  
  
  @Column(name ="gender", nullable = false)
  private UserGender gender;
  
  public Long getId() {
    return id;
  } 
  
  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

public String getFirtsName() {
    return firtsName;
}

public void setFirtsName(String firtsName) {
    this.firtsName = firtsName;
}

public String getSurname() {
    return surname;
}

public UserGender getGender() {
    return gender;
}

public void setSurname(String surname) {
    this.surname = surname;
}

public void setGender(UserGender gender) {
    this.gender = gender;
}

public OrganizationalUnit getOrganizationalUnit() {
    return organizationalUnit;
}

public void setOrganizationalUnit(OrganizationalUnit organizationalUnit) {
    this.organizationalUnit = organizationalUnit;
}

}
