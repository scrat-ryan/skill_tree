package com.jointstarc.ssm.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with jointstarc.
 * Description:
 * User: lol.
 * Date: 2017/1/26.
 * Time: 22:02.
 */
@Controller
public class LoginController extends BaseController {

    @RequestMapping("/login")
    public ModelAndView welcome() {
        ModelAndView mav = new ModelAndView();
        String str = "这是返回给freemarker页面的值";
        mav.addObject("haha", str);
        mav.setViewName("/login");
        return mav;
    }
}
