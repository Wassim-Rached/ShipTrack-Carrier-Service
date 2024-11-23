package com.dsi301.shiptrackcarrierservice.services;

import com.dsi301.shiptrackcarrierservice.dto.carrier.ShipmentInfoRequestDTO;
import com.dsi301.shiptrackcarrierservice.entities.Carrier;
import com.dsi301.shiptrackcarrierservice.interfaces.ICarrierService;
import com.dsi301.shiptrackcarrierservice.repositories.CarrierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CarrierServiceImpl implements ICarrierService {

    private final CarrierRepository carrierRepository;

    @Override
    public Carrier saveCarrier(Carrier carrier) {
        return carrierRepository.save(carrier);
    }

    @Override
    public Carrier getCarrierById(Integer carrierId) {
        return carrierRepository.findById(carrierId).orElse(null);
    }

    @Override
    public Carrier updateCarrierLiveTrackingLink(Integer carrierId, String liveTrackingLink) {
        Carrier carrier = carrierRepository.findById(carrierId).orElse(null);
        if (carrier != null) {
            carrier.setLiveTrackingLink(liveTrackingLink);
            return carrierRepository.save(carrier);
        }
        return null;
    }

    @Override
    public String getCarrierLiveTrackingLink(Integer carrierId) {
        Carrier carrier = carrierRepository.findById(carrierId).orElse(null);
        if (carrier != null) {
            return carrier.getLiveTrackingLink();
        }
        return null;
    }

    @Override
    public Collection<Carrier> getAvailableCarriersForShipment(ShipmentInfoRequestDTO requestDTO) {
        // should have an algorithm to choose the best carriers based on the requestDTO
        // but for now, we will just return all carriers
        return carrierRepository.findAll();
    }
    

}
