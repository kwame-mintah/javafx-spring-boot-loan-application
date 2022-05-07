package org.library.dto;

import java.util.Date;

abstract class AbstractItemDto {
  private String name;
  private String description;
  private String type;
  private String image;
  private Integer availableCount;
  private Integer onLoan;
  private Date releaseDate;

  protected AbstractItemDto(
      final String name,
      final String description,
      final String type,
      final String image,
      final Integer availableCount,
      final Integer onLoan,
      final Date releaseDate) {
    this.name = name;
    this.description = description;
    this.type = type;
    this.image = image;
    this.availableCount = availableCount;
    this.onLoan = onLoan;
    this.releaseDate = releaseDate;
  }

  protected AbstractItemDto() {
     super();
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

  public String getType() {
    return type;
  }

  public void setType(final String type) {
    this.type = type;
  }

  public String getImage() {
    return image;
  }

  public void setImage(final String image) {
    this.image = image;
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

  public Date getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(final Date releaseDate) {
    this.releaseDate = releaseDate;
  }
}
