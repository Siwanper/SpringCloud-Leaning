package com.siwanper.common.service;

import com.siwanper.common.model.PageModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseService<Record, Example> {

    /**
     * 根据条件查询记录数
     * @param example
     * @return
     */
    long countByExample(Example example);

    /**
     * 根据条件删除
     * @param example
     * @return
     */
    int deleteByExample(Example example);

    /**
     * 根据主键删除
     * @param key
     * @return
     */
    int deleteByPrimaryKey(String key);

    /**
     * 插入数据
     * @param record
     * @return
     */
    int insert(Record record);

    /**
     * 插入有效数据
     * @param record
     * @return
     */
    int insertSelective(Record record);

    /**
     * 根据条件查询
     * @param example
     * @return
     */
    List<Record> selectByExample(Example example);

    /**
     * 根据主键查询
     * @param key
     * @return
     */
    Record selectByPrimaryKey(String key);

    /**
     * 根据条件分页查询
     * @param example
     * @param pageNumber 当前页下标
     * @param pageSize  每页条数
     * @return
     */
    PageModel<Record> selectByExampleStartPage(Example example, Integer pageNumber, Integer pageSize);

    /**
     * 根据条件分页查询
     * @param example
     * @param offset 从多少条开始
     * @param limit  查询多少条
     * @return
     */
    PageModel<Record> selectByExampleOffset(Example example, Integer offset, Integer limit);

    /**
     * 根据条件更新记录的有效字段
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example);

    /**
     * 根据条件更新记录
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") Record record, @Param("example") Example example);

    /**
     * 根据主键更新记录的有效字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Record record);

    /**
     * 根据主键更新记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(Record record);

}
