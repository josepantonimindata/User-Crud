package me.team.usercrud.user.domain;

import me.team.usercrud.shared.domain.AggregateRoot;

import java.util.Objects;

public final class User extends AggregateRoot {
    private final UserId id;
    private UserName name;
    private UserSurname surname;
    private UserEmail email;
    private UserPassword password;

    public User(UserId id, UserName name, UserSurname surname, UserEmail email, UserPassword password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public static User create(UserId id, UserName name, UserSurname surname, UserEmail email, UserPassword password) {
        // Todo: record event of user created
        return new User(id, name, surname, email, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public UserId id() {
        return id;
    }

    public UserName name() {
        return name;
    }

    public void name(UserName name) {
        this.name = name;
    }

    public UserSurname surname() {
        return surname;
    }

    public void surname(UserSurname surname) {
        this.surname = surname;
    }

    public UserEmail email() {
        return email;
    }

    public void email(UserEmail email) {
        this.email = email;
    }

    public UserPassword password() {
        return password;
    }

    public void password(UserPassword password) {
        this.password = password;
    }
}
