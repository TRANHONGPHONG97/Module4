use banking;
SELECT *
FROM (
SELECT 
	cus.id,
    dep.created_at,
    cus.full_name,
    cus.email,
    cus.balance,
    dep.transaction_amount,
    'deposits' AS `transaction`
    -- INSERT("deposits",0,0, "") AS `transaction`
FROM customers AS cus
RIGHT JOIN deposits AS dep
ON cus.id = dep.customer_id
ORDER BY dep.created_at ASC
) result_deposits
UNION

SELECT *
FROM
(
SELECT 
	cus.id,
    wit.created_at,
    cus.full_name,
    cus.email,
    cus.balance,
    wit.transaction_amount,
    'withdraws' AS `transaction`
    -- INSERT("withdraws",0,0, "") AS `transaction`
FROM customers AS cus
RIGHT JOIN withdraws AS wit
ON cus.id = wit.customer_id
ORDER BY wit.created_at ASC
) result_withdraws;



