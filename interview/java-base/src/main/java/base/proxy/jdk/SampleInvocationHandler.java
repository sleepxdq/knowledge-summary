package base.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Seven.Xu
 * @version 2021/5/3
 **/
public class SampleInvocationHandler implements InvocationHandler {

    private final Object target;

    public SampleInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前");
        Object result = method.invoke(this.target, args);
        System.out.println("代理后");
        return result;
    }
}
