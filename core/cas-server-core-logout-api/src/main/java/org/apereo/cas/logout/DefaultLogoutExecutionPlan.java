package org.apereo.cas.logout;

import org.apereo.cas.logout.slo.SingleLogoutServiceMessageHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This is {@link DefaultLogoutExecutionPlan}.
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
@Slf4j
public class DefaultLogoutExecutionPlan implements LogoutExecutionPlan {
    private final List<LogoutRedirectionStrategy> logoutRedirectionStrategies = new ArrayList<>(0);
    
    private final List<LogoutPostProcessor> handlers = new ArrayList<>(0);

    private final List<SingleLogoutServiceMessageHandler> singleLogoutServiceMessageHandlers = new ArrayList<>(0);

    @Override
    public void registerLogoutPostProcessor(final LogoutPostProcessor handler) {
        LOGGER.debug("Registering logout handler [{}]", handler.getName());
        handlers.add(handler);
        AnnotationAwareOrderComparator.sort(this.handlers);
    }

    @Override
    public void registerSingleLogoutServiceMessageHandler(final SingleLogoutServiceMessageHandler handler) {
        LOGGER.trace("Registering single logout service message handler [{}]", handler.getName());
        singleLogoutServiceMessageHandlers.add(handler);
        AnnotationAwareOrderComparator.sort(this.singleLogoutServiceMessageHandlers);
    }

    @Override
    public void registerLogoutRedirectionStrategy(final LogoutRedirectionStrategy strategy) {
        LOGGER.trace("Registering logout redirection strategy [{}]", strategy.getName());
        logoutRedirectionStrategies.add(strategy);
        AnnotationAwareOrderComparator.sort(this.logoutRedirectionStrategies);
    }

    @Override
    public Collection<LogoutPostProcessor> getLogoutPostProcessors() {
        return this.handlers;
    }

    @Override
    public Collection<SingleLogoutServiceMessageHandler> getSingleLogoutServiceMessageHandlers() {
        return this.singleLogoutServiceMessageHandlers;
    }

    @Override
    public Collection<LogoutRedirectionStrategy> getLogoutRedirectionStrategies() {
        return this.logoutRedirectionStrategies;
    }
}
