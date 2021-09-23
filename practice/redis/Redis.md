Redis学习
---
[官网文档](https://redis.io/documentation)
[中文官网文档](http://www.redis.cn/documentation.html)
# 初步认识
## 能做什么

## 有什么维护的工具
## 
#### Programming with Redis
- The full list of commands implemented by Redis, along with thorough documentation for each of them.
- Pipelining: Learn how to send multiple commands at once, saving on round trip time.
- Redis Pub/Sub: Redis is a fast and stable Publish/Subscribe messaging system! Check it out.
- Redis Lua scripting: Redis Lua scripting feature documentation.
- Debugging Lua scripts: Redis 3.2 introduces a native Lua debugger for Redis scripts.
- Memory optimization: Understand how Redis uses RAM and learn some tricks to use less of it.
- Expires: Redis allows to set a time to live different for every key so that the key will be automatically removed from the server when it expires.
- Redis as an LRU cache: How to configure and use Redis as a cache with a fixed amount of memory and auto eviction of keys.
- Redis transactions: It is possible to group commands together so that they are executed as a single transaction.
- Client side caching: Starting with version 6 Redis supports server assisted client side caching. This document describes how to use it.
- Mass insertion of data: How to add a big amount of pre existing or generated data to a Redis instance in a short time.
- Partitioning: How to distribute your data among multiple Redis instances.
- Distributed locks: Implementing a distributed lock manager with Redis.
- Redis keyspace notifications: Get notifications of keyspace events via Pub/Sub (Redis 2.8 or greater).
- Creating secondary indexes with Redis: Use Redis data structures to create secondary indexes, composed indexes
### 知识图谱
有api是阻塞的，也有api是异步的
### 总结
#### 常见问题
##### 如何保障数据一致性
redis是AP模型，节点数据同步是异步的。如果是集群的redis，会有数据同步到一个节点时，恰好此节点还没有将数据同步到其他节点就宕机了，这是锁会失效，两个系统的逻辑仍然在执行。

1. 使用红锁[RedLock](https://redis.io/topics/distlock?spm=a2c63.p38356.879954.5.31a66567vLiBpw#the-redlock-algorithm)
会将数据同步到几个节点上才算锁成功，这样可以保障一致性，但是性能会差点
2. 线程等待1秒，最大5秒，目的是让数据同步到其他节点，也有可能出现数据不一致的情况
3. 使用云Redis(阿里云) 
### 参考资料
引用文档
* https://dzone.com/articles/distributed-java-locks-with-redis
* https://www.fatalerrors.org/a/redis-distributed-lock-implementation-of-redisson-rlock-reentrant-lock.html
* https://redisson.org/glossary/java-distributed-lock.html
* https://github.com/redisson/redisson
* https://martin.kleppmann.com/2016/02/08/how-to-do-distributed-locking.html
* https://redis.io/topics/distlock
* https://redisson.org/