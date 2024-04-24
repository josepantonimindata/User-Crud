package me.team.usercrud.shared.infrastructure.dto;

import java.util.Objects;

public class UserDto {
    private String uuid;
    private String name;
    private String surname;
    private String email;
    private String password;

    public UserDto(String uuid, String name, String surname, String email, String password) {
        this.uuid = uuid;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public UserDto()                         {}

    public String getUuid()                  {return this.uuid;}

    public void setUuid(String uuid)         {this.uuid = uuid;}

    public String getName()                  {return this.name;}

    public void setName(String name)         {this.name = name;}

    public String getSurname()               {return this.surname;}

    public void setSurname(String surname)   {this.surname = surname;}

    public String getEmail()                 {return this.email;}

    public void setEmail(String email)       {this.email = email;}

    public String getPassword()              {return this.password;}

    public void setPassword(String password) {this.password = password;}

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserDto other)) return false;
        if (!other.canEqual(this)) return false;
        final Object this$uuid = this.getUuid();
        final Object other$uuid = other.getUuid();
        if (!Objects.equals(this$uuid, other$uuid)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (!Objects.equals(this$name, other$name)) return false;
        final Object this$surname = this.getSurname();
        final Object other$surname = other.getSurname();
        if (!Objects.equals(this$surname, other$surname)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (!Objects.equals(this$email, other$email)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        return Objects.equals(this$password, other$password);
    }

    protected boolean canEqual(final Object other) {return other instanceof UserDto;}

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $uuid = this.getUuid();
        result = result * PRIME + ($uuid == null ? 43 : $uuid.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $surname = this.getSurname();
        result = result * PRIME + ($surname == null ? 43 : $surname.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        return result;
    }

    public String toString() {return "UserDto(uuid=" + this.getUuid() + ", name=" + this.getName() + ", surname=" + this.getSurname() + ", email=" + this.getEmail() + ", password=" + this.getPassword() + ")";}
}
