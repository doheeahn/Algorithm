# -- 코드를 입력하세요


SELECT CATEGORY, SUM(S.SALES) TOTAL_SALES
FROM BOOK B
JOIN (SELECT BOOK_ID,SUM(SALES) SALES
FROM BOOK_SALES
WHERE SALES_DATE LIKE '2022-01%'
GROUP BY BOOK_ID) S
USING(BOOK_ID)
GROUP BY CATEGORY
ORDER BY CATEGORY












