create database `cms`;

use `cms`;

create table `cms_user` (
    `id` int not null auto_increment comment '用户ID'
);

create table `cms_article` ();

create table `cms_tag` ();

create table `cms_category` ();

create table `cms_tag_article` ();

create table `cms_comment` ();

create table `cms_follow` ();
