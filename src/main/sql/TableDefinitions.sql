CREATE TABLE building
(
  address VARCHAR(255),
  id BIGINT(20) PRIMARY KEY NOT NULL
);
CREATE TABLE computer
(
  dvi_output TINYINT(1),
  hdmi_output TINYINT(1),
  hostname VARCHAR(255),
  keyboard TINYINT(1),
  machine_type VARCHAR(255),
  manufacturer VARCHAR(255),
  model VARCHAR(255),
  mouse TINYINT(1),
  speakers TINYINT(1),
  vga_output TINYINT(1),
  wired_networking TINYINT(1),
  wireless_networking TINYINT(1),
  id BIGINT(20) PRIMARY KEY NOT NULL,
  operating_system_id BIGINT(20)
);
CREATE TABLE computeros
(
  id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  license VARCHAR(255),
  version INT(11),
  os_type VARCHAR(255)
);
CREATE TABLE department
(
  id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(255)
);
CREATE TABLE employee
(
  username VARCHAR(255) PRIMARY KEY NOT NULL,
  email VARCHAR(255),
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  password_encrypted VARCHAR(255),
  phone VARCHAR(255),
  department_id BIGINT(20)
);
CREATE TABLE projector
(
  dvi_input BIT(1),
  hdmi_input BIT(1),
  height INT(11) NOT NULL,
  width INT(11) NOT NULL,
  vga_input BIT(1),
  id BIGINT(20) PRIMARY KEY NOT NULL
);
CREATE TABLE reservation
(
  id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  end_date_time TINYBLOB,
  start_date_time TINYBLOB,
  user_username VARCHAR(255)
);
CREATE TABLE reservation_resources
(
  reservation_id BIGINT(20) NOT NULL,
  resources_id BIGINT(20) NOT NULL
);
CREATE TABLE resource
(
  id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  available BIT(1),
  description VARCHAR(255),
  moveable BIT(1),
  name VARCHAR(255),
  resourceUID BIGINT(20) NOT NULL
);
CREATE TABLE room
(
  room_number VARCHAR(255),
  id BIGINT(20) PRIMARY KEY NOT NULL,
  building_id BIGINT(20)
);
CREATE TABLE user_role
(
  id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  user_role_human_readable VARCHAR(255)
);
CREATE TABLE user_roles
(
  user_username VARCHAR(255) NOT NULL,
  roles_id BIGINT(20) NOT NULL
);
CREATE TABLE whiteboard
(
  height INT(11) NOT NULL,
  width INT(11) NOT NULL,
  id BIGINT(20) PRIMARY KEY NOT NULL
);
ALTER TABLE building ADD FOREIGN KEY (id) REFERENCES resource (id);
ALTER TABLE computer ADD FOREIGN KEY (id) REFERENCES resource (id);
ALTER TABLE computer ADD FOREIGN KEY (operating_system_id) REFERENCES computeros (id);
CREATE INDEX FKpnqqgd3ou1krjhk931xkdjcxr ON computer (operating_system_id);
ALTER TABLE employee ADD FOREIGN KEY (department_id) REFERENCES department (id);
CREATE INDEX FKgkh2fko1e4ydv1y6vtrwdc6my ON employee (department_id);
ALTER TABLE projector ADD FOREIGN KEY (id) REFERENCES resource (id);
ALTER TABLE reservation ADD FOREIGN KEY (user_username) REFERENCES employee (username);
CREATE INDEX FK98ovihk6btlxrb1b12q6mgpbm ON reservation (user_username);
ALTER TABLE reservation_resources ADD FOREIGN KEY (reservation_id) REFERENCES reservation (id);
ALTER TABLE reservation_resources ADD FOREIGN KEY (resources_id) REFERENCES resource (id);
CREATE INDEX FK3ibmdb9y8dq9w9ih59ttfc86 ON reservation_resources (reservation_id);
CREATE INDEX FKb0tsgapany4r31fymm97gvgon ON reservation_resources (resources_id);
ALTER TABLE room ADD FOREIGN KEY (id) REFERENCES resource (id);
ALTER TABLE room ADD FOREIGN KEY (building_id) REFERENCES building (id);
CREATE INDEX FK4kmfw73x2vpfymk0ml875rh2q ON room (building_id);
ALTER TABLE user_roles ADD FOREIGN KEY (user_username) REFERENCES employee (username);
ALTER TABLE user_roles ADD FOREIGN KEY (roles_id) REFERENCES user_role (id);
CREATE INDEX FK1misndtpfm9hx3ttvixdus8d1 ON user_roles (user_username);
CREATE INDEX FK5i6gd32hnpr2nyf5edlvl9nhw ON user_roles (roles_id);
ALTER TABLE whiteboard ADD FOREIGN KEY (id) REFERENCES resource (id);