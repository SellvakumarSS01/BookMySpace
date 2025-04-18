package com.example.bookmyspace.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "resource_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceType extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
}
