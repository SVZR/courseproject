
INSERT INTO user (firstName, lastName, useremail, userLogin, userpassword, role) VALUES ('TestFirstNameOne', 'TestLastNameOne', 'TestOne@test.by', 'TestLoginOne', 'test', 'USER');
INSERT INTO user (firstName, lastName, useremail, userLogin, userpassword, role) VALUES ('TestFirstNameTwo', 'TestLastNameTwo', 'TestTwo@test.by', 'TestLoginTwo', 'test', 'USER');
INSERT INTO user (firstName, lastName, useremail, userLogin, userpassword, role) VALUES ('TestFirstNameThree', 'TestLastNameThree', 'TestThree@test.by', 'TestLoginThree', 'test', 'MODERATOR');
INSERT INTO user (firstName, lastName, useremail, userLogin, userpassword, role) VALUES ('TestFirstNameFour', 'TestLastNameFour', 'TestFour@test.by', 'TestLoginFour', 'test', 'ADMINISTRATOR');

INSERT INTO country (name) VALUES ('TestCountryNameOne');
INSERT INTO theme (name, country_id) VALUES ('TestThemeNameOne', 1);
INSERT INTO series (name, theme_id) VALUES ('TestSeriesNameOne', 1);

INSERT INTO coin (name, series_id, release_date, designer, minted_by, description, image_address)
VALUES ('TestCoinOne', 1, '12-12-2000', 'TestDesignerOne', 'testMintedOne', 'testone', 'testone');
INSERT INTO coin (name, series_id, release_date, designer, minted_by, description, image_address)
VALUES ('TestCoinTwo', 1, '12-12-2000', 'TestDesignerTwo', 'testMintedTwo', 'testtwo', 'testtwo');
INSERT INTO coin (name, series_id, release_date, designer, minted_by, description, image_address)
VALUES ('TestCoinThree', 1, '12-12-2000', 'TestDesignerThree', 'testMintedThree', 'testthree', 'testthree');
INSERT INTO coin (name, series_id, release_date, designer, minted_by, description, image_address)
VALUES ('TestCoinFour', 1, '12-12-2000', 'TestDesignerFour', 'testMintedFour', 'testfour', 'testfour');

