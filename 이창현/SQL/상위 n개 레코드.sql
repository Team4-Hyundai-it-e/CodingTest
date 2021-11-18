SELECT *
from (select NAME from ANIMAL_INS order by DATETIME)
where rownum = 1
