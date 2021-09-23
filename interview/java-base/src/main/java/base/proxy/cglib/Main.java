package base.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author Seven.Xu
 * @version 2021/5/4
 **/
public class Main {
    public static void main(String[] args) {
        Sample sample = (Sample) getProxy(SubSample.class);
//        Sample sample = (Sample) getProxy(Sample.class);
        sample.print();
    }

    public static Object getProxy(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new SampleInterceptor());
        return enhancer.create();
    }
}
