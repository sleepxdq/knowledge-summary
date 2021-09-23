package base.proxy.jdk;

/**
 * @author Seven.Xu
 * @version 2021/5/3
 **/
public class Sample implements SampleInterface{
    @Override
    public void print() {
        System.out.println("Proxy Sample");
    }
}
