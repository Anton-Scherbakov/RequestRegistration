package com.asherbakov.service.impl;

import com.asherbakov.entity.TypeOfRequest;
import com.asherbakov.repository.TypeOfRequestRepository;
import com.asherbakov.service.TypeOfRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfRequestServiceImpl implements TypeOfRequestService {
    @Autowired
    private TypeOfRequestRepository typeOfRequestRepository;
    @Override
    public List<TypeOfRequest> getAllTypes() {
        return typeOfRequestRepository.findAll();
    }
}
