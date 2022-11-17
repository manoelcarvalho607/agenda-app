create table tb_clientsTest(
	id bigint not null auto_increment,
    user_id bigint not null,
    nome varchar(60) not null,
    email varchar(60) not null,
    fone varchar(20) not null,
    
    constraint pk_id_tb_clientsTest primary key(id),
    
    constraint uq_client_nome unique(nome),
    constraint uq_client_email unique(email),
    
    constraint fk_tb_clientsTest_user_id foreign key (user_id) references tb_users (id)
    );