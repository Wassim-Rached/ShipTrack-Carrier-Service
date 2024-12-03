package com.dsi301.shiptrackcarrierservice;

import com.dsi301.shiptrackcarrierservice.dto.carrier.UpdateCarrierLiveTrackingLink;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import com.dsi301.shiptrackcarrierservice.dto.carrier.CreateCarrierRequestDTO;
import com.dsi301.shiptrackcarrierservice.dto.carrier.ShipmentInfoRequestDTO;
import com.dsi301.shiptrackcarrierservice.entities.Carrier;
import com.dsi301.shiptrackcarrierservice.interfaces.ICarrierService;
import jakarta.inject.Inject;

@Path("/service/carriers")
public class WebService {

    @Inject
    private ICarrierService carrierService;

    // create carrier
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Carrier createCarrier(CreateCarrierRequestDTO requestDTO) {
        Carrier carrier = requestDTO.toEntity(null);
        return carrierService.saveCarrier(carrier);
    }

    // get available carriers for a shipment
    @GET
    @Path("/available-carriers")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Carrier> getAvailableCarriers(ShipmentInfoRequestDTO requestDTO) {
        return carrierService.getAvailableCarriersForShipment(requestDTO);
    }

    // update 'carrier' live tracking link
    @PUT
    @Path("/{carrierId}/live-tracking-link")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Carrier updateCarrierLiveTrackingLink(@PathParam("carrierId") Integer carrierId, UpdateCarrierLiveTrackingLink requestDTO) {
        return carrierService.updateCarrierLiveTrackingLink(carrierId, requestDTO.getLiveTrackingLink());
    }

    // get carrier live tracking link
    @GET
    @Path("/{carrierId}/live-tracking-link")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCarrierLiveTrackingLink(@PathParam("carrierId") Integer carrierId) {
        return carrierService.getCarrierLiveTrackingLink(carrierId);
    }


    // get carrier by id
    @GET
    @Path("/{carrierId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Carrier getCarrierById(@PathParam("carrierId") Integer carrierId) {
        return carrierService.getCarrierById(carrierId);
    }
}
