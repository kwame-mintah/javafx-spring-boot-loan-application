package org.library.dto;

import java.util.Date;

public class DvdDto extends AbstractItemDto {
  private String actors;
  private String studio;

  protected DvdDto(
      final String name,
      final String description,
      final Integer onLoan,
      final Integer availableCount,
      final Date releaseDate,
      final String actors,
      final String studio) {
    super(name, description, availableCount, onLoan, releaseDate);
    this.actors = actors;
    this.studio = studio;
  }

  public String getActors() {
    return actors;
  }

  public void setActors(final String actors) {
    this.actors = actors;
  }

  public String getStudio() {
    return studio;
  }

  public void setStudio(final String studio) {
    this.studio = studio;
  }
}
