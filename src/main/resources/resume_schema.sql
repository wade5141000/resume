-- DROP DATABASE `resume`;

-- CREATE DATABASE `resume` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `resume`;

DROP TABLE IF EXISTS `resume`.`user`;
CREATE TABLE `resume`.`user` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '使用者編號',
  `ACCOUNT` varchar(30) NOT NULL COMMENT '使用者帳號',
  `USER_NAME` varchar(30) DEFAULT NULL COMMENT '姓名',
  `PASSWORD` varchar(200) DEFAULT NULL COMMENT '密碼',
  `EMAIL` varchar(30) NOT NULL COMMENT '信箱',
  `PHONE` varchar(20) DEFAULT NULL COMMENT '電話',
  `BIRTHDAY` timestamp NULL DEFAULT NULL COMMENT '生日',
  `SEX` char(1) DEFAULT NULL COMMENT '性別',
  `MILITARY_SERVICE` varchar(10) DEFAULT NULL COMMENT '服役情況',
  `MILITARY_DATE` timestamp NULL DEFAULT NULL COMMENT '退伍日期',
  `ADDRESS` varchar(255) DEFAULT NULL COMMENT '通訊地址',
  `SPECIAL_IDENTITY` varchar(50) DEFAULT NULL COMMENT '特殊身分',
  `INTRODUCTION` varchar(200) DEFAULT NULL COMMENT '自我介紹',
  `BIO_ENG` varchar(4000) DEFAULT NULL COMMENT '英文自傳',
  `BIO_CHN` varchar(4000) DEFAULT NULL COMMENT '中文自傳',
  `PROFILE_IMG_PATH` varchar(1000) DEFAULT NULL COMMENT '使用者圖像路徑',
  `CR_USER` varchar(30) DEFAULT NULL COMMENT '建立者',
  `CR_DATETIME` timestamp NULL DEFAULT NULL COMMENT '建立日期',
  `UP_USER` varchar(30) DEFAULT NULL COMMENT '更新者',
  `UP_DATETIME` timestamp NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  UNIQUE KEY `ACCOUNT_UNIQUE` (`ACCOUNT`),
  UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='使用者帳號' AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `resume`.`resume`;
CREATE TABLE `resume`.`resume` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '編號',
  `UID` int NOT NULL COMMENT '使用者編號',
  `TEMPLATE_ID` int DEFAULT NULL COMMENT '模板編號',
  `RESUME_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '履歷命名',
  `BASIC_INFO_COLUMNS` varchar(200) DEFAULT NULL COMMENT '基本資料類別',
  `FILE_PATH` varchar(50) NOT NULL COMMENT '檔案路徑',
  `CR_USER` varchar(30) DEFAULT NULL COMMENT '建立者',
  `CR_DATETIME` timestamp NULL DEFAULT NULL COMMENT '建立日期',
  `UP_USER` varchar(30) DEFAULT NULL COMMENT '更新者',
  `UP_DATETIME` timestamp NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`ID`,`UID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='履歷' AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `resume`.`template`;
CREATE TABLE `resume`.`template` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '編號',
  `NAME` varchar(20) NOT NULL COMMENT '模板名稱',
  `BASIC_INFO_LIMIT` int NOT NULL DEFAULT '1' COMMENT '基本資料上限',
  `EDUCATION_LIMIT` int NOT NULL DEFAULT '1' COMMENT '學歷上限',
  `EXPERIENCE_LIMIT` int NOT NULL DEFAULT '1' COMMENT '經歷上限',
  `SKILL_LIMIT` int NOT NULL DEFAULT '1' COMMENT '技能上限',
  `LICENSE_LIMIT` int NOT NULL DEFAULT '1' COMMENT '證照上限',
  `LANGUAGE_LIMIT` int NOT NULL DEFAULT '1' COMMENT '語言技能上限',
  `FEATURE_LIMIT` int NOT NULL DEFAULT '1' COMMENT '個人特色上限',
  `LINK_LIMIT` int NOT NULL DEFAULT '1' COMMENT '連結上限',
  `CR_USER` varchar(30) DEFAULT NULL COMMENT '建立者',
  `CR_DATETIME` timestamp NULL DEFAULT NULL COMMENT '建立日期',
  `UP_USER` varchar(30) DEFAULT NULL COMMENT '更新者',
  `UP_DATETIME` timestamp NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='履歷模板' AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `resume`.`skill`;
CREATE TABLE `resume`.`skill` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '編號',
  `UID` int NOT NULL COMMENT '使用者編號',
  `SKILL_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '技能',
  `SKILL_DESC` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '技能描述',
  `CR_USER` varchar(30) DEFAULT NULL COMMENT '建立者',
  `CR_DATETIME` timestamp NULL DEFAULT NULL COMMENT '建立日期',
  `UP_USER` varchar(30) DEFAULT NULL COMMENT '更新者',
  `UP_DATETIME` timestamp NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`ID`,`UID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='專業技能' AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `resume`.`education`;
CREATE TABLE `resume`.`education` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '編號',
  `UID` int NOT NULL COMMENT '使用者編號',
  `SCHOOL_NAME` varchar(50) DEFAULT NULL COMMENT '學校',
  `LEVEL` varchar(20) DEFAULT NULL COMMENT '學歷等級(國中、高中...)',
  `MAJOR` varchar(50) DEFAULT NULL COMMENT '學系',
  `SECOND_MAJOR` varchar(50) DEFAULT NULL COMMENT '輔修',
  `STATUS` varchar(20) DEFAULT NULL COMMENT '在學狀態(畢業、肄業...)',
  `START_DATE` timestamp NULL DEFAULT NULL COMMENT '入學時間',
  `END_DATE` timestamp NULL DEFAULT NULL COMMENT '畢業時間',
  `COUNTRY` varchar(50) DEFAULT NULL COMMENT '國家',
  `GPA` float DEFAULT NULL COMMENT 'GPA',
  `CR_USER` varchar(30) DEFAULT NULL COMMENT '建立者',
  `CR_DATETIME` timestamp NULL DEFAULT NULL COMMENT '建立日期',
  `UP_USER` varchar(30) DEFAULT NULL COMMENT '更新者',
  `UP_DATETIME` timestamp NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`ID`,`UID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='學歷' AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `resume`.`experience`;
CREATE TABLE `resume`.`experience` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '編號',
  `UID` int NOT NULL COMMENT '使用者編號',
  `COMPANY_NAME` varchar(50) DEFAULT NULL COMMENT '公司名稱',
  `POSITION` varchar(50) DEFAULT NULL COMMENT '職稱',
  `START_DATE` timestamp NULL DEFAULT NULL COMMENT '到職日',
  `END_DATE` timestamp NULL DEFAULT NULL COMMENT '離職日',
  `EXPERIENCE_DESC` varchar(100) DEFAULT NULL COMMENT '簡介',
  `ABILITY` varchar(150) DEFAULT NULL COMMENT '工作能力(分號分隔字串)',
  `CR_USER` varchar(30) DEFAULT NULL COMMENT '建立者',
  `CR_DATETIME` timestamp NULL DEFAULT NULL COMMENT '建立日期',
  `UP_USER` varchar(30) DEFAULT NULL COMMENT '更新者',
  `UP_DATETIME` timestamp NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`ID`,`UID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='工作經驗' AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `resume`.`feature`;
CREATE TABLE `resume`.`feature` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '個人特色編號',
  `UID` int NOT NULL COMMENT '使用者編號',
  `CONTENT` varchar(20) DEFAULT NULL COMMENT '內容',
  `CR_USER` varchar(30) DEFAULT NULL COMMENT '建立者',
  `CR_DATETIME` timestamp NULL DEFAULT NULL COMMENT '建立日期',
  `UP_USER` varchar(30) DEFAULT NULL COMMENT '更新者',
  `UP_DATETIME` timestamp NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`ID`,`UID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='個人特色' AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `resume`.`language`;
CREATE TABLE `resume`.`language` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '編號',
  `UID` int NOT NULL COMMENT '使用者編號',
  `LANGUAGE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '語言',
  `LISTENING` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '聽力',
  `SPEAKING` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '口說',
  `READING` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '閱讀',
  `WRITING` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '寫作',
  `CR_USER` varchar(30) DEFAULT NULL COMMENT '建立者',
  `CR_DATETIME` timestamp NULL DEFAULT NULL COMMENT '建立日期',
  `UP_USER` varchar(30) DEFAULT NULL COMMENT '更新者',
  `UP_DATETIME` timestamp NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`ID`,`UID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='語言能力' AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `resume`.`license`;
CREATE TABLE `resume`.`license` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '編號',
  `UID` int NOT NULL COMMENT '使用者編號',
  `NAME` varchar(50) DEFAULT NULL COMMENT '證照名稱',
  `CR_USER` varchar(30) DEFAULT NULL COMMENT '建立者',
  `CR_DATETIME` timestamp NULL DEFAULT NULL COMMENT '建立日期',
  `UP_USER` varchar(30) DEFAULT NULL COMMENT '更新者',
  `UP_DATETIME` timestamp NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`ID`,`UID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='證照' AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `resume`.`link`;
CREATE TABLE `resume`.`link` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '個人連結編號',
  `UID` int NOT NULL COMMENT '使用者編號',
  `PLATFORM` varchar(20) DEFAULT NULL COMMENT '平台',
  `URL` varchar(200) DEFAULT NULL COMMENT '連結網址',
  `CR_USER` varchar(30) DEFAULT NULL COMMENT '建立者',
  `CR_DATETIME` timestamp NULL DEFAULT NULL COMMENT '建立日期',
  `UP_USER` varchar(30) DEFAULT NULL COMMENT '更新者',
  `UP_DATETIME` timestamp NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`ID`,`UID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='個人連結' AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `resume`.`rel_resume_edu`;
CREATE TABLE `resume`.`rel_resume_edu` (
  `RID` int NOT NULL COMMENT '履歷編號',
  `EDU_ID` int NOT NULL COMMENT '學歷編號',
  PRIMARY KEY (`RID`,`EDU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='履歷_學歷_關聯表' AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `resume`.`rel_resume_exp`;
CREATE TABLE `resume`.`rel_resume_exp` (
  `RID` int NOT NULL COMMENT '履歷編號',
  `EXP_ID` int NOT NULL COMMENT '工作經驗編號',
  PRIMARY KEY (`RID`,`EXP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='履歷_工作經驗_關聯表' AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `resume`.`rel_resume_lang`;
CREATE TABLE `resume`.`rel_resume_lang` (
  `RID` int NOT NULL COMMENT '履歷編號',
  `LANGUAGE_ID` int NOT NULL COMMENT '語言能力編號',
  PRIMARY KEY (`RID`,`LANGUAGE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='履歷_語言能力_關聯表' AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `resume`.`rel_resume_license`;
CREATE TABLE `resume`.`rel_resume_license` (
  `RID` int NOT NULL COMMENT '履歷編號',
  `LICENSE_ID` int NOT NULL COMMENT '證照編號',
  PRIMARY KEY (`RID`,`LICENSE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='履歷_證照_關聯表' AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `resume`.`rel_resume_skill`;
CREATE TABLE `resume`.`rel_resume_skill` (
  `RID` int NOT NULL COMMENT '履歷編號',
  `SKILL_ID` int NOT NULL COMMENT '專業技能編號',
  PRIMARY KEY (`RID`,`SKILL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='履歷_專業技能_關聯表' AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `resume`.`address`;
CREATE TABLE `resume`.`address` (
 `ID` int primary key  AUTO_INCREMENT,
 `CITY` varchar(10) NOT NULL,
 `TOWN` varchar(10) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='address';

ALTER TABLE resume.address AUTO_INCREMENT=1;
INSERTresume INTO resume.address (city,town) VALUES
    ("連江縣","北竿鄉"),
("連江縣","南竿鄉"),
("連江縣","東引鄉"),
("連江縣","莒光鄉"),
("金門縣","烈嶼鄉"),
("金門縣","金城鎮"),
("金門縣","金寧鄉"),
("金門縣","金沙鎮"),
("金門縣","金湖鎮"),
("金門縣","烏坵鄉"),
("高雄市","六龜區"),
("高雄市","永安區"),
("臺南市","北門區"),
("臺南市","將軍區"),
("臺南市","七股區"),
("高雄市","小港區"),
("高雄市","前鎮區"),
("高雄市","苓雅區"),
("高雄市","旗津區"),
("高雄市","林園區"),
("高雄市","前金區"),
("高雄市","新興區"),
("高雄市","鳳山區"),
("高雄市","大寮區"),
("高雄市","鼓山區"),
("高雄市","三民區"),
("高雄市","鳥松區"),
("高雄市","左營區"),
("高雄市","仁武區"),
("高雄市","楠梓區"),
("高雄市","大社區"),
("高雄市","梓官區"),
("高雄市","大樹區"),
("高雄市","橋頭區"),
("高雄市","彌陀區"),
("高雄市","燕巢區"),
("高雄市","岡山區"),
("高雄市","路竹區"),
("高雄市","阿蓮區"),
("高雄市","茄萣區"),
("高雄市","湖內區"),
("高雄市","田寮區"),
("高雄市","旗山區"),
("高雄市","美濃區"),
("臺南市","南區"),
("臺南市","仁德區"),
("臺南市","中西區"),
("高雄市","茂林區"),
("臺南市","東區"),
("臺南市","安平區"),
("臺南市","龍崎區"),
("臺南市","關廟區"),
("臺南市","歸仁區"),
("臺南市","北區"),
("高雄市","內門區"),
("高雄市","杉林區"),
("臺南市","永康區"),
("臺南市","新化區"),
("臺南市","左鎮區"),
("臺南市","安南區"),
("臺南市","新市區"),
("臺南市","安定區"),
("臺南市","山上區"),
("臺南市","西港區"),
("臺南市","善化區"),
("臺南市","玉井區"),
("臺南市","大內區"),
("高雄市","甲仙區"),
("臺南市","佳里區"),
("臺南市","官田區"),
("臺南市","麻豆區"),
("臺南市","楠西區"),
("臺南市","南化區"),
("臺南市","六甲區"),
("臺南市","下營區"),
("臺南市","學甲區"),
("臺南市","柳營區"),
("臺南市","東山區"),
("臺南市","新營區"),
("臺南市","鹽水區"),
("高雄市","那瑪夏區"),
("臺南市","後壁區"),
("臺南市","白河區"),
("臺東縣","長濱鄉"),
("臺東縣","東河鄉"),
("臺東縣","成功鎮"),
("臺東縣","大武鄉"),
("臺東縣","達仁鄉"),
("臺東縣","金峰鄉"),
("臺東縣","太麻里鄉"),
("臺東縣","臺東市"),
("臺東縣","卑南鄉"),
("臺東縣","延平鄉"),
("臺東縣","鹿野鄉"),
("臺東縣","關山鎮"),
("臺東縣","池上鄉"),
("臺東縣","海端鄉"),
("屏東縣","牡丹鄉"),
("屏東縣","佳冬鄉"),
("屏東縣","枋寮鄉"),
("嘉義縣","東石鄉"),
("嘉義縣","布袋鎮"),
("雲林縣","臺西鄉"),
("雲林縣","麥寮鄉"),
("屏東縣","恆春鎮"),
("屏東縣","車城鄉"),
("屏東縣","滿州鄉"),
("屏東縣","枋山鄉"),
("屏東縣","獅子鄉"),
("屏東縣","林邊鄉"),
("屏東縣","春日鄉"),
("屏東縣","東港鎮"),
("屏東縣","南州鄉"),
("屏東縣","新埤鄉"),
("屏東縣","崁頂鄉"),
("屏東縣","新園鄉"),
("屏東縣","潮州鎮"),
("屏東縣","來義鄉"),
("屏東縣","萬丹鄉"),
("屏東縣","竹田鄉"),
("屏東縣","萬巒鄉"),
("屏東縣","泰武鄉"),
("屏東縣","麟洛鄉"),
("屏東縣","內埔鄉"),
("屏東縣","屏東市"),
("屏東縣","瑪家鄉"),
("屏東縣","長治鄉"),
("屏東縣","九如鄉"),
("屏東縣","鹽埔鄉"),
("屏東縣","里港鄉"),
("屏東縣","霧臺鄉"),
("屏東縣","三地門鄉"),
("屏東縣","高樹鄉"),
("嘉義縣","大埔鄉"),
("嘉義縣","義竹鄉"),
("嘉義縣","鹿草鄉"),
("嘉義縣","中埔鄉"),
("嘉義縣","水上鄉"),
("嘉義縣","朴子市"),
("嘉義縣","番路鄉"),
("嘉義縣","竹崎鄉"),
("嘉義縣","六腳鄉"),
("嘉義縣","民雄鄉"),
("嘉義縣","新港鄉"),
("嘉義縣","梅山鄉"),
("嘉義縣","阿里山鄉"),
("嘉義縣","溪口鄉"),
("雲林縣","水林鄉"),
("雲林縣","北港鎮"),
("嘉義縣","大林鎮"),
("雲林縣","口湖鄉"),
("雲林縣","大埤鄉"),
("雲林縣","元長鄉"),
("雲林縣","古坑鄉"),
("雲林縣","四湖鄉"),
("雲林縣","斗南鎮"),
("雲林縣","東勢鄉"),
("雲林縣","褒忠鄉"),
("雲林縣","虎尾鎮"),
("雲林縣","土庫鎮"),
("雲林縣","斗六市"),
("雲林縣","林內鄉"),
("雲林縣","西螺鎮"),
("雲林縣","崙背鄉"),
("雲林縣","二崙鄉"),
("屏東縣","琉球鄉"),
("高雄市","鹽埕區"),
("雲林縣","莿桐鄉"),
("新北市","中和區"),
("臺北市","文山區"),
("桃園市","新屋區"),
("新北市","樹林區"),
("新北市","永和區"),
("新北市","深坑區"),
("桃園市","中壢區"),
("桃園市","桃園區"),
("新北市","板橋區"),
("新北市","石碇區"),
("臺北市","大安區"),
("臺北市","萬華區"),
("臺北市","中正區"),
("臺北市","信義區"),
("臺北市","南港區"),
("桃園市","龜山區"),
("新北市","新莊區"),
("新北市","泰山區"),
("臺北市","松山區"),
("新北市","平溪區"),
("臺北市","大同區"),
("桃園市","觀音區"),
("臺北市","中山區"),
("新北市","三重區"),
("新北市","雙溪區"),
("新北市","蘆洲區"),
("基隆市","暖暖區"),
("臺北市","內湖區"),
("桃園市","蘆竹區"),
("桃園市","大園區"),
("新北市","貢寮區"),
("新北市","五股區"),
("基隆市","仁愛區"),
("新北市","林口區"),
("新北市","瑞芳區"),
("新北市","汐止區"),
("基隆市","信義區"),
("基隆市","七堵區"),
("基隆市","中山區"),
("新北市","八里區"),
("基隆市","安樂區"),
("臺北市","士林區"),
("臺北市","北投區"),
("新北市","萬里區"),
("新北市","淡水區"),
("新北市","金山區"),
("新北市","三芝區"),
("新北市","石門區"),
("南投縣","魚池鄉"),
("南投縣","鹿谷鄉"),
("花蓮縣","豐濱鄉"),
("花蓮縣","富里鄉"),
("花蓮縣","玉里鎮"),
("花蓮縣","瑞穗鄉"),
("花蓮縣","卓溪鄉"),
("花蓮縣","光復鄉"),
("花蓮縣","鳳林鎮"),
("花蓮縣","萬榮鄉"),
("花蓮縣","壽豐鄉"),
("花蓮縣","吉安鄉"),
("花蓮縣","花蓮市"),
("花蓮縣","新城鄉"),
("花蓮縣","秀林鄉"),
("宜蘭縣","蘇澳鎮"),
("宜蘭縣","南澳鄉"),
("宜蘭縣","冬山鄉"),
("宜蘭縣","羅東鎮"),
("宜蘭縣","三星鄉"),
("宜蘭縣","五結鄉"),
("宜蘭縣","大同鄉"),
("宜蘭縣","宜蘭市"),
("宜蘭縣","員山鄉"),
("宜蘭縣","壯圍鄉"),
("宜蘭縣","礁溪鄉"),
("臺中市","南區"),
("南投縣","竹山鎮"),
("彰化縣","二水鄉"),
("南投縣","集集鎮"),
("南投縣","信義鄉"),
("彰化縣","溪州鄉"),
("南投縣","名間鄉"),
("彰化縣","竹塘鄉"),
("彰化縣","北斗鎮"),
("彰化縣","田中鎮"),
("彰化縣","大城鄉"),
("南投縣","水里鄉"),
("彰化縣","田尾鄉"),
("彰化縣","埤頭鄉"),
("彰化縣","社頭鄉"),
("彰化縣","永靖鄉"),
("南投縣","南投市"),
("南投縣","中寮鄉"),
("彰化縣","埔心鄉"),
("彰化縣","溪湖鎮"),
("彰化縣","員林市"),
("彰化縣","二林鎮"),
("彰化縣","大村鄉"),
("南投縣","草屯鎮"),
("彰化縣","埔鹽鄉"),
("彰化縣","芳苑鄉"),
("彰化縣","芬園鄉"),
("南投縣","埔里鎮"),
("彰化縣","花壇鄉"),
("彰化縣","福興鄉"),
("彰化縣","秀水鄉"),
("臺中市","霧峰區"),
("彰化縣","彰化市"),
("臺中市","大里區"),
("彰化縣","鹿港鎮"),
("南投縣","國姓鄉"),
("臺中市","烏日區"),
("臺中市","中區"),
("彰化縣","線西鄉"),
("彰化縣","和美鎮"),
("臺中市","西區"),
("臺中市","太平區"),
("臺中市","南屯區"),
("臺中市","北區"),
("臺中市","大肚區"),
("彰化縣","伸港鄉"),
("臺中市","西屯區"),
("臺中市","北屯區"),
("臺中市","潭子區"),
("南投縣","仁愛鄉"),
("臺中市","大雅區"),
("臺中市","沙鹿區"),
("臺中市","新社區"),
("臺中市","豐原區"),
("臺中市","石岡區"),
("臺中市","龍井區"),
("臺中市","神岡區"),
("臺中市","東勢區"),
("臺中市","清水區"),
("臺中市","后里區"),
("臺中市","外埔區"),
("苗栗縣","卓蘭鎮"),
("臺中市","大安區"),
("苗栗縣","三義鄉"),
("臺中市","大甲區"),
("臺中市","和平區"),
("苗栗縣","大湖鄉"),
("苗栗縣","苑裡鎮"),
("苗栗縣","泰安鄉"),
("苗栗縣","銅鑼鄉"),
("苗栗縣","公館鄉"),
("苗栗縣","通霄鎮"),
("苗栗縣","西湖鄉"),
("苗栗縣","苗栗市"),
("苗栗縣","獅潭鄉"),
("苗栗縣","頭屋鄉"),
("苗栗縣","南庄鄉"),
("苗栗縣","造橋鄉"),
("苗栗縣","後龍鎮"),
("新竹縣","五峰鄉"),
("苗栗縣","三灣鄉"),
("苗栗縣","頭份市"),
("新竹縣","峨眉鄉"),
("新竹縣","北埔鄉"),
("苗栗縣","竹南鎮"),
("新竹縣","橫山鄉"),
("新竹縣","尖石鄉"),
("新竹縣","寶山鄉"),
("新竹縣","竹東鎮"),
("新竹縣","芎林鄉"),
("新竹市","東區"),
("新竹市","香山區"),
("新竹縣","關西鎮"),
("桃園市","復興區"),
("新竹市","北區"),
("新竹縣","竹北市"),
("新竹縣","新埔鎮"),
("桃園市","龍潭區"),
("新北市","烏來區"),
("桃園市","大溪區"),
("新竹縣","湖口鄉"),
("新竹縣","新豐鄉"),
("新北市","三峽區"),
("桃園市","楊梅區"),
("桃園市","平鎮區"),
("新北市","鶯歌區"),
("新北市","坪林區"),
("桃園市","八德區"),
("新北市","新店區"),
("新北市","土城區"),
("基隆市","中正區"),
("宜蘭縣","頭城鎮"),
("臺東縣","綠島鄉"),
("臺東縣","蘭嶼鄉"),
("高雄市","桃源區"),
("澎湖縣","七美鄉"),
("澎湖縣","白沙鄉"),
("澎湖縣","西嶼鄉"),
("澎湖縣","馬公市"),
("澎湖縣","望安鄉"),
("澎湖縣","湖西鄉"),
("嘉義縣","太保市"),
("臺中市","東區"),
("臺中市","梧棲區"),
("嘉義市","西區"),
("嘉義市","東區");
