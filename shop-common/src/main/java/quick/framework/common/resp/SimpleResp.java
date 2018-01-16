package quick.framework.common.resp;

/**
 * 数据集响应对象
 *
 * @param <T>
 */
public class SimpleResp<T> extends Response {
    private static final long serialVersionUID = -1560733582226132947L;

    private long total;

    private T record;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public T getRecord() {
        return record;
    }

    public void setRecord(T record) {
        this.record = record;
    }
}
