package org.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "user_accounts", schema = "public")
public class UserEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "userId", nullable = false )
  private int userId;
  @Column(name = "username", nullable = false)
  private String username;
  @Column(name = "firstname", nullable = false)
  private String firstname;
  @Column(name = "lastname", nullable = false)
  private String lastname;
  @Column(name = "email", nullable = false)
  private String email;
  @Column(name = "role", nullable = false)
  private String role;
  @Column(name = "enabled")
  private Boolean enabled;

  public int getUserId() {
    return userId;
  }

  public void setUserId(final int userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(final String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(final String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(final Boolean enabled) {
    this.enabled = enabled;
  }

  @Override
  public String toString() {
    return "UserId=" + userId +
            " username=" + username +
            " firstname=" + firstname +
            " lastname=" + lastname +
            " role=" + role +
            "email=" + email;
  }
}