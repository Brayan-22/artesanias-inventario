insert into ubicacion (id_ubicacion, direccion) values
                                                    (1, 'Centro comercial el ensueño'),
                                                    (2, 'Centro comercial centro mayor'),
                                                    (3, 'Centro comercial plaza de las americas');

insert into tienda (id_ubicacion, id_tienda, nombre_tienda) values
                                                                (1, gen_random_uuid(), 'Tienda de artesanias el ensueño'),
                                                                (2, gen_random_uuid(), 'Tienda de artesanias centro mayor'),
                                                                (3, gen_random_uuid(), 'Tienda de artesanias plaza de las americas');

select * from tienda;

insert into almacen (id_almacen, id_tienda, id_ubicacion, is_central) values
                                                                          (gen_random_uuid(), '4ca50257-1e2d-4d35-986c-5f3b33faa112', 1, false),
                                                                          (gen_random_uuid(), '951e639d-de38-4abb-85d0-c17ab70e4065', 2, false),
                                                                          (gen_random_uuid(), 'b1d7bc05-0668-407c-a921-f727d0816d4d', 3, false);

select * from almacen;
-- Almacenes centrales
insert into ubicacion (id_ubicacion, direccion) values
                                                    (4, 'Calle 26 # 13-45'),
                                                    (5, 'Calle 34 # 13-45'),
                                                    (6, 'Calle 45 # 13-45');

insert into almacen (id_almacen, id_tienda, id_ubicacion, is_central) values
                                                                          (gen_random_uuid(),null, 4, true),
                                                                          (gen_random_uuid(),null, 5, true),
                                                                          (gen_random_uuid(),null, 6, true);

select * from almacen where id_tienda is null;

select * from producto;

select * from almacen;

insert into inventario (id_productopk, id_almacen, cantidad) values
                                                                 ('9c6867a2-bb4c-4224-ae5f-c1e982b83aa9','a8919bb9-ede1-4292-ab4f-f498e7a7db6b',random(2,10)),
                                                                 ('a3bd5198-9974-474e-82f8-1bc91780f5b9','a8919bb9-ede1-4292-ab4f-f498e7a7db6b',random(2,10)),
                                                                 ('b810ec2d-1dac-4756-a674-26bef4830c5c','a8919bb9-ede1-4292-ab4f-f498e7a7db6b',random(2,10)),
                                                                 ('0f6e330e-b5e5-47d4-909e-84e1922e0b99','a8919bb9-ede1-4292-ab4f-f498e7a7db6b',random(2,10)),
                                                                 ('9925f2a1-3154-41de-9f30-4d9531c5b328','a8919bb9-ede1-4292-ab4f-f498e7a7db6b',random(2,10)),
                                                                 ('dee6f1c8-f47c-48a3-b2ea-89267d4156aa','a8919bb9-ede1-4292-ab4f-f498e7a7db6b',random(2,10)),
                                                                 ('c534c9df-1495-4aba-a4c9-2423cf8210bf','a8919bb9-ede1-4292-ab4f-f498e7a7db6b',random(2,10)),
                                                                 ('be030f4c-80b7-4ca6-b305-d249c385af82','a8919bb9-ede1-4292-ab4f-f498e7a7db6b',random(2,10)),
                                                                 ('ff4c045b-3f1d-41d6-a0ad-ced278fcfd6e','a8919bb9-ede1-4292-ab4f-f498e7a7db6b',random(2,10)),
                                                                 ('e19c17cc-1ff9-4ebb-b5a5-02feb49ec23d','a8919bb9-ede1-4292-ab4f-f498e7a7db6b',random(2,10)),
                                                                 ('97374cc9-cea9-4303-a242-ff179758dd9b','a8919bb9-ede1-4292-ab4f-f498e7a7db6b',random(2,10)),
                                                                 ('01813ac1-c224-44c1-abdb-976a5f0429eb','a8919bb9-ede1-4292-ab4f-f498e7a7db6b',random(2,10)),
                                                                 ('6a5bfad8-2ed3-419c-8d43-c5221ca03e1f','a8919bb9-ede1-4292-ab4f-f498e7a7db6b',random(2,10)),
                                                                 ('08fb91c2-98bc-44c9-90e4-3e802aa17673','a8919bb9-ede1-4292-ab4f-f498e7a7db6b',random(2,10)),
                                                                 ('8389b1be-aa6a-4f06-9458-93c9055df2de','a8919bb9-ede1-4292-ab4f-f498e7a7db6b',random(2,10)),
                                                                 ('dd39b092-00ef-41c4-bf7a-258ddd6b4196','a8919bb9-ede1-4292-ab4f-f498e7a7db6b',random(2,10)),
                                                                 ('3c6fb891-3c1e-448a-9aa3-86bc19a0b6ae','a8919bb9-ede1-4292-ab4f-f498e7a7db6b',random(2,10)),
                                                                 ('c74bfa27-75d3-41ee-9ddf-b4913943953b','a8919bb9-ede1-4292-ab4f-f498e7a7db6b',random(2,10)),

                                                                 ('9c6867a2-bb4c-4224-ae5f-c1e982b83aa9','202ee7d3-d50c-45c5-9648-45029095ccfe',random(2,10)),
                                                                 ('a3bd5198-9974-474e-82f8-1bc91780f5b9','202ee7d3-d50c-45c5-9648-45029095ccfe',random(2,10)),
                                                                 ('b810ec2d-1dac-4756-a674-26bef4830c5c','202ee7d3-d50c-45c5-9648-45029095ccfe',random(2,10)),
                                                                 ('0f6e330e-b5e5-47d4-909e-84e1922e0b99','202ee7d3-d50c-45c5-9648-45029095ccfe',random(2,10)),
                                                                 ('9925f2a1-3154-41de-9f30-4d9531c5b328','202ee7d3-d50c-45c5-9648-45029095ccfe',random(2,10)),
                                                                 ('dee6f1c8-f47c-48a3-b2ea-89267d4156aa','202ee7d3-d50c-45c5-9648-45029095ccfe',random(2,10)),
                                                                 ('c534c9df-1495-4aba-a4c9-2423cf8210bf','202ee7d3-d50c-45c5-9648-45029095ccfe',random(2,10)),
                                                                 ('be030f4c-80b7-4ca6-b305-d249c385af82','202ee7d3-d50c-45c5-9648-45029095ccfe',random(2,10)),
                                                                 ('ff4c045b-3f1d-41d6-a0ad-ced278fcfd6e','202ee7d3-d50c-45c5-9648-45029095ccfe',random(2,10)),
                                                                 ('e19c17cc-1ff9-4ebb-b5a5-02feb49ec23d','202ee7d3-d50c-45c5-9648-45029095ccfe',random(2,10)),
                                                                 ('97374cc9-cea9-4303-a242-ff179758dd9b','202ee7d3-d50c-45c5-9648-45029095ccfe',random(2,10)),
                                                                 ('01813ac1-c224-44c1-abdb-976a5f0429eb','202ee7d3-d50c-45c5-9648-45029095ccfe',random(2,10)),
                                                                 ('6a5bfad8-2ed3-419c-8d43-c5221ca03e1f','202ee7d3-d50c-45c5-9648-45029095ccfe',random(2,10)),
                                                                 ('08fb91c2-98bc-44c9-90e4-3e802aa17673','202ee7d3-d50c-45c5-9648-45029095ccfe',random(2,10)),
                                                                 ('8389b1be-aa6a-4f06-9458-93c9055df2de','202ee7d3-d50c-45c5-9648-45029095ccfe',random(2,10)),
                                                                 ('dd39b092-00ef-41c4-bf7a-258ddd6b4196','202ee7d3-d50c-45c5-9648-45029095ccfe',random(2,10)),
                                                                 ('3c6fb891-3c1e-448a-9aa3-86bc19a0b6ae','202ee7d3-d50c-45c5-9648-45029095ccfe',random(2,10)),
                                                                 ('c74bfa27-75d3-41ee-9ddf-b4913943953b','202ee7d3-d50c-45c5-9648-45029095ccfe',random(2,10)),

                                                                 ('9c6867a2-bb4c-4224-ae5f-c1e982b83aa9','60f68cde-3adb-47f5-86f7-54de8239f116',random(2,10)),
                                                                 ('a3bd5198-9974-474e-82f8-1bc91780f5b9','60f68cde-3adb-47f5-86f7-54de8239f116',random(2,10)),
                                                                 ('b810ec2d-1dac-4756-a674-26bef4830c5c','60f68cde-3adb-47f5-86f7-54de8239f116',random(2,10)),
                                                                 ('0f6e330e-b5e5-47d4-909e-84e1922e0b99','60f68cde-3adb-47f5-86f7-54de8239f116',random(2,10)),
                                                                 ('9925f2a1-3154-41de-9f30-4d9531c5b328','60f68cde-3adb-47f5-86f7-54de8239f116',random(2,10)),
                                                                 ('dee6f1c8-f47c-48a3-b2ea-89267d4156aa','60f68cde-3adb-47f5-86f7-54de8239f116',random(2,10)),
                                                                 ('c534c9df-1495-4aba-a4c9-2423cf8210bf','60f68cde-3adb-47f5-86f7-54de8239f116',random(2,10)),
                                                                 ('be030f4c-80b7-4ca6-b305-d249c385af82','60f68cde-3adb-47f5-86f7-54de8239f116',random(2,10)),
                                                                 ('ff4c045b-3f1d-41d6-a0ad-ced278fcfd6e','60f68cde-3adb-47f5-86f7-54de8239f116',random(2,10)),
                                                                 ('e19c17cc-1ff9-4ebb-b5a5-02feb49ec23d','60f68cde-3adb-47f5-86f7-54de8239f116',random(2,10)),
                                                                 ('97374cc9-cea9-4303-a242-ff179758dd9b','60f68cde-3adb-47f5-86f7-54de8239f116',random(2,10)),
                                                                 ('01813ac1-c224-44c1-abdb-976a5f0429eb','60f68cde-3adb-47f5-86f7-54de8239f116',random(2,10)),
                                                                 ('6a5bfad8-2ed3-419c-8d43-c5221ca03e1f','60f68cde-3adb-47f5-86f7-54de8239f116',random(2,10)),
                                                                 ('08fb91c2-98bc-44c9-90e4-3e802aa17673','60f68cde-3adb-47f5-86f7-54de8239f116',random(2,10)),
                                                                 ('8389b1be-aa6a-4f06-9458-93c9055df2de','60f68cde-3adb-47f5-86f7-54de8239f116',random(2,10)),
                                                                 ('dd39b092-00ef-41c4-bf7a-258ddd6b4196','60f68cde-3adb-47f5-86f7-54de8239f116',random(2,10)),
                                                                 ('3c6fb891-3c1e-448a-9aa3-86bc19a0b6ae','60f68cde-3adb-47f5-86f7-54de8239f116',random(2,10)),
                                                                 ('c74bfa27-75d3-41ee-9ddf-b4913943953b','60f68cde-3adb-47f5-86f7-54de8239f116',random(2,10)),


                                                                 ('9c6867a2-bb4c-4224-ae5f-c1e982b83aa9','60fd1199-173b-473d-ac03-480358e9fc40',random(2,10)),
                                                                 ('a3bd5198-9974-474e-82f8-1bc91780f5b9','60fd1199-173b-473d-ac03-480358e9fc40',random(2,10)),
                                                                 ('b810ec2d-1dac-4756-a674-26bef4830c5c','60fd1199-173b-473d-ac03-480358e9fc40',random(2,10)),
                                                                 ('0f6e330e-b5e5-47d4-909e-84e1922e0b99','60fd1199-173b-473d-ac03-480358e9fc40',random(2,10)),
                                                                 ('9925f2a1-3154-41de-9f30-4d9531c5b328','60fd1199-173b-473d-ac03-480358e9fc40',random(2,10)),
                                                                 ('dee6f1c8-f47c-48a3-b2ea-89267d4156aa','60fd1199-173b-473d-ac03-480358e9fc40',random(2,10)),
                                                                 ('c534c9df-1495-4aba-a4c9-2423cf8210bf','60fd1199-173b-473d-ac03-480358e9fc40',random(2,10)),
                                                                 ('be030f4c-80b7-4ca6-b305-d249c385af82','60fd1199-173b-473d-ac03-480358e9fc40',random(2,10)),
                                                                 ('ff4c045b-3f1d-41d6-a0ad-ced278fcfd6e','60fd1199-173b-473d-ac03-480358e9fc40',random(2,10)),
                                                                 ('e19c17cc-1ff9-4ebb-b5a5-02feb49ec23d','60fd1199-173b-473d-ac03-480358e9fc40',random(2,10)),
                                                                 ('97374cc9-cea9-4303-a242-ff179758dd9b','60fd1199-173b-473d-ac03-480358e9fc40',random(2,10)),
                                                                 ('01813ac1-c224-44c1-abdb-976a5f0429eb','60fd1199-173b-473d-ac03-480358e9fc40',random(2,10)),
                                                                 ('6a5bfad8-2ed3-419c-8d43-c5221ca03e1f','60fd1199-173b-473d-ac03-480358e9fc40',random(2,10)),
                                                                 ('08fb91c2-98bc-44c9-90e4-3e802aa17673','60fd1199-173b-473d-ac03-480358e9fc40',random(2,10)),
                                                                 ('8389b1be-aa6a-4f06-9458-93c9055df2de','60fd1199-173b-473d-ac03-480358e9fc40',random(2,10)),
                                                                 ('dd39b092-00ef-41c4-bf7a-258ddd6b4196','60fd1199-173b-473d-ac03-480358e9fc40',random(2,10)),
                                                                 ('3c6fb891-3c1e-448a-9aa3-86bc19a0b6ae','60fd1199-173b-473d-ac03-480358e9fc40',random(2,10)),
                                                                 ('c74bfa27-75d3-41ee-9ddf-b4913943953b','60fd1199-173b-473d-ac03-480358e9fc40',random(2,10)),


                                                                 ('9c6867a2-bb4c-4224-ae5f-c1e982b83aa9','16708e98-5feb-4d93-a614-f80ca7fe37ea',random(2,10)),
                                                                 ('a3bd5198-9974-474e-82f8-1bc91780f5b9','16708e98-5feb-4d93-a614-f80ca7fe37ea',random(2,10)),
                                                                 ('b810ec2d-1dac-4756-a674-26bef4830c5c','16708e98-5feb-4d93-a614-f80ca7fe37ea',random(2,10)),
                                                                 ('0f6e330e-b5e5-47d4-909e-84e1922e0b99','16708e98-5feb-4d93-a614-f80ca7fe37ea',random(2,10)),
                                                                 ('9925f2a1-3154-41de-9f30-4d9531c5b328','16708e98-5feb-4d93-a614-f80ca7fe37ea',random(2,10)),
                                                                 ('dee6f1c8-f47c-48a3-b2ea-89267d4156aa','16708e98-5feb-4d93-a614-f80ca7fe37ea',random(2,10)),
                                                                 ('c534c9df-1495-4aba-a4c9-2423cf8210bf','16708e98-5feb-4d93-a614-f80ca7fe37ea',random(2,10)),
                                                                 ('be030f4c-80b7-4ca6-b305-d249c385af82','16708e98-5feb-4d93-a614-f80ca7fe37ea',random(2,10)),
                                                                 ('ff4c045b-3f1d-41d6-a0ad-ced278fcfd6e','16708e98-5feb-4d93-a614-f80ca7fe37ea',random(2,10)),
                                                                 ('e19c17cc-1ff9-4ebb-b5a5-02feb49ec23d','16708e98-5feb-4d93-a614-f80ca7fe37ea',random(2,10)),
                                                                 ('97374cc9-cea9-4303-a242-ff179758dd9b','16708e98-5feb-4d93-a614-f80ca7fe37ea',random(2,10)),
                                                                 ('01813ac1-c224-44c1-abdb-976a5f0429eb','16708e98-5feb-4d93-a614-f80ca7fe37ea',random(2,10)),
                                                                 ('6a5bfad8-2ed3-419c-8d43-c5221ca03e1f','16708e98-5feb-4d93-a614-f80ca7fe37ea',random(2,10)),
                                                                 ('08fb91c2-98bc-44c9-90e4-3e802aa17673','16708e98-5feb-4d93-a614-f80ca7fe37ea',random(2,10)),
                                                                 ('8389b1be-aa6a-4f06-9458-93c9055df2de','16708e98-5feb-4d93-a614-f80ca7fe37ea',random(2,10)),
                                                                 ('dd39b092-00ef-41c4-bf7a-258ddd6b4196','16708e98-5feb-4d93-a614-f80ca7fe37ea',random(2,10)),
                                                                 ('3c6fb891-3c1e-448a-9aa3-86bc19a0b6ae','16708e98-5feb-4d93-a614-f80ca7fe37ea',random(2,10)),
                                                                 ('c74bfa27-75d3-41ee-9ddf-b4913943953b','16708e98-5feb-4d93-a614-f80ca7fe37ea',random(2,10)),


                                                                 ('9c6867a2-bb4c-4224-ae5f-c1e982b83aa9','b101dfd3-bb7b-4657-b443-0ca5105d9443',random(2,10)),
                                                                 ('a3bd5198-9974-474e-82f8-1bc91780f5b9','b101dfd3-bb7b-4657-b443-0ca5105d9443',random(2,10)),
                                                                 ('b810ec2d-1dac-4756-a674-26bef4830c5c','b101dfd3-bb7b-4657-b443-0ca5105d9443',random(2,10)),
                                                                 ('0f6e330e-b5e5-47d4-909e-84e1922e0b99','b101dfd3-bb7b-4657-b443-0ca5105d9443',random(2,10)),
                                                                 ('9925f2a1-3154-41de-9f30-4d9531c5b328','b101dfd3-bb7b-4657-b443-0ca5105d9443',random(2,10)),
                                                                 ('dee6f1c8-f47c-48a3-b2ea-89267d4156aa','b101dfd3-bb7b-4657-b443-0ca5105d9443',random(2,10)),
                                                                 ('c534c9df-1495-4aba-a4c9-2423cf8210bf','b101dfd3-bb7b-4657-b443-0ca5105d9443',random(2,10)),
                                                                 ('be030f4c-80b7-4ca6-b305-d249c385af82','b101dfd3-bb7b-4657-b443-0ca5105d9443',random(2,10)),
                                                                 ('ff4c045b-3f1d-41d6-a0ad-ced278fcfd6e','b101dfd3-bb7b-4657-b443-0ca5105d9443',random(2,10)),
                                                                 ('e19c17cc-1ff9-4ebb-b5a5-02feb49ec23d','b101dfd3-bb7b-4657-b443-0ca5105d9443',random(2,10)),
                                                                 ('97374cc9-cea9-4303-a242-ff179758dd9b','b101dfd3-bb7b-4657-b443-0ca5105d9443',random(2,10)),
                                                                 ('01813ac1-c224-44c1-abdb-976a5f0429eb','b101dfd3-bb7b-4657-b443-0ca5105d9443',random(2,10)),
                                                                 ('6a5bfad8-2ed3-419c-8d43-c5221ca03e1f','b101dfd3-bb7b-4657-b443-0ca5105d9443',random(2,10)),
                                                                 ('08fb91c2-98bc-44c9-90e4-3e802aa17673','b101dfd3-bb7b-4657-b443-0ca5105d9443',random(2,10)),
                                                                 ('8389b1be-aa6a-4f06-9458-93c9055df2de','b101dfd3-bb7b-4657-b443-0ca5105d9443',random(2,10)),
                                                                 ('dd39b092-00ef-41c4-bf7a-258ddd6b4196','b101dfd3-bb7b-4657-b443-0ca5105d9443',random(2,10)),
                                                                 ('3c6fb891-3c1e-448a-9aa3-86bc19a0b6ae','b101dfd3-bb7b-4657-b443-0ca5105d9443',random(2,10)),
                                                                 ('c74bfa27-75d3-41ee-9ddf-b4913943953b','b101dfd3-bb7b-4657-b443-0ca5105d9443',random(2,10));

-- Productos disponibles en tienda de artesanias el ensueño
select * from tienda;
select P.nombre_producto,I.cantidad from  producto P join
                                          inventario I on P.id_productopk = I.id_productopk
                                                     join almacen A
                                                          on I.id_almacen = A.id_almacen
                                                     join tienda T
                                                          on A.id_tienda = T.id_tienda
where T.nombre_tienda='Tienda de artesanias el ensueño';

-- Productos disponibles en almacenes centrales
select P.nombre_producto,principal.cantidad
from (select P.id_productopk idP, sum(I.cantidad) cantidad
      from producto P
               join
           inventario I on P.id_productopk = I.id_productopk
               join almacen A
                    on I.id_almacen = A.id_almacen
      where is_central = true
      group by P.id_productopk) as principal
         join producto P on principal.idP = P.id_productopk;