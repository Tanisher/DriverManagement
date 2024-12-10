package com.logistics.service.Impl;

import com.logistics.entity.Load;
import com.logistics.repository.LoadRepository;
import com.logistics.service.LoadService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadServiceImpl implements LoadService {
    private final LoadRepository loadRepository;

    public LoadServiceImpl(LoadRepository loadRepository) {
        this.loadRepository = loadRepository;
    }

    @Override
    public Load saveLoad(Load load) {



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
}
