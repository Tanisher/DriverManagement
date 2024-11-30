package com.logistics.service.Impl;

import com.logistics.entity.Fault;
import com.logistics.repository.FaultRepository;
import com.logistics.service.FaultService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaultServiceImpl implements FaultService {

    private final FaultRepository faultRepository;

    public FaultServiceImpl(FaultRepository faultRepository) {
        this.faultRepository = faultRepository;
    }

    @Override
    public Fault createFault(Fault fault) {
        return faultRepository.save(fault);
    }

    @Override
    public Fault updateFault(Long id, Fault updatedFault) {
        Optional<Fault> existingFault = faultRepository.findById(id);
        if (existingFault.isPresent()) {
            Fault fault = existingFault.get();
            fault.setDescription(updatedFault.getDescription());
            fault.setReportedAt(updatedFault.getReportedAt());
            fault.setResolved(updatedFault.isResolved());
            fault.setResolutionNotes(updatedFault.getResolutionNotes());
            return faultRepository.save(fault);
        }
        throw new RuntimeException("Fault not found with id: " + id);
    }

    @Override
    public Fault markAsResolved(Long id, String resolutionNotes) {
        Optional<Fault> existingFault = faultRepository.findById(id);
        if (existingFault.isPresent()) {
            Fault fault = existingFault.get();
            fault.setResolved(true);
            fault.setResolutionNotes(resolutionNotes);
            return faultRepository.save(fault);
        }
        throw new RuntimeException("Fault not found with id: " + id);
    }

    @Override
    public List<Fault> getAllFaults() {
        return faultRepository.findAll();
    }

    @Override
    public Fault getFaultById(Long id) {
        return faultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fault not found with id: " + id));
    }

    @Override
    public List<Fault> getFaultsByResolvedStatus(boolean resolved) {
        return faultRepository.findByResolved(resolved);
    }

    @Override
    public void deleteFault(Long id) {
        faultRepository.deleteById(id);
    }
}
