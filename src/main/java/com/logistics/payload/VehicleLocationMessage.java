package com.logistics.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleLocationMessage {
    private Long vehicleId;
    private Double latitude;
    private Double longitude;

}
