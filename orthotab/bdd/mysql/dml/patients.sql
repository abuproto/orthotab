insert into patient values(0,'usertechnique','usertechnique','usertechnique','',0,'',null,0);
insert into patient values(1,'abunel','Bunel','Arnaud','abunel',1,'f726eba9c996d5bd76ea00ed9842cd13',null,0);



*************
OLD


insert into USER values(1,'abunel','Bunel','Arnaud','abunel','ADMIN',1);
insert into USER values(2,'mbunel','Bunel','Marie','mbunel','ADMIN',1);
insert into USER values(3,'mbizot','Bizot','Maxime','mbizot','ADMIN',1);
insert into USER values(4,'patient1','Patient1','Patient1','patient1','PATIENT',1);
insert into USER values(5,'patient2','Patient2','Patient2','patient2','PATIENT',1);


update USER set TOKEN='f726eba9c996d5bd76ea00ed9842cd13' where id=1;
update USER set TOKEN='a5a6fb23f7187ba93226b530fb7878f3' where id=2;
update USER set TOKEN='b2572d33428ae46d9236861af3d7ded9' where id=3;
update USER set TOKEN='1e6dbf2102e420752c022b9ba827b585' where id=4;
update USER set TOKEN='74c67fcd5e83cd15b8312176ef941fb1' where id=5;
update USER set TOKEN='5e274f34bcce847a1581d18833ca8ccc' where id=6; 


insert into USER values(7,'louann','Boubier','Lou-Ann','louann','PATIENT',0,'48947312a23257503b041223cef93464');
insert into USER values(8,'erelle','Le Ca�r','Erelle','erelle','PATIENT',0,'beaa260bdb926fc9e6b166778af7313c');
insert into USER values(9,'clara','Dudrat','Clara','clara','PATIENT',0,'39e3a69a96c07d3453896d435f730105');
insert into USER values(10,'manon','Diraison','Manon','manon','PATIENT',0,'ff89c5b3678e3bdf4707ab43574ce177');

insert into USER values(11,'emma','De Sousa','Emma','emma','PATIENT',0,'e4bd48d062d9a48457666bf53913b0ae');
insert into USER values(12,'noemie','Delalande','No�mie','noemie','PATIENT',0,'99cf6e5f733d6f5281b87ee5076d8772');
insert into USER values(13,'janesse','Habbani','Janesse','janesse','PATIENT',0,'2b1f63107ceb0565cf3387367fc5b3bb');

insert into USER values(14,'lurson','Lurson','','lurson','PATIENT',0,'85680e20f80126cd05221b766a65714f');

insert into USER values(15,'sophie','Rouvreau','Sophie','sophie','ADMIN',1,'c22e07168c3f5d561e8cd05c94055442',null,0);

insert into USER values(16,'lucas','','Lucas','lucas','PATIENT',1,'623b7691f883f7d3db0a3ece53ab4879',null,0);

update USER set nivcourant=1 where nivcourant=0;


insert into USER values(0,'usertechnique','usertechnique','usertechnique','','TECHNIQUE',0,'',null,0);

insert into USER values(17,'stephanie','Duigou','Stephanie','stephanie','PATIENT',1,'05c176e345afe114e7409f5762e7336a',null,0);

insert into USER values(18,'shaina','Lejoly','Shaina','shaina','PATIENT',1,'b69e0d5a62640422786da15cff6b37f8',null,0);
insert into USER values(19,'maiana','Le Cocq','Maiana','maiana','PATIENT',1,'cafb6764611aba2870081f12cdc6eb73',null,0);

insert into USER values(20,'julie','Guillet','Julie','julie','PATIENT',1,'630a176a59c63baa05b45b180431ee65',null,0);

insert into USER values(21,'sophie2','(Etudiante)','Sophie','sophie2','PATIENT',1,'cb2d3ef97438bb875b4eb493b97377f2',null,0);

insert into USER values(22,'claire','(Etudiante)','Claire','claire','PATIENT',1,'fb99fc1cd93b29db10dee483d5a4be11',null,0);


ATTENTION, pas d'accent dans le pr�nom, pb avec cookie pour le moment !
