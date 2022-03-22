package org.library.dto;

import java.util.Date;

public class VideoGameDto extends AbstractItemDto {
  private final boolean digitalCopy;
  private final String ageRating;

  protected VideoGameDto(
      final String name,
      final String description,
      final String publisher,
      final Integer availableCount,
      final Integer onLoan,
      final String genre,
      final Date releaseDate,
      final boolean digitalCopy,
      final String ageRating) {
    super(name, description, publisher, availableCount, onLoan, genre, releaseDate);
    this.digitalCopy = digitalCopy;
    this.ageRating = ageRating;
  }

  public boolean isDigitalCopy() {
    return digitalCopy;
  }

  public String getAgeRating() {
    return ageRating;
  }
}
