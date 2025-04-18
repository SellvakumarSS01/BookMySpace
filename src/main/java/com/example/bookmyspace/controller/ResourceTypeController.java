package com.example.bookmyspace.controller;

import com.example.bookmyspace.model.ResourceType;
import com.example.bookmyspace.service.ResourceTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resource-types")
public class ResourceTypeController {
    private final ResourceTypeService resourceTypeService;

    public ResourceTypeController(ResourceTypeService resourceTypeService) {
        this.resourceTypeService = resourceTypeService;
    }

    @GetMapping
    public List<ResourceType> getAllResourceTypes() {
        return resourceTypeService.getAllResourceTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceType> getResourceTypeById(@PathVariable Long id) {
        Optional<ResourceType> resourceType = resourceTypeService.getResourceTypeById(id);
        return resourceType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResourceType createResourceType(@RequestBody ResourceType resourceType) {
        return resourceTypeService.saveResourceType(resourceType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResourceType(@PathVariable Long id) {
        resourceTypeService.deleteResourceType(id);
        return ResponseEntity.noContent().build();
    }
}
