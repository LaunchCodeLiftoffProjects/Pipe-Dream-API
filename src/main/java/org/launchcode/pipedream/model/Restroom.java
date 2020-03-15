package org.launchcode.pipedream.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restroom {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "business")
    private String business;

    @Column(name = "rating")
    private Integer rating;
}

