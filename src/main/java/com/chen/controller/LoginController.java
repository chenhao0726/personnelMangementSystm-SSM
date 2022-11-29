package com.chen.controller;

import com.chen.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String ,Object> login(String username, String password, HttpSession session) {
        Map<String, Object> result = employeeService.login(username, password);
        // 如果登录成功，将登录信息存入session
        Object data = result.get("data");
        Boolean success = (Boolean) result.get("success");
        if (success){
            session.setAttribute("loginUser", data);
        }
        return result;
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session) {
        session.removeAttribute("loginUser");
        return "redirect:/login.jsp";
    }


}
