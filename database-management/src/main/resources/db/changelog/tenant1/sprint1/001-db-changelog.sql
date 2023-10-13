-- liquibase formatted sql

-- changeset muthu:1
CREATE TABLE test_table_1 (
    test_column_1 VARCHAR(255) NOT NULL
);
-- rollback DROP TABLE test_table_1

-- changeset muthu:2
CREATE TABLE test_table_2 (
    test_column_1 VARCHAR(255) NOT NULL
);
-- rollback DROP TABLE test_table_2

-- changeset muthu:3
CREATE TABLE test_table_3 (
    test_column_1 VARCHAR(255) NOT NULL
);
-- rollback DROP TABLE test_table_3
