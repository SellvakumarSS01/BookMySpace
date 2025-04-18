package com.example.bookmyspace.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "floors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Floor extends BaseEntity {
    @Column(nullable = false)
    private int floorNumber;

    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;
}
