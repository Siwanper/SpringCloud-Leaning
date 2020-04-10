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


###3、异常处理
自定义枚举错误类型，声明自ErrorType （implements ErrorType）

自定义异常，继承自BaseException

统一处理异常 ，继承自DefaultGlobalExceptionHandlerAdvice，该类需要使用@RestControllerAdvice注解。

###4、WebMvc配置，主要是拦截器的配置。
继承自WebMvcConfigurer，使用重写addInterceptor方法，添加拦截器。

###5、redis使用
@EnableCaching

###6、rabbitmq使用


###7、Swagger2的使用