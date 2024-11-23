package com.dsi301.shiptrackcarrierservice.dto.carrier;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShipmentInfoRequestDTO {
    private String streetAddress;
    private String city;
    private String postalCode;
}
