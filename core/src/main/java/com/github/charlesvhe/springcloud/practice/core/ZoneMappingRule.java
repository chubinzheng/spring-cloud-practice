package com.github.charlesvhe.springcloud.practice.core;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractServerPredicate;
import com.netflix.loadbalancer.AvailabilityPredicate;
import com.netflix.loadbalancer.CompositePredicate;
import com.netflix.loadbalancer.PredicateBasedRule;

/**
 * Created by charles on 2017/6/9.
 */
public class ZoneMappingRule extends PredicateBasedRule {
    private CompositePredicate compositePredicate;

    public ZoneMappingRule() {
        super();
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        this.compositePredicate = CompositePredicate.withPredicates(
                new AvailabilityPredicate(this, clientConfig)
                ).build();
    }

    @Override
    public AbstractServerPredicate getPredicate() {
        return this.compositePredicate;
    }
}