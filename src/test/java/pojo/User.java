package pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class User {
    public String id;
    public String firstName;
    public String lastName;
    public int age;
    public String email;
    public String token;
    public Date updatedAt;
}
