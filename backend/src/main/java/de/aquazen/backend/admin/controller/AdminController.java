package de.aquazen.backend.admin.controller;

import de.aquazen.backend.admin.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/shutdown")
    public void powerOff() {

    }

    @GetMapping("/reboot")
    public void reboot() {

    }

    @GetMapping("/reload")
    public void reload() {

    }
}
