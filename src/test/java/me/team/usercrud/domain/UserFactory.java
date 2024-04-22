package me.team.usercrud.domain;

import net.bytebuddy.utility.RandomString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserFactory {

    public static User named(String name) {
        return new User(
            UUID.randomUUID(),
            name,
            RandomString.make(),
            RandomString.make(),
            RandomString.make()
        );
    }

    public static User random() {
        return new User(
            UUID.randomUUID(),
            RandomString.make(),
            RandomString.make(),
            RandomString.make(),
            RandomString.make()
        );
    }

    public static List<User> randomList(int number) {
        var list = new ArrayList<User>();

        for (int i = 0; i < number; i++) {
            list.add(UserFactory.random());
        }

        return list;
    }
}
