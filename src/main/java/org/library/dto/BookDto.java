package org.library.dto;

import java.util.Date;

public class BookDto extends AbstractItemDto {
  private final String author;
  private final String isbn;

  protected BookDto(
      final String name,
      final String description,
      final String publisher,
      final Integer availableCount,
      final Integer onLoan,
      final String genre,
      final String author,
      final Date releaseDate,
      final String isbn) {
    super(name, description, publisher, availableCount, onLoan, genre, releaseDate);
    this.author = author;
    this.isbn = isbn;
  }

  public String getAuthor() {
    return author;
  }

  public String getIsbn() {
    return isbn;
  }
}
