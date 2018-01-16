package quick.framework.shop.service;

import quick.framework.common.event.BaseEvent;
import quick.framework.common.resp.Response;

/**
 * 所有service类需实现此接口<br />
 * 统一的编码规范
 */
public interface IService {

    /**
     * 实现此方法<br />
     * 统一的service层业务处理
     *
     * @param event 事件对象
     * @param args  扩展参数
     * @return 数据响应对象
     */
    Response doService(BaseEvent event, Object... args);

}
