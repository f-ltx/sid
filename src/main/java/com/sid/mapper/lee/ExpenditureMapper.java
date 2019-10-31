package com.sid.mapper.lee;

import com.sid.model.lee.Expenditure;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExpenditureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Expenditure record);

    int insertSelective(Expenditure record);

    Expenditure selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Expenditure record);

    int updateByPrimaryKey(Expenditure record);
}