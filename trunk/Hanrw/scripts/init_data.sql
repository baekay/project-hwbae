INSERT INTO `menu_master` VALUES ('MNU01','사진변환텍스트');
INSERT INTO `menu_master` VALUES ('MNU02','음성변환텍스트');
INSERT INTO `menu_master` VALUES ('MNU03','보고서');
INSERT INTO `menu_master` VALUES ('MNU04','화상대독');
INSERT INTO `menu_master` VALUES ('MNU05','자유게시판');
INSERT INTO `menu_master` VALUES ('MNU06','회원관리');
INSERT INTO `role_master` VALUES ('ADMIN','관리자');
INSERT INTO `role_master` VALUES ('COORD','코디');
INSERT INTO `role_master` VALUES ('USER','사용자');
INSERT INTO `menu_role` VALUES ('ADMIN','MNU01','CRUD');
INSERT INTO `menu_role` VALUES ('ADMIN','MNU02','CRUD');
INSERT INTO `menu_role` VALUES ('ADMIN','MNU03','CRUD');
INSERT INTO `menu_role` VALUES ('ADMIN','MNU04','CRUD');
INSERT INTO `menu_role` VALUES ('ADMIN','MNU05','CRUD');
INSERT INTO `menu_role` VALUES ('ADMIN','MNU06','CRUD');
INSERT INTO `menu_role` VALUES ('COORD','MNU01','CRUD');
INSERT INTO `menu_role` VALUES ('COORD','MNU02','CRUD');
INSERT INTO `menu_role` VALUES ('COORD','MNU03','CRUD');
INSERT INTO `menu_role` VALUES ('COORD','MNU04','CRUD');
INSERT INTO `menu_role` VALUES ('USER','MNU01','CRUD');
INSERT INTO `menu_role` VALUES ('USER','MNU02','CRUD');
INSERT INTO `menu_role` VALUES ('USER','MNU03','R');
INSERT INTO `menu_role` VALUES ('USER','MNU04','R');
INSERT INTO `menu_role` VALUES ('USER','MNU05','CRUD');
INSERT INTO `user_master` VALUES ('admin', '관리자', password('rhksflwk00!'), '', sysdate(), 'ADMIN', '');