-- 코드를 입력하세요


SELECT FLAVOR
FROM FIRST_HALF F JOIN(
SELECT FLAVOR,SUM(TOTAL_ORDER) SUM
FROM JULY
GROUP BY FLAVOR) J
USING(FLAVOR)
ORDER BY TOTAL_ORDER + SUM DESC
LIMIT 3










