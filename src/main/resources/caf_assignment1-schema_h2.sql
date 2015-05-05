CREATE TABLE IF NOT EXISTS chObject (
  id varchar(11) NOT NULL,
  title varchar(100) DEFAULT NULL,
  date varchar(11) DEFAULT NULL,
  medium varchar(100) DEFAULT NULL,
  creditline varchar(100) DEFAULT NULL,
  description text,
  gallery_text text
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS authorities (
  username varchar(50) NOT NULL,
  authority varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS comment (
  id int(11) NOT NULL AUTO_INCREMENT,
  commenttext text
) ENGINE=InnoDB  DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS crowdsourcing (
id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) DEFAULT 0,
  chobject_id varchar(11) DEFAULT NULL,
  datestamp date DEFAULT NULL,
  flag tinyint(1) DEFAULT 0,
  flagusername varchar(254) DEFAULT NULL,
  flagdate date DEFAULT NULL,
  adminflagreviewed varchar(254) DEFAULT NULL,
  adminflagdate date DEFAULT NULL,
  description text
) ENGINE=InnoDB  DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS follow (
id int(11) NOT NULL AUTO_INCREMENT,
  followingid varchar(254) DEFAULT NULL,
  followerid varchar(254) DEFAULT NULL,
  datestamp date DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS gametype (
game_id int(11) NOT NULL AUTO_INCREMENT,
  gamename varchar(64) DEFAULT NULL,
  gamepoints int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB  DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS gamification (
id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) NOT NULL DEFAULT 0,
  chobject_id varchar(11) DEFAULT NULL,
  game_id int(11) NOT NULL,
  gamepoints int(11) NOT NULL DEFAULT 0,
  datestamp date DEFAULT NULL,
  tagname varchar(128) DEFAULT NULL,
  commentid int(11) DEFAULT NULL,
  storybookid varchar(11) DEFAULT NULL,
  thumbup tinyint(1) DEFAULT 0,
  thumbdown tinyint(1) DEFAULT 0,
 follow_id int(11) NOT NULL DEFAULT 0,
  flag tinyint(1) DEFAULT 0,
  flagusername varchar(254) DEFAULT NULL,
  flagdate date DEFAULT NULL,
  adminflagreviewed varchar(254) DEFAULT NULL,
  adminflagdate date DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS gamificationlevel (
level_id int(11) NOT NULL AUTO_INCREMENT,
  levelname varchar(64) DEFAULT NULL,
  levelpoints int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS userrole (
  id varchar(11) NOT NULL,
  username varchar(254) DEFAULT NULL,
  role varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS users (
	id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(254) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
   enabled tinyint(1) NOT NULL
  profilename varchar(64) DEFAULT NULL,
  address1 varchar(64) DEFAULT NULL,
  address2 varchar(64) DEFAULT NULL,
  address3 varchar(64) DEFAULT NULL,
  email varchar(254) DEFAULT NULL,
  age int(11) DEFAULT NULL,
  accountstatus tinyint(1) DEFAULT NULL,
  pinid int(11) DEFAULT NULL,
  datejoined date DEFAULT NULL
 
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS 'user' (
	id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(254) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
   enabled tinyint(1) NOT NULL
  profilename varchar(64) DEFAULT NULL,
  address1 varchar(64) DEFAULT NULL,
  address2 varchar(64) DEFAULT NULL,
  address3 varchar(64) DEFAULT NULL,
  email varchar(254) DEFAULT NULL,
  age int(11) DEFAULT NULL,
  accountstatus tinyint(1) DEFAULT NULL,
  pinid int(11) DEFAULT NULL,
  datejoined date DEFAULT NULL
 
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

ALTER TABLE `authorities`
 ADD UNIQUE KEY `authorities_idx_1` (`username`,`authority`);

ALTER TABLE `comment`
 ADD PRIMARY KEY (`id`);

ALTER TABLE `crowdsourcing`
 ADD PRIMARY KEY (`id`);

ALTER TABLE `follow`
 ADD PRIMARY KEY (`id`);

ALTER TABLE `gametype`
 ADD PRIMARY KEY (`game_id`);

ALTER TABLE `gamification`
 ADD PRIMARY KEY (`id`);

ALTER TABLE `gamificationlevel`
 ADD PRIMARY KEY (`level_id`);

ALTER TABLE `user`
 ADD PRIMARY KEY (`id`);

ALTER TABLE `userrole`
 ADD PRIMARY KEY (`id`);

ALTER TABLE `users`
 ADD PRIMARY KEY (`username`);


CREATE TABLE IF NOT EXISTS image (
 image_id varchar(11) NOT NULL,
  image_res varchar(11) NOT NULL,
  chObject_id varchar(11) NOT NULL,
  is_primary varchar(11) DEFAULT NULL,
  height int(11) DEFAULT NULL,
  width int(11) DEFAULT NULL,
  url varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS participant (
  person_id varchar(100) NOT NULL,
  person_name varchar(100) DEFAULT NULL,
  person_date varchar(100) DEFAULT NULL,
  person_url varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS participation (
  chObject_id int(11) NOT NULL,
  participant_id int(11) NOT NULL,
  role_id int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS role (
  role_id varchar(100) NOT NULL,
  role_name varchar(100) DEFAULT NULL,
  role_display_name varchar(100) DEFAULT NULL,
  role_url varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

ALTER TABLE `chObject`
 ADD PRIMARY KEY (`id`);


ALTER TABLE `image`
 ADD PRIMARY KEY (`image_id`,`image_res`);


ALTER TABLE `participant`
 ADD PRIMARY KEY (`person_id`);


ALTER TABLE `participation`
 ADD PRIMARY KEY (`chObject_id`,`participant_id`,`role_id`);


ALTER TABLE `role`
 ADD PRIMARY KEY (`role_id`);
