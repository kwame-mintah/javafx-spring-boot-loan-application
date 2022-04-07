package org.library.dto;

import java.util.Date;

public class VideoGameDto extends AbstractItemDto {
  private boolean digitalCopy;
  private String ageRating;

  protected VideoGameDto(
      final String name,
      final String description,
      final Integer availableCount,
      final Integer onLoan,
      final Date releaseDate,
      final boolean digitalCopy,
      final String ageRating) {
    super(name, description, availableCount, onLoan, releaseDate);
    this.digitalCopy = digitalCopy;
    this.ageRating = ageRating;
  }

  public boolean isDigitalCopy() {
    return digitalCopy;
  }

  public void setDigitalCopy(final boolean digitalCopy) {
    this.digitalCopy = digitalCopy;
  }

  public String getAgeRating() {
    return ageRating;
  }

  public void setAgeRating(final String ageRating) {
    this.ageRating = ageRating;
  }
}
