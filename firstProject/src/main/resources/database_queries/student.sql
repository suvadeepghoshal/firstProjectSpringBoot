-- Table: public.student

-- DROP TABLE public.student;

CREATE TABLE public.student
(
    id bigint NOT NULL,
    age integer,
    dob date,
    email character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT student_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.student
    OWNER to postgres;