package com.asherbakov.service.impl;

import com.asherbakov.entity.PurposeOfRequest;
import com.asherbakov.repository.PurposeOfRequestRepository;
import com.asherbakov.service.PurposeOfRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurposeOfRequestServiceImpl implements PurposeOfRequestService {
    @Autowired
    private PurposeOfRequestRepository purposeOfRequestRepository;
    @Override
    public List<PurposeOfRequest> getAllPurposes() {
        return purposeOfRequestRepository.findAll();
    }
}
