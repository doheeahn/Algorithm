# SELECT P.PRODUCT_CODE,SUM(SALES_AMOUNT*PRICE) SALES
# FROM OFFLINE_SALE S LEFT OUTER JOIN PRODUCT P
# USING (PRODUCT_ID)
# GROUP BY P.PRODUCT_CODE
# ORDER BY SALES DESC ,P.PRODUCT_CODE

SELECT PRODUCT_CODE , SUM(P.PRICE * S.AMOUNT) SALES
FROM PRODUCT P JOIN (
SELECT PRODUCT_ID, SUM(SALES_AMOUNT) AMOUNT
FROM OFFLINE_SALE
GROUP BY PRODUCT_ID) S
USING(PRODUCT_ID)
GROUP BY PRODUCT_CODE
ORDER BY SALES DESC, PRODUCT_CODE











