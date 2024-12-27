package com.logistics.controllers;

import com.logistics.DTO.FaultDTO;
import com.logistics.DTO.FaultMapper;
import com.logistics.service.FaultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/faults")
public class FaultController {

    private final FaultService faultService;
    private final FaultMapper faultMapper;

    public FaultController(FaultService faultService, FaultMapper faultMapper) {
        this.faultService = faultService;
        this.faultMapper = faultMapper;
    }

    @PostMapping
    public ResponseEntity<FaultDTO> createFault(@RequestBody FaultDTO faultDTO) {
        var fault = faultMapper.toEntity(faultDTO);
        var createdFault = faultService.createFault(fault);
        return ResponseEntity.ok(faultMapper.toDTO(createdFault));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FaultDTO> updateFault(@PathVariable Long id, @RequestBody FaultDTO faultDTO) {
        var fault = faultMapper.toEntity(faultDTO);
        var updatedFault = faultService.updateFault(id, fault);
        return ResponseEntity.ok(faultMapper.toDTO(updatedFault));
    }

    @PatchMapping("/{id}/resolve")
    public ResponseEntity<FaultDTO> markAsResolved(@PathVariable Long id, @RequestBody String resolutionNotes) {
        var resolvedFault = faultService.markAsResolved(id, resolutionNotes);
        return ResponseEntity.ok(faultMapper.toDTO(resolvedFault));
    }

    @GetMapping
    public ResponseEntity<List<FaultDTO>> getAllFaults() {
        var faults = faultService.getAllFaults();
        var faultDTOs = faults.stream()
                .map(faultMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(faultDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaultDTO> getFaultById(@PathVariable Long id) {
        var fault = faultService.getFaultById(id);
        return ResponseEntity.ok(faultMapper.toDTO(fault));
    }

    @GetMapping("/status/{resolved}")
    public ResponseEntity<List<FaultDTO>> getFaultsByResolvedStatus(@PathVariable boolean resolved) {
        var faults = faultService.getFaultsByResolvedStatus(resolved);
        var faultDTOs = faults.stream()
                .map(faultMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(faultDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFault(@PathVariable Long id) {
        faultService.deleteFault(id);
        return ResponseEntity.noContent().build();
    }
}