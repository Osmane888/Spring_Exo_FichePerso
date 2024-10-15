package org.example.exo_spring.dl.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Contacts {

    private String name;
    private String firstname;
    private String email;
    private String phoneNumber;
}
