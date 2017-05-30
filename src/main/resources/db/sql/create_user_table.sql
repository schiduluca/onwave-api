CREATE TABLE users(
  id SERIAL PRIMARY KEY,
  email TEXT UNIQUE NOT NULL,
  firstName TEXT,
  lastName TEXT,
  uuid UUID UNIQUE NOT NULL,
  photoUrl TEXT,
  creationDate timestamp default current_timestamp
);
