CREATE TABLE tenants
(
    id         UUID         NOT NULL,
    name       VARCHAR(255) NOT NULL,
    status     VARCHAR(255) NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    CONSTRAINT pk_tenants PRIMARY KEY (id)
);