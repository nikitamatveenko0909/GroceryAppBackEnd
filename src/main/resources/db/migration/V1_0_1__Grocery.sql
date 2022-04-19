CREATE TABLE articles (
    id SERIAL NOT NULL,
    name VARCHAR (100),
    price INTEGER,
    PRIMARY KEY (id)
);

INSERT INTO articles(name, price) VALUES('Milk', 21);