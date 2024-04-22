create database `connect_cms`;

use `connect_cms`;

-- -----------------------
-- module of administrator
-- -----------------------

create table `cms_admin`
(
    `id`       int         not null auto_increment comment '管理员ID',
    `name`     varchar(64) not null comment '管理员名称，全局唯一',
    `password` varchar(64) not null comment '管理员登录密码',
    `email`    varchar(64) not null comment '管理员联系邮箱',
    primary key (`id`),
    unique index (`name`)
);

create table `cms_role`
(
    `id`         int         not null auto_increment comment '角色ID',
    `name`       varchar(64) not null comment '角色名称',
    `created_at` timestamp   not null default current_timestamp comment '创建时间',
    `updated_at` timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
    `deleted_at` timestamp            default null comment '删除时间',
    primary key (`id`)
);

create table `cms_permission`
(
    `id`         int         not null auto_increment comment '权限ID',
    `name`       varchar(64) not null comment '权限名称',
    `url`        varchar(64) not null comment '权限路径',
    `created_at` timestamp   not null default current_timestamp comment '创建时间',
    `updated_at` timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
    `deleted_at` timestamp            default null comment '删除时间',
    primary key (`id`)
);

-- one admin can have many roles
-- one roles can have many permissions
-- one permission can be given to many roles

create table `cms_admin_role`
(
    `id`            int       not null auto_increment comment '管理员角色ID',
    `role_id`       int       not null comment '管理员ID',
    `permission_id` int       not null comment '角色ID',
    `created_at`    timestamp not null default current_timestamp comment '创建时间',
    `updated_at`    timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    `deleted_at`    timestamp          default null comment '删除时间',
    primary key (`id`)
);

create table `cms_role_permission`
(
    `id`            int       not null auto_increment comment '角色权限ID',
    `role_id`       int       not null comment '角色ID',
    `permission_id` int       not null comment '权限ID',
    `created_at`    timestamp not null default current_timestamp comment '创建时间',
    `updated_at`    timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    `deleted_at`    timestamp          default null comment '删除时间',
    primary key (`id`)
);

-- --------------------
-- module of community
-- --------------------

create table `cms_user`
(
    `id`            int          not null auto_increment comment '用户ID',
    `name`          varchar(64)  not null comment '用户名称',
    `password`      varchar(128) not null comment '用户密码',
    `avatar`        varchar(128) not null comment '用户头像',
    `signature`     varchar(256) not null comment '用户个人签名',
    `email`         varchar(128) not null comment '用户邮箱',
    `article_count` int          not null default 0 comment '用户发布的文章数量',
    `liked_count`   int          not null default 0 comment '用户被点赞数量',
    `create_time`   timestamp    not null default current_timestamp comment '用户创建时间',
    primary key (`id`),
    unique index (`name`)
);

create table `cms_article`
(
    `id`            int          not null auto_increment comment '文章ID',
    `author_id`     int          not null comment '文章作者ID',
    `community_id`  int          not null comment '文章所在社区ID',
    `title`         varchar(64)  not null comment '文章标题',
    `cover`         varchar(128) not null comment '文章封面',
    `content`       text         not null comment '文章正文',
    `like_count`    int          not null default 0 comment '文章点赞数量',
    `comment_count` int          not null default 0 comment '文章评论数量',
    `heat`          int          not null default 0 comment '文章热度 热度=点赞+评论+浏览量',
    `view_count`    int          not null default 0 comment '文章浏览量',
    `status`        tinyint      not null default 0 comment '文章状态 0-草稿 1-审核中 2-发布失败 3-发布成功',
    `create_time`   timestamp    not null default current_timestamp comment '发布时间',
    `update_time`   timestamp    not null default current_timestamp on update current_timestamp comment '最后修改时间',
    primary key (`id`)
);

create table `cms_tag`
(
    `id`          int          not null auto_increment comment '标签ID',
    `name`        varchar(64)  not null comment '标签名称',
    `description` varchar(255) not null default '' comment '标签概述',
    `create_time` timestamp    not null default current_timestamp comment '标签创建时间',
    `created_by`  int          not null comment '被哪个管理员创建',
    primary key (`id`)
);

create table `cms_article_tag`
(
    `article_id` int not null comment '文章ID',
    `tag_id`     int not null comment '标签ID',
    primary key (`article_id`, `tag_id`)
);

create table `cms_community`
(
    `id`            int          not null auto_increment comment '社区ID',
    `name`          varchar(128) not null comment '社区名称',
    `description`   varchar(128) not null default '' comment '社区概述',
    `article_count` int          not null default 0 comment '社区文章数量',
    `user_count`    int          not null default 0 comment '社区参与用户数量',
    `created_by`    int          not null comment '社区被哪个管理员创建的'
);

create table `cms_like`
(
    `user_id`    int not null comment '点赞用户ID',
    `article_id` int not null comment '点赞的文章ID',
    primary key (`user_id`, `article_id`)
);

create table `cms_comment`
(
    `id`           int           not null auto_increment comment '评论ID',
    `parent_id`    int           not null default 0 comment '父评论ID, 无父评论则为 0',
    `user_id`      int           not null comment '评论用户',
    `article_id`   int           not null comment '评论的文章ID',
    `content`      varchar(1024) not null comment '评论内容',
    `comment_time` timestamp     not null default current_timestamp comment '评论时间',
    primary key (`id`)
);

