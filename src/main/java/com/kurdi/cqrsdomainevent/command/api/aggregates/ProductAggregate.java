package com.kurdi.cqrsdomainevent.command.api.aggregates;

import com.kurdi.cqrsdomainevent.command.api.commands.CreateProductCommand;
import com.kurdi.cqrsdomainevent.command.api.events.ProductCreatedEvent;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
@NoArgsConstructor
@Data
public class ProductAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private double price;

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand){
        //validate if it's done create events
        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();

        BeanUtils.copyProperties(createProductCommand, productCreatedEvent);

        AggregateLifecycle.apply(productCreatedEvent);
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent)
    {
        this.id = productCreatedEvent.getId();
        this.name = productCreatedEvent.getName();
        this.price = productCreatedEvent.getPrice();
    }
}

