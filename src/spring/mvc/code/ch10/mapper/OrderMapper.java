package spring.mvc.code.ch10.mapper;

import spring.mvc.code.ch10.domain.Order;

public interface OrderMapper {

    Order selectOrderById(int id);

}
