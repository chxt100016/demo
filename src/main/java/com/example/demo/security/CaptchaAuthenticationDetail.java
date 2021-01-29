package com.example.demo.security;

import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CaptchaAuthenticationDetail extends WebAuthenticationDetails {
    private boolean imageCodeIsRight;

    public boolean isImageCodeIsRight() {
        return imageCodeIsRight;
    }

    public CaptchaAuthenticationDetail(HttpServletRequest request) {
        super(request);
        String requestCode = request.getParameter("captcha");
        HttpSession session = request.getSession();
        String code = session.getAttribute("captcha") + "";
        if (!StringUtils.isEmpty(code)) {
            //清验证码
            session.removeAttribute("captcha");
            if (code.equals(requestCode)) {
                this.imageCodeIsRight = true;
            }
        }
    }
}
