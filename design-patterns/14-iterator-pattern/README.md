### 迭代器模式(Iterator Pattern)

#### 概念
它提供一种方法访问一个容器对象中各个元素，而又不需暴露该对象的内部细节。

迭代器模式目前已经是一个没落的模式，基本上没人会单独写一个迭代器，除非是产品性质的开发。

**Iterator 抽象迭代器**

抽象迭代器负责定义访问和遍历元素的接口，而且基本上是有固定的3个方法：first()获得第一个元素，next()访问下一个元素，isDone()是否已经访问到底部（Java叫做hasNext()方法）。

**ConcreteIterator 具体迭代器**

具体迭代器角色要实现迭代器接口，完成容器元素的遍历。

注意：开发系统时，迭代器的删除方法应该完成两个逻辑：一是删除当前元素，二是当前游标指向下一个元素。

**Aggregate 抽象容器**

容器角色负责提供创建具体迭代器角色的接口，必然提供一个类似createIterator()这样的方法，在Java中一般是iterator()方法。

**Concrete Aggregate具体容器**

具体容器实现容器接口定义的方法，创建出容纳迭代器的对象。

#### 应用
我们在例子中使用了迭代器模式后为什么使原本简单的应用变得复杂起来了呢？那是因为我们在简单的应用中使用了迭代器，在哪？注意这段话：for(IProjectproject:projectList)，它为什么能够运行起来？还不是因为ArrayList已经实现了iterator()方法，我们才能如此简单地应用。

从JDK 1.2版本开始增加java.util.Iterator这个接口，并逐步把Iterator应用到各个聚集类（Collection）中，我们来看JDK 1.5的API帮助文件，你会看到有一个叫java.util.Iterable的接口，看看有多少个接口继承了它：

    BeanContext,BeanContextServices,BlockingQueue<E>,Collection<E>,List<E>,Queue<E>,Set<E>,SortedSet<E>，

再看看有它多少个实现类：

    AbstractCollection,AbstractList,AbstractQueue,AbstractSequentialList,AbstractSet,ArrayBlockingQueue,ArrayList,AttributeList,BeanContextServicesSupport,BeanContextSupport,ConcurrentLinkedQueue,CopyOnWriteArrayList,CopyOnWriteArraySet,DelayQueue,EnumSet,HashSet,JobStateReasons,LinkedBlockingQueue,LinkedHashSet,LinkedList,PriorityBlockingQueue,PriorityQueue,RoleList,RoleUnresolvedList,Stack,SynchronousQueue,TreeSet,Vector，

基本上我们经常使用的类都在这个表中了，也正是因为Java把迭代器模式已经融入到基本API中了，我们才能如此轻松、便捷。

我们再来看看Iterable接口。java.util.Iterable接口只有一个方法：iterator()，也就说，通过iterator()这个方法去遍历聚集类中的所有方法或属性，基本上现在所有的高级语言都有Iterator这个接口或者实现，Java已经把迭代器给我们准备好了，我们再去写迭代器，就有点多余了。所以呀，这个迭代器模式也有点没落了，基本上很少有项目再独立写迭代器了，直接使用Collection下的实现类就可以完美地解决问题。

迭代器现在应用得越来越广泛了，甚至已经成为一个最基础的工具。一些大师级人物甚至建议把迭代器模式从23个模式中删除，为什么呢？就是因为现在它太普通了，已经融入到各个语言和工具中了，比如PHP中你能找到它的身影，Perl也有它的存在，甚至是前台的页面技术AJAX也可以有它的出现（如在Struts2中就可以直接使用iterator）。基本上，只要你不是在使用那些古董级（指版本号）的编程语言的话，都不用自己动手写迭代器。

#### 最佳实践
如果你是做Java开发，尽量不要自己写迭代器模式！省省吧，使用Java提供的Iterator一般就能满足你的要求了。