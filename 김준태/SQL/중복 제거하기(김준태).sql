SELECT COUNT(NAME)
    FROM (
        SELECT NAME
            FROM ANIMAL_INS
            WHERE NAME IS NOT NULL
            GROUP BY NAME
    );
