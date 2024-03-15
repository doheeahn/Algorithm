-- 코드를 작성해주세요
SELECT DISTINCT D.ID , D.EMAIL,D.FIRST_NAME, D.LAST_NAME 
FROM DEVELOPERS D INNER JOIN (
SELECT CODE
FROM SKILLCODES
WHERE CATEGORY = 'FRONT END') S
WHERE D.SKILL_CODE & S.CODE
ORDER BY D.ID 