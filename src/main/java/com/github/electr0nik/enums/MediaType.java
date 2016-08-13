package com.github.electr0nik.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author nik
 * @since 1.0.0-SNAPSHOT
 */
public enum MediaType {

  MOVIE("movie", "film", "video", "divx"),
  BOOK("book", "ebook"),
  MUSIC("mp3", "audiobook", "wmv", "music"),
  UNDEFINED();


  private final String[] values;

  MediaType(final String... values) {
    this.values = values;
  }

  public boolean containsAny(final String value) {
    return Arrays.stream(values)
        .map(String::toLowerCase)
        .filter(it -> it.contentEquals(Optional.ofNullable(value).orElse("").toLowerCase()))
        .findAny().isPresent();
  }

  public boolean equals(final String... values) {
    return Arrays.stream(this.values)
        .map(String::toLowerCase)
        .allMatch(it -> Arrays.stream(Optional.ofNullable(values).orElse(new String[]{""}))
            .filter(s -> Optional.ofNullable(s).orElse("").toLowerCase().contentEquals(it))
            .findAny().isPresent());
  }

  public static MediaType getMediaTypeByValue(final String value) {
    return Arrays.stream(MediaType.values())
        .filter(mediaType -> Arrays.stream(mediaType.values)
            .map(String::toLowerCase)
            .filter(v -> v.contentEquals(Optional.ofNullable(value).orElse("").toLowerCase()))
            .findFirst().isPresent())
        .findFirst().orElse(MediaType.UNDEFINED);

  }
}
