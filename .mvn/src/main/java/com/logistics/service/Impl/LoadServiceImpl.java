package com.logistics.service.Impl;

import com.logistics.entity.Customer;
import com.logistics.entity.Load;
import com.logistics.entity.LoadDTO;
import com.logistics.repository.CustomerRepository;
import com.logistics.repository.LoadRepository;
import com.logistics.service.LoadService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadServiceImpl implements LoadService {
    private final LoadRepository loadRepository;
    private final CustomerRepository customerRepository;

    public LoadServiceImpl(LoadRepository loadRepository, CustomerRepository customerRepository) {
        this.loadRepository = loadRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    public Load saveLoad(Load load) {
        if (load.getCustomerId() == null) {
            throw new RuntimeException("Customer ID is required");
        }

        Customer customer = customerRepository.findById(load.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        load.setCustomer(customer);
        return loadRepository.save(load);
    }

    @Override
    public List<Load> getAllLoads() {
        return loadRepository.findAll();
    }

    @Override
    public Load getLoadById(Long id) {
        return loadRepository.findById(id).orElseThrow(() -> new RuntimeException("Load not found"));
    }

    @Override
    public void deleteLoad(Long id) {
        loadRepository.deleteById(id);
    }

    // Optional: method to convert to DTO
    public LoadDTO convertToDTO(Load load) {
        LoadDTO dto = new LoadDTO();
        dto.setId(load.getId());
        dto.setCustomerId(load.getCustomerId());
        dto.setDescription(load.getDescription());
        dto.setStatus(load.getStatus());
        dto.setDeliveryLocation(load.getDeliveryLocation());
        dto.setPickupLocation(load.getPickupLocation());
        dto.setWeight(load.getWeight());

        // Set other fields...

        // Optional: set customer name
        if (load.getCustomer() != null) {
            dto.setCustomerName(load.getCustomer().getName());
        }

        return dto;

    }
}
