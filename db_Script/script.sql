-- MySQL Script generated by MySQL Workbench
-- Tue 11 Sep 2018 03:33:30 PM +0530
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema webpos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema webpos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `webpos` DEFAULT CHARACTER SET utf8 ;
USE `webpos` ;

-- -----------------------------------------------------
-- Table `webpos`.`Company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Company` (
  `idcompany` INT NOT NULL AUTO_INCREMENT,
  `comapanyName` VARCHAR(100) NULL,
  `Address1` VARCHAR(100) NULL,
  `Address2` VARCHAR(100) NULL,
  `City` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  `contactNo1` VARCHAR(45) NULL,
  `contactNo2` VARCHAR(45) NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idcompany`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Department` (
  `idDepartment` INT NOT NULL AUTO_INCREMENT,
  `DepartmentName` VARCHAR(45) NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `idcompanyFK` INT NOT NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idDepartment`),
  INDEX `fk_Department_company1_idx` (`idcompanyFK` ASC),
  CONSTRAINT `fk_Department_company1`
    FOREIGN KEY (`idcompanyFK`)
    REFERENCES `webpos`.`Company` (`idcompany`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Employees` (
  `idemployees` INT NOT NULL AUTO_INCREMENT,
  `NIC` VARCHAR(45) NULL,
  `FirstName` VARCHAR(45) NULL,
  `LastName` VARCHAR(45) NULL,
  `emailAdress` VARCHAR(45) NULL,
  `contactNo1` VARCHAR(45) NULL,
  `contactNo2` VARCHAR(45) NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idemployees`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Users` (
  `idusers` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `isActive` VARCHAR(45) NULL,
  `loginBlock` VARCHAR(45) NULL,
  `idemployeesFK` INT NOT NULL,
  `role` VARCHAR(45) NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idusers`),
  INDEX `fk_users_employees1_idx` (`idemployeesFK` ASC),
  CONSTRAINT `fk_users_employees1`
    FOREIGN KEY (`idemployeesFK`)
    REFERENCES `webpos`.`Employees` (`idemployees`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Category` (
  `idcategory` INT NOT NULL AUTO_INCREMENT,
  `categoryCode` VARCHAR(45) NULL,
  `categoryname` VARCHAR(45) NULL,
  `categoryType` VARCHAR(45) NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `idDepartmentFK` INT NOT NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idcategory`),
  INDEX `fk_category_Department1_idx` (`idDepartmentFK` ASC),
  CONSTRAINT `fk_category_Department1`
    FOREIGN KEY (`idDepartmentFK`)
    REFERENCES `webpos`.`Department` (`idDepartment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Units`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Units` (
  `idunits` INT NOT NULL AUTO_INCREMENT,
  `unitname` VARCHAR(45) NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idunits`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Products` (
  `idproducts` INT NOT NULL AUTO_INCREMENT,
  `productscode` VARCHAR(45) NULL,
  `productName` VARCHAR(100) NULL,
  `unitPrice` DOUBLE NULL,
  `sellingPrice` DOUBLE NULL,
  `isStock` VARCHAR(45) NULL,
  `isService` VARCHAR(45) NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `reorderLevel` DOUBLE NULL,
  `idcategoryFK` INT NOT NULL,
  `idunitsFK` INT NOT NULL,
  `barcode` VARCHAR(100) NULL,
  `SpecialPrice` DOUBLE NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idproducts`),
  INDEX `fk_products_category1_idx` (`idcategoryFK` ASC),
  INDEX `fk_products_units1_idx` (`idunitsFK` ASC),
  CONSTRAINT `fk_products_category1`
    FOREIGN KEY (`idcategoryFK`)
    REFERENCES `webpos`.`Category` (`idcategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_units1`
    FOREIGN KEY (`idunitsFK`)
    REFERENCES `webpos`.`Units` (`idunits`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Stock` (
  `idstock` INT NOT NULL AUTO_INCREMENT,
  `qty` DOUBLE NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `idproductsFK` INT NOT NULL,
  `idunits` INT NOT NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idstock`),
  INDEX `fk_stock_products1_idx` (`idproductsFK` ASC),
  INDEX `fk_stock_units1_idx` (`idunits` ASC),
  CONSTRAINT `fk_stock_products1`
    FOREIGN KEY (`idproductsFK`)
    REFERENCES `webpos`.`Products` (`idproducts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_stock_units1`
    FOREIGN KEY (`idunits`)
    REFERENCES `webpos`.`Units` (`idunits`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Stockmaintain`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Stockmaintain` (
  `idstockmaintain` INT NOT NULL AUTO_INCREMENT,
  `stockDate` DATE NULL,
  `qty` DOUBLE NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `idemployeesFK` INT NOT NULL,
  `idproductsFK` INT NOT NULL,
  `StockTime` DATETIME NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idstockmaintain`),
  INDEX `fk_stockmaintain_employees1_idx` (`idemployeesFK` ASC),
  INDEX `fk_stockmaintain_products1_idx` (`idproductsFK` ASC),
  CONSTRAINT `fk_stockmaintain_employees1`
    FOREIGN KEY (`idemployeesFK`)
    REFERENCES `webpos`.`Employees` (`idemployees`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_stockmaintain_products1`
    FOREIGN KEY (`idproductsFK`)
    REFERENCES `webpos`.`Products` (`idproducts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Suppliers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Suppliers` (
  `idsuppliers` INT NOT NULL AUTO_INCREMENT,
  `supplierName` VARCHAR(100) NULL,
  `supplierAddress1` VARCHAR(100) NULL,
  `supplierAddress2` VARCHAR(100) NULL,
  `city` VARCHAR(45) NULL,
  `contactNo1` VARCHAR(45) NULL,
  `contactNo2` VARCHAR(45) NULL,
  `emailAdress` VARCHAR(45) NULL,
  `contactPerson` VARCHAR(45) NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `department` VARCHAR(45) NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idsuppliers`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Grn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Grn` (
  `idGRN` INT NOT NULL AUTO_INCREMENT,
  `grnDate` DATE NULL,
  `grnTotal` DOUBLE NULL,
  `grnDiscount` DOUBLE NULL,
  `grnNettotal` DOUBLE NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `PaymentType` VARCHAR(45) NULL,
  `idsuppliersFK` INT NOT NULL,
  `GRNNo` VARCHAR(45) NULL,
  `Department` VARCHAR(45) NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idGRN`),
  INDEX `fk_GRN_suppliers1_idx` (`idsuppliersFK` ASC),
  CONSTRAINT `fk_GRN_suppliers1`
    FOREIGN KEY (`idsuppliersFK`)
    REFERENCES `webpos`.`Suppliers` (`idsuppliers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`GrnItems`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`GrnItems` (
  `idgrnItems` INT NOT NULL AUTO_INCREMENT,
  `itemQty` DOUBLE NULL,
  `unitPrice` DOUBLE NULL,
  `lineTotal` DOUBLE NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `idGRNFK` INT NOT NULL,
  `idproductsFK` INT NOT NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idgrnItems`),
  INDEX `fk_grnItems_GRN1_idx` (`idGRNFK` ASC),
  INDEX `fk_grnItems_products1_idx` (`idproductsFK` ASC),
  CONSTRAINT `fk_grnItems_GRN1`
    FOREIGN KEY (`idGRNFK`)
    REFERENCES `webpos`.`Grn` (`idGRN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_grnItems_products1`
    FOREIGN KEY (`idproductsFK`)
    REFERENCES `webpos`.`Products` (`idproducts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Supplierpayments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Supplierpayments` (
  `idsupplierpayments` INT NOT NULL AUTO_INCREMENT,
  `paymentDate` DATE NULL,
  `PaymentType` VARCHAR(45) NULL,
  `Amount` DOUBLE NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `idGRNFK` INT NOT NULL,
  `idsuppliersFK` INT NOT NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idsupplierpayments`),
  INDEX `fk_supplierpayments_GRN1_idx` (`idGRNFK` ASC),
  INDEX `fk_supplierpayments_suppliers1_idx` (`idsuppliersFK` ASC),
  CONSTRAINT `fk_supplierpayments_GRN1`
    FOREIGN KEY (`idGRNFK`)
    REFERENCES `webpos`.`Grn` (`idGRN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_supplierpayments_suppliers1`
    FOREIGN KEY (`idsuppliersFK`)
    REFERENCES `webpos`.`Suppliers` (`idsuppliers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Bankaccounts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Bankaccounts` (
  `idbankaccounts` INT NOT NULL,
  `bankName` VARCHAR(100) NULL,
  `branch` VARCHAR(45) NULL,
  `accountNo` VARCHAR(45) NULL,
  `accType` VARCHAR(45) NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `idcompanyFK` INT NOT NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idbankaccounts`),
  INDEX `fk_bankaccounts_company1_idx` (`idcompanyFK` ASC),
  CONSTRAINT `fk_bankaccounts_company1`
    FOREIGN KEY (`idcompanyFK`)
    REFERENCES `webpos`.`Company` (`idcompany`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Supplierpaymentcheque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Supplierpaymentcheque` (
  `idsupplierpaymentcheque` INT NOT NULL AUTO_INCREMENT,
  `cequeNo` VARCHAR(45) NULL,
  `dueDate` DATE NULL,
  `Amount` DOUBLE NULL,
  `isActive` VARCHAR(45) NULL,
  `idsupplierpaymentsFK` INT NOT NULL,
  `idsuppliersFK` INT NOT NULL,
  `createBy` VARCHAR(45) NULL,
  `idbankaccountsFK` INT NOT NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idsupplierpaymentcheque`),
  INDEX `fk_supplierpaymentcheque_supplierpayments1_idx` (`idsupplierpaymentsFK` ASC),
  INDEX `fk_supplierpaymentcheque_suppliers1_idx` (`idsuppliersFK` ASC),
  INDEX `fk_supplierpaymentcheque_bankaccounts1_idx` (`idbankaccountsFK` ASC),
  CONSTRAINT `fk_supplierpaymentcheque_supplierpayments1`
    FOREIGN KEY (`idsupplierpaymentsFK`)
    REFERENCES `webpos`.`Supplierpayments` (`idsupplierpayments`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_supplierpaymentcheque_suppliers1`
    FOREIGN KEY (`idsuppliersFK`)
    REFERENCES `webpos`.`Suppliers` (`idsuppliers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_supplierpaymentcheque_bankaccounts1`
    FOREIGN KEY (`idbankaccountsFK`)
    REFERENCES `webpos`.`Bankaccounts` (`idbankaccounts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Purchaseorder`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Purchaseorder` (
  `idporder` INT NOT NULL AUTO_INCREMENT,
  `poDate` DATE NULL,
  `poTotal` DOUBLE NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `idsuppliersFK` INT NOT NULL,
  `poNO` VARCHAR(45) NULL,
  `Department` VARCHAR(45) NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idporder`),
  INDEX `fk_GRN_suppliers1_idx` (`idsuppliersFK` ASC),
  CONSTRAINT `fk_GRN_suppliers10`
    FOREIGN KEY (`idsuppliersFK`)
    REFERENCES `webpos`.`Suppliers` (`idsuppliers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Poitems`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Poitems` (
  `idpoItems` INT NOT NULL AUTO_INCREMENT,
  `itemQty` DOUBLE NULL,
  `unitPrice` DOUBLE NULL,
  `lineTotal` DOUBLE NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `idproductsFK` INT NOT NULL,
  `idporderFK` INT NOT NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idpoItems`),
  INDEX `fk_grnItems_products1_idx` (`idproductsFK` ASC),
  INDEX `fk_poitems_purchaseorder1_idx` (`idporderFK` ASC),
  CONSTRAINT `fk_grnItems_products10`
    FOREIGN KEY (`idproductsFK`)
    REFERENCES `webpos`.`Products` (`idproducts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_poitems_purchaseorder1`
    FOREIGN KEY (`idporderFK`)
    REFERENCES `webpos`.`Purchaseorder` (`idporder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Customers` (
  `idcustomer` INT NOT NULL AUTO_INCREMENT,
  `customersName` VARCHAR(100) NULL,
  `Address1` VARCHAR(100) NULL,
  `Address2` VARCHAR(100) NULL,
  `City` VARCHAR(45) NULL,
  `contactNo1` VARCHAR(45) NULL,
  `contactNo2` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `isActive` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `isSpecial` VARCHAR(45) NULL,
  `department` VARCHAR(45) NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idcustomer`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Invoice` (
  `idinvoice` INT NOT NULL AUTO_INCREMENT,
  `invoiceNo` VARCHAR(45) NULL,
  `invoiceDate` DATE NULL,
  `total` DOUBLE NULL,
  `discount` DOUBLE NULL,
  `nettotal` DOUBLE NULL,
  `PaymentType` VARCHAR(45) NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `idcustomerFK` INT NOT NULL,
  `invoiceTime` DATETIME NULL,
  `Department` VARCHAR(45) NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idinvoice`),
  INDEX `fk_invoice_customers1_idx` (`idcustomerFK` ASC),
  CONSTRAINT `fk_invoice_customers1`
    FOREIGN KEY (`idcustomerFK`)
    REFERENCES `webpos`.`Customers` (`idcustomer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Invoiceitems`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Invoiceitems` (
  `idinvoiceitem` INT NOT NULL AUTO_INCREMENT,
  `qty` DOUBLE NULL,
  `unitPrice` DOUBLE NULL,
  `lineTotal` DOUBLE NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `idinvoiceFK` INT NOT NULL,
  `idproductsFK` INT NOT NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idinvoiceitem`),
  INDEX `fk_invoiceitems_invoice1_idx` (`idinvoiceFK` ASC),
  INDEX `fk_invoiceitems_products1_idx` (`idproductsFK` ASC),
  CONSTRAINT `fk_invoiceitems_invoice1`
    FOREIGN KEY (`idinvoiceFK`)
    REFERENCES `webpos`.`Invoice` (`idinvoice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_invoiceitems_products1`
    FOREIGN KEY (`idproductsFK`)
    REFERENCES `webpos`.`Products` (`idproducts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Customerpayments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Customerpayments` (
  `idcustomerpayments` INT NOT NULL AUTO_INCREMENT,
  `paymentDate` DATE NULL,
  `PaymentType` VARCHAR(45) NULL,
  `Amount` DOUBLE NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `idcustomerFK` INT NOT NULL,
  `idinvoiceFK` INT NOT NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idcustomerpayments`),
  INDEX `fk_customerpayments_customers1_idx` (`idcustomerFK` ASC),
  INDEX `fk_customerpayments_invoice1_idx` (`idinvoiceFK` ASC),
  CONSTRAINT `fk_customerpayments_customers1`
    FOREIGN KEY (`idcustomerFK`)
    REFERENCES `webpos`.`Customers` (`idcustomer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customerpayments_invoice1`
    FOREIGN KEY (`idinvoiceFK`)
    REFERENCES `webpos`.`Invoice` (`idinvoice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Customerpaymentcheque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Customerpaymentcheque` (
  `idcustomerpaymentc` INT NOT NULL AUTO_INCREMENT,
  `chequeno` VARCHAR(45) NULL,
  `dueDate` DATE NULL,
  `Amount` DOUBLE NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `idcustomerpaymentsFK` INT NOT NULL,
  `idcustomerFK` INT NOT NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idcustomerpaymentc`),
  INDEX `fk_customerpaymentcheque_customerpayments1_idx` (`idcustomerpaymentsFK` ASC),
  INDEX `fk_customerpaymentcheque_customers1_idx` (`idcustomerFK` ASC),
  CONSTRAINT `fk_customerpaymentcheque_customerpayments1`
    FOREIGN KEY (`idcustomerpaymentsFK`)
    REFERENCES `webpos`.`Customerpayments` (`idcustomerpayments`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customerpaymentcheque_customers1`
    FOREIGN KEY (`idcustomerFK`)
    REFERENCES `webpos`.`Customers` (`idcustomer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Cashbooktypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Cashbooktypes` (
  `idcashbooktypes` INT NOT NULL AUTO_INCREMENT,
  `typename` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `isActive` VARCHAR(45) NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idcashbooktypes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webpos`.`Cashbook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webpos`.`Cashbook` (
  `idcashbook` INT NOT NULL AUTO_INCREMENT,
  `recordDate` DATE NULL,
  `description` VARCHAR(45) NULL,
  `income` DOUBLE NULL,
  `expense` DOUBLE NULL,
  `isActive` VARCHAR(45) NULL,
  `createBy` VARCHAR(45) NULL,
  `idcashbooktypesFK` INT NOT NULL,
  `Department` VARCHAR(45) NULL,
  `CompanyCode` VARCHAR(45) NULL,
  PRIMARY KEY (`idcashbook`),
  INDEX `fk_cashbook_cashbooktypes1_idx` (`idcashbooktypesFK` ASC),
  CONSTRAINT `fk_cashbook_cashbooktypes1`
    FOREIGN KEY (`idcashbooktypesFK`)
    REFERENCES `webpos`.`Cashbooktypes` (`idcashbooktypes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
