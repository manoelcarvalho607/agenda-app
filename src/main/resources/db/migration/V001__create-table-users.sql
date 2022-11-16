 create table tb_users(
	id bigint not null auto_increment,
    user_name varchar(60) not null,
    user_email varchar(60) not null,
    user_phone varchar(20) not null,
    
    constraint pk_id_tb_users primary key(id),
    constraint uq_client_name_users unique(user_name),
    constraint uq_client_email_users unique(user_email)
    );