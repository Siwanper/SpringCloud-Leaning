### 单元测试

1、单元测试的特性

+ 单元测试不应该依赖外部系统
+ 单元测试运行速度很快
+ 单元测试不应该造成测试环境的脏数据
+ 单元测试可以重复运行。

2、单元测试怎么写

数据库操作层、中间件依赖层、业务逻辑层，各自的单元测试各自写，互相不要有依赖。


+ dao层测试，使用H2进行测试，做独立的BaseH2Test，只对dao的测试
+ service层测试，依赖mockito框架，使用@RunWith(MockitoJUnitRunner.class)注解，就无需加载其他spring bean，具体用法
+ 对于依赖外部的中间件（例如redis、diamond、mq），在处理单测的时候要注意分开加载和测试，尤其是与dao的测试分开

### TDD

测试驱动开发(Test-Driven Development)。是敏捷开发中的一项核心实践和技术。

TDD是在开发功能代码之前，先编写单元测试用例代码，测试代码确定需要编写什么产品代码。


### Mockito 框架
[参考链接](https://www.jianshu.com/p/ef282f186874)