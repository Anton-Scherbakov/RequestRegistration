package com.asherbakov.service.impl;

import com.asherbakov.entity.Request;
import com.asherbakov.repository.RequestRepository;
import com.asherbakov.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestRepository requestRepository;
    @Override
    public Request saveRequest(Request request) {
        return requestRepository.save(request);
    }
    @Override
    public List<Request> getRequests() {
        return requestRepository.findAll();
    }
}
