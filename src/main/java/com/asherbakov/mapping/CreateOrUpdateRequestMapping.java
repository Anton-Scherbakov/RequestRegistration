package com.asherbakov.mapping;

import com.asherbakov.dto.CreateOrUpdateRequestDTO;
import com.asherbakov.entity.*;
import com.asherbakov.exception.TypeOfRequestException;
import com.asherbakov.repository.*;
import com.asherbakov.service.RecipientService;
import com.asherbakov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class CreateOrUpdateRequestMapping {
    @Autowired
    private UserService userService;
    @Autowired
    private PurposeOfRequestRepository purposeOfRequestRepository;
    @Autowired
    private TypeOfRequestRepository typeOfRequestRepository;
    @Autowired
    private HolidayRepository holidayRepository;
    @Autowired
    private WorkDayRepository workDayRepository;
    @Autowired
    private DeliveryTypeRepository deliveryTypeRepository;

    @Autowired
    private RecipientService recipientService;

    public Request mapToRequestEntity(CreateOrUpdateRequestDTO createOrUpdateRequestDTO) {
        Request request = new Request();
        User user = userService.getUser();
        // TODO: дописать id и регистрационный номер
        request.setId(2L);
        request.setRegistrationNumber("123123");


        request.setRegistrationDate(getDateFromString(createOrUpdateRequestDTO.getRegistrationDate()));
        request.setPurposeOfRequest(purposeOfRequestRepository.findById(createOrUpdateRequestDTO.getDocumentPurpose()).orElseThrow());
        request.setTypeOfRequest(typeOfRequestRepository.findById(createOrUpdateRequestDTO.getTypeOfRequest()).orElseThrow());
        request.setLastName(createOrUpdateRequestDTO.getLastName());
        request.setFirstName(createOrUpdateRequestDTO.getFirstName());
        request.setMiddleName(createOrUpdateRequestDTO.getMiddleName());
        request.setDateOfBirthday(getDateFromString(createOrUpdateRequestDTO.getDateOfBirthday()));
        request.setSocialNumber(createOrUpdateRequestDTO.getSocialNumber());
        request.setEnabled(true);
        request.setLocation(user.getLocation());
        request.setStructuralDivision(user.getStructuralDivision());
        request.setPurposeOfRequest(purposeOfRequestRepository.findById(createOrUpdateRequestDTO.getDocumentPurpose()).orElseThrow());
        request.setTypeOfRequest(typeOfRequestRepository.findById(createOrUpdateRequestDTO.getTypeOfRequest()).orElseThrow());
        request.setRecipient(recipientService.checkRecipient(createOrUpdateRequestDTO.getRecipient(), request.getTypeOfRequest()));
        request.setDeliveryType(deliveryTypeRepository.findById(createOrUpdateRequestDTO.getSendMethod()).orElseThrow());    //  TODO: привести к одному виду
        request.setUser(user);
        request.setDateWith(calculateDateWith(request.getRegistrationDate(), request.getTypeOfRequest()));
        System.out.println(request);
        return request;
    }

    /**
     * Converting a string to a date format.
     *
     * @param date string representation of the date in the format "yyyy-MM-dd"
     * @return {@link LocalDate} or null
     */
    private LocalDate getDateFromString(String date) {
        LocalDate ld = null;
        if (date != null && !date.isBlank()) {
            try {
                ld = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect date format: " + e.getParsedString());
            }
        }
        return ld;
    }

    /**
     * Calculating the deadline
     *
     * @param registrationDate date of request registration
     * @param typeOfRequest    type of registered request
     * @return {@link LocalDate}
     */
    private LocalDate calculateDateWith(LocalDate registrationDate, TypeOfRequest typeOfRequest) {
        LocalDate result = null;
        switch (typeOfRequest.getDayType()) {
            case "wd" -> {
                int dayCount = 0;
                int add = typeOfRequest.getPeriod();
                // TODO: получать только даты, следующие за датой подачи
                List<Holiday> holidays = holidayRepository.findAll();
                List<WorkDay> workDays = workDayRepository.findAll();
                for (int i = 0; i <= add; i++) {
                    LocalDate tempDate = registrationDate.plusDays(i);
                    if (tempDate.getDayOfWeek().getValue() == 6 || tempDate.getDayOfWeek().getValue() == 7) {
                        for (WorkDay wd : workDays) {
                            if (!tempDate.isEqual(wd.getDate())) {
                                dayCount++;
                                add++;
                            }
                        }
                    } else {
                        for (Holiday hd : holidays) {
                            if (tempDate.isEqual(hd.getDate())) {
                                dayCount++;
                                add++;
                            }
                        }
                    }
                }
                result = registrationDate.plusDays(dayCount);
            }
            case "cd" -> result = registrationDate.plusDays(typeOfRequest.getPeriod());
            default -> throw new TypeOfRequestException("Invalid day type.");
        }
        return result;
    }

}
