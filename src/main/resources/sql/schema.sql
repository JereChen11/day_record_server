# ----------------------------------- about user_table -------------------------------------
# 奇怪的问题，这行注释如果删除了，就会报错 nested exception is java.sql.SQLSyntaxErrorException: Table 'user_table' already exists
# DROP TABLE IF EXISTS `user_table`;
DROP TABLE IF EXISTS `user_table`;

CREATE TABLE `user_table` (
    `user_id` bigint NOT NULL AUTO_INCREMENT,
    `username` varchar(50) NOT NULL COMMENT '用户名',
    `password` varchar(100) NOT NULL COMMENT '密码',
    `introduce` varchar(255) DEFAULT NULL COMMENT '简介',
    `register_date` date DEFAULT NULL COMMENT '注册时间',
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 4 DEFAULT CHARSET = utf8mb3;

INSERT INTO `user_table` (user_id, username, password, introduce, register_date)
VALUES (NULL, 'jerechen', '13333', 'Android Engineer', '2023-06-28'),
       (NULL, '小帅', 'uuuuuuuuu', 'Farmer', '2023-06-28'),
       (NULL, '大大', '1299', 'Banker', '2023-06-28'),
       (NULL, 'du小帅', 'huhhhhh1', 'Baller', '2023-06-28');

# ------------------------------------------- end ------------------------------------------

# ----------------------------------- about user_token_table -------------------------------------
# DROP TABLE IF EXISTS `user_token_table`;
DROP TABLE IF EXISTS `user_token_table`;

CREATE TABLE `user_token_table` (
    `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户主键id',
    `token` varchar(32) NOT NULL COMMENT 'token值(32位字符串)',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'token更新时间',
    `expire_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'token过期时间',
    PRIMARY KEY (`user_id`),
    UNIQUE KEY (`token`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb3;

# ------------------------------------------- end ------------------------------------------

# ----------------------------------- about year_task -------------------------------------
#DROP TABLE IF EXISTS `year_task`;
DROP TABLE IF EXISTS `year_task`;

CREATE TABLE `year_task` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `task_name` varchar(100) NOT NULL COMMENT '任务名',
    `target` int NOT NULL COMMENT '打卡目标天数',
    `progress` int NOT NULL COMMENT '打卡进度',
    `create_date` date DEFAULT NULL COMMENT '创建日期',
    `finish_date` date DEFAULT NULL COMMENT '介绍日期',
    `is_finish` tinyint DEFAULT 0 COMMENT '任务是否结束',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;

INSERT INTO `year_task` (id, task_name, target, progress, create_date, finish_date, is_finish)
VALUES (NULL, '打篮球', 21, 0, NULL, NULL, 0),
       (NULL, '学习游泳', 20, 0, NULL, NULL, 0),
       (NULL, '洗冷水澡', 30, 0, NULL, NULL, 0)


# ------------------------------------------- end ------------------------------------------