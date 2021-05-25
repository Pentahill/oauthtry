INSERT INTO `users` VALUES ('reader', '$2a$04$C6pPJvC1v6.enW6ZZxX.luTdpSI/1gcgTVN7LhvQV6l/AfmzNU/3i', 1);
INSERT INTO `users` VALUES ('writer', '$2a$04$M9t2oVs3/VIreBMocOujqOaB/oziWL0SnlWdt8hV4YnlhQrORA0fS', 1);
# password reader/reader writer/writer

INSERT INTO `authorities` VALUES ('reader', 'READ');
INSERT INTO `authorities` VALUES ('writer', 'READ,WRITE');

INSERT INTO `oauth_client_details` VALUES ('userservice1', 'userservice', '1234', 'FOO', 'password,refresh_token', '', 'READ,WRITE', 7200, NULL, NULL, 'true');
INSERT INTO `oauth_client_details` VALUES ('userservice2', 'userservice', '1234', 'FOO', 'client_credentials,refresh_token', '', 'READ,WRITE', 7200, NULL, NULL, 'true');
INSERT INTO `oauth_client_details` VALUES ('userservice3', 'userservice', '1234', 'FOO', 'authorization_code,refresh_token', 'https://baidu.com,http://localhost:8082/ui/login,http://localhost:8083/ui/login,http://localhost:8082/ui/remoteCall', 'READ,WRITE', 7200, NULL, NULL, 'false');