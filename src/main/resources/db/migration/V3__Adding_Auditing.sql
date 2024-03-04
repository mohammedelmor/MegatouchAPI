ALTER TABLE inflatable
    ADD created_by VARCHAR(255);

ALTER TABLE inflatable
    ADD created_date BIGINT;

ALTER TABLE inflatable
    ADD modified_by VARCHAR(255);

ALTER TABLE inflatable
    ADD modified_date BIGINT;

ALTER TABLE inflatable_category
    ADD created_by VARCHAR(255);

ALTER TABLE inflatable_category
    ADD created_date BIGINT;

ALTER TABLE inflatable_category
    ADD modified_by VARCHAR(255);

ALTER TABLE inflatable_category
    ADD modified_date BIGINT;

ALTER TABLE inflatable
    ALTER COLUMN created_date SET NOT NULL;

ALTER TABLE inflatable_category
    ALTER COLUMN created_date SET NOT NULL;