CREATE TABLE IF NOT EXISTS `TODOS`
(
    `id`          INTEGER PRIMARY KEY AUTO_INCREMENT,
    `title`       varchar(255) NOT NULL,
    `description` clob,
    `completed`   boolean      not null,
    `created_at`  timestamp,
    `updated_at`  timestamp
)
/*
select * from TODOS;
*/