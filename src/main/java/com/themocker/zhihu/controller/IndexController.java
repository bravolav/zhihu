package com.themocker.zhihu.controller;

import com.themocker.zhihu.service.WendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    WendaService wendaService;

    @RequestMapping(path={"/","/index"})
    @ResponseBody
    public String index(){
        return "Hello NewCoder";
    }

    @RequestMapping(path={"/profile/{gId}/{useId}"})
    @ResponseBody
    public String profile(@PathVariable("useId") int useId,
                          @PathVariable("gId") int gId,
                          @RequestParam(value = "type", defaultValue = "1") int type,
                          @RequestParam(value = "key",required = false) String key
                          ){
        return String.format("Profile Page of %s / %d, t: %d k: %s",gId,useId,type,key);
    }

    @RequestMapping(path = {"/vm"}, method = {RequestMethod.GET})
    public String template(Model model){
        model.addAttribute("value1","vvvv1");
        List<String> colors = Arrays.asList(new String[]{"RED","GREEN"});
        model.addAttribute("colors",colors);
        return "home";

    }

    @RequestMapping(path = {"/request"}, method = {RequestMethod.GET})
    @ResponseBody
    public String request(Model model, HttpServletResponse response,
                          HttpServletRequest request, HttpSession httpSession,
                          @CookieValue("JSESSIONID") String sessionId){
            StringBuilder sb = new StringBuilder();
            sb.append("COOKIEVALUE:"+ sessionId);
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            sb.append(name + ":" + request.getHeader(name)+"<br>");
        }
            sb.append(request.getMethod() +   "<br>");
        sb.append(request.getQueryString() + "<br>");
        sb.append(request.getMethod() + "<br>");
        sb.append(request.getRequestURI() + "<br>");


            response.addHeader("nowcoderId","hello");
            response.addCookie(new Cookie("username","nowcoder"));
            return  sb.toString();
    }
}
