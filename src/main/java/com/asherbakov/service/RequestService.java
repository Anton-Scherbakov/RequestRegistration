package com.asherbakov.service;

import com.asherbakov.entity.Request;

import java.util.List;

public interface RequestService {
    Request saveRequest(Request request);

    List<Request> getRequests();
}
