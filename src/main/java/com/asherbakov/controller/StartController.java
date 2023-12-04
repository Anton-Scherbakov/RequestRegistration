package com.asherbakov.controller;

import com.asherbakov.service.DeliveryTypeService;
import com.asherbakov.service.PurposeOfRequestService;
import com.asherbakov.service.RequestService;
import com.asherbakov.service.TypeOfRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
    @Autowired
    private TypeOfRequestService typeOfRequestService;
    @Autowired
    private PurposeOfRequestService purposeOfRequestService;
    @Autowired
    private DeliveryTypeService deliveryTypeService;
    @Autowired
    private RequestService requestService;
    @GetMapping
    public String startPage(Model model) {
        model.addAttribute("TypeOfRequest", typeOfRequestService.getAllTypes());
        model.addAttribute("PurposeOfRequest", purposeOfRequestService.getAllPurposes());
        model.addAttribute("DeliveryType", deliveryTypeService.getAllDeliveryTypes());
        model.addAttribute("Requests", requestService.getRequests());
        return "index";
    }
    @GetMapping("/admin")
    public String adminPage() {
        return "pages/admin/admin";
    }

    @GetMapping("/admin/users")
    public String usersPage() {
        return "pages/admin/users";
    }

    @GetMapping("/admin/holidays")
    public String holidaysPage() {
        return "pages/admin/holidays";
    }
}
