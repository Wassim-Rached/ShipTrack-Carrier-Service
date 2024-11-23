package com.dsi301.shiptrackcarrierservice.dto.carrier;

import com.dsi301.shiptrackcarrierservice.entities.Carrier;
import com.dsi301.shiptrackcarrierservice.interfaces.ToEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCarrierRequestDTO implements ToEntity<Carrier,Void> {
    private String name;
    private String phoneNumber;

    @Override
    public Carrier toEntity(Void aVoid) {
        Carrier carrier = new Carrier();
        carrier.setName(name);
        carrier.setPhoneNumber(phoneNumber);
        return carrier;
    }
}
