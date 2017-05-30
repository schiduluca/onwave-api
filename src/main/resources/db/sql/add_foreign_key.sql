alter table songs add column user_id int not null;
alter table songs add constraint fk_user
foreign key (user_id)
references users;