package me.team.usercrud.shared.infrastructure.dto;

import java.util.Objects;

public class UserDto {
    private String id;
    private String name;
    private String surname;
    private String email;
    private String password;

    public UserDto(String id, String name, String surname, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public String id() {
        return id;
    }

    public void id(String uuid) {
        this.id = uuid;
    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public String surname() {
        return surname;
    }

    public void surname(String surname) {
        this.surname = surname;
    }

    public String email() {
        return email;
    }

    public void email(String email) {
        this.email = email;
    }

    public String password() {
        return password;
    }

    public void password(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
