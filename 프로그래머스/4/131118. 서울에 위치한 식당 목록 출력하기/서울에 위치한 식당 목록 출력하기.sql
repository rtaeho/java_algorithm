SELECT 
    i.REST_ID, 
    i.REST_NAME, 
    i.FOOD_TYPE, 
    i.FAVORITES, 
    i.ADDRESS, 
    ROUND(AVG(r.REVIEW_SCORE), 2) AS SCORE  -- 1. 평균 계산 및 반올림
FROM 
    REST_INFO i
JOIN 
    REST_REVIEW r ON i.REST_ID = r.REST_ID
WHERE 
    i.ADDRESS LIKE '서울%'                  -- 2. 서울 지역 필터링
GROUP BY 
    i.REST_ID                               -- 3. 식당별로 그룹화
ORDER BY 
    SCORE DESC,                             -- 4. 점수 내림차순
    i.FAVORITES DESC;                       -- 5. 즐겨찾기 내림차순