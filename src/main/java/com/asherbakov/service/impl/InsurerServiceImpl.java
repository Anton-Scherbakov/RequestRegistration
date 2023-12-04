package com.asherbakov.service.impl;

import com.asherbakov.entity.Insurer;
import com.asherbakov.repository.InsurerRepository;
import com.asherbakov.service.InsurerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsurerServiceImpl implements InsurerService {
    @Autowired
    private InsurerRepository insurerRepository;

    @Override
    public Insurer saveInsurer(List<String> recipient) {
        Insurer insurer = new Insurer();
        insurer.setName(recipient.get(1));
        insurer.setCode(recipient.get(2));
        return insurerRepository.save(insurer);
    }
}
