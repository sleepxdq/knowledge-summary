package base.map;

import java.util.HashMap;

/**
 * @author Seven.Xu
 * @version 2021/5/4
 **/
public class HashMapSample {

    public static void main(String[] args) throws InterruptedException {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put("xdq" + i, "xdq" + i);
        }
        //k=xdq0,v=xdq0,会执行resize()，这是table的大小为16
        //这里的扩容只是开辟空间
        //k=xdq1,v=xdq1,会将元素放到table上,数组位置是hash(key)&(table大小-1)
        //k=xdq2,v=xdq2,会将元素放到table上,数组位置是hash(key)&(table大小-1)
        //...
        //k=xdq12,v=xdq12时，会发现同一个数组位置有元素，这时候会把新的元素链到原的next节点上
        //并且会发现size=13>16*0.75=12，这个会执行resize()做扩容
        //这里的扩容会开辟原来table大小的2次方(使用的是右移<<1)大小的新的table
        //会将原来table上的元素转移到新的table中，这里面会有三种逻辑
        //1.原来的table数组位置只有一个元素->基本是放在原来索引下
        //2.原来的table数组位置是一个链表->判断是否是相同索引位置，之后从头到尾的转到新的链表上，再放到对应的索引上
        //3.原来的table数组存放的是树节点-> todo

        //只有在节点长度大于等于8时&数组的长度大于等于64才会转红黑树
        //长度大于8但数组长度小于64只会resize()
    }
}
