-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE seckill;
-- 使用数据库
USE seckill;
CREATE TABLE seckill (
  `seckill_id`  BIGINT       NOT NULL AUTO_INCREMENT
  COMMENT '商品库存ID',
  `name`        VARCHAR(120) NOT NULL
  COMMENT '商品名称',
  `number`      INT          NOT NULL
  COMMENT '库存数量',
  `start_time`  TIMESTAMP    NOT NULL
  COMMENT '秒杀开始时间',
  `end_time`    TIMESTAMP    NOT NULL
  COMMENT '秒杀结束时间',
  `create_time` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  PRIMARY KEY (seckill_id),
  KEY idx_start_time(start_time),
  KEY idx_end_time(end_time),
  KEY idx_create_time(create_time)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT ='秒杀库存表';

-- 初始化数据
INSERT INTO seckill (name, number, start_time, end_time)
VALUES
  ('1000元秒杀iphone6', 100, '2016-01-01 00:00:00', '2016-01-02 00:00:00'),
  ('800元秒杀ipad', 200, '2016-01-01 00:00:00', '2016-01-02 00:00:00'),
  ('6600元秒杀mac book pro', 300, '2016-01-01 00:00:00', '2016-01-02 00:00:00'),
  ('7000元秒杀iMac', 400, '2016-01-01 00:00:00', '2016-01-02 00:00:00');

-- 秒杀成功明细表
-- 用户登录认证相关信息(简化为手机号)
CREATE TABLE success_killed (
  `seckill_id`  BIGINT    NOT NULL
  COMMENT '秒杀商品ID',
  `user_phone`  BIGINT    NOT NULL
  COMMENT '用户手机号',
  `state`       TINYINT   NOT NULL DEFAULT -1
  COMMENT '状态标识:-1:无效 0:成功 1:已付款 2:已发货',
  `create_time` TIMESTAMP NOT NULL
  COMMENT '创建时间',
  PRIMARY KEY (seckill_id, user_phone), /*联合主键*/
  KEY idx_create_time(create_time)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  COMMENT ='秒杀成功明细表';

CREATE TABLE t_comments (
  coid      INTEGER AUTO_INCREMENT NOT NULL,
  cid       INTEGER DEFAULT 0      NOT NULL,
  created   INTEGER(10)            NOT NULL,
  author    VARCHAR(200)           NOT NULL,
  author_id INTEGER(10) DEFAULT 0,
  owner_id  INTEGER(10) DEFAULT 0,
  mail      VARCHAR(200)           NOT NULL,
  url       VARCHAR(200),
  ip        VARCHAR(64),
  agent     VARCHAR(200),
  content   TEXT                   NOT NULL,
  type      VARCHAR(16),
  status    VARCHAR(16),
  parent    INTEGER(10) DEFAULT 0,
  PRIMARY KEY (coid)
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  COMMENT ='评论信息表';

CREATE TABLE t_contents (
  cid           INTEGER AUTO_INCREMENT,
  title         VARCHAR(255)                       NOT NULL,
  slug          VARCHAR(255),
  thumb_img     VARCHAR(255),
  created       INTEGER(10)                        NOT NULL,
  modified      INTEGER(10),
  content       TEXT,
  author_id     INTEGER(10)                        NOT NULL,
  type          VARCHAR(16)                        NOT NULL,
  status        VARCHAR(16)                        NOT NULL,
  fmt_type      VARCHAR(16) DEFAULT 'markdown',
  tags          VARCHAR(200),
  categories     VARCHAR(200),
  hits          INTEGER(10) DEFAULT 0,
  comments_num  INTEGER(1)  DEFAULT 0,
  allow_comment INTEGER(1)  DEFAULT 1,
  allow_ping    INTEGER(1),
  allow_feed    INTEGER(1),
  PRIMARY KEY (cid)
);
INSERT INTO t_contents (title, slug, created, modified, content, author_id, type, status, tags, categories, hits, comments_num, allow_comment, allow_ping, allow_feed) VALUES ('1', 'about', 1487853610, 1487872488, '### Hello World这是我的关于页面### 当然还有其他具体你来写点什么吧', 1, 'page', 'publish', NULL, NULL, 0, 0, 1, 1, 1);

-- SHOW CREATE TABLE seckill;#显示表的创建信息