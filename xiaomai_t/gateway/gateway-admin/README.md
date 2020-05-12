### Predicates


        - Host=**.foo.org
        - Path=/headers
        - Method=GET
        - Header=X-Request-Id, \d+
        - Query=foo, ba.
        - Query=baz
        - Cookie=chocolate, ch.p
        - After=2018-01-20T06:06:06+08:00[Asia/Shanghai]

### Filters

#### 1 StripPrefix Filter
StripPrefix Filter 是一个请求路径截取的功能

#### 2 PrefixPath Filter
PrefixPath Filter 的作用和 StripPrefix 正相反，是在 URL 路径前面添加一部分的前缀

#### 3 RequestRateLimiter 限速路由器
首先需要添加对应的依赖包spring-boot-starter-data-redis-reactive

```
         filters:
            - name: RequestRateLimiter
            args:
                redis-rate-limiter.replenishRate: 10
                 redis-rate-limiter.burstCapacity: 20
                 key-resolver: "#{@userKeyResolver}"
```

#### 4 熔断路由器 Hystrix
Spring Cloud Gateway 也可以利用 Hystrix 的熔断特性，在流量过大时进行服务降级
```
        filters:
        - name: Hystrix
          args:
            name: fallbackcmd
            fallbackUri: forward:/incaseoffailureusethis
```

#### 5 RetryGatewayFilter 
是 Spring Cloud Gateway 对请求重试提供的一个 GatewayFilter Factory

```
        filters:
        - name: Retry
          args:
            retries: 3
            statuses: BAD_GATEWAY
```
```
retries：重试次数，默认值是 3 次
statuses：HTTP 的状态返回码，取值请参考：org.springframework.http.HttpStatus
methods：指定哪些方法的请求需要进行重试逻辑，默认值是 GET 方法，取值参考：org.springframework.http.HttpMethod
series：一些列的状态码配置，取值参考：org.springframework.http.HttpStatus.Series。符合的某段状态码才会进行重试逻辑，默认值是 SERVER_ERROR，值是 5，也就是 5XX(5 开头的状态码)，共有5 个值。
```

### @PostConstruct
被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行，init（）方法之前执行