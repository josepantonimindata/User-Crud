package me.team.usercrud.user.domain;

import me.team.usercrud.shared.domain.AggregateRoot;
import me.team.usercrud.shared.domain.services.DatetimeUtils;

import java.util.Objects;

public final class User extends AggregateRoot {
    private final UserId id;
    private UserName name;
    private UserSurname surname;
    private UserEmail email;
    private UserPassword password;
    private UserCreationTime creationTime;
    private UserLastEditTime lastEditTime;

    public User(UserId id, UserName name, UserSurname surname, UserEmail email, UserPassword password, UserCreationTime creationTime, UserLastEditTime lastEditTime) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.creationTime = creationTime;
        this.lastEditTime = lastEditTime;
    }

    public User(String userId, String userName, String userSurname, String userEmail, String userPassword, String userCreationTime, String userLastEditTime) {
        this(new UserId(userId),
                new UserName(userName),
                new UserSurname(userSurname),
                new UserEmail(userEmail),
                new UserPassword(userPassword),
                new UserCreationTime(userCreationTime),
                new UserLastEditTime(userLastEditTime));
    }

    public static User create(String userId, String userName, String userSurname, String userEmail, String userPassword) {
        return new User(userId, userName, userSurname, userEmail, userPassword, DatetimeUtils.getNowTimeInString(), DatetimeUtils.getNowTimeInString());
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

    public UserCreationTime creationTime() {
        return creationTime;
    }

    public void creationTime(UserCreationTime creationTime) {
        this.creationTime = creationTime;
    }

    public UserLastEditTime lastEditTime() {
        return lastEditTime;
    }

    public void lastEditTime(UserLastEditTime lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
