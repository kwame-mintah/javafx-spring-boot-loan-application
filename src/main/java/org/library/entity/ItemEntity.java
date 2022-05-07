package org.library.entity;

import org.library.dto.ItemDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "items", schema = "public")
public class ItemEntity extends ItemDto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private int id;
  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "description", nullable = false)
  private String description;
  @Column(name = "type", nullable = false)
  private String type;
  @Column(name = "image")
  private String image;
  @Column(name = "availableCount", nullable = false)
  private Integer availableCount;
  @Column(name = "onLoan", nullable = false)
  private Integer onLoan;
  @Column(name = "releaseDate", nullable = false)
  private Date releaseDate;

  public ItemEntity() {
    // no-args constructor for entity
  }

  public int getId() {
    return id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(final String name) {
    this.name = name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public void setDescription(final String description) {
    this.description = description;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public void setType(final String type) {
    this.type = type;
  }

  @Override
  public String getImage() {
    return image;
  }

  @Override
  public void setImage(final String image) {
    this.image = image;
  }

  @Override
  public Integer getAvailableCount() {
    return availableCount;
  }

  @Override
  public void setAvailableCount(final Integer availableCount) {
    this.availableCount = availableCount;
  }

  @Override
  public Integer getOnLoan() {
    return onLoan;
  }

  @Override
  public void setOnLoan(final Integer onLoan) {
    this.onLoan = onLoan;
  }

  @Override
  public Date getReleaseDate() {
    return releaseDate;
  }

  @Override
  public void setReleaseDate(final Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  @Override
  public String toString() {
    return "id=" + id +
            " name=" + name +
            " description=" + description +
            " availableCount=" + availableCount +
            " onLoan=" + onLoan +
            " releaseDate=" + releaseDate;
  }
}