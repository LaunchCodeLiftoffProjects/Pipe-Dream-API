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
public class Review {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="rating")
    private Long rating;

    @Column(name="reviewText")
    private String reviewText;

    @Column(name="restroomId")
    private Long restroomId;

}
