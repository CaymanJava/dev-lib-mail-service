CREATE TABLE messages (
  id                SERIAL                   PRIMARY KEY,
  user_id   		INTEGER                  DEFAULT 0,
  email             VARCHAR(255)             NOT NULL,
  message           VARCHAR              DEFAULT '',
  ip           VARCHAR(255)             DEFAULT '',
  send_date_time     TIMESTAMP               DEFAULT now(),
  new_one           BOOLEAN                  DEFAULT TRUE
);