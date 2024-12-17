package com.logistics.service;

import com.logistics.entity.Fault;

import java.util.List;

public interface FaultService {
    Fault createFault(Fault fault);

    Fault updateFault(Long id, Fault updatedFault);

    Fault markAsResolved(Long id, String resolutionNotes);

    List<Fault> getAllFaults();

    Fault getFaultById(Long id);

    List<Fault> getFaultsByResolvedStatus(boolean resolved);

    void deleteFault(Long id);
}