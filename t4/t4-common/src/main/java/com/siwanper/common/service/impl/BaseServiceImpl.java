package com.siwanper.common.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.siwanper.common.model.PageModel;
import com.siwanper.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public abstract class BaseServiceImpl<Mapper, Record, Example> implements BaseService<Record, Example> {

    @Autowired
    private Mapper mapper;

    @Override
    public long countByExample(Example example) {
        long res = 0;
        try {
            Method method = mapper.getClass().getDeclaredMethod("countByExample", example.getClass());
            Object result = method.invoke(mapper, example);
            res = Long.parseLong(String.valueOf(result));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int deleteByExample(Example example) {
        int res = 0;
        try {
            Method method = mapper.getClass().getDeclaredMethod("deleteByExample", example.getClass());
            Object result = method.invoke(mapper, example);
            res = Integer.parseInt(String.valueOf(result));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int deleteByPrimaryKey(String key) {
        int res = 0;
        try {
            Method method = mapper.getClass().getDeclaredMethod("deleteByPrimaryKey", key.getClass());
            Object result = method.invoke(mapper, key);
            res = Integer.parseInt(String.valueOf(result));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int insert(Record record) {
        int res = 0;
        try {
            Method method = mapper.getClass().getDeclaredMethod("insert", record.getClass());
            Object result = method.invoke(mapper, record);
            res = Integer.parseInt(String.valueOf(result));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int insertSelective(Record record) {
        int res = 0;
        try {
            Method method = mapper.getClass().getDeclaredMethod("insertSelective", record.getClass());
            Object result = method.invoke(mapper, record);
            res = Integer.parseInt(String.valueOf(result));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Record> selectByExample(Example example) {
        List<Record> list = null;
        try {
            Method method = mapper.getClass().getDeclaredMethod("selectByExample", example.getClass());
            Object result = method.invoke(mapper, example);
            list = (List<Record>) result;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Record selectByPrimaryKey(String key) {
        Record record = null;
        try {
            Method method = mapper.getClass().getDeclaredMethod("selectByPrimaryKey", key.getClass());
            Object result = method.invoke(mapper, key);
            record = (Record) result;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return record;
    }

    @Override
    public PageModel<Record> selectByExampleStartPage(Example example, Integer pageNumber, Integer pageSize) {
        PageModel<Record> pageModel = null;
        try {
            Method method = mapper.getClass().getDeclaredMethod("selectByExample", example.getClass());
            PageHelper.startPage(pageNumber, pageSize);
            Object result = method.invoke(mapper, example);
            pageModel = new PageModel<>((Page<Record>) result);
            return pageModel;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return pageModel;
    }

    @Override
    public PageModel<Record> selectByExampleOffset(Example example, Integer offset, Integer limit) {
        PageModel<Record> pageModel = null;
        try {
            Method method = mapper.getClass().getDeclaredMethod("selectByExample", example.getClass());
            PageHelper.offsetPage(offset, limit);
            Object result = method.invoke(mapper, example);
            pageModel = new PageModel<>((Page<Record>) result);
            return pageModel;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return pageModel;
    }

    @Override
    public int updateByExampleSelective(Record record, Example example) {
        int res = 0;
        try {
            Method method = mapper.getClass().getDeclaredMethod("updateByExampleSelective", record.getClass(),example.getClass());
            Object result = method.invoke(mapper, record, example);
            res = Integer.parseInt(String.valueOf(result));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int updateByExample(Record record, Example example) {
        int res = 0;
        try {
            Method method = mapper.getClass().getDeclaredMethod("updateByExample", record.getClass(),example.getClass());
            Object result = method.invoke(mapper, record, example);
            res = Integer.parseInt(String.valueOf(result));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int updateByPrimaryKeySelective(Record record) {
        int res = 0;
        try {
            Method method = mapper.getClass().getDeclaredMethod("updateByPrimaryKeySelective", record.getClass());
            Object result = method.invoke(mapper, record);
            res = Integer.parseInt(String.valueOf(result));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int updateByPrimaryKey(Record record) {
        int res = 0;
        try {
            Method method = mapper.getClass().getDeclaredMethod("updateByPrimaryKey", record.getClass());
            Object result = method.invoke(mapper, record);
            res = Integer.parseInt(String.valueOf(result));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return res;
    }
}
