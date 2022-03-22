package org.library.dto;

import java.util.Date;

public class DvdDto extends AbstractItemDto {
  private final String actors;
  private final String studio;

  protected DvdDto(
      final String name,
      final String description,
      final String publisher,
      final Integer onLoan,
      final Integer availableCount,
      final String genre,
      final Date releaseDate,
      final String actors,
      final String studio) {
    super(name, description, publisher, availableCount, onLoan, genre, releaseDate);
    this.actors = actors;
    this.studio = studio;
  }

  public String getActors() {
    return actors;
  }

  public String getStudio() {
    return studio;
  }
}
