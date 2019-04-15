Login
===
*登入查询
    select * from user where username=#username# and password=#password#

Forget
===
*修改密码
    update user set password=#password# where username=#username#


InsertStudent
===
*插入
    insert into user ((varchar)username,(varchar)password) values ((varchar)#username#,(varchar)#password#)