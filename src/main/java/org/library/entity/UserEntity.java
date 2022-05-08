package org.library.entity;

import org.library.dto.UserDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users", schema = "public")
public class UserEntity extends UserDto {
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

  @Override
  public int getUserId() {
    return userId;
  }

  @Override
  public void setUserId(final int userId) {
    this.userId = userId;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public void setUsername(final String username) {
    this.username = username;
  }

  @Override
  public String getFirstname() {
    return firstname;
  }

  @Override
  public void setFirstname(final String firstname) {
    this.firstname = firstname;
  }

  @Override
  public String getLastname() {
    return lastname;
  }

  @Override
  public void setLastname(final String lastname) {
    this.lastname = lastname;
  }

  @Override
  public String getEmail() {
    return email;
  }

  @Override
  public void setEmail(final String email) {
    this.email = email;
  }

  @Override
  public String getRole() {
    return role;
  }

  @Override
  public void setRole(final String role) {
    this.role = role;
  }

  @Override
  public Boolean getEnabled() {
    return enabled;
  }

  @Override
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