# spring-ddd
# 项目说明
spring-ddd是一个依赖spring的类加载机制，结合作者多年对DDD的理解和实践经验而总结的一套DDD编程框架。
领域驱动设计最早源于Eric的《领域驱动设计》一书，这本书介绍的思想在应对软件复杂性方面非常有价值，但是内容非常抽象难以理解，下面先介绍一下本人理解对《领域驱动设计》的核心思想，以及如何在编程实践中运用这些思想。DDD总体上可以分为战术设计和战略设计两个层面

**战术设计：**

实体(Entity)：实体对象简单来说对应一个数据库存储对象，实体对象需要一个ID来标示唯一性，实体对象通过数据访问层(Repository)加载到应用内存中，计算结果也通过数据访问层(Repository)保存到数据库中。

值对象：

聚合：

领域事件：

