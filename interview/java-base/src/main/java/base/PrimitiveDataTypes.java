package base;

/**
 * @author Seven.Xu
 * @version 2021/4/28
 **/
public class PrimitiveDataTypes {
    public void a(){
        boolean result = true;
        char capitalC = 'C';
        byte by = 100;
        short s = 10000;
        int i = 100000;
        int a=0;
        //
        short b = 12;
        //-128~127
        Short.valueOf(b);
        Integer.valueOf(a);
        Long.valueOf(a);
        byte c='1';
        Byte.valueOf(c);

        //<=127->cache,else new
        Character.valueOf('a');
        Boolean.valueOf(true);

        //new
        Double.valueOf(1d);
        Float.valueOf(1f);
    }

    public static void main(String[] args) {

    }
}
