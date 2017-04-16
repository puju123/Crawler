CREATE TABLE `hauses` (
  `id` char(12) NOT NULL,
  `crawldate` date NOT NULL,
  `price` int(11) DEFAULT NULL,
  `areaName` varchar(128) DEFAULT NULL,
  `community` varchar(45) DEFAULT NULL,
  `huxing` varchar(45) DEFAULT NULL,
  `louceng` varchar(45) DEFAULT NULL,
  `jianmian` float DEFAULT NULL,
  `taomian` float DEFAULT NULL,
  `louxing` varchar(45) DEFAULT NULL,
  `chaoxiang` varchar(45) DEFAULT NULL,
  `jiegou` varchar(45) DEFAULT NULL,
  `zhuangxiu` varchar(45) DEFAULT NULL,
  `tihubili` varchar(45) DEFAULT NULL,
  `gongnuan` varchar(45) DEFAULT NULL,
  `hasDianti` varchar(45) DEFAULT NULL,
  `chanquan` varchar(45) DEFAULT NULL,
  `jiaoyiquanshu` varchar(45) DEFAULT NULL,
  `guapaishijian` varchar(45) DEFAULT NULL,
  `shangcijiaoyi` varchar(45) DEFAULT NULL,
  `yongtu` varchar(45) DEFAULT NULL,
  `chiyounianxian` varchar(45) DEFAULT NULL,
  `suoyouquan` varchar(45) DEFAULT NULL,
  `diya` varchar(45) DEFAULT NULL,
  `note` varchar(45) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,CREATE TABLE `proxy` (
  `ip` char(17) NOT NULL,
  `port` int(11) NOT NULL,
  `type` char(16) DEFAULT NULL,
  `successcount` int(11) DEFAULT NULL,
  `creattime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`ip`,`port`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `proxy` (
  `ip` char(17) NOT NULL,
  `port` int(11) NOT NULL,
  `type` char(16) DEFAULT NULL,
  `successcount` int(11) DEFAULT NULL,
  `creattime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`ip`,`port`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

  PRIMARY KEY (`id`,`crawldate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SELECT * FROM crawler.proxy;