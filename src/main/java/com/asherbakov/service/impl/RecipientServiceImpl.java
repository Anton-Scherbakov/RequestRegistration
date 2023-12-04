package com.asherbakov.service.impl;

import com.asherbakov.dto.RecipientDTO;
import com.asherbakov.entity.TypeOfRequest;
import com.asherbakov.exception.TypeOfRequestException;
import com.asherbakov.mapping.RecipientMapping;
import com.asherbakov.repository.ArchiveRepository;
import com.asherbakov.repository.CountryRepository;
import com.asherbakov.repository.DepartmentRepository;
import com.asherbakov.repository.InsurerRepository;
import com.asherbakov.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RecipientServiceImpl implements RecipientService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private InsurerRepository insurerRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ArchiveRepository archiveRepository;
    @Autowired
    private ArchiveService archiveService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private InsurerService insurerService;
    @Override
    public List<RecipientDTO> getRecipientList(Object rec) {
        if (Objects.isNull(rec)) {
            throw new NullPointerException("Type of request is null.");
        }
        List<RecipientDTO> result = new ArrayList<>();
        int id = Integer.parseInt(rec.toString());
        switch(id) {
            case 1 -> result = departmentRepository.findAll().stream().map(s -> new RecipientMapping().mapToRecipient(s)).toList();
            case 2 -> result = archiveRepository.findAll().stream().map(s -> new RecipientMapping().mapToRecipient(s)).toList();
            case 3 -> result = countryRepository.findAll().stream().map(s -> new RecipientMapping().mapToRecipient(s)).toList();
            case 4 -> result = insurerRepository.findAll().stream().map(s -> new RecipientMapping().mapToRecipient(s)).toList();
            default -> throw new IllegalArgumentException("Type of request not found: " + id);
        }
        return result;
    }
    @Override
    public Long checkRecipient(List<String> recipient, TypeOfRequest typeOfRequest) {
        Long returnId = Long.valueOf(recipient.get(0));
        try {
            if (returnId == -1) {
                switch (typeOfRequest.getId()) {
                    case 1 -> returnId = (long) departmentService.saveDepartment(recipient).getId();
                    case 2 -> returnId = (long) archiveService.saveArchive(recipient).getId();
                    case 3 -> returnId = (long) countryService.saveCountry(recipient).getId();
                    case 4 -> returnId = insurerService.saveInsurer(recipient).getId();
                    default -> throw new TypeOfRequestException();
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return returnId;
    }
}
