# -- 코드를 입력하세요

SELECT YEAR(S.SALES_DATE) YEAR, MONTH(S.SALES_DATE) MONTH,U.GENDER GENDER,COUNT(DISTINCT USER_ID) USERS
FROM ONLINE_SALE S JOIN USER_INFO U
USING(USER_ID)
WHERE U.GENDER IS NOT NULL
GROUP BY YEAR(S.SALES_DATE),MONTH(S.SALES_DATE),U.GENDER
ORDER BY YEAR(S.SALES_DATE), MONTH(S.SALES_DATE),U.GENDER











