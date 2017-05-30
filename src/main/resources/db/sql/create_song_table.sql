CREATE TABLE songs(
  id SERIAL PRIMARY KEY,
  track TEXT,
  artist TEXT,
  album TEXT,
  longitude REAL,
  latitude REAL,
  photoUrl TEXT,
  creationDate timestamp default current_timestamp
);
