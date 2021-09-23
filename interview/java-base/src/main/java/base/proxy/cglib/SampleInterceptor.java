package base.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Seven.Xu
 * @version 2021/5/4
 **/
public class SampleInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("代理前");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("代理后");
        return result;
    }
}
