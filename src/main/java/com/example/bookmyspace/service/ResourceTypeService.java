package com.example.bookmyspace.service;

import com.example.bookmyspace.model.ResourceType;
import com.example.bookmyspace.repository.ResourceTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceTypeService {
    private final ResourceTypeRepository resourceTypeRepository;

    public ResourceTypeService(ResourceTypeRepository resourceTypeRepository) {
        this.resourceTypeRepository = resourceTypeRepository;
    }

    public List<ResourceType> getAllResourceTypes() {
        return resourceTypeRepository.findAll();
    }

    public Optional<ResourceType> getResourceTypeById(Long id) {
        return resourceTypeRepository.findById(id);
    }

    public ResourceType saveResourceType(ResourceType resourceType) {
        return resourceTypeRepository.save(resourceType);
    }

    public void deleteResourceType(Long id) {
        resourceTypeRepository.deleteById(id);
    }
}
