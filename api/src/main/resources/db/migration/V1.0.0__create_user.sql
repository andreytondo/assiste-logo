create table "user"
(
    userid    serial primary key,
    name      varchar(300),
    email     varchar(300),
    password  varchar(300),
    createdAt timestamp,
    image     bytea,
    constraint unique_email unique (email)
);

create table userfriend
(
    userfriendid serial primary key,
    userid       integer,
    friendid     integer,
    status       varchar(30),
    createdAt    timestamp,
    constraint unique_user_friend unique (userid, friendid),
    constraint fk_user_friend foreign key (userid) references "user" (userid) on delete cascade,
    constraint fk_user_friend2 foreign key (friendid) references "user" (userid) on delete cascade
);

create table usermedia
(
    usermediaid serial primary key,
    userid      integer,
    mediaid     integer,
    mediatype   varchar(30),
    status      varchar(30),
    rating      integer,
    review      varchar(300),
    updatedAt   timestamp,
    constraint unique_user_media unique (userid, mediaid),
    constraint fk_user_media foreign key (userid) references "user" (userid) on delete cascade
);