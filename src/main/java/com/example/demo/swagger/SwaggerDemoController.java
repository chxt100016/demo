package com.example.demo.swagger;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "swagger测试")
@RestController
public class SwaggerDemoController {

    @ApiOperation(value="value", notes="notes", produces="application/json")
    @ApiImplicitParams({@ApiImplicitParam(name="id", value = "编号"),
            @ApiImplicitParam(name="name", value = "名字")})
    @RequestMapping("/swaggerTest")
    public String hello(String name, String id) {
        return String.format("hello,name:%s,id:%s", name, id);
    }
}
