package org.library.dto;

import java.util.Date;

/**
 * Data transfer object (DTO), formerly known as value objects or VO, is a design pattern used to
 * transfer data between software application subsystems. DTOs are often used in conjunction with
 * data access objects to retrieve data from a database.
 */
abstract class AbstractItemDto {
  private final String name;
  private final String description;
  private final String publisher;
  private final Integer availableCount;
  private final Integer onLoan;
  private final String genre;
  private final Date releaseDate;

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

  public String getDescription() {
    return description;
  }

  public String getPublisher() {
    return publisher;
  }

  public Integer getAvailableCount() {
    return availableCount;
  }

  public Integer getOnLoan() {
    return onLoan;
  }

  public String getGenre() {
    return genre;
  }

  public Date getReleaseDate() {
    return releaseDate;
  }
}
