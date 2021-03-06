PGDMP     5                    u           banco    10.0    10.0 %               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                       1262    16393    banco    DATABASE     ?   CREATE DATABASE banco WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE banco;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false                       0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false                       0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            ?            1259    16416    alunos    TABLE     ?   CREATE TABLE alunos (
    "A_ID" integer NOT NULL,
    "A_NOME" character varying(100),
    "A_EMAIL" character varying(200),
    "A_TELEFONE" character varying(30)
);
    DROP TABLE public.alunos;
       public         postgres    false    3            ?            1259    16414    alunos_A_ID_seq    SEQUENCE     ?   CREATE SEQUENCE "alunos_A_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public."alunos_A_ID_seq";
       public       postgres    false    197    3                       0    0    alunos_A_ID_seq    SEQUENCE OWNED BY     9   ALTER SEQUENCE "alunos_A_ID_seq" OWNED BY alunos."A_ID";
            public       postgres    false    196            ?            1259    16432    disciplinas    TABLE     ?   CREATE TABLE disciplinas (
    "D_ID" integer NOT NULL,
    "D_NOME" character varying,
    "D_DESCRICAO" character varying,
    "P_ID" integer
);
    DROP TABLE public.disciplinas;
       public         postgres    false    3            ?            1259    16430    disciplinas_D_ID_seq    SEQUENCE     ?   CREATE SEQUENCE "disciplinas_D_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public."disciplinas_D_ID_seq";
       public       postgres    false    3    201                       0    0    disciplinas_D_ID_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE "disciplinas_D_ID_seq" OWNED BY disciplinas."D_ID";
            public       postgres    false    200            ?            1259    16443 	   matricula    TABLE     C   CREATE TABLE matricula (
    "D_ID" integer,
    "A_ID" integer
);
    DROP TABLE public.matricula;
       public         postgres    false    3            ?            1259    16424    professores    TABLE     ?   CREATE TABLE professores (
    "P_ID" integer NOT NULL,
    "P_NOME" character varying(100),
    "P_EMAIL" character varying(200),
    "P_TELEFONE" character varying(30)
);
    DROP TABLE public.professores;
       public         postgres    false    3            ?            1259    16422    professores_P_ID_seq    SEQUENCE     ?   CREATE SEQUENCE "professores_P_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public."professores_P_ID_seq";
       public       postgres    false    3    199                       0    0    professores_P_ID_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE "professores_P_ID_seq" OWNED BY professores."P_ID";
            public       postgres    false    198            ?            1259    16456    usuario    TABLE     j   CREATE TABLE usuario (
    u_email character varying(200) NOT NULL,
    u_senha character varying(100)
);
    DROP TABLE public.usuario;
       public         postgres    false    3            ?
           2604    16419    alunos A_ID    DEFAULT     `   ALTER TABLE ONLY alunos ALTER COLUMN "A_ID" SET DEFAULT nextval('"alunos_A_ID_seq"'::regclass);
 <   ALTER TABLE public.alunos ALTER COLUMN "A_ID" DROP DEFAULT;
       public       postgres    false    197    196    197            ?
           2604    16435    disciplinas D_ID    DEFAULT     j   ALTER TABLE ONLY disciplinas ALTER COLUMN "D_ID" SET DEFAULT nextval('"disciplinas_D_ID_seq"'::regclass);
 A   ALTER TABLE public.disciplinas ALTER COLUMN "D_ID" DROP DEFAULT;
       public       postgres    false    200    201    201            ?
           2604    16427    professores P_ID    DEFAULT     j   ALTER TABLE ONLY professores ALTER COLUMN "P_ID" SET DEFAULT nextval('"professores_P_ID_seq"'::regclass);
 A   ALTER TABLE public.professores ALTER COLUMN "P_ID" DROP DEFAULT;
       public       postgres    false    199    198    199                      0    16416    alunos 
   TABLE DATA               D   COPY alunos ("A_ID", "A_NOME", "A_EMAIL", "A_TELEFONE") FROM stdin;
    public       postgres    false    197   ?%                 0    16432    disciplinas 
   TABLE DATA               G   COPY disciplinas ("D_ID", "D_NOME", "D_DESCRICAO", "P_ID") FROM stdin;
    public       postgres    false    201   ?&                 0    16443 	   matricula 
   TABLE DATA               ,   COPY matricula ("D_ID", "A_ID") FROM stdin;
    public       postgres    false    202   +'                 0    16424    professores 
   TABLE DATA               I   COPY professores ("P_ID", "P_NOME", "P_EMAIL", "P_TELEFONE") FROM stdin;
    public       postgres    false    199   Z'                 0    16456    usuario 
   TABLE DATA               ,   COPY usuario (u_email, u_senha) FROM stdin;
    public       postgres    false    203   ?'                  0    0    alunos_A_ID_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('"alunos_A_ID_seq"', 20, true);
            public       postgres    false    196                       0    0    disciplinas_D_ID_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('"disciplinas_D_ID_seq"', 18, true);
            public       postgres    false    200                        0    0    professores_P_ID_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('"professores_P_ID_seq"', 6, true);
            public       postgres    false    198            ?
           2606    16498    matricula D_ID_A_ID_UN 
   CONSTRAINT     V   ALTER TABLE ONLY matricula
    ADD CONSTRAINT "D_ID_A_ID_UN" UNIQUE ("D_ID", "A_ID");
 B   ALTER TABLE ONLY public.matricula DROP CONSTRAINT "D_ID_A_ID_UN";
       public         postgres    false    202    202            ?
           2606    16421    alunos alunos_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY alunos
    ADD CONSTRAINT alunos_pkey PRIMARY KEY ("A_ID");
 <   ALTER TABLE ONLY public.alunos DROP CONSTRAINT alunos_pkey;
       public         postgres    false    197            ?
           2606    16437    disciplinas disciplinas_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY disciplinas
    ADD CONSTRAINT disciplinas_pkey PRIMARY KEY ("D_ID");
 F   ALTER TABLE ONLY public.disciplinas DROP CONSTRAINT disciplinas_pkey;
       public         postgres    false    201            ?
           2606    16429    professores professores_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY professores
    ADD CONSTRAINT professores_pkey PRIMARY KEY ("P_ID");
 F   ALTER TABLE ONLY public.professores DROP CONSTRAINT professores_pkey;
       public         postgres    false    199            ?
           2606    16460    usuario usuario_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (u_email);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public         postgres    false    203            ?
           2606    16525    disciplinas D_P_ID_FK    FK CONSTRAINT     ?   ALTER TABLE ONLY disciplinas
    ADD CONSTRAINT "D_P_ID_FK" FOREIGN KEY ("P_ID") REFERENCES professores("P_ID") ON UPDATE CASCADE ON DELETE SET NULL;
 A   ALTER TABLE ONLY public.disciplinas DROP CONSTRAINT "D_P_ID_FK";
       public       postgres    false    2697    201    199            ?
           2606    16515    matricula matricula_ibfk_1    FK CONSTRAINT     ?   ALTER TABLE ONLY matricula
    ADD CONSTRAINT matricula_ibfk_1 FOREIGN KEY ("D_ID") REFERENCES disciplinas("D_ID") ON UPDATE CASCADE ON DELETE CASCADE;
 D   ALTER TABLE ONLY public.matricula DROP CONSTRAINT matricula_ibfk_1;
       public       postgres    false    201    2699    202            ?
           2606    16520    matricula matricula_ibfk_2    FK CONSTRAINT     ?   ALTER TABLE ONLY matricula
    ADD CONSTRAINT matricula_ibfk_2 FOREIGN KEY ("A_ID") REFERENCES alunos("A_ID") ON UPDATE CASCADE ON DELETE CASCADE;
 D   ALTER TABLE ONLY public.matricula DROP CONSTRAINT matricula_ibfk_2;
       public       postgres    false    2695    202    197               ?   x?e???0?????????>???
????׷??hl?~m?k??N8?.#AH?kO??2b??-??P????,$?Vx
K?)s3{?a%???ͪb; ?EO1<i?+EG?????6']?]S?4??S???6???v??hP???5f?q????-N?a???U? ?
?E         v   x?34??/*)M/M-????K/MT(?	$*?d?%sq?q?&???&?d&'r??b??1??9?{j~njIQf??!yc΀ G???B?Yp??r?'?$??s?r??qqq g-m            x?34?44?24?44?24?4??????? )?J         ?   x?e?;?@k?$Pl$?ʇ.G@B??1ɲ???(??G?b,???7??1?m
v1???~?'??t??????	??Nc?{????B&G,?5=&???o?|???rY?l?X??o?:[??G?~i??۸?nZ<T??~?3?         '   x??H?,?/?442?? ?饙9?E???????? ??
i     