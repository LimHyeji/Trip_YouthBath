use enjoytrip;

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
    INDEX  `id_idx` (`id` ASC) VISIBLE,
    CONSTRAINT `id`
        FOREIGN KEY (`id`)
            REFERENCES `enjoytrip`.`member` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);
CREATE TABLE `enjoytrip`.`board`
(
    `articleno` BIGINT       NOT NULL AUTO_INCREMENT,
    `title`     VARCHAR(255) NOT NULL,
    `content`   TEXT NULL,
    `hit`       INT NULL DEFAULT 0,
    `writer`    VARCHAR(50)  NOT NULL,
    `regTime`   DATETIME NULL DEFAULT now(),
    PRIMARY KEY (`articleno`),
    INDEX       `writer_id_idx` (`writer` ASC) VISIBLE,
    CONSTRAINT `writer_id`
        FOREIGN KEY (`writer`)
            REFERENCES `enjoytrip`.`member` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);
