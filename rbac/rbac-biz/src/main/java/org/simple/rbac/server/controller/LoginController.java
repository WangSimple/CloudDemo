package org.simple.rbac.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@Api(tags = "登录接口")
@RequestMapping("")
@Slf4j
public class LoginController {

    @Value("${logout-path}")
    private String logoutPath;
    @ApiOperation("登录")
    //@PostMapping("/login")
    @RequestMapping("/login")
    public ResponseEntity<String> login(HttpServletRequest request){
        HttpSession session = request.getSession();
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid==null){
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid",uid);

        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>login");
        Assertion assertion= (Assertion) request.getSession().getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION);
        AttributePrincipal principal=assertion.getPrincipal();
        return new ResponseEntity<String>(principal.getName(), HttpStatus.OK);
    }

    @ApiOperation("登出")
    //@PostMapping("/logout")
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>logout");
        session.invalidate();
        log.info(logoutPath);
        return "redirect:"+logoutPath;
    }


}
