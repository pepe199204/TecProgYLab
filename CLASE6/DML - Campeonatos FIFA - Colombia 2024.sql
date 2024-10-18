DO $$
DECLARE nuevoIdCampeonato INTEGER;
    nuevoIdGrupo INTEGER;
    nuevoIdPais INTEGER;
    totalPaises INTEGER;
    idPais1 INTEGER; idPais2 INTEGER; idPais3 INTEGER; idPais4 INTEGER;
BEGIN
    SELECT MAX(Id)+1 INTO nuevoIdPais
        FROM pais;

    --validar si ya está el campeonato
    SELECT id INTO nuevoIdCampeonato 
        FROM campeonato
        WHERE campeonato='FIFA U-20 Women''s World Cup Colombia 2024';
    IF nuevoIdCampeonato IS NULL THEN
        SELECT MAX(Id)+1 INTO nuevoIdCampeonato FROM campeonato;
        INSERT INTO campeonato
            (id, campeonato, idpais, año)
            VALUES(nuevoIdCampeonato, 'FIFA U-20 Women''s World Cup Colombia 2024', 1, 2024);
    END IF;

    --validar si ya estan los grupos
    SELECT id INTO nuevoIdGrupo
        FROM grupo
        WHERE idCampeonato = nuevoIdCampeonato
            AND grupo='A';
    IF nuevoIdGrupo IS NULL THEN
        SELECT MAX(Id)+1 INTO nuevoIdGrupo FROM grupo;

        INSERT INTO grupo
            (id, grupo, idcampeonato)
            VALUES
            (nuevoIdGrupo,'A', nuevoIdCampeonato),
            (nuevoIdGrupo+1,'B', nuevoIdCampeonato),
            (nuevoIdGrupo+2,'C', nuevoIdCampeonato),
            (nuevoIdGrupo+3,'D', nuevoIdCampeonato),
            (nuevoIdGrupo+4,'E', nuevoIdCampeonato),
            (nuevoIdGrupo+5,'F', nuevoIdCampeonato);
    END IF;
       
    SELECT id INTO idPais1 FROM pais WHERE pais='Colombia';
    IF idPais1 IS NULL THEN
        INSERT INTO pais
            (id, pais, entidad) VALUES(nuevoIdPais, 'Colombia', '');
        idPais1 := nuevoIdPais;
        nuevoIdPais := nuevoIdPais + 1;
    END IF;
    
    SELECT id INTO idPais2 FROM pais WHERE pais='Australia';
    IF idPais2 IS NULL THEN
        INSERT INTO pais
            (id, pais, entidad) VALUES(nuevoIdPais, 'Australia', '');
        idPais2 := nuevoIdPais;
        nuevoIdPais := nuevoIdPais + 1;
    END IF;

    SELECT id INTO idPais3 FROM pais WHERE pais='Camerún';
    IF idPais3 IS NULL THEN
        INSERT INTO pais
            (id, pais, entidad) VALUES(nuevoIdPais, 'Camerún', '');
        idPais3 := nuevoIdPais;
        nuevoIdPais := nuevoIdPais + 1;
    END IF;

    SELECT id INTO idPais4 FROM pais WHERE pais='México';
    IF idPais4 IS NULL THEN
        INSERT INTO pais
            (id, pais, entidad) VALUES(nuevoIdPais, 'México', '');
        idPais4 := nuevoIdPais;
        nuevoIdPais := nuevoIdPais + 1;
    END IF;

    SELECT COUNT(*) INTO totalPaises
        FROM grupopais
        WHERE idgrupo=nuevoIdGrupo;
    IF totalPaises=0 THEN
        INSERT INTO grupopais
            (idgrupo, idpais)
            VALUES
            (nuevoIdGrupo, idPais1),
            (nuevoIdGrupo, idPais2),
            (nuevoIdGrupo, idPais3),
            (nuevoIdGrupo, idPais4);
    END IF;
    
    SELECT id INTO idPais1 FROM pais WHERE pais='Francia';
    IF idPais1 IS NULL THEN
        INSERT INTO pais
            (id, pais, entidad) VALUES(nuevoIdPais, 'Francia', '');
        idPais1 := nuevoIdPais;
        nuevoIdPais := nuevoIdPais + 1;
    END IF;
    
    SELECT id INTO idPais2 FROM pais WHERE pais='Canadá';
    IF idPais2 IS NULL THEN
        INSERT INTO pais
            (id, pais, entidad) VALUES(nuevoIdPais, 'Canadá', '');
        idPais2 := nuevoIdPais;
        nuevoIdPais := nuevoIdPais + 1;
    END IF;

    SELECT id INTO idPais3 FROM pais WHERE pais='Brasil';
    IF idPais3 IS NULL THEN
        INSERT INTO pais
            (id, pais, entidad) VALUES(nuevoIdPais, 'Brasil', '');
        idPais3 := nuevoIdPais;
        nuevoIdPais := nuevoIdPais + 1;
    END IF;

    SELECT id INTO idPais4 FROM pais WHERE pais='Fiyi';
    IF idPais4 IS NULL THEN
        INSERT INTO pais
            (id, pais, entidad) VALUES(nuevoIdPais, 'Fiyi', '');
        idPais4 := nuevoIdPais;
        nuevoIdPais := nuevoIdPais + 1;
    END IF;

    SELECT COUNT(*) INTO totalPaises
        FROM grupopais
        WHERE idgrupo=nuevoIdGrupo+1;
    IF totalPaises=0 THEN
        INSERT INTO grupopais
            (idgrupo, idpais)
            VALUES
            (nuevoIdGrupo+1, idPais1),
            (nuevoIdGrupo+1, idPais2),
            (nuevoIdGrupo+1, idPais3),
            (nuevoIdGrupo+1, idPais4);
    END IF;

    SELECT id INTO idPais1 FROM pais WHERE pais='España';
    IF idPais1 IS NULL THEN
        INSERT INTO pais
            (id, pais, entidad) VALUES(nuevoIdPais, 'España', '');
        idPais1 := nuevoIdPais;
        nuevoIdPais := nuevoIdPais + 1;
    END IF;
    
    SELECT id INTO idPais2 FROM pais WHERE pais='Estados Unidos';
    IF idPais2 IS NULL THEN
        INSERT INTO pais
            (id, pais, entidad) VALUES(nuevoIdPais, 'Estados Unidos', '');
        idPais2 := nuevoIdPais;
        nuevoIdPais := nuevoIdPais + 1;
    END IF;

    SELECT id INTO idPais3 FROM pais WHERE pais='Paraguay';
    IF idPais3 IS NULL THEN
        INSERT INTO pais
            (id, pais, entidad) VALUES(nuevoIdPais, 'Paraguay', '');
        idPais3 := nuevoIdPais;
        nuevoIdPais := nuevoIdPais + 1;
    END IF;

    SELECT id INTO idPais4 FROM pais WHERE pais='Marruecos';
    IF idPais4 IS NULL THEN
        INSERT INTO pais
            (id, pais, entidad) VALUES(nuevoIdPais, 'Marruecos', '');
        idPais4 := nuevoIdPais;
        nuevoIdPais := nuevoIdPais + 1;
    END IF;

    SELECT COUNT(*) INTO totalPaises
        FROM grupopais
        WHERE idgrupo=nuevoIdGrupo+2;
    IF totalPaises=0 THEN
        INSERT INTO grupopais
            (idgrupo, idpais)
            VALUES
            (nuevoIdGrupo+2, idPais1),
            (nuevoIdGrupo+2, idPais2),
            (nuevoIdGrupo+2, idPais3),
            (nuevoIdGrupo+2, idPais4);
    END IF;

END $$;


SELECT c.id, c.campeonato, p.pais, g.grupo, g.id, pg.id, pg.pais
    FROM campeonato c
        JOIN grupo g ON g.idcampeonato=c.id
        JOIN pais p ON c.idpais=p.id
        LEFT JOIN grupopais gp ON gp.idgrupo = g.id
        LEFT JOIN pais pg ON pg.id = gp.idpais
        WHERE campeonato='FIFA U-20 Women''s World Cup Colombia 2024';
