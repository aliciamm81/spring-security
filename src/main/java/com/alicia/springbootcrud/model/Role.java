package com.alicia.springbootcrud.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
//
//    @JsonIgnoreProperties({"roles", "handler", "hibernateLazyInitializer"})
//    @ManyToMany(mappedBy = "roles")
//    private List<User> users = new ArrayList<>();
}
