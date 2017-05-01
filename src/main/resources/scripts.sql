CREATE TABLE messages (
  id                SERIAL                   PRIMARY KEY,
  user_id   		INTEGER                  DEFAULT 0,
  email             VARCHAR(255)             NOT NULL,
  message           VARCHAR(255)             NOT NULL,
  send_date_time     TIMESTAMP               DEFAULT now(),
  new_one           BOOLEAN                  DEFAULT TRUE
);