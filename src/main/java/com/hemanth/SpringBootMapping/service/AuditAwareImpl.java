package com.hemanth.SpringBootMapping.service;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditAwareImpl implements AuditorAware<String>
{

    AuditConfig auditConfig;
    @Override
    public Optional<String> getCurrentAuditor()
    {
        return Optional.of("Ramesh");

    }
}
