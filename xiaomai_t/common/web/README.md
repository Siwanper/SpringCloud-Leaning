#WEB 公告包

主要封装了一些web中常用的核心类和对象。例如VO ，PO，统一异常处理，拦截器，redis配置。

#通用的实体对象

VO ： 值对象 ，只存在与Controller  Service中，用于和业务交互

PO ： 持久化对象，和数据库进行交互，存在与DAO。

VO和PO的数据有可能一样，但是他们所表示的意义完全不一样。

FORM ： 表单数据。可以转为PO。

QueryFORM ： 表单查询数据。可以转为Param。

PARAM ： 参数。