package me.team.usercrud.user.infrastructure.hibernate;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

import java.util.Objects;

@Builder
@Entity
@Table(name="Users")
public final class UserEntity {
    @Id
    private String id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String creationTime;
    private String lastEditTime;

    public UserEntity(String id, String name, String surname, String email, String password, String creationTime, String lastEditTime) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.creationTime = creationTime;
        this.lastEditTime = lastEditTime;
    }

    public UserEntity() {}

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
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

    public String creationTime() {
        return creationTime;
    }

    public void creationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String lastEditTime() {
        return lastEditTime;
    }

    public void lastEditTime(String lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, password);
    }
}
