package com.ramil.courier.mapper;

import com.ramil.courier.model.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface OrderMapper {
    @Select("SELECT \"ORD_ID\", to_char(\"ORD_DATE\", 'DD.MM.YYYY HH24:MI:SS') as ORD_DATE FROM DELIVERY.ORDERS " +
            "WHERE \"ORD_ID\" = #{orderId}")
    List<Order> getOrderById(Long orderId);

    @Select("SELECT \"ORD_ID\", to_char(\"ORD_DATE\", 'DD.MM.YYYY HH24:MI:SS') as ORD_DATE FROM DELIVERY.ORDERS")
    List<Order> getOrders();

    @Insert("INSERT INTO DELIVERY.ORDERS(\"ORD_ID\") VALUES (#{orderId})")
    void addOrder(Long orderId) throws SQLException;
}
