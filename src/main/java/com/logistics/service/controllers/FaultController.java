package com.logistics.controllers;

import com.logistics.entity.Fault;
import com.logistics.service.FaultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faults")
public class FaultController {

    private final FaultService faultService;

    public FaultController(FaultService faultService) {
        this.faultService = faultService;
    }

    @PostMapping
    public ResponseEntity<Fault> createFault(@RequestBody Fault fault) {
        return ResponseEntity.ok(faultService.createFault(fault));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fault> updateFault(@PathVariable Long id, @RequestBody Fault fault) {
        return ResponseEntity.ok(faultService.updateFault(id, fault));
    }

    @PatchMapping("/{id}/resolve")
    public ResponseEntity<Fault> markAsResolved(@PathVariable Long id, @RequestBody String resolutionNotes) {
        return ResponseEntity.ok(faultService.markAsResolved(id, resolutionNotes));
    }

    @GetMapping
    public ResponseEntity<List<Fault>> getAllFaults() {
        return ResponseEntity.ok(faultService.getAllFaults());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fault> getFaultById(@PathVariable Long id) {
        return ResponseEntity.ok(faultService.getFaultById(id));
    }

    @GetMapping("/status/{resolved}")
    public ResponseEntity<List<Fault>> getFaultsByResolvedStatus(@PathVariable boolean resolved) {
        return ResponseEntity.ok(faultService.getFaultsByResolvedStatus(resolved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFault(@PathVariable Long id) {
        faultService.deleteFault(id);
        return ResponseEntity.noContent().build();
    }
}