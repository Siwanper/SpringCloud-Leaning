
#Swagger2 使用方法

##Maven配置
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
    
##配置文件 及 插件配置

在启动类上 加@EableSwagger2 

默认swagger2的界面地址是:项目的根路径/swagger-ui.html

##注解API

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

