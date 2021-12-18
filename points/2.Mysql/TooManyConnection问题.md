TooManyConnection问题解决
---
遇到TooManyConnection问题如果解决
线上先登录数据库
查看进程情况
看阻塞的进程是哪些
可以直接kill掉
如果很多可以使用如下脚本
```shell
mysql -u root -p123456 -e "show processlist" | grep -i "Locked或者Sleep" >> locked_log.txt

for line in `cat locked_log.txt | awk '{print $1}'`
do 
   echo "kill $line;" >> kill_thread_id.sql
done
```
然后在数据服务上执行
```mysql
mysql>source kill_thread_id.sql;
```