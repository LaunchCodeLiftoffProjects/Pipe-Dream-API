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

    @Column(name="businessName")
    private String businessName;

    @Column(name="businessType")
    private String businessType;

    @Column(name="isAccessible")
    private Boolean isAccessible;

    @Column(name="isGenderNeutral")
    private Boolean genderNeutral;

    @Column(name="hasChangingTable")
    private Boolean changingTable;

    @Column(name="isSingleStall")
    private Boolean isSingleStall;

    @Column(name = "address")
    private String address;

    @Column(name = "rating")
    private Integer rating;


}

