package me.team.usercrud.shared.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String uuid;
    private String name;
    private String surname;
    private String email;
    private String password;
}
