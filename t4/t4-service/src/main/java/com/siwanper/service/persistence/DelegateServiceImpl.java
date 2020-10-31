package com.siwanper.service.persistence;

import com.github.pagehelper.PageHelper;
import com.siwanper.api.persistence.DelegateService;
import com.siwanper.common.model.PageModel;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 名称：DelegateServiceImpl
 * 描述：Service代理类，封装常用的sql语句 CRUD
 * 传入的参数statement，是对应sqlMapper中 sql语句 的映射名，而不是sql语句
 *
 * @author chenjie
 * @date 2020/10/31  11:39 上午
 */
@Service("delegateService")
public class DelegateServiceImpl implements DelegateService {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public <T> T selectOne(String statement) {
        return this.sqlSessionTemplate.selectOne(statement);
    }

    @Override
    public <T> T selectOne(String statement, Object param) {
        return this.sqlSessionTemplate.selectOne(statement, param);
    }

    @Override
    public <T> List<T> selectList(String statement) {
        return this.sqlSessionTemplate.selectList(statement);
    }

    @Override
    public <T> List<T> selectList(String statement, Object param) {
        return this.sqlSessionTemplate.selectList(statement, param);
    }

    @Override
    public <T> PageModel<T> selectPage(String statement, int offset, int limit) {
        return new PageModel(PageHelper.offsetPage(offset,limit).doSelectPage(() -> this.sqlSessionTemplate.selectList(statement)));
    }

    @Override
    public <T> PageModel<T> selectPage(String statement, String param, int offset, int limit) {
        return new PageModel(PageHelper.offsetPage(offset,limit).doSelectPage(() -> this.sqlSessionTemplate.selectList(statement, param)));
    }

    @Override
    public int insert(String statement) {
        return this.sqlSessionTemplate.insert(statement);
    }

    @Override
    public int insert(String statement, Object parameter) {
        return this.sqlSessionTemplate.insert(statement, parameter);
    }

    @Override
    public int update(String statement) {
        return this.sqlSessionTemplate.update(statement);
    }

    @Override
    public int update(String statement, Object parameter) {
        return this.sqlSessionTemplate.update(statement, parameter);
    }

    @Override
    public int delete(String statement) {
        return this.sqlSessionTemplate.delete(statement);
    }

    @Override
    public int delete(String statement, Object parameter) {
        return this.sqlSessionTemplate.delete(statement, parameter);
    }
}
