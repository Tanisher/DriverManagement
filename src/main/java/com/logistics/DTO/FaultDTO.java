package com.logistics.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FaultDTO {
    private Long id;
    private String description;
    private LocalDateTime reportedAt;
    private boolean resolved;
    private String resolutionNotes;
    private Long vehicleId;
    private Long driverId;
}
