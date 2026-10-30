package com.formation.shop.catalog;

import com.formation.shop.catalog.internal.CoffeeEntity;
import com.formation.shop.catalog.internal.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class Catalog {

    private final CoffeeRepository repository;
    private final ApplicationEventPublisher events;

    @Transactional
    public Long createCoffee(String name, int price)
    {
        CoffeeEntity saved = repository.save(new CoffeeEntity(name, price));
        events.publishEvent(new CoffeeCreated(saved.getId(), saved.getName()));
        return saved.getId();
    }

    @Transactional(readOnly = true)
    public List<CoffeeView> findAll() {
        return repository.findAll().stream()
                .map(c -> new CoffeeView(c.getId(), c.getName(), c.getPrice()))
                .toList();
    }

    public record CoffeeView(Long id, String name, int price) {}
}
