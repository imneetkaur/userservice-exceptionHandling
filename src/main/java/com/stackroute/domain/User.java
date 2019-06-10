package com.stackroute.domain;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="user")
public class User {
    @Id
    int id;
    String name;
    int age;
}
