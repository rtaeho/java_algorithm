-- 코드를 입력하세요
SELECT BOOK_ID, date_format(published_date,"%Y-%m-%d") as PUBLISHED_DATE
from BOOK
where year(PUBLISHED_DATE) = 2021 and category = '인문'
order by published_date asc