package pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Note {
    public String id;
    public String text;
    public Date createdAt;
    public Date updatedAt;
    public User user;
}
