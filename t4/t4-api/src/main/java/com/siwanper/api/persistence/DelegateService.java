package com.siwanper.api.persistence;

import com.siwanper.common.model.PageModel;

import java.util.List;

/**
 * 名称：DelegateService
 * 描述：代理Service接口，封装常用的sql CRUD
 *
 * @author chenjie
 * @date 2020/10/31  11:17 上午
 */
public interface DelegateService {

    /**
     * 无参数查询单个对象
     *
     * @param statement 对应 sqlMapper 模板中的单个对象查询 sql 语句的映射名
     * @param <T> 查询返回的对象
     * @return
     */
    public <T> T selectOne(String statement);

    /**
     * 带参数查询单个对象
     *
     * @param statement 对应 sqlMapper 模板中的单个对象查询 sql 语句的映射名
     * @param param 查询所需要的参数
     * @param <T> 查询返回的对象
     * @return
     */
    public <T> T selectOne(String statement, Object param);

    /**
     * 无参数查询集合对象
     *
     * @param statement 对应 sqlMapper 模板中的集合对象查询 sql 语句的映射名
     * @param <T> 查询返回的对象
     * @return
     */
    public <T> List<T> selectList(String statement);

    /**
     * 带参数查询集合对象
     *
     * @param statement 对应 sqlMapper 模板中的集合对象查询 sql 语句的映射名
     * @param param 查询所需要的参数
     * @param <T> 查询返回的对象
     * @return
     */
    public <T> List<T> selectList(String statement, Object param);

    /**
     * 无参数分页查询
     *
     * @param statement 对应 sqlMapper 模板中的集合对象查询 sql 语句的映射名
     * @param offset 查询开始位置
     * @param limit 查询数量
     * @param <T> 查询返回的对象
     * @return
     */
    public <T> PageModel<T> selectPage(String statement, int offset, int limit);

    /**
     * 带参数分页查询
     *
     * @param statement 对应 sqlMapper 模板中的集合对象查询 sql 语句的映射名
     * @param param 查询所需参数
     * @param offset 查询开始位置
     * @param limit 查询数量
     * @param <T> 查询返回的对象
     * @return
     */
    public <T> PageModel<T> selectPage(String statement, String param, int offset, int limit);

    /**
     * 无参增加方法<br>
     *
     * @param statement 对应 sqlMapper 模板中的增加 sql 语句的映射名
     * @return int 增加成功的条数
     */
    int insert(String statement);

    /**
     * 带参增加方法<br>
     *
     * @param statement 对应 sqlMapper 模板中的增加 sql 语句的映射名
     * @param parameter 增加数据所需的参数
     * @return int 增加成功的条数
     */
    int insert(String statement, Object parameter);

    /**
     * 无参修改方法<br>
     *
     * @param statement 对应 sqlMapper 模板中的修改 sql 语句的映射名
     * @return int 修改成功的条数
     */
    int update(String statement);

    /**
     * 带参修改方法<br>
     *
     * @param statement 对应 sqlMapper 模板中的修改 sql 语句的映射名
     * @param parameter 修改数据所需的参数
     * @return int 修改成功的条数
     */
    int update(String statement, Object parameter);

    /**
     * 无参删除方法<br>
     *
     * @param statement 对应 sqlMapper 模板中的删除 sql 语句的映射名
     * @return int 删除成功的条数
     */
    int delete(String statement);

    /**
     * 带参删除方法<br>
     *
     * @param statement 对应 sqlMapper 模板中的删除 sql 语句的映射名
     * @param parameter 删除数据所需的参数
     * @return int 删除成功的条数
     */
    int delete(String statement, Object parameter);


}
