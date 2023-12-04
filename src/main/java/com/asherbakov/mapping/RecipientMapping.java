package com.asherbakov.mapping;

import com.asherbakov.dto.RecipientDTO;
import com.asherbakov.entity.Archive;
import com.asherbakov.entity.Country;
import com.asherbakov.entity.Department;
import com.asherbakov.entity.Insurer;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RecipientMapping {
    public RecipientDTO mapToRecipient(Archive archive) {
        checkForNull(archive);
        RecipientDTO recipientDTO = new RecipientDTO();
        String name;
        if (archive.getAddress() == null || archive.getAddress().isBlank()) {
            name =  archive.getName();
        } else {
            name =  archive.getName() + ". " + archive.getAddress();
        }
        recipientDTO.setId((long) archive.getId());
        recipientDTO.setName(name);
        return recipientDTO;
    }
    public RecipientDTO mapToRecipient(Country country) {
        checkForNull(country);
        RecipientDTO recipientDTO = new RecipientDTO();
        recipientDTO.setId((long) country.getId());
        recipientDTO.setName(country.getName());
        return recipientDTO;
    }
    public RecipientDTO mapToRecipient(Department department) {
        checkForNull(department);
        RecipientDTO recipientDTO = new RecipientDTO();
        recipientDTO.setId((long) department.getId());
        recipientDTO.setName(department.getName());
        return recipientDTO;
    }
    public RecipientDTO mapToRecipient(Insurer insurer) {
        checkForNull(insurer);
        RecipientDTO recipientDTO = new RecipientDTO();
        String name;
        if (insurer.getCode() == null || insurer.getCode().isBlank()) {
            name =  insurer.getName();
        } else {
            name =  insurer.getCode() + " " + insurer.getName();
        }
        recipientDTO.setId(insurer.getId());
        recipientDTO.setName(name);
        return recipientDTO;
    }
    private void checkForNull(Object o) {
        if (Objects.isNull(o)) {
            throw new NullPointerException();
        }
    }
}
