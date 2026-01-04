package com.example.ledgerone.tenant

object TenantContext {

    private val currentTenant = ThreadLocal<Long>()

    fun setTenantId(id: Long) {
        currentTenant.set(id)
    }

    fun getTenantId(): Long? {
        return currentTenant.get()
    }

    fun clear() {
        currentTenant.remove()
    }
}