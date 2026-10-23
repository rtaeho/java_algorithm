-- 코드를 입력하세요
SELECT o.ANIMAL_ID, o.NAME
FROM ANIMAL_INS i
right outer join ANIMAL_OUTS o
on i.animal_id = o.animal_id
where i.animal_type is null
ORDER BY o.ANIMAL_ID