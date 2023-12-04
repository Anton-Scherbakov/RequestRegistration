package com.asherbakov.service;

import com.asherbakov.entity.Insurer;

import java.util.List;

public interface InsurerService {
    Insurer saveInsurer(List<String> recipient);
}
