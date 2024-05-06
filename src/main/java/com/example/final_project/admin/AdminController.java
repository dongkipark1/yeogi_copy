package com.example.final_project.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminController {
    private final AdminService adminService;
    private final HttpSession session;

    @GetMapping("/admin")
    public String login() {
        return "/admin/login";
    }

    @GetMapping("/admin/join")
    public String join() {
        return "/admin/customer-c/report";
    }

    // 기업 회원 정보 조회 View
    @GetMapping("/admin/company")
    public String company(HttpServletRequest request) {
        List<AdminResponse.companyListDTO> respDTO = adminService.adminCompanyList();
        request.setAttribute("companyList", respDTO);
        request.setAttribute("companyCount", respDTO.size());
        return "/admin/customer-c/join";
    }

    // 기업 블랙 취소 기능
    @PutMapping("/admin/company/black/{companyId}")
    public String companyBlack(@PathVariable Integer companyId) {
        adminService.adminCompanyBlack(companyId);
        return "redirect:/admin/company";
    }

    // 기업 블랙 취소 기능
    @PutMapping("/admin/company/black/cancel/{companyId}")
    public String companyBlackCancel(@PathVariable Integer companyId) {
        adminService.adminCompanyBlackCancel(companyId);
        return "redirect:/admin/company";
    }

    // 개인 회원 정보 조회 View
    @GetMapping("/admin/user")
    public String user(HttpServletRequest request) {
        List<AdminResponse.userListDTO> respDTO = adminService.adminUserList();
        request.setAttribute("userCount", respDTO.size());
        request.setAttribute("userList", respDTO);
        return "/admin/customer-u/join";
    }
}
