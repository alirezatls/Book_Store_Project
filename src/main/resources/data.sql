INSERT INTO auth_member(user_name, auth_group)
VALUES ('admin', 'USER'),
       ('admin', 'ADMIN');
INSERT INTO auth_member(user_name, auth_group)
VALUES ('user', 'USER');

INSERT INTO members(name, user_name, password, email, enabled)
VALUES ('alireza', 'admin', '12345678', 'test@gmail.com', TRUE);

INSERT INTO members(name, user_name, password, email, enabled)
VALUES ('jon', 'user', '12345678', 'xyz@gmail.com', TRUE);


INSERT INTO book(book_author, book_code, book_name, cost, creation_date, details, page_number, publisher, url)
VALUES ( 'Josh Long', 1000
       , 'Pointless Meeting', 120, now()
       , 'Lorem ipsum dolor sit amet, consectetur adipiscing elit,' ||
         ' sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim' ||
         ' ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip' ||
         ' ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit' ||
         ' esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat' ||
         ' non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
       , 340, 'Oriely'
       , 'https://drive.google.com/uc?id=1FUOSPMgTu1aLfICfzfBURF76ozVNm2x7&export=download');

INSERT INTO book(book_author, book_code, book_name, cost, creation_date, details, page_number, publisher, url)
VALUES ( 'Josh Long', 1001, 'Learning Python', 135, now(), 'Lorem ipsum dolor sit amet, consectetur adipiscing elit,' ||
                                                           ' sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim' ||
                                                           ' ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip' ||
                                                           ' ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit' ||
                                                           ' esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat' ||
                                                           ' non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
       , 300, 'Oriely'
       , 'https://drive.google.com/uc?id=171dfXF8nZc99iMeA4aSKXurY72dj3hga&export=download');

INSERT INTO book(book_author, book_code, book_name, cost, creation_date, details, page_number, publisher, url)
VALUES ( 'Josh Long', 1002, 'Learning React', 110, now(), 'Lorem ipsum dolor sit amet, consectetur adipiscing elit,' ||
                                                          ' sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim' ||
                                                          ' ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip' ||
                                                          ' ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit' ||
                                                          ' esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat' ||
                                                          ' non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
       , 360, 'Oriely'
       , 'https://drive.google.com/uc?id=1q8968zVVEAYsQYdBg5WoXGMr0bwo0w0-&export=download');

INSERT INTO book(book_author, book_code, book_name, cost, creation_date, details, page_number, publisher, url)
VALUES ( 'Josh Long', 1003, 'HTML', 103, now(), 'Lorem ipsum dolor sit amet, consectetur adipiscing elit,' ||
                                                ' sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim' ||
                                                ' ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip' ||
                                                ' ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit' ||
                                                ' esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat' ||
                                                ' non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
       , 230, 'Oriely'
       , 'https://drive.google.com/uc?id=1WLx8VFzPGnkZeS8BU7awwin688mt3MQ0&export=download');

INSERT INTO book(book_author, book_code, book_name, cost, creation_date, details, page_number, publisher, url)
VALUES ( 'Josh Long', 1004
       , 'Build Software Team', 177
       , now(),
         'Lorem ipsum dolor sit amet, consectetur adipiscing elit,' ||
         ' sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim' ||
         ' ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip' ||
         ' ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit' ||
         ' esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat' ||
         ' non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
       , 544, 'Oriely'
       , 'https://drive.google.com/uc?id=1nusXB3ky-cBW4vidyppwTdObtJCHz3Bj&export=download');

INSERT INTO book(book_author, book_code, book_name, cost, creation_date, details, page_number, publisher, url)
VALUES ( 'Josh Long', 1005, 'AngularJs', 144, now(), 'Lorem ipsum dolor sit amet, consectetur adipiscing elit,' ||
                                                     ' sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim' ||
                                                     ' ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip' ||
                                                     ' ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit' ||
                                                     ' esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat' ||
                                                     ' non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
       , 410, 'Oriely'
       , 'https://drive.google.com/uc?id=19soHGxYtT2arbRZ6ri0l8kbmc6KRp8ph&export=download');

INSERT INTO book(book_author, book_code, book_name, cost, creation_date, details, page_number, publisher, url)
VALUES ( 'Josh Long', 1006, 'Ubuntu', 170, now(), 'Lorem ipsum dolor sit amet, consectetur adipiscing elit,' ||
                                                  ' sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim' ||
                                                  ' ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip' ||
                                                  ' ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit' ||
                                                  ' esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat' ||
                                                  ' non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
       , 635, 'Oriely'
       , 'https://drive.google.com/uc?id=1UF3t7h9CRj78Kol-ZtIafZ3juOYaVWyu&export=download');

INSERT INTO book(book_author, book_code, book_name, cost, creation_date, details, page_number, publisher, url)
VALUES ( 'Josh Long', 1007
       , 'Become Better Programmer', 100
       , now(),
         'Lorem ipsum dolor sit amet, consectetur adipiscing elit,' ||
         ' sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim' ||
         ' ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip' ||
         ' ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit' ||
         ' esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat' ||
         ' non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
       , 210, 'Oriely'
       , 'https://drive.google.com/uc?id=1S9JKCJUCgEOYA7RixbVOjsZlV5PYSlXZ&export=download');

INSERT INTO book(book_author, book_code, book_name, cost, creation_date, details, page_number, publisher, url)
VALUES ( 'Josh Long', 1008, 'R Package', 70, now(), 'Lorem ipsum dolor sit amet, consectetur adipiscing elit,' ||
                                                    ' sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim' ||
                                                    ' ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip' ||
                                                    ' ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit' ||
                                                    ' esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat' ||
                                                    ' non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
       , 129, 'Oriely'
       , 'https://drive.google.com/uc?id=1LpTwWrDp-xwmI1hfC85UthqDUmViBFzx&export=download');

INSERT INTO book(book_author, book_code, book_name, cost, creation_date, details, page_number, publisher, url)
VALUES ( 'Josh Long', 1009, 'Drupal', 40, now(), 'Lorem ipsum dolor sit amet, consectetur adipiscing elit,' ||
                                                 ' sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim' ||
                                                 ' ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip' ||
                                                 ' ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit' ||
                                                 ' esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat' ||
                                                 ' non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
       , 205, 'Oriely'
       , 'https://drive.google.com/uc?id=1Iyv0bRr61kcgOETQlfr8CXgp5clvAc2v&export=download');