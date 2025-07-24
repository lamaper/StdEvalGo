package org.birdt.stdevalgo.Coontroller;

import org.birdt.stdevalgo.Utils.Result;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldReq {
    // 登录/注册接口
    @RequestMapping("/api/auth/login")
    public Result loginOrRegister(@RequestBody LoginRequest request) {
        System.out.println(request);
        return Result.success();
    }
}


class LoginRequest {
    private String studentId;
    private String password;

    public LoginRequest() {}

    public LoginRequest(String studentId, String password) {
        this.studentId = studentId;
        this.password = password;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequest [studentId=" + studentId + ", password=" + password + "]";
    }
}