//package me.team.usercrud.domain;
//
//import lombok.val;
//import me.team.usercrud.user.domain.User;
//import org.junit.jupiter.api.Test;
//
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//
//public class UserTests {
//    @Test
//    public void testEqualUsers() {
//        val user =  new User(UUID.fromString("c20e75c4-8ed4-4e15-aa5e-cc81fe10c3c1"), "espai422", "Garcia", "andreu@andreu.com", "somehash1");
//        val user2 =  new User(UUID.fromString("c20e75c4-8ed4-4e15-aa5e-cc81fe10c3c1"), "Andreu", "Garcia", "andreu@andreu.com", "somehash1");
//
//        assertEquals(user, user2);
//    }
//
//    @Test
//    public void testEqualWithDifferentUsers() {
//        val user =  new User(UUID.fromString("c20e75c4-8ed4-4e15-aa5e-cc81fe10c3c2"), "Andreu", "Garcia", "andreu@andreu.com", "somehash1");
//        val user2 =  new User(UUID.fromString("c20e75c4-8ed4-4e15-aa5e-cc81fe10c3c1"), "Andreu", "Garcia", "andreu@andreu.com", "somehash1");
//
//        assertNotEquals(user, user2);
//    }
//}
