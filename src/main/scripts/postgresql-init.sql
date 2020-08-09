DROP DATABASE IF EXISTS beer_order_service;

CREATE DATABASE beer_order_service;

CREATE ROLE beer_order_user WITH ENCRYPTED PASSWORD 'beerorderpassword';

ALTER ROLE beer_order_user LOGIN;