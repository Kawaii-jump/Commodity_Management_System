/*
Navicat MySQL Data Transfer

Source Server         : HeTao
Source Server Version : 50016
Source Host           : localhost:3308
Source Database       : goods

Target Server Type    : MYSQL
Target Server Version : 50016
File Encoding         : 65001

Date: 2019-07-03 09:03:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for classgoods
-- ----------------------------
DROP TABLE IF EXISTS `classgoods`;
CREATE TABLE `classgoods` (
  `ClassificationNum` varchar(20) NOT NULL,
  `Classification` varchar(20) default NULL,
  PRIMARY KEY  (`ClassificationNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classgoods
-- ----------------------------
INSERT INTO `classgoods` VALUES ('1', '日用品');
INSERT INTO `classgoods` VALUES ('2', '蔬菜');
INSERT INTO `classgoods` VALUES ('3', '水果');
INSERT INTO `classgoods` VALUES ('4', '零食');
INSERT INTO `classgoods` VALUES ('5', '化妆品');
INSERT INTO `classgoods` VALUES ('6', '品');
INSERT INTO `classgoods` VALUES ('7', '哈哈哈哈');
INSERT INTO `classgoods` VALUES ('8', '888');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `GoodsId` varchar(20) NOT NULL default '',
  `GoodsName` varchar(50) default NULL,
  `ClassificationNum` varchar(20) default NULL,
  `Price` double(10,2) default NULL,
  `Stock` int(11) default NULL,
  PRIMARY KEY  (`GoodsId`),
  KEY `ClassificationNum` (`ClassificationNum`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`ClassificationNum`) REFERENCES `classgoods` (`ClassificationNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '222', '1', '45.00', '67');
INSERT INTO `goods` VALUES ('10', '4321', '2', '66.00', '79');
INSERT INTO `goods` VALUES ('11', '000', '2', '90.00', '99');
INSERT INTO `goods` VALUES ('14', 'haha', '7', '77.00', '90');
INSERT INTO `goods` VALUES ('2', '5556', '2', '66.00', '98');
INSERT INTO `goods` VALUES ('3', '777', '3', '6.00', '100');
INSERT INTO `goods` VALUES ('4', '9996', '2', '88.00', '100');
INSERT INTO `goods` VALUES ('5', '99000', '1', '79.00', '100');
INSERT INTO `goods` VALUES ('6', '999', '3', '0.00', '100');
INSERT INTO `goods` VALUES ('9', '98', '3', '0.00', '0');

-- ----------------------------
-- Table structure for journal
-- ----------------------------
DROP TABLE IF EXISTS `journal`;
CREATE TABLE `journal` (
  `JTime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `Content` varchar(200) default NULL,
  PRIMARY KEY  (`JTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of journal
-- ----------------------------
INSERT INTO `journal` VALUES ('2019-07-01 23:47:52', '超级管理员user  添加管理员：rrrr管理员密码为：rrr');
INSERT INTO `journal` VALUES ('2019-07-02 00:30:19', '管理员jx  添加用户：ttt用户密码为：ttt');
INSERT INTO `journal` VALUES ('2019-07-02 00:30:41', '超级管理员jx  添加管理员：hhtthht管理员密码为：111');
INSERT INTO `journal` VALUES ('2019-07-02 07:15:57', '超级管理员jx  添加管理员：uuu管理员密码为：uuu');
INSERT INTO `journal` VALUES ('2019-07-02 07:16:24', '管理员jx  删除用户：uuuuuuu');
INSERT INTO `journal` VALUES ('2019-07-02 07:17:08', '用户jx  添加商品：giao  单价为：999   类别为：化妆品  数量为：999');
INSERT INTO `journal` VALUES ('2019-07-02 07:18:13', '用户jx  添加商品：999  单价为：999   类别为：化妆品  数量为：999');
INSERT INTO `journal` VALUES ('2019-07-02 07:18:39', '管理员：jx  删除商品：999');
INSERT INTO `journal` VALUES ('2019-07-02 08:45:22', '超级管理员user  添加管理员：ttttt管理员密码为：hahaha');
INSERT INTO `journal` VALUES ('2019-07-02 08:46:01', '用户user  添加商品：haha  单价为：77   类别为：忽然哈哈地方  数量为：90');
INSERT INTO `journal` VALUES ('2019-07-02 09:46:36', '用户null  添加商品：哈啊哈  单价为：777   类别为：化妆品  数量为：7777');
INSERT INTO `journal` VALUES ('2019-07-02 09:47:04', '管理员：null  删除商品：哈啊哈');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `Onumber` int(11) NOT NULL auto_increment,
  `GoodsId` varchar(20) default NULL,
  `GoodsNum` int(11) default NULL,
  `Prices` double(12,2) default NULL,
  `User` varchar(10) default NULL,
  `OrderDate` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`Onumber`),
  KEY `GoodsId` (`GoodsId`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`GoodsId`) REFERENCES `goods` (`GoodsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', '2', '90.00', null, '2019-07-01 22:34:20');
INSERT INTO `orders` VALUES ('2', '10', '2', '132.00', null, '2019-07-01 22:34:25');
INSERT INTO `orders` VALUES ('5', '1', '1', '45.00', 'k1', '2019-07-01 22:38:07');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Number` int(11) NOT NULL,
  `UserName` varchar(10) default NULL,
  `Password` varchar(20) default NULL,
  `Rank` int(11) default NULL,
  `Phone` char(11) default NULL,
  PRIMARY KEY  (`Number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'user', 'user', '0', '17390957948');
INSERT INTO `user` VALUES ('2', 'user', 'pass', '1', '11111111111');
INSERT INTO `user` VALUES ('3', 'k1', 'k1', '2', '99999999999');
INSERT INTO `user` VALUES ('4', 'k2', 'k2', '2', '99999999999');
INSERT INTO `user` VALUES ('6', 'lhq', 'lhq', '2', '000000');
INSERT INTO `user` VALUES ('7', 'zz', 'zz', '2', '00000000');
INSERT INTO `user` VALUES ('10', 'zz', 'zz', '2', '111');
INSERT INTO `user` VALUES ('12', 'aa', 'aa', '2', '123');
INSERT INTO `user` VALUES ('13', 'asa', 'asdf', '2', '123');
INSERT INTO `user` VALUES ('14', 'aa', 'aa', '2', '1234');
INSERT INTO `user` VALUES ('15', 'ad', 'fa', '2', '1233');
INSERT INTO `user` VALUES ('16', 'aa', 'aa', '2', '123');
INSERT INTO `user` VALUES ('17', 'hahah', 'qqq', '2', '999');
INSERT INTO `user` VALUES ('18', 'qqq', 'qqq', '2', '890');
INSERT INTO `user` VALUES ('19', 'fff', 'fff', '2', '9999');
INSERT INTO `user` VALUES ('20', 'ttt', 'ttt', '2', '888');
INSERT INTO `user` VALUES ('21', 'jjj', 'jjj', '2', '666');
INSERT INTO `user` VALUES ('22', 'lalal', 'lalal', '2', '9999');
INSERT INTO `user` VALUES ('23', 'rrrr', 'rrr', '1', '123');
INSERT INTO `user` VALUES ('24', 'ttt', 'ttt', '2', '0987');
INSERT INTO `user` VALUES ('25', 'hhtthht', '111', '1', '222');
INSERT INTO `user` VALUES ('26', 'ttt', 'hhhh', '2', '6666');
INSERT INTO `user` VALUES ('66', 'jx', 'jx', '0', '999');
INSERT INTO `user` VALUES ('666', 'hetao', 'hetao', '0', '8888888888');

-- ----------------------------
-- Procedure structure for delclass
-- ----------------------------
DROP PROCEDURE IF EXISTS `delclass`;
DELIMITER ;;
CREATE PROCEDURE `delclass`(in cfnum varchar(20))
begin 
		DELETE from goods where ClassificationNum = cfnum;
		delete from classgoods where ClassificationNum = cfnum;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for delgoods
-- ----------------------------
DROP PROCEDURE IF EXISTS `delgoods`;
DELIMITER ;;
CREATE PROCEDURE `delgoods`(in gi varchar(20))
BEGIN
	delete from goods where GoodsId = gi;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for delorders
-- ----------------------------
DROP PROCEDURE IF EXISTS `delorders`;
DELIMITER ;;
CREATE PROCEDURE `delorders`(in num int)
BEGIN
		delete from orders where Onumber = num;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for deluser
-- ----------------------------
DROP PROCEDURE IF EXISTS `deluser`;
DELIMITER ;;
CREATE PROCEDURE `deluser`(in num int)
BEGIN
		delete from user where Number = num;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for dx
-- ----------------------------
DROP PROCEDURE IF EXISTS `dx`;
DELIMITER ;;
CREATE PROCEDURE `dx`()
BEGIN
		select * from user;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for inclass
-- ----------------------------
DROP PROCEDURE IF EXISTS `inclass`;
DELIMITER ;;
CREATE PROCEDURE `inclass`(in cln varchar(20),in cfn varchar(20))
BEGIN
		insert into classgoods VALUES(cln,cfn);
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for ingoods
-- ----------------------------
DROP PROCEDURE IF EXISTS `ingoods`;
DELIMITER ;;
CREATE PROCEDURE `ingoods`(in gi varchar(20),in gn varchar(50),in cf varchar(20),in p double(10,2),in s int)
begin 
		insert into goods values(gi,gn,cf,p,s);
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for inuser
-- ----------------------------
DROP PROCEDURE IF EXISTS `inuser`;
DELIMITER ;;
CREATE PROCEDURE `inuser`(in num int,in name2 varchar(20),in pass varchar(20),in rank2 int,in phone2 char(11))
begin 
	insert into user values(num,name2,pass,rank2,phone2);
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for inusergoods
-- ----------------------------
DROP PROCEDURE IF EXISTS `inusergoods`;
DELIMITER ;;
CREATE PROCEDURE `inusergoods`(in gi varchar(20),in num int,in p double(12,2),in us varchar(10))
BEGIN
		insert into orders(GoodsId,GoodsNum,Prices,User) values(gi,num,p*num,us);
	  UPDATE goods set Stock = Stock - num where GoodsId = gi;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Jwrite
-- ----------------------------
DROP PROCEDURE IF EXISTS `Jwrite`;
DELIMITER ;;
CREATE PROCEDURE `Jwrite`(in str varchar(200))
BEGIN
    insert into Journal(Content) values(str);
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for selclass
-- ----------------------------
DROP PROCEDURE IF EXISTS `selclass`;
DELIMITER ;;
CREATE PROCEDURE `selclass`(in cf varchar(20))
BEGIN
		select * from classgoods where Classification like CONCAT('%',cf,'%');
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for selg
-- ----------------------------
DROP PROCEDURE IF EXISTS `selg`;
DELIMITER ;;
CREATE PROCEDURE `selg`(in gi varchar(20),out a int)
BEGIN
		select count(*) into a from orders where GoodsId = gi;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for selgoods
-- ----------------------------
DROP PROCEDURE IF EXISTS `selgoods`;
DELIMITER ;;
CREATE PROCEDURE `selgoods`(in gname varchar(50))
BEGIN
	if gname is null THEN
		SELECT GoodsId,GoodsName,classgoods.Classification,Price,Stock from goods,classgoods where goods.ClassificationNum=classgoods.ClassificationNum order by GoodsId;
	else SELECT GoodsId,GoodsName,classgoods.Classification,Price,Stock from goods,classgoods where goods.ClassificationNum=classgoods.ClassificationNum and GoodsName like CONCAT('%',gname,'%') order by GoodsId; 
	end if;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for selgoodsclass
-- ----------------------------
DROP PROCEDURE IF EXISTS `selgoodsclass`;
DELIMITER ;;
CREATE PROCEDURE `selgoodsclass`()
BEGIN
		select * from classgoods;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for selgoodss
-- ----------------------------
DROP PROCEDURE IF EXISTS `selgoodss`;
DELIMITER ;;
CREATE PROCEDURE `selgoodss`(in fname varchar(20),in gname varchar(50))
BEGIN
	if gname is null then
		SELECT GoodsId,GoodsName,classgoods.Classification,Price,Stock from goods,classgoods where goods.ClassificationNum=classgoods.ClassificationNum and Classification = fname;
	else SELECT GoodsId,GoodsName,classgoods.Classification,Price,Stock from goods,classgoods where goods.ClassificationNum=classgoods.ClassificationNum and Classification = fname and GoodsName like CONCAT('%',gname,'%') ;
	end if;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for selJournal
-- ----------------------------
DROP PROCEDURE IF EXISTS `selJournal`;
DELIMITER ;;
CREATE PROCEDURE `selJournal`()
BEGIN
    select * from Journal;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for selorders
-- ----------------------------
DROP PROCEDURE IF EXISTS `selorders`;
DELIMITER ;;
CREATE PROCEDURE `selorders`(in us varchar(10))
BEGIN
	if us is null then
		select Onumber,GoodsName,GoodsNum,Prices,`User`,OrderDate 
		from orders,goods 
		where orders.GoodsId=goods.GoodsId;
	else select Onumber,GoodsName,GoodsNum,Prices,`User`,OrderDate 
	from orders,goods 
	where orders.GoodsId=goods.GoodsId and User like CONCAT('%',us,'%');
	end if;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for seluser
-- ----------------------------
DROP PROCEDURE IF EXISTS `seluser`;
DELIMITER ;;
CREATE PROCEDURE `seluser`(in rank2 int,in username2 VARCHAR(20) )
BEGIN
		if username2 is null then
			select * FROM `user` where Rank > rank2;
		else SELECT * from user where Rank > rank2 and UserName like CONCAT('%',username2,'%');
		end if;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for seluser1
-- ----------------------------
DROP PROCEDURE IF EXISTS `seluser1`;
DELIMITER ;;
CREATE PROCEDURE `seluser1`(in rank2 int,in username2 varchar(20))
BEGIN
		if username2 is null then
			SELECT * from user where Rank = rank2;
		else select * from user where Rank = rank2 and UserName like CONCAT('%',username2,'%');
		end if;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for seluserorders
-- ----------------------------
DROP PROCEDURE IF EXISTS `seluserorders`;
DELIMITER ;;
CREATE PROCEDURE `seluserorders`(in us varchar(10),in uname varchar(10))
BEGIN
	if us is null then
		select Onumber,GoodsName,GoodsNum,Prices,`User`,OrderDate 
	from orders,goods 
		where orders.GoodsId=goods.GoodsId and User = uname;
	else select Onumber,GoodsName,GoodsNum,Prices,`User`,OrderDate 
	from orders,goods 
	where orders.GoodsId=goods.GoodsId and User like CONCAT('%',us,'%') and User = uname;
	end if;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for upclass
-- ----------------------------
DROP PROCEDURE IF EXISTS `upclass`;
DELIMITER ;;
CREATE PROCEDURE `upclass`(in cfnum varchar(20),in cfn varchar(20))
BEGIN
	update classgoods set Classification = cfn where ClassificationNum = cfnum;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for upgoods
-- ----------------------------
DROP PROCEDURE IF EXISTS `upgoods`;
DELIMITER ;;
CREATE PROCEDURE `upgoods`(in gi varchar(20),in gn varchar(50),in cf varchar(20),in p double(10,2),in s int)
BEGIN
		update goods set GoodsName = gn,ClassificationNum = cf,Price = p,Stock = s where GoodsId = gi;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for uporders
-- ----------------------------
DROP PROCEDURE IF EXISTS `uporders`;
DELIMITER ;;
CREATE PROCEDURE `uporders`(in id int,in num1 int,in p double(12,2),in num2 int)
BEGIN
	UPDATE orders set GoodsNum = num1,Prices = p/num2*num1 where Onumber = id;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for upuser
-- ----------------------------
DROP PROCEDURE IF EXISTS `upuser`;
DELIMITER ;;
CREATE PROCEDURE `upuser`(in num int,in name2 varchar(20),in pass varchar(20),in rank2 int,in phone2 char(11))
BEGIN
update user set UserName = name2,Password = pass,Rank = rank2,Phone = phone2 where Number = num;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for u_p
-- ----------------------------
DROP PROCEDURE IF EXISTS `u_p`;
DELIMITER ;;
CREATE PROCEDURE `u_p`(in userName varchar(10),in passward varchar(20))
BEGIN
		select * from user where UserName = userName and Password = passward;
END
;;
DELIMITER ;
