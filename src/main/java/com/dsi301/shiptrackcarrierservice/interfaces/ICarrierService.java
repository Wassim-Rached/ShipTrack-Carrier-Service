package com.dsi301.shiptrackcarrierservice.interfaces;

import com.dsi301.shiptrackcarrierservice.dto.carrier.ShipmentInfoRequestDTO;
import com.dsi301.shiptrackcarrierservice.entities.Carrier;

import java.util.Collection;

public interface ICarrierService {
    Carrier saveCarrier(Carrier carrier);
    Carrier getCarrierById(Integer carrierId);
    Carrier updateCarrierLiveTrackingLink(Integer carrierId, String liveTrackingLink);
    String getCarrierLiveTrackingLink(Integer carrierId);
    Collection<Carrier> getAvailableCarriersForShipment(ShipmentInfoRequestDTO requestDTO);
}
