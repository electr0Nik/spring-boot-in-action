package com.github.electr0nik.repository.jpa.entity;

import com.github.electr0nik.enums.MediaType;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 * This entity keeps elements you want to process,
 * like cook a meal, read a book, listen to music or watch a movie ...
 *
 * @author nik
 * @since 1.XX-SNAPSHOT
 */
@Entity
public class ProcessEntity implements Serializable {

  @NotNull
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Type(type = "uuid-char")
  private UUID uuid;

  @NotNull
  @Version
  private Long version;

  private String user;
  private String todoTitle;
  private String description;
  private MediaType type;

  private String creationUser;
  /**
   * new date to today on insert
   * {@link NotNull} makes sure, that you cannot save Entity with empty value,
   * but since we don't want to update creationDate,
   * there might be a {@link org.springframework.dao.DataIntegrityViolationException}
   * therefore we have to leave it out, for now
   */
  // @NotNull
  @CreatedDate
  @Column(name = "CREATION_DATE", updatable = false)
  private Date creationDate = new Date();

  /**
   * new date to today on modify;
   * {@link NotNull} makes sure, that you cannot update Entity with empty value,
   * but since we don't want to insert modifyDate,
   * there will be a {@link org.springframework.dao.DataIntegrityViolationException},
   * therefore we have to leave it out, for now
   */
  // @NotNull
  @LastModifiedDate
  @Column(name = "MODIFY_DATE", insertable = false)
  private Date modifyDate = new Date();

  private Date doneDate;

  private Boolean active;


  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getTodoTitle() {
    return todoTitle;
  }

  public void setTodoTitle(String todoTitle) {
    this.todoTitle = todoTitle;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public MediaType getType() {
    return type;
  }

  public void setType(MediaType type) {
    this.type = type;
  }

  public void setType(final String value) {
    this.type = MediaType.getMediaTypeByValue(value);
  }

  public String getCreationUser() {
    return creationUser;
  }

  public void setCreationUser(String creationUser) {
    this.creationUser = creationUser;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public Date getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(Date modifyDate) {
    this.modifyDate = modifyDate;
  }

  public Date getDoneDate() {
    return doneDate;
  }

  public void setDoneDate(Date doneDate) {
    this.doneDate = doneDate;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }
}