# ----------------------------------- about user_table -------------------------------------
# 奇怪的问题，这行注释如果删除了，就会报错 nested exception is java.sql.SQLSyntaxErrorException: Table 'user_table' already exists
# DROP TABLE IF EXISTS `user_table`;
DROP TABLE IF EXISTS `user_table`;

CREATE TABLE `user_table` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `username` varchar(50) NOT NULL,
    `password` varchar(100) NOT NULL,
    `introduce` varchar(255) DEFAULT NULL,
    `register_date` date DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 4 DEFAULT CHARSET = utf8mb3;

INSERT INTO `user_table` (id, username, password, introduce, register_date)
VALUES (NULL, 'jerechen', '13333', 'Android Engineer', '2023-06-28'),
       (NULL, '小帅', 'uuuuuuuuu', 'Farmer', '2023-06-28'),
       (NULL, '大大', '1299', 'Banker', '2023-06-28'),
       (NULL, 'du小帅', 'huhhhhh1', 'Baller', '2023-06-28');

# ------------------------------------------- end ------------------------------------------

# ----------------------------------- about year_task -------------------------------------
#DROP TABLE IF EXISTS `year_task`;
DROP TABLE IF EXISTS `year_task`;

CREATE TABLE `year_task` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `task_name` varchar(100) NOT NULL,
    `target` int NOT NULL,
    `progress` int NOT NULL,
    `create_date` date DEFAULT NULL,
    `finish_date` date DEFAULT NULL,
    `is_finish` tinyint DEFAULT 0,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;

INSERT INTO `year_task` (id, task_name, target, progress, create_date, finish_date, is_finish)
VALUES (NULL, '打篮球', 21, 0, NULL, NULL, 0),
       (NULL, '学习游泳', 20, 0, NULL, NULL, 0),
       (NULL, '洗冷水澡', 30, 0, NULL, NULL, 0)


# ------------------------------------------- end ------------------------------------------