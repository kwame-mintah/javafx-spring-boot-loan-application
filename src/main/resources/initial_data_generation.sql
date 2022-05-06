--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2 (Debian 14.2-1.pgdg110+1)
-- Dumped by pg_dump version 14.2

-- Started on 2022-05-06 20:51:16 BST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3338 (class 1262 OID 16384)
-- Name: library-system-db; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "library-system-db" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';


ALTER DATABASE "library-system-db" OWNER TO postgres;

\connect -reuse-previous=on "dbname='library-system-db'"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 209 (class 1259 OID 16385)
-- Name: books; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.books (
    id bigint NOT NULL,
    author character varying(255),
    isbn character varying(255)
);


ALTER TABLE public.books OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16390)
-- Name: books_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.books_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.books_id_seq OWNER TO postgres;

--
-- TOC entry 3339 (class 0 OID 0)
-- Dependencies: 210
-- Name: books_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.books_id_seq OWNED BY public.books.id;


--
-- TOC entry 211 (class 1259 OID 16391)
-- Name: items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.items (
    id integer NOT NULL,
    available_count integer NOT NULL,
    description character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    on_loan integer NOT NULL,
    release_date timestamp without time zone NOT NULL,
    type character varying(255),
    image character varying(255)
);


ALTER TABLE public.items OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16396)
-- Name: items_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.items_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.items_id_seq OWNER TO postgres;

--
-- TOC entry 3340 (class 0 OID 0)
-- Dependencies: 212
-- Name: items_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.items_id_seq OWNED BY public.items.id;


--
-- TOC entry 213 (class 1259 OID 16397)
-- Name: user_accounts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_accounts (
    user_id integer NOT NULL,
    email character varying(255) NOT NULL,
    enabled boolean,
    firstname character varying(255) NOT NULL,
    lastname character varying(255) NOT NULL,
    role character varying(255) NOT NULL,
    username character varying(255) NOT NULL
);


ALTER TABLE public.user_accounts OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16402)
-- Name: user_accounts_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_accounts_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_accounts_user_id_seq OWNER TO postgres;

--
-- TOC entry 3341 (class 0 OID 0)
-- Dependencies: 214
-- Name: user_accounts_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_accounts_user_id_seq OWNED BY public.user_accounts.user_id;


--
-- TOC entry 3177 (class 2604 OID 16403)
-- Name: books id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books ALTER COLUMN id SET DEFAULT nextval('public.books_id_seq'::regclass);


--
-- TOC entry 3178 (class 2604 OID 16404)
-- Name: items id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.items ALTER COLUMN id SET DEFAULT nextval('public.items_id_seq'::regclass);


--
-- TOC entry 3179 (class 2604 OID 16405)
-- Name: user_accounts user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_accounts ALTER COLUMN user_id SET DEFAULT nextval('public.user_accounts_user_id_seq'::regclass);


--
-- TOC entry 3327 (class 0 OID 16385)
-- Dependencies: 209
-- Data for Name: books; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.books (id, author, isbn) VALUES (1, 'Man of Action Studios', '9781911461227');


--
-- TOC entry 3329 (class 0 OID 16391)
-- Dependencies: 211
-- Data for Name: items; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.items (id, available_count, description, name, on_loan, release_date, type, image) VALUES (2, 5, 'Jonathan Xavier Johnny Test is the main protagonist of the series of the same name', 'Johnny Test Comic', 1, '2004-03-04 00:00:00', 'Book', 'johnny_test_image_1.jpeg');
INSERT INTO public.items (id, available_count, description, name, on_loan, release_date, type, image) VALUES (3, 5, 'Power Rangers Macintosh game', 'Saban Power Rangers Zeo Versus The Machine Empire', 0, '2006-04-03 00:00:00', 'Video Game', 'power_ranger_image_1.jpeg');
INSERT INTO public.items (id, available_count, description, name, on_loan, release_date, type, image) VALUES (4, 2, 'Sleeping Beauty is the 1959 full length animated feature production from Walt Disney Studios', 'Sleeping Beauty', 0, '2000-02-02 00:00:00', 'Dvd', 'sleep_beauty_image_1.jpeg');
INSERT INTO public.items (id, available_count, description, name, on_loan, release_date, type, image) VALUES (1, 10, 'The Omnimatrix better known as the Omnitrix was a watch-like device that attached to Ben Tennyson wrist', 'Ben 10 classic omnitrix', 2, '2003-03-03 00:00:00', 'Toy', 'ben_tennyson_image_1.jpeg');


--
-- TOC entry 3331 (class 0 OID 16397)
-- Dependencies: 213
-- Data for Name: user_accounts; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_accounts (user_id, email, enabled, firstname, lastname, role, username) VALUES (1, 'user@library.com', true, 'Johnny', 'Test', 'user', 'johnny.test');
INSERT INTO public.user_accounts (user_id, email, enabled, firstname, lastname, role, username) VALUES (2, 'admin@library.com', true, 'Ben', 'Tennyson', 'admin', 'ben.tennyson');
INSERT INTO public.user_accounts (user_id, email, enabled, firstname, lastname, role, username) VALUES (3, 'disabled@library', false, 'Dexter', 'Lab', 'user', 'dexter.lab');


--
-- TOC entry 3342 (class 0 OID 0)
-- Dependencies: 210
-- Name: books_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.books_id_seq', 1, false);


--
-- TOC entry 3343 (class 0 OID 0)
-- Dependencies: 212
-- Name: items_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.items_id_seq', 1, false);


--
-- TOC entry 3344 (class 0 OID 0)
-- Dependencies: 214
-- Name: user_accounts_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_accounts_user_id_seq', 1, false);


--
-- TOC entry 3181 (class 2606 OID 16407)
-- Name: books books_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (id);


--
-- TOC entry 3185 (class 2606 OID 16409)
-- Name: items items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.items
    ADD CONSTRAINT items_pkey PRIMARY KEY (id);


--
-- TOC entry 3183 (class 2606 OID 16411)
-- Name: books uk_kibbepcitr0a3cpk3rfr7nihn; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT uk_kibbepcitr0a3cpk3rfr7nihn UNIQUE (isbn);


--
-- TOC entry 3187 (class 2606 OID 16413)
-- Name: user_accounts user_accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_accounts
    ADD CONSTRAINT user_accounts_pkey PRIMARY KEY (user_id);


-- Completed on 2022-05-06 20:51:16 BST

--
-- PostgreSQL database dump complete
--

