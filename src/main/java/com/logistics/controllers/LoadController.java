package com.logistics.controllers;

import com.logistics.entity.Load;
import com.logistics.service.LoadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loads")
public class LoadController {
    private final LoadService loadService;

    public LoadController(LoadService loadService) {
        this.loadService = loadService;
    }

    @PostMapping
    public Load createLoad(@RequestBody Load load) {
        return loadService.saveLoad(load);
    }

    @GetMapping
    public List<Load> getAllLoads() {
        return loadService.getAllLoads();
    }

    @GetMapping("/{id}")
    public Load getLoadById(@PathVariable Long id) {
        return loadService.getLoadById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLoad(@PathVariable Long id) {
        loadService.deleteLoad(id);
    }
}
