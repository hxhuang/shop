package quick.framework.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.framework.common.event.BaseEvent;
import quick.framework.common.resp.Response;
import quick.framework.shop.service.test.TestService;

@RestController
@RequestMapping("/test")
@Api("测试")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/hello")
    @ApiOperation(value = "测试控制器")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "limit", value = "分页Id", required = true, dataType = "Long")
    })
    public Response test(BaseEvent event) {
        return testService.doService(event);
    }

}
