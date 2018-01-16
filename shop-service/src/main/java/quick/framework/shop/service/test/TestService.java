package quick.framework.shop.service.test;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;
import quick.framework.common.event.BaseEvent;
import quick.framework.common.resp.Response;
import quick.framework.shop.service.IService;

import java.util.Map;

@Service
public class TestService implements IService {
    public Response doService(BaseEvent event, Object... args) {

        Map<String, Object> map = Maps.newConcurrentMap();

        map.put("test", "Hello World");

        Response response = new Response();
        response.setObj(map);
        return response;
    }
}
