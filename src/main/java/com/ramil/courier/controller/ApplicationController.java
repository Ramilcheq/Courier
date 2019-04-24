package com.ramil.courier.controller;

import com.ramil.courier.mapper.OrderMapper;
import com.ramil.courier.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
public class ApplicationController {
    private final OrderMapper orderMapper;

    public ApplicationController(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @RequestMapping
    public String main(Map<String, Object> model) {
        return "main";
    }

    @RequestMapping("/courier")
    public String courier() {
        return "courier";
    }

    @RequestMapping("/operator")
    public String operator(
            @RequestParam(required = false) Long orderId,
            Map<String, Object> model) {
        List<Order> orders = orderId != null ? orderMapper.getOrderById(orderId) : orderMapper.getOrders();
        model.put("orders", orders);
        return "operator";
    }

    @RequestMapping("/addOrder")
    public String addOrder(@RequestParam Long orderId) {
        try {
            orderMapper.addOrder(orderId);
        } catch (SQLException e) {
            return "error";
        }
        return "success";
    }
}
