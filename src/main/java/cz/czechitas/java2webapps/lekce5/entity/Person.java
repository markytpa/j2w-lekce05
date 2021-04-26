package cz.czechitas.java2webapps.lekce5.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author Filip Jirsák
 */
public class Person {
  private String givenName;
  private String lastName;
  private LocalDate birthDate;

  public Person() {
  }

  public Person(String givenName, String lastName, LocalDate birthDate) {
    this.givenName = givenName;
    this.lastName = lastName;
    this.birthDate = birthDate;
  }

  public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }
}
