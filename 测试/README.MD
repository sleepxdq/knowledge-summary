测试规范
---
## 测试优点
1. 提升软件质量
2. 便于优化和重构
3. 提升研发效率
## 基本原则
1. AIR原则：

    - Automatic(自动化)
    >自动判断执行结果，不需要人为参加，不需要人为判断结果
    - Independent(独立性)
    >测试之间不要互相影响，没有依赖关系
    - Repeatable(可重复)
    >可以重复执行，不受外界（网络、服务、中间件）影响

2. BCDE：
    - Border
    >边界值测试，包括循环边界、特殊取值、特殊时间点、数据顺序等
    - Correct
    >正确的输入，得到预期结果
    - Design
    >与设计文档相结合写单元测试
    - Error
    >单元测试的目的是证明程序有错，而不是程序无错
## 覆盖率
1. 类覆盖和方法覆盖

    每个类和每个方法都得写测试
2. 情景覆盖

    上面的覆盖很容易达到100%，但这是不够的，我们要满足方法内各种情况，各种场景的测试，这样这个方法的所有情况都覆盖了。
## 命名
单元测试类与被测试类一一对应，包结构相同，类名是：被测试类Test，单元测试必须要在test下，测试资源文件必须在test/resource下
> 方法命名最好使用should...When结构，尽量在五个单词内
## 断言的使用
尽量使用流式断言，例如：
```
Assertions.asserThat("abcd").as("字符串判断：判断首尾集长度")
    .startsWith("abc")
    .endWith("de")
    .hasSize(4)
```
[Mockito:How-to-write-good-tests](https://github.com/mockito/mockito/wiki/How-to-write-good-tests)
