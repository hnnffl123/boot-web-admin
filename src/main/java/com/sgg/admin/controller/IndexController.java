package com.sgg.admin.controller;

import com.sgg.admin.bean.Customers;
import com.sgg.admin.bean.User;
import com.sgg.admin.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author huangruiqing
 * @Description
 * @date 2022-10-07 15:54
 */
@Controller
public class IndexController {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired
    CustomersService customersService;
    
    @ResponseBody
    @GetMapping("/cust")
    public Customers getById(@RequestParam("id") Long id){
    
        return customersService.getCustById(id);
    }
    
    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from smbms_address", long.class);
        return aLong.toString();
    }
    
    

    /** 
     * @Description //TODO 登录页
     * @Author huangruiqing
     * @Date 15:56 2022/10/7
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping({"/","/login"})
    public String loginPage(){
        
        return "login";
    }
    
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
    
        if(!StringUtils.isEmpty(user.getUserName()) && StringUtils.hasLength(user.getPassword())){
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser", user);
            //登录成功重定向到main.html;  重定向防止表单重复提交
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            return "login";
        }
        
     
    }
    
    /**
     * @Description //TODO 去main页面
     * @Author huangruiqing
     * @Date 16:10 2022/10/7
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
    
        /*Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null){
            return "main";
        } else {
            model.addAttribute("msg","请重新登录");
            return "login";
        }*/
        return "main";
    }
}
