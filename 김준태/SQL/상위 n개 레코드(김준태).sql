SELECT NAME
    FROM (
        SELECT *
            FROM ANIMAL_INS
            ORDER BY DATETIME
    )
    WHERE ROWNUM = 1;
