package org.library.dto;

import java.util.Date;

public class BookDto extends AbstractItemDto {
  private String author;
  private String isbn;

  protected BookDto(
      final String name,
      final String description,
      final Integer availableCount,
      final Integer onLoan,
      final String author,
      final Date releaseDate,
      final String isbn) {
    super(name, description, availableCount, onLoan, releaseDate);
    this.author = author;
    this.isbn = isbn;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(final String author) {
    this.author = author;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(final String isbn) {
    this.isbn = isbn;
  }
}
