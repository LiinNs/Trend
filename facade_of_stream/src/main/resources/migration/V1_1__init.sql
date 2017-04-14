--
CREATE TABLE `article`(
  `id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` VARCHAR (50) NOT NULL COMMENT 'title',
  `abstracts` VARCHAR (50) NOT NULL COMMENT 'abstracts',
  `content` VARCHAR (500) NOT NULL COMMENT 'content',
  `post_time` DATETIME NOT NULL COMMENT 'postTime',
  `click_count` BIGINT (15) NOT NULL COMMENT 'clickCount',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`article`';

TRUNCATE TABLE `trend`.`user`;
INSERT `trend`.`user` (id, name, age) VALUES (1,"测试", 27);