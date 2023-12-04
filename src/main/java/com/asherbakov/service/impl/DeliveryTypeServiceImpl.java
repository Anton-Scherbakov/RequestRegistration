package com.asherbakov.service.impl;

import com.asherbakov.entity.DeliveryType;
import com.asherbakov.repository.DeliveryTypeRepository;
import com.asherbakov.service.DeliveryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryTypeServiceImpl implements DeliveryTypeService {
    @Autowired
    private DeliveryTypeRepository deliveryTypeRepository;
    @Override
    public List<DeliveryType> getAllDeliveryTypes() {
        return deliveryTypeRepository.findAll(Sort.by("name"));
    }
}
