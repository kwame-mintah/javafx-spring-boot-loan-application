package org.library.dto;

import java.util.Date;

/**
 * Data transfer object (DTO), formerly known as value objects or VO, is a design pattern used to
 * transfer data between software application subsystems. DTOs are often used in conjunction with
 * data access objects to retrieve data from a database.
 */
abstract class AbstractItemDto {
  private String name;
  private String description;
  private String publisher;
  private Integer availableCount;
  private Integer onLoan;
  private String genre;
  private Date releaseDate;

  protected AbstractItemDto(
      final String name,
      final String description,
      final String publisher,
      final Integer availableCount,
      final Integer onLoan,
      final String genre,
      final Date releaseDate) {
    this.name = name;
    this.description = description;
    this.publisher = publisher;
    this.availableCount = availableCount;
    this.onLoan = onLoan;
    this.genre = genre;
    this.releaseDate = releaseDate;
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
}
