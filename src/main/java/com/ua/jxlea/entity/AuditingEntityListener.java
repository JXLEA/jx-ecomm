package com.ua.jxlea.entity;


import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.Instant;

public class AuditingEntityListener {

    @PrePersist
    void preCreate(AbstractEntity auditable) {
        var now = Instant.now();
        auditable.setCreatedDate(now);
        auditable.setLastModifiedDate(now);
    }

    @PreUpdate
    void preUpdate(AbstractEntity auditable) {
        var now = Instant.now();
        auditable.setLastModifiedDate(now);
    }

}
