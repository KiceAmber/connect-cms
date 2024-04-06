create database `connect_cms`;

use `connect_cms`;

-- -----------------------
-- module of administrator
-- -----------------------

create table `cms_admin` -- created
(
    `id`          int         not null auto_increment comment '管理员ID',
    `name`        varchar(64) not null comment '管理员名称，全局唯一',
    `password`    varchar(64) not null comment '管理员登录密码',
    `email`       varchar(64) not null comment '管理员联系邮箱',
    `status`      tinyint     not null default 1 comment '管理员状态 0-禁用 1-启用',
    `create_time` timestamp   not null default CURRENT_TIMESTAMP comment '创建时间',
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
    `id`          int          not null auto_increment comment '用户ID',
    `name`        varchar(64)  not null comment '用户名称',
    `password`    varchar(64)  not null comment '用户密码',
    `email`       varchar(64)  not null comment '用户邮箱',
    `signature`   varchar(128) not null comment '用户个人签名',
    `avatar`      varchar(128) not null comment '用户头像',
    `create_time` timestamp    not null default current_timestamp comment '创建时间',
    primary key (`id`),
    unique index (`name`)
);

create table `cms_article`
(
    `id`          int          not null auto_increment comment '文章ID',
    `title`       varchar(64)  not null comment '文章标题',
    `content`     text         not null comment '文章正文',
    `image`       varchar(128) not null comment '文章图片',
    `author_id`   int          not null comment '文章作者ID',
    `category_id` int          not null comment '文章分类ID',
    `status`      tinyint      not null default 0 comment '文章状态 0-草稿 1-审核中 2-发布失败 3-发布成功',
    `created_at`  timestamp    not null default current_timestamp comment '创建时间',
    `updated_at`  timestamp    not null default current_timestamp on update current_timestamp comment '修改时间',
    `deleted_at`  timestamp             default null comment '删除时间',
    primary key (`id`)
);

create table `cms_tag`
(
    `id`         int         not null auto_increment comment '标签ID',
    `name`       varchar(64) not null comment '标签名称',
    `created_at` timestamp   not null default current_timestamp comment '创建时间',
    `updated_at` timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
    `deleted_at` timestamp            default null comment '删除时间',
    primary key (`id`)
);

create table `cms_article_tag`
(
    `id`         int       not null auto_increment comment '文章标签ID',
    `article_id` int       not null comment '文章ID',
    `tag_id`     int       not null comment '标签ID',
    `created_at` timestamp not null default current_timestamp comment '创建时间',
    `updated_at` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    `deleted_at` timestamp          default null comment '删除时间',
    primary key (`id`)
);

create table `cms_category`
(
    `id`         int         not null auto_increment comment '分类ID',
    `name`       varchar(64) not null comment '分类名称',
    `created_at` timestamp   not null default current_timestamp comment '创建时间',
    `updated_at` timestamp   not null default current_timestamp on update current_timestamp comment '修改时间',
    `deleted_at` timestamp            default null comment '删除时间',
    primary key (`id`)
);

create table `cms_comment`
(
    `id`         int          not null auto_increment comment '评论ID',
    `parent_id`  int          not null default 0 comment '父评论ID, 无父评论则为 0',
    `user_id`    int          not null comment '评论用户',
    `content`    varchar(128) not null comment '评论内容',
    `created_at` timestamp    not null default current_timestamp comment '创建时间',
    `updated_at` timestamp    not null default current_timestamp on update current_timestamp comment '修改时间',
    `deleted_at` timestamp             default null comment '删除时间',
    primary key (`id`)
);

