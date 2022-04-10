--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2 (Debian 14.2-1.pgdg110+1)
-- Dumped by pg_dump version 14.2

-- Started on 2022-04-09 13:37:36 BST

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
-- TOC entry 3326 (class 1262 OID 16384)
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
-- TOC entry 210 (class 1259 OID 16386)
-- Name: items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.items (
    id integer NOT NULL,
    available_count integer NOT NULL,
    description character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    on_loan integer NOT NULL,
    release_date timestamp without time zone NOT NULL
);


ALTER TABLE public.items OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16385)
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
-- TOC entry 3327 (class 0 OID 0)
-- Dependencies: 209
-- Name: items_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.items_id_seq OWNED BY public.items.id;


--
-- TOC entry 212 (class 1259 OID 16395)
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
-- TOC entry 211 (class 1259 OID 16394)
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
-- TOC entry 3328 (class 0 OID 0)
-- Dependencies: 211
-- Name: user_accounts_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_accounts_user_id_seq OWNED BY public.user_accounts.user_id;


--
-- TOC entry 3172 (class 2604 OID 16389)
-- Name: items id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.items ALTER COLUMN id SET DEFAULT nextval('public.items_id_seq'::regclass);


--
-- TOC entry 3173 (class 2604 OID 16398)
-- Name: user_accounts user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_accounts ALTER COLUMN user_id SET DEFAULT nextval('public.user_accounts_user_id_seq'::regclass);


--
-- TOC entry 3318 (class 0 OID 16386)
-- Dependencies: 210
-- Data for Name: items; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.items (id, available_count, description, name, on_loan, release_date) VALUES (1, 10, 'An incredible item, that many people are jealous of', 'Very cool', 2, '2003-03-03 00:00:00');


--
-- TOC entry 3320 (class 0 OID 16395)
-- Dependencies: 212
-- Data for Name: user_accounts; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_accounts (user_id, email, enabled, firstname, lastname, role, username) VALUES (1, 'user@library.com', true, 'Johnny', 'Test', 'user', 'johnny.test');
INSERT INTO public.user_accounts (user_id, email, enabled, firstname, lastname, role, username) VALUES (2, 'admin@library.com', true, 'Ben', 'Tennyson', 'admin', 'ben.tennyson');
INSERT INTO public.user_accounts (user_id, email, enabled, firstname, lastname, role, username) VALUES (3, 'disabled@library', false, 'Dexter', 'Lab', 'user', 'dexter.lab');


--
-- TOC entry 3329 (class 0 OID 0)
-- Dependencies: 209
-- Name: items_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.items_id_seq', 1, false);


--
-- TOC entry 3330 (class 0 OID 0)
-- Dependencies: 211
-- Name: user_accounts_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_accounts_user_id_seq', 1, false);


--
-- TOC entry 3175 (class 2606 OID 16393)
-- Name: items items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.items
    ADD CONSTRAINT items_pkey PRIMARY KEY (id);


--
-- TOC entry 3177 (class 2606 OID 16402)
-- Name: user_accounts user_accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_accounts
    ADD CONSTRAINT user_accounts_pkey PRIMARY KEY (user_id);


-- Completed on 2022-04-09 13:37:36 BST

--
-- PostgreSQL database dump complete
--

