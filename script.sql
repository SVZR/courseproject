CREATE TABLE coin
(
  id            INT AUTO_INCREMENT
    PRIMARY KEY,
  name          VARCHAR(50)  NOT NULL,
  series_id     INT          NOT NULL,
  release_date  VARCHAR(50)  NOT NULL,
  designer      VARCHAR(50)  NOT NULL,
  minted_by     VARCHAR(50)  NOT NULL,
  description   TEXT         NOT NULL,
  image_address VARCHAR(100) NOT NULL,
  CONSTRAINT coin_image_address_uindex
  UNIQUE (image_address)
)
  ENGINE = InnoDB;

CREATE INDEX series_id
  ON coin (series_id);

CREATE TABLE coin_description
(
  id            INT AUTO_INCREMENT
    PRIMARY KEY,
  coin_id       INT          NOT NULL,
  metal_id      INT          NOT NULL,
  denomination  INT          NULL,
  weight        FLOAT        NULL,
  diameter      FLOAT        NULL,
  mintage       INT          NULL,
  image_obverse VARCHAR(100) NOT NULL,
  image_reverse VARCHAR(100) NOT NULL,
  CONSTRAINT image_obverse
  UNIQUE (image_obverse),
  CONSTRAINT image_reverse
  UNIQUE (image_reverse),
  CONSTRAINT coin_description_ibfk_1
  FOREIGN KEY (coin_id) REFERENCES coin (id)
)
  ENGINE = InnoDB;

CREATE INDEX coin_id
  ON coin_description (coin_id);

CREATE INDEX metal_id
  ON coin_description (metal_id);

CREATE TABLE collection
(
  id                 INT AUTO_INCREMENT
    PRIMARY KEY,
  user_id            INT NOT NULL,
  coindescription_id INT NOT NULL,
  amount             INT NOT NULL,
  CONSTRAINT collection_ibfk_2
  FOREIGN KEY (coindescription_id) REFERENCES coin_description (id)
)
  ENGINE = InnoDB;

CREATE INDEX user_id
  ON collection (user_id);

CREATE INDEX coin_description_id
  ON collection (coindescription_id);

CREATE TABLE country
(
  id   INT AUTO_INCREMENT
    PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  CONSTRAINT name
  UNIQUE (name)
)
  ENGINE = InnoDB;

CREATE TABLE metal
(
  id   INT AUTO_INCREMENT
    PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  CONSTRAINT name
  UNIQUE (name)
)
  ENGINE = InnoDB;

ALTER TABLE coin_description
  ADD CONSTRAINT coin_description_ibfk_2
FOREIGN KEY (metal_id) REFERENCES metal (id);

CREATE TABLE sale
(
  id            INT AUTO_INCREMENT
    PRIMARY KEY,
  collection_id INT     NOT NULL,
  cost          DECIMAL NOT NULL,
  CONSTRAINT sale_ibfk_1
  FOREIGN KEY (collection_id) REFERENCES collection (id)
)
  ENGINE = InnoDB;

CREATE INDEX user_coin_description_id
  ON sale (collection_id);

CREATE TABLE series
(
  id       INT AUTO_INCREMENT
    PRIMARY KEY,
  name     VARCHAR(50) NOT NULL,
  theme_id INT         NOT NULL
)
  ENGINE = InnoDB;

CREATE INDEX theme_id
  ON series (theme_id);

ALTER TABLE coin
  ADD CONSTRAINT coin_ibfk_1
FOREIGN KEY (series_id) REFERENCES series (id);

CREATE TABLE theme
(
  id         INT AUTO_INCREMENT
    PRIMARY KEY,
  name       VARCHAR(50) NOT NULL,
  country_id INT         NOT NULL,
  CONSTRAINT theme_ibfk_1
  FOREIGN KEY (country_id) REFERENCES country (id)
)
  ENGINE = InnoDB;

CREATE INDEX country_id
  ON theme (country_id);

ALTER TABLE series
  ADD CONSTRAINT series_ibfk_1
FOREIGN KEY (theme_id) REFERENCES theme (id);

CREATE TABLE user
(
  id           INT AUTO_INCREMENT
    PRIMARY KEY,
  username     VARCHAR(50) NOT NULL,
  useremail    VARCHAR(50) NOT NULL,
  userpassword VARCHAR(50) NOT NULL,
  role         VARCHAR(10) NOT NULL,
  CONSTRAINT user_id_uindex
  UNIQUE (id),
  CONSTRAINT user_username_uindex
  UNIQUE (username),
  CONSTRAINT user_useremail_uindex
  UNIQUE (useremail)
)
  ENGINE = InnoDB;

ALTER TABLE collection
  ADD CONSTRAINT collection_ibfk_1
FOREIGN KEY (user_id) REFERENCES user (id);

INSERT INTO country (name) VALUE ('Republic of Belarus');
INSERT INTO country (name) VALUE ('Republic of Kazakhstan');
INSERT INTO country (name) VALUE ('Russian Federation');
