# -- 코드를 입력하세요
# SELECT B.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(S.SALES * B.PRICE) TOTAL_SALES
# FROM BOOK B LEFT OUTER JOIN AUTHOR A 
# USING (AUTHOR_ID) LEFT OUTER JOIN BOOK_SALES S
# USING (BOOK_ID)
# WHERE S.SALES_DATE LIKE '2022-01%'
# GROUP BY B.AUTHOR_ID, B.CATEGORY
# ORDER BY B.AUTHOR_ID, B.CATEGORY DESC;

# SELECT A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(S.SALES * B.PRICE) TOTAL_SALES
# FROM BOOK B JOIN AUTHOR A 
# USING(AUTHOR_ID) JOIN BOOK_SALES S
# USING(BOOK_ID)
# WHERE S.SALES_DATE LIKE '2022-01%'
# GROUP BY AUTHOR_ID, CATEGORY
# ORDER BY A.AUTHOR_ID, B.CATEGORY DESC;

# SELECT AUTHOR_ID, AUTHOR_NAME,CATEGORY, SUM(S.SALES * PRICE) TOTAL_SALES
# FROM BOOK B JOIN BOOK_SALES S
# USING (BOOK_ID) JOIN AUTHOR USING (AUTHOR_ID)
# WHERE S.SALES_DATE LIKE '2022-01%'
# GROUP BY B.AUTHOR_ID, CATEGORY
# ORDER BY AUTHOR_ID, CATEGORY DESC

SELECT B.AUTHOR_ID,A.AUTHOR_NAME,B.CATEGORY, SUM(S.SALES * B.PRICE) TOTAL_SALES
FROM BOOK_SALES S JOIN BOOK B
USING(BOOK_ID) JOIN AUTHOR A USING(AUTHOR_ID)
WHERE YEAR(SALES_DATE) = 2022 AND MONTH(SALES_DATE) = 1
GROUP BY AUTHOR_ID, CATEGORY
ORDER BY B.AUTHOR_ID, B.CATEGORY DESC

