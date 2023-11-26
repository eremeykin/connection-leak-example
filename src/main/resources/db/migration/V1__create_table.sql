create table album
(
    id   uuid default gen_random_uuid() primary key,
    name varchar(1024) not null,
    year int           not null
);

create table songs
(
    id       uuid default gen_random_uuid() primary key,
    name     varchar(1024) not null,
    artist   varchar(1024) not null,
    album_id uuid          not null references album (id)
);

with data(song_name, artist, album_name, year) as (
values ('Electric Dreamscape', 'Quantum Flux', 'Synthetica', 2025),
       ('Celestial Rapture', 'Nebula Echo', 'Stellarian', 2024),
       ('Sonic Prism', 'Chromatic Pulse', 'Technoverse', 2023),
       ('Galactic Groove Machine', 'Stellar Surge', 'Celestify', 2026),
       ('Nebulous Odyssey', 'Cosmic Drifters', 'Astroverse', 2022),
       ('Hypersonic Horizon', 'Quantum Quasar', 'Warpwave', 2027),
       ('Lunar Reverie', 'Astral Serenade', 'Lunaria', 2024),
       ('Thunderstruck Nebula', 'Celestial Shockwave', 'Nebulosity', 2023),
       ('Psychedelic Nebulosity', 'Astral Mirage', 'Psychotronic', 2025),
       ('Quantum Resonance', 'Echo Gravity', 'Quantumica', 2022),
       ('Solaris Surge', 'Starlight Catalyst', 'Solaric', 2026),
       ('Astral Labyrinth', 'Warp Dynamo', 'Labyrinthia', 2024),
       ('Interstellar Insomnia', 'Dreamwave Nexus', 'Hypnospace', 2023),
       ('Cosmic Carnival', 'Gravity Gypsies', 'Galactica', 2027),
       ('Aurora Borealis Blues', 'Sonic Aurora', 'Borealis', 2025),
       ('Nebula Nomad', 'Wanderlust Warp', 'Nomadica', 2022),
       ('Galactic Ghost Dance', 'Celestial Spirits', 'Ghostdance', 2024),
       ('Quantum Quake', 'Sonic Vortex', 'Quakewave', 2023),
       ('Orion''s Overture', 'Stellar Symphony', 'Orionica', 2026),
       ('Celestial Synchronicity', 'Harmony Nebula', 'Synchronia', 2025)),
     album_insert as ( insert into album (name, year) select album_name, year from data returning id, name)
insert
into songs(name, artist, album_id)
select song_name, artist, album_insert.id
from data
         join album_insert on data.album_name = album_insert.name;

