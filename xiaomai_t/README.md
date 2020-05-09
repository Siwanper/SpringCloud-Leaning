
###Swagger2 使用方法

####Maven配置
    <dependencies>
        <!--Swagger2 - RESTful API文档-->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
        </dependency>
    </dependencies>
    
####配置文件 及 插件配置

在启动类上 加@EableSwagger2 

默认swagger2的界面地址是:项目的根路径/swagger-ui.html

####注解API

@Api：修饰整个类，描述Controller的作用

@ApiOperation：描述一个类的一个方法，或者说一个接口

@ApiParam：单个参数描述

@ApiModel：用对象来接收参数

@ApiProperty：用对象接收参数时，描述对象的一个字段

@ApiResponse：HTTP响应其中1个描述

@ApiResponses：HTTP响应整体描述

@ApiIgnore：使用该注解忽略这个API

@ApiError ：发生错误返回的信息

@ApiImplicitParam：描述一个请求参数，可以配置参数的中文含义，还可以给参数设置默认值

@ApiImplicitParams：描述由多个 @ApiImplicitParam 注解的参数组成的请求参数列表

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