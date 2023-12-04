package com.asherbakov.service;

import com.asherbakov.entity.Archive;

import java.util.List;

public interface ArchiveService {
    Archive saveArchive(List<String> recipient);
}
