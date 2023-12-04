package com.asherbakov.service;

import com.asherbakov.dto.RecipientDTO;
import com.asherbakov.entity.TypeOfRequest;

import java.util.List;

public interface RecipientService {
    List<RecipientDTO> getRecipientList(Object rec);

    /**
     * If the recipient is entered manually, then save it to the database and return the id.
     *
     * @param recipient     list of String in format (id, name, additional data)
     * @param typeOfRequest {@link TypeOfRequest}
     * @return id from database
     */
    Long checkRecipient(List<String> recipient, TypeOfRequest typeOfRequest);
}
