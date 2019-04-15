selectItemNumber
===
*根据编号查询
   select * from products where itemNumber=#itemNumber#


deleteProduct
===
*删除指定数据(根据编号)
    delete from products where `itemNumber`=#itemNumber#

addProduct
===
*增加企业
    insert into products(enterpriseName,pay,dueDate) values (#enterpriseName#,#pay#,#dueDate#)
