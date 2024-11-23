package com.dsi301.shiptrackcarrierservice.controllers;

import com.dsi301.shiptrackcarrierservice.dto.carrier.CreateCarrierRequestDTO;
import com.dsi301.shiptrackcarrierservice.dto.carrier.ShipmentInfoRequestDTO;
import com.dsi301.shiptrackcarrierservice.entities.Carrier;
import com.dsi301.shiptrackcarrierservice.interfaces.ICarrierService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Collate;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/service/carriers")
@RequiredArgsConstructor
public class CarrierController {

    private final ICarrierService carrierService;


    // create carrier
    @PostMapping
    public Carrier createCarrier(@RequestBody CreateCarrierRequestDTO requestDTO) {
        Carrier carrier = requestDTO.toEntity(null);
        return carrierService.saveCarrier(carrier);
    }

    // get available carriers for a shipment
    @GetMapping("/available-carriers")
    public Iterable<Carrier> getAvailableCarriers(@RequestBody ShipmentInfoRequestDTO requestDTO) {
        return carrierService.getAvailableCarriersForShipment(requestDTO);
    }

    // get carrier by id
    @GetMapping("/{carrierId}")
    public Carrier getCarrierById(@PathVariable Integer carrierId) {
        return carrierService.getCarrierById(carrierId);
    }

    // update 'carrier' live tracking link
    @PutMapping("/{carrierId}/live-tracking-link")
    public Carrier updateCarrierLiveTrackingLink(@PathVariable Integer carrierId, @RequestBody String liveTrackingLink) {
        return carrierService.updateCarrierLiveTrackingLink(carrierId, liveTrackingLink);
    }

    // get carrier live tracking link
    @GetMapping("/{carrierId}/live-tracking-link")
    public String getCarrierLiveTrackingLink(@PathVariable Integer carrierId) {
        return carrierService.getCarrierLiveTrackingLink(carrierId);
    }
}
