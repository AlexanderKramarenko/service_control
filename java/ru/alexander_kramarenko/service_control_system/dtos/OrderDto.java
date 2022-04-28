package ru.alexander_kramarenko.service_control_system.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.alexander_kramarenko.service_control_system.model.*;


import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private LocalDateTime createdAt;
    private User customer;
    private User executor;
    private Model model;
    private Category category;
    private String subject;
    private String description;
    private Date deadline;
    private Status statuses;
    private String serialNumber;
    private Float totalPrice;

    public OrderDto(Order orders) {
        this.id = orders.getId();
        this.createdAt = orders.getCreatedAt();
        this.customer = orders.getCustomer();
        this.executor = orders.getExecutor();
        this.model = orders.getModel();
        this.category = orders.getCategory();
        this.subject = orders.getSubject();
        this.description = orders.getDescription();
        this.deadline = orders.getDeadline();
        this.statuses = orders.getStatuses();
        this.serialNumber = orders.getSerialNumber();
        this.totalPrice = orders.getTotalPrice();

    }
}
