ALTER TABLE inflatable
    ADD CONSTRAINT uc_inflatable_ar_name UNIQUE (ar_name);

ALTER TABLE inflatable
    ADD CONSTRAINT uc_inflatable_en_name UNIQUE (en_name);

ALTER TABLE inflatable_category
    ADD CONSTRAINT uc_inflatablecategory_ar_name UNIQUE (ar_name);

ALTER TABLE inflatable_category
    ADD CONSTRAINT uc_inflatablecategory_en_name UNIQUE (en_name);