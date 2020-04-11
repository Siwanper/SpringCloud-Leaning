###1、PO、VO、form、param
po继承自BasePo，和数据库字段对应一致。

vo继承自BaseVo<T extends BasePo>， 用户业务输出，为了不暴漏数据库字段，如果和数据库字段一致，可以将Po转为Vo

form继承自BaseForm<T extends BasePo>提交的表单数据，可以使用org.hibernate.validator验证，如果和数据库字段一致，可以转为Po

queryForm继承自BaseQueryForm<T extends BaseParam>，查询表单，封装了Page，可以转为param

param继承自BaseParam<T extends BasePo>，用户在service中条件查询。

###2、mybatis配置
1、分页配置 PaginationInterceptor

2、逻辑删除配置 LogicSqlInjector，并在配置文件中配置 logic-delete-value 和 logic-not-delete-value

3、公共字段自动填充 MetaObjectHandler

#### mybatis plus 使用
1、mapper 声明自 BaseMapper<T>

2、service 声明自 ServiceImpl<M extends BaseMapper<T>, T>

常用方法
save(User user), deleteById(String id), updateById(String id), getById(String id), getOne(wrapper), page(page, wrapper) 

###3、异常处理
自定义枚举错误类型，声明自ErrorType （implements ErrorType）

自定义异常，继承自BaseException

统一处理异常 ，继承自DefaultGlobalExceptionHandlerAdvice，该类需要使用@RestControllerAdvice注解。

###4、WebMvc配置，主要是拦截器的配置。
继承自WebMvcConfigurer，使用重写addInterceptor方法，添加拦截器。

###5、redis使用
配置 @EnableCaching

JetCache是一个基于Java的缓存系统封装，提供统一的API和注解来简化缓存的使用。 JetCache提供了比SpringCache更加强大的注解，可以原生的支持TTL、两级缓存、分布式自动刷新，还提供了Cache接口用于手工缓存操作。当前有四个实现，RedisCache、TairCache（此部分未在github开源）、CaffeineCache(in memory)和一个简易的LinkedHashMapCache(in memory)，要添加新的实现也是非常简单的。

[jetcache参考链接](https://blog.csdn.net/sinat_32366329/article/details/80260944)

[官网](https://github.com/alibaba/jetcache)

###6、rabbitmq使用


###7、Swagger2的使用


###8、日期统一处理
1、数据库存储：
```
created_time DATETIME     NOT NULL DEFAULT now() COMMENT '创建时间',
```

2、Po中字段：
```
private Date createdTime;
```

3、form表单请求：
```
@ApiModelProperty(value = "查询的开始时间")
@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
@Past(message = "查询的开始时间必须小于当前时间")
private Date createdStartTime;
```
4、post请求参数
```
{
	"page":"1",
	"size":"10",
	"username":"史万鹏1",
	"createdStartTime":"2020-04-10 20:15:36",
	"createdEndTime":"2020-04-10 22:15:36"
}
```