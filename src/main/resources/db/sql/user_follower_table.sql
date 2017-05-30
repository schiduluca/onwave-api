CREATE TABLE user_follower (
      id SERIAL PRIMARY KEY,
      user_id  INT NOT NULL REFERENCES users(id),
      follower_id INT NOT NULL REFERENCES users(id)
);