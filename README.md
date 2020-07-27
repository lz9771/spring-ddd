# spring-ddd
## 项目说明
spring-ddd是一个依赖spring的类加载机制，结合本人多年对DDD的理解和实践经验而总结的一套DDD编程框架。
领域驱动设计最早源于Eric的《领域驱动设计》一书，这本书介绍的思想在应对软件复杂性方面非常有价值，但是内容非常抽象难以理解，下面先介绍一下本人对《领域驱动设计》的核心概念及思想的理解，以及如何在编程实践中运用这些概念及思想。

总体上DDD可以分为战术设计和战略设计两个层面

### 战术设计：

**实体(Entity)：** 实体对象一般来说对应一个数据库存储对象，实体对象需要一个ID(主键)来标示唯一性，实体对象通过数据访问层(Repository)加载到应用内存中，计算结果也通过数据访问层(Repository)保存到数据存储层(MySQL)中。

**值对象(ValueObject)：** 这个概念稍微有点难理解，简单来说类似DTO(Data transform object)对象，用来在不同领域对象之间传递信息。值对象和实体间可以相互转换，不同的地方在于值对象没有与之直接对应的数据存储对象。

**聚合：** 这是《领域驱动设计》这本书里提出的最晦涩难懂的概念，并且让很多人在实践DDD的过程中走了很多弯路，这里重点说明一下。聚合概念是这样的：聚合是一组相关的领域对象，其目的是要确保业务规则在领域对象的各个生命周期都得以执行。聚合的提出应该是Eric想在应用内存中重建一套业务逻辑模型，在之前的编码中，业务逻辑往往散落于代码的各个角落甚至于SQL语句(存储过程)中，开发人员无法看到业务模型的全貌，导致后期代码维护成本越来越高，风险越来越大。聚合希望在应用中统一维护业务逻辑模型，保证对业务对象的操作具有事务一致性。但是在实际编程中，这个概念往往非常难于落地。举个例子：某个订单(订单表)包含1000个子订单(子订单表)，当某个子订单的金额变更需要同步更新订单的总金额。以往的编程模式中一般是写两条SQL更新逻辑，同时将这两条SQL更新代码放到一个事务中保证一致性。但是按照聚合模型，需要先将订单及相关子订单的数据全部加载到应用中，在内存中重建订单聚合模型，通过对订单聚合根的操作更新业务模型数据，再将更新后的订单聚合模型保存到数据存储层中。是不是有种想死的感觉？一个架构即使想法再好，如果增加了事情的复杂性，也不是一个好的架构设计。那聚合真正的价值是什么？**我认为聚合的价值在于如何在应用代码中明确体现业务模型及业务规则。** 但是就表现形式而言，不一定非要构造一个聚合类这样的内存模型，也可以是关系数据表这样的数据模型(现在Mybatis这样的ORM框架已经可以很好的建立内存与数据模型的映射关系)。一个优秀的DDD开发人员对聚合把控应该能做到手中无剑而心中有剑。在编程框架如何体现聚合的概念，这里就要提到DDD战术设计最重要的概念-领域事件。

**领域事件：**

### 战略设计： 
战略设计核心就讲了一个问题，领域(界限上下文)如何隔离及领域之间如何关联

