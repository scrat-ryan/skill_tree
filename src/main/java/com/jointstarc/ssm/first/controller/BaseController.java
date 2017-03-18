package com.jointstarc.ssm.first.controller;

import com.jointstarc.ssm.first.utils.UuidUtil;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with lol.
 * Description:
 * User: lol.
 * Date: 16/9/11.
 * Time: 09:38.
 */
public class BaseController {

    /**
     * BaseController调用之前必须调用的方法.
     *
     * @return HttpSession
     */
    @ModelAttribute
    public void initPath(HttpServletRequest request, ModelMap model) {
        String base = request.getContextPath().toString(); // /rent
        String rootUrl = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort();// http://localhost:8080
        String fullPath = rootUrl + base;// http://localhost:8080/rent
        String url = fullPath + request.getServletPath().toString();// http://localhost:8080/wdy/xxController/xx.do
        String phUrl = request.getSession().getServletContext().getRealPath("");// D:\\j2ee\\...\\wtpwebapps\\ssss

        model.addAttribute("base", base);
        model.addAttribute("rootUrl", rootUrl);
        model.addAttribute("fullPath", fullPath);
        model.addAttribute("url", url);
        model.addAttribute("phUrl", phUrl);
        model.addAttribute("app_name","my ssm demo");
    }

    /**
     * 得到32位的uuid
     *
     * @return
     */
    public String get32UUID() {
        return UuidUtil.get32UUID();
    }
}
