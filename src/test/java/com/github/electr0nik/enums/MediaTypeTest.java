package com.github.electr0nik.enums;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author nik
 * @since 1.XX-SNAPSHOT
 */
public class MediaTypeTest {

  @Test
  public void containsAny() throws Exception {
    final String video = "video";
    assertTrue(MediaType.MOVIE.containsAny(video));

    final String movie = "movie";
    assertTrue(MediaType.MOVIE.containsAny(movie));

    final String mp3 = "mp3";
    assertTrue(MediaType.MUSIC.containsAny(mp3));

    final String audioBook = "book";
    assertTrue(MediaType.BOOK.containsAny(audioBook));

    assertFalse(MediaType.BOOK.containsAny(null));
    assertFalse(MediaType.BOOK.containsAny(""));
    assertFalse(MediaType.BOOK.containsAny(video));
  }

  @Test
  public void equals() throws Exception {
    assertTrue(MediaType.MOVIE.equals("Movie", "Film", "Video", "diVX"));

    final String[] movie = {"Movie", "Film", "Video", "diVX"};
    assertTrue(MediaType.MOVIE.equals(movie));

    assertTrue(MediaType.MUSIC.equals("mp3", "audiobook", "wmv", "music"));

    assertTrue(MediaType.BOOK.equals("book", "ebook"));

    assertFalse(MediaType.MUSIC.equals(null));
    assertFalse(MediaType.MOVIE.equals("", null));
    assertFalse(MediaType.BOOK.equals("", "ebook", null));
    assertFalse(MediaType.MOVIE.equals("mp3", "audiobook", "wmv", "music"));
  }

  @Test
  public void getMediaTypeByValue() throws Exception {
    assertThat(MediaType.getMediaTypeByValue("MoVie"), is(MediaType.MOVIE));
    assertThat(MediaType.getMediaTypeByValue("fIlM"), is(MediaType.MOVIE));
    assertThat(MediaType.getMediaTypeByValue("VidEO"), is(MediaType.MOVIE));
    assertThat(MediaType.getMediaTypeByValue("DIVx"), is(MediaType.MOVIE));

    assertThat(MediaType.getMediaTypeByValue("mP3"), is(MediaType.MUSIC));
    assertThat(MediaType.getMediaTypeByValue("AuDioBooK"), is(MediaType.MUSIC));
    assertThat(MediaType.getMediaTypeByValue("WMv"), is(MediaType.MUSIC));
    assertThat(MediaType.getMediaTypeByValue("MuSIc"), is(MediaType.MUSIC));

    assertThat(MediaType.getMediaTypeByValue("bOOk"), is(MediaType.BOOK));
    assertThat(MediaType.getMediaTypeByValue("EbOOk"), is(MediaType.BOOK));

    assertThat(MediaType.getMediaTypeByValue("null"), is(MediaType.UNDEFINED));
    assertThat(MediaType.getMediaTypeByValue(null), is(MediaType.UNDEFINED));
    assertThat(MediaType.getMediaTypeByValue(""), is(MediaType.UNDEFINED));
  }

}