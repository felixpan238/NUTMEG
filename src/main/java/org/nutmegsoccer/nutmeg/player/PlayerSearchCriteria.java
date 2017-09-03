package org.nutmegsoccer.nutmeg.player;

public class PlayerSearchCriteria {

    private String firstName;

    private String lastName;

    private String gender;

    private String birthdayStartsWith;

    private String birthdayEndsWith;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdayStartsWith() {
        return birthdayStartsWith;
    }

    public void setBirthdayStartsWith(String birthdayStartsWith) {
        this.birthdayStartsWith = birthdayStartsWith;
    }

    public String getBirthdayEndsWith() {
        return birthdayEndsWith;
    }

    public void setBirthdayEndsWith(String birthdayEndsWith) {
        this.birthdayEndsWith = birthdayEndsWith;
    }
}