package com.asherbakov.service.impl;

import com.asherbakov.entity.Archive;
import com.asherbakov.repository.ArchiveRepository;
import com.asherbakov.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveServiceImpl implements ArchiveService {
    @Autowired
    private ArchiveRepository archiveRepository;

    @Override
    public Archive saveArchive(List<String> recipient) {
        Archive archive = new Archive();
        archive.setName(recipient.get(1));
        if (!recipient.get(2).isBlank()) {
            archive.setAddress(recipient.get(2));
        }
        return archiveRepository.save(archive);
    }
}
