package com.logistics.service;

import com.logistics.entity.Load;
import com.logistics.entity.LoadDTO;

import java.util.List;

public interface LoadService {
    Load saveLoad(Load load);
    List<Load> getAllLoads();
    Load getLoadById(Long id);
    void deleteLoad(Long id);
    LoadDTO convertToDTO(Load savedLoad);
}
