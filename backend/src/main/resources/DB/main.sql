create
database huhjdb;

use
huhjdb;

-- create table member(
--     id varchar(20) primary key,
--     pw varchar(500),
--     name varchar(20)
--     );
--
-- # 관광지 크롤링 코드 실행

CREATE TABLE member
(
    `id`       VARCHAR(50)  NOT NULL,
    `password` VARCHAR(300) NOT NULL,
    `name`     VARCHAR(50)  NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);
CREATE TABLE membersec
(
    `id`   VARCHAR(50)  NOT NULL,
    `salt` VARCHAR(300) NOT NULL,
    `try_count` INT DEFAULT 0,
    `blocked_time` DATETIME,
    INDEX  `id_idx` (`id` ASC) VISIBLE,
    CONSTRAINT `id`
        FOREIGN KEY (`id`)
            REFERENCES `enjoytrip`.`member` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);
