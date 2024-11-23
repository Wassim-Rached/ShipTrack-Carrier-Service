package com.dsi301.shiptrackcarrierservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "carriers")
@Getter
@Setter
public class Carrier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carrierId;
    private String name;
    private String phoneNumber;
    private String liveTrackingLink;
}
