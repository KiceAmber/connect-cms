create database `connect_cms`;

use `connect_cms`;

-- 创建角色表
CREATE TABLE `roles`
(
    `id`          INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '角色ID',
    `name`        VARCHAR(50) NOT NULL UNIQUE COMMENT '角色名称',
    `description` TEXT COMMENT '角色描述',
    `created_at`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
);

-- 创建资源表
CREATE TABLE `resources`
(
    `id`          INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `name`        VARCHAR(50) NOT NULL UNIQUE COMMENT '资源名称',
    `description` TEXT COMMENT '资源描述',
    `path`        VARCHAR(64) COMMENT '资源路径',
    `created_at`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
);

-- 角色资源关联表
CREATE TABLE `role_resources`
(
    `id`          INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `role_id`     INT UNSIGNED,
    `resource_id` INT UNSIGNED
);

-- 用户表
CREATE TABLE `users`
(
    `id`         INT AUTO_INCREMENT COMMENT '用户ID',
    `passport`   VARCHAR(64)  NOT NULL UNIQUE COMMENT '用户账号',
    `nickname`   VARCHAR(50)  NOT NULL COMMENT '用户昵称',
    `password`   VARCHAR(100) NOT NULL COMMENT '用户密码',
    `email`      VARCHAR(100) NOT NULL UNIQUE COMMENT '电子邮件',
    `avatar`     VARCHAR(128) NOT NULL COMMENT '用户头像',
    `role_id`    INT          NOT NULL COMMENT '角色ID 用户只能赋予一个角色',
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`)
);

-- 内容分类表
CREATE TABLE `categories`
(
    `id`          INT AUTO_INCREMENT COMMENT '分类ID',
    `parent_id`   INT COMMENT '父分类ID',
    `name`        VARCHAR(100) NOT NULL UNIQUE COMMENT '分类名称',
    `description` TEXT COMMENT '分类描述',
    `slug`        VARCHAR(64) COMMENT '分类别名 用于路径显示',
    `cover`       VARCHAR(128) COMMENT '分类封面',
    PRIMARY KEY (`id`)
);

-- 内容标签表
CREATE TABLE `tags`
(
    `id`          INT AUTO_INCREMENT COMMENT '标签ID',
    `name`        VARCHAR(100) NOT NULL UNIQUE COMMENT '标签名称',
    `description` TEXT COMMENT '标签描述',
    PRIMARY KEY (`id`)
);

-- 内容表
CREATE TABLE `posts`
(
    `id`            INT AUTO_INCREMENT COMMENT '内容ID',
    `type`          TINYINT COMMENT '内容类型 1-文章 2-页面',
    `title`         VARCHAR(255) NOT NULL COMMENT '标题',
    `cover`         VARCHAR(128) NOT NULL COMMENT '封面',
    `url`           VARCHAR(128) NOT NULL COMMENT '路径',
    `content`       TEXT         NOT NULL COMMENT '内容',
    `summary`       VARCHAR(64) COMMENT '文章摘要',
    `user_id`       INT          NOT NULL COMMENT '作者ID',
    `category_id`   INT COMMENT '分类ID',
    `comment_count` INT COMMENT '评论数量',
    `view_count`    INT COMMENT '访问量',
    `is_top`        TINYINT COMMENT '是否置顶',
    `slug`          VARCHAR(64) COMMENT '路径别名',
    `status`        TINYINT COMMENT '状态 0-未发布 1-已发布 2-位于回收站',
    `created_at`    TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`)
);

-- 内容标签关联表
CREATE TABLE `post_tags`
(
    `post_id` INT COMMENT '内容ID',
    `tag_id`  INT COMMENT '标签ID',
    PRIMARY KEY (`post_id`, `tag_id`)
);

-- 评论表
CREATE TABLE `comments`
(
    `id`          INT AUTO_INCREMENT COMMENT '评论ID',
    `parent_id`   INT COMMENT '评论父ID',
    `post_id`     INT  NOT NULL COMMENT '评论的内容ID',
    `author_id`   INT COMMENT '评论者ID',
    `author_name` VARCHAR(128) COMMENT '评论者的名称',
    `author_url`  VARCHAR(128) COMMENT '评论的URL',
    `content`     TEXT NOT NULL COMMENT '评论内容',
    `created_at`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`)
);

-- 附件表
CREATE TABLE `attachments`
(
    `id`         INT AUTO_INCREMENT NOT NULL COMMENT '附件ID',
    `author_id`  INT COMMENT '上传者ID',
    `type`       TINYINT COMMENT '附件类型 1-图片 2-视频 3-其他',
    `name`       VARCHAR(64) COMMENT '附件名称',
    `url`        VARCHAR(128) COMMENT '附件的访问路径',
    `size`       BIGINT COMMENT '文件大小',
    `ext`        VARCHAR(32) COMMENT '文件扩展名',
    `strategy`   TINYINT COMMENT '附件存储策略 0-本地存储 1-OSS存储',
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`)
);

-- 菜单表
CREATE TABLE `menus`
(
    `id`        INT AUTO_INCREMENT NOT NULL COMMENT '菜单ID',
    `parent_id` INT COMMENT '父级ID',
    `sort`      INT COMMENT '导航上菜单的排序',
    `url`       VARCHAR(64) COMMENT '菜单所指向的URL',
    `title`     VARCHAR(64) COMMENT '菜单标题',
    `name`      VARCHAR(64) COMMENT '菜单名称',
    `icon`      VARCHAR(64) COMMENT '菜单图标',
    PRIMARY KEY (`id`)
);

-- 站点设置表
CREATE TABLE `options`
(
    `option_key`   VARCHAR(128) COMMENT '选项的key 如博客标题',
    `option_value` VARCHAR(128) COMMENT '选项的值 如博客标题是什么',
    `type`         TINYINT COMMENT '内部选项为0 自定义的选项为1'
);