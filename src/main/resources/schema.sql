CREATE TABLE IF NOT EXISTS `TODOS`
(
    `id`         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    completed   boolean not null,
    created_at  timestamp,
    description clob,
    title       varchar(255),
    updated_at  timestamp
)

/*

CREATE TABLE IF NOT EXISTS `Person` (
                                        `id`         INTEGER  PRIMARY KEY AUTO_INCREMENT,
                                        `first_name` VARCHAR(50) NOT NULL,
                                        `age`        INTEGER  NOT NULL
);
*/