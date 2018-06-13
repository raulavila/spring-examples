package com.raulavila.springrestapi.audit

import org.springframework.stereotype.Service

@Service
class AuditService {

    val auditMessages = mutableListOf<String>()

    fun audit(message: String) {
        if (auditMessages.size == 2) {
            throw RuntimeException("Can't audit more operations!!!")
        }

        auditMessages.add(message)
    }

    fun getAllAuditMessages(): List<String> {
        return auditMessages
    }
}