CREATE SEQUENCE IF NOT EXISTS inflatable_category_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS inflatable_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE inflatable
(
    id             BIGINT DEFAULT NEXTVAL('inflatable_seq'),
    en_name        VARCHAR(255),
    ar_name        VARCHAR(255),
    en_description VARCHAR(255),
    ar_description VARCHAR(255),
    length         INTEGER,
    width          INTEGER,
    height         INTEGER,
    category_id    BIGINT,
    CONSTRAINT pk_inflatable PRIMARY KEY (id)
);

CREATE TABLE inflatable_category
(
    id      BIGINT DEFAULT NEXTVAL('inflatable_category_seq'),
    en_name VARCHAR(255),
    ar_name VARCHAR(255),
    CONSTRAINT pk_inflatablecategory PRIMARY KEY (id)
);

CREATE TABLE inflatable_images
(
    inflatable_id BIGINT NOT NULL,
    image         VARCHAR(255)
);

CREATE TABLE inflatable_keywords
(
    inflatable_id BIGINT NOT NULL,
    keyword       VARCHAR(255)
);

ALTER TABLE inflatable
    ADD CONSTRAINT FK_INFLATABLE_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES inflatable_category (id);

ALTER TABLE inflatable_images
    ADD CONSTRAINT fk_inflatable_images_on_inflatable FOREIGN KEY (inflatable_id) REFERENCES inflatable (id);

ALTER TABLE inflatable_keywords
    ADD CONSTRAINT fk_inflatable_keywords_on_inflatable FOREIGN KEY (inflatable_id) REFERENCES inflatable (id);