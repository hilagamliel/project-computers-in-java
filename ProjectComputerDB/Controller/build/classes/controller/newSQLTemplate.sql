/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  student
 * Created: 04/01/2021
 */

-- CREATE TABLE CUSTOMERS (ID BIGINT NOT NULL, "NAME" VARCHAR(20), ADRRES VARCHAR(25), PRIMARY KEY (ID));
-- CREATE TABLE ORDERS(ID BIGINT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1,
-- INCREMENT BY 1)
-- , "CUSTOMERID" BIGINT NOT NULL,
-- CONSTRAINT CUS FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMERS(ID)
--  );

-- CREATE TABLE PRODUCTINORDERS(ID BIGINT NOT NULL 
-- , "PRODUCTID" BIGINT NOT NULL,
-- CONSTRAINT ORD FOREIGN KEY (ID) REFERENCES ORDERS(ID),
-- CONSTRAINT PRO FOREIGN KEY (PRODUCTID) REFERENCES PRODUCT(ID)
-- 
--  );
DELETE FROM CCC.ORDERS WHERE ID = 24;