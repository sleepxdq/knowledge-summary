package base.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author Seven.Xu
 * @version 2021/5/3
 **/
public class JDKProxySample {

    public static void main(String[] args) {
        SampleInterface proxyInstance = (SampleInterface) getProxyInstance(new Sample());
//        sample.print();
        proxyInstance.print();
    }

    private static Object getProxyInstance(Sample sample) {
        return Proxy.newProxyInstance(sample.getClass().getClassLoader(), sample.getClass().getInterfaces(), new SampleInvocationHandler(sample));
    }
}
