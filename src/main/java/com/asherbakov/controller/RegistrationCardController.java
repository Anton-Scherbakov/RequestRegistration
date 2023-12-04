package com.asherbakov.controller;

import com.asherbakov.dto.CreateOrUpdateRequestDTO;
import com.asherbakov.dto.RecipientDTO;
import com.asherbakov.mapping.CreateOrUpdateRequestMapping;
import com.asherbakov.service.RecipientService;
import com.asherbakov.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegistrationCardController {
    @Autowired
    private RecipientService recipientService;
    @Autowired
    private CreateOrUpdateRequestMapping createOrUpdateRequestMapping;
    @Autowired
    private RequestService requestService;

    @PostMapping("/recipients")
    public List<RecipientDTO> getRecipient(@RequestParam(name = "type") String rec) {
        return recipientService.getRecipientList(rec);
    }
    @PostMapping("/")
    public void createOrUpdateRequest(@RequestBody CreateOrUpdateRequestDTO request) {
        requestService.saveRequest(createOrUpdateRequestMapping.mapToRequestEntity(request));
    }
}
