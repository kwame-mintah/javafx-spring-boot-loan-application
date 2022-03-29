package org.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "items", schema = "public")
public class ItemEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private int id;
  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "description", nullable = false)
  private String description;
  @Column(name = "publisher", nullable = false)
  private String publisher;
  @Column(name = "availableCount", nullable = false)
  private Integer availableCount;
  @Column(name = "onLoan", nullable = false)
  private Integer onLoan;
  @Column(name = "genre")
  private String genre;
  @Column(name = "releaseDate", nullable = false)
  private Date releaseDate;

  public int getId() {
    return id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(final String publisher) {
    this.publisher = publisher;
  }

  public Integer getAvailableCount() {
    return availableCount;
  }

  public void setAvailableCount(final Integer availableCount) {
    this.availableCount = availableCount;
  }

  public Integer getOnLoan() {
    return onLoan;
  }

  public void setOnLoan(final Integer onLoan) {
    this.onLoan = onLoan;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(final String genre) {
    this.genre = genre;
  }

  public Date getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(final Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  @Override
  public String toString() {
    return "id=" + id +
            " name=" + name +
            " description=" + description +
            " publisher=" + publisher +
            " availableCount=" + availableCount +
            " onLoan=" + onLoan +
            " genre=" + genre +
            " releaseDate=" + releaseDate;
  }
}