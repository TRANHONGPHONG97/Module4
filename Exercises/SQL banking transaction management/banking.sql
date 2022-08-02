use banking;
INSERT INTO `customers` (id, created_at, created_by, deleted, updated_at, updated_by, full_name, balance, email, address, phone) VALUES
(1, '2021-09-02 20:09:25', NULL,0, '2021-09-02 20:09:25', NULL, 'Doloribus laborum il', 0, 'duzyqagahi@mailinator.com',  'Rosalyn Howe',  '+1 (483) 202-2127'),
(2, '2021-09-02 20:09:38', NULL,0, '2021-09-02 20:09:38', NULL, 'Ex fugit exercitati', 0, 'wijacab@mailinator.com',  'Moses Meadows',  '+1 (596) 452-9922'),
(3, '2021-09-02 20:09:58', NULL,0, '2021-09-02 20:09:58', NULL, 'Dolore officia eaque', 0, 'tusiger@mailinator.com',  'Imogene Dixon',  '+1 (581) 924-7822'),
(4, '2021-09-02 20:10:00', NULL,0, '2021-09-02 20:10:00', NULL, 'Blanditiis occaecat ', 0, 'putam@mailinator.com',  'Maxwell Pennington',  '+1 (746) 439-7553'),
(5, '2021-09-02 20:10:02', NULL,0, '2021-09-02 20:10:02', NULL, 'Dignissimos amet ne', 0, 'sirekel@mailinator.com',  'Garrison George',  '+1 (881) 121-2407'),
(6, '2021-09-02 20:10:04', NULL,0, '2021-09-02 20:10:04', NULL, 'Magni aut sint eos ', 0, 'bagukyrezy@mailinator.com',  'Irene Nolan',  '+1 (989) 281-9342'),
(7, '2021-09-03 01:06:15', NULL,0, '2021-09-03 01:06:15', NULL, 'Quam eum reiciendis ', 0, 'lemiliwub@mailinator.com',  'Joseph Davidson',  '+1 (125) 607-7363'),
(8, '2021-09-03 01:07:12', NULL,0, '2021-09-03 01:07:12', NULL, 'Nihil debitis exerci', 0, 'zywax@mailinator.com',  'Noelle Clark',  '+1 (752) 233-4897'),
(9, '2021-09-03 11:40:17', NULL,0, '2021-09-03 11:40:17', NULL, 'Repellendus At volu', 0, 'seximoliwi@mailinator.com',  'Hall Guy',  '+1 (121) 958-8876'),
(10, '2021-12-19 14:56:04', NULL,0, '2021-12-19 14:56:04', NULL, 'Incididunt voluptas ', 0, 'pabevigu@mailinator.com',  'Garrett Alvarez',  '+1 (892) 613-2085'),
(11, '2021-12-19 14:56:17', NULL,0, '2021-12-19 14:56:17', NULL, 'Dicta neque eius dic', 0, 'dahabemo@mailinator.com',  'Rogan Williamson',  '+1 (921) 747-7892');

-- tao bang deposits
delimiter //
DROP PROCEDURE IF EXISTS `Deposits`;
CREATE PROCEDURE `Deposits`()
BEGIN
	SELECT 
		dep.customer_id,
		cus.full_name,
        cus.email,
        cus.phone,
        dep.transaction_amount
	FROM deposits AS dep
    JOIN customers AS cus
	ON cus.id = dep.customer_id;
    
END //
delimiter ;

-- viet sp deposits
delimiter //
DROP PROCEDURE IF EXISTS `sp_deposits`;
CREATE PROCEDURE `sp_deposits`(
IN id_dep int,
IN money DECIMAL (12,0),
OUT message VARCHAR (255)
)
BEGIN
	IF (SELECT COUNT(id) FROM customers WHERE customers.id = id_dep) > 0
    THEN 
		UPDATE customers 
		SET balance = balance + money
		WHERE id = id_dep;
        
        INSERT INTO deposits (customer_id, transaction_amount) 
        VALUES (id_dep, money);
        
		SET message = 'gửi tiền thành công';
    ELSE
		SET message = 'id không tồn tại';
	END IF;
END //
delimiter ;

 -- viet sp withdraws
delimiter //
DROP PROCEDURE IF EXISTS `sp_withdraws`;
CREATE PROCEDURE `sp_withdraws`(
IN id_with int,
IN money DECIMAL (12,0),
OUT message VARCHAR (255)
)
BEGIN
	IF (SELECT COUNT(id) FROM customers WHERE customers.id = id_with) > 0
    THEN
		IF (money < (SELECT balance FROM customers WHERE customers.id = id_with) AND money > 50000)
        THEN
			UPDATE customers
            SET balance = balance - money
            WHERE id = id_with;
            
			INSERT INTO withdraws (customer_id, transaction_amount) 
			VALUES (id_with, money);
        
            SET message = 'Rút tiền thành công';
        ELSE
			SET message ='tài khoản không đủ hoặc số tiền rút phải lớn hơn 50000';
		END IF;
    ELSE
    SET message ='id không tồn tại';
    END IF;
END //
delimiter ;

 -- viet sp transfers
delimiter //
DROP PROCEDURE IF EXISTS `sp_transfers`;
CREATE PROCEDURE `sp_transfers`(
	IN sen_id INT,
    IN rec_id INT,
    IN money DECIMAL(12,0),
    OUT message varchar(255)
    )
BEGIN
	DECLARE current_sender_balance DECIMAL(12,0);
	DECLARE transaction_amount DECIMAL(12,0);
	DECLARE fees_amount DECIMAL(12,0);
	DECLARE count_sender_id int;
	DECLARE count_recipient_id int;
	SET fees_amount = money * 0.1;
	SET transaction_amount = money + fees_amount;
	SET count_sender_id = (SELECT COUNT(*) FROM customers c WHERE c.id = sen_id);
	SET count_recipient_id = (SELECT COUNT(*) FROM customers c WHERE c.id = rec_id);
	SELECT c.balance INTO current_sender_balance  FROM customers c
	WHERE c.id = sen_id;
	IF(count_sender_id = 0 OR count_recipient_id = 0)
	THEN
		SET message = 'id không tồn tại';
	ELSE
		IF(sen_id = rec_id)
		THEN
			SET message = "Không thể chuyển tiền vào cùng một tài khoản";
		ELSE
			IF(transaction_amount > current_sender_balance)
			THEN
				SET message = "Số dư tài khoản không đủ";
			ELSE
				IF (transaction_amount < 50000)
				THEN
					SET message = "Số tiền chuyển phải lớn hơn 50000";
				ELSE
					UPDATE customers c
					SET c.balance = c.balance - transaction_amount
					WHERE c.id = sen_id;
						
					UPDATE customers c
					SET c.balance = c.balance + money
					WHERE c.id = rec_id;
						
					INSERT INTO transfers (created_at, fees, fees_amount, transaction_amount, transfer_amount, recipient_id, sender_id)
					VALUES (NOW(), 10, fees_amount, transaction_amount, money, recipient_id, sender_id);
						
					SET message = 'Chuyển tiền thành công';	
				END IF;
			END IF;
		END IF;
	END IF;
END //
delimiter ;

-- Tạo VIEW hiển thị lịch sử chuyển khoản, trong đó có ID và tên người gửi, ID và tên người nhận, và các thông tin giao dịch.
DROP VIEW IF EXISTS `history_transfers`;
CREATE VIEW `history_transfers` AS
SELECT
	tran.id,
    tran.transfer_amount,
    tran.fees,
    tran.fees_amount,
    tran.transaction_amount,
    tran.sender_id,
    sen.full_name AS senderName,
    tran.recipient_id,
    rec.full_name AS recipientName
FROM transfers AS tran
JOIN customers AS sen
ON sen.id = tran.sender_id
JOIN customers AS rec
ON rec.id = tran.recipient_id;














