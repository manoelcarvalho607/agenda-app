create table tb_clients(
	id bigint not null auto_increment,
    users_id bigint not null,
    client_name varchar(60) not null,
    client_email varchar(60) not null,
    client_phone varchar(20) not null,
    
    constraint pk_id_tb_clients primary key(id),
    
    constraint uq_client_name_clients unique(client_name),
    constraint uq_client_email_clients unique(client_email),
    
    constraint fk_tb_clients_users_id foreign key (users_id) references tb_users (id)
    );