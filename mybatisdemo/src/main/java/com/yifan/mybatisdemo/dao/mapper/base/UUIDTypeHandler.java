package com.yifan.mybatisdemo.dao.mapper.base;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UUIDTypeHandler extends BaseTypeHandler {
    @Override
    public String getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        String id="";
        if (rs.getString(columnName)!=null) {
            try {
                id = UUID.fromString(rs.getString(columnName)).toString();
            } catch (Exception e) {
                id =rs.getString(columnName).toString();
            }
        }
        return  id;
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        Object id="";
        if (cs.getString(columnIndex)!=null) {
            try {
                id = UUID.fromString((cs.getString(columnIndex)));
            } catch (Exception e) {
                id = cs.getString(columnIndex);
            }
        }
        return id;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i,
                                    Object parameter, JdbcType jdbcType) throws SQLException {
        try {
            ps.setObject(i,UUID.fromString(parameter.toString()));
        }catch(Exception e)
        {
            ps.setObject(i,null);
        }
    }
}
