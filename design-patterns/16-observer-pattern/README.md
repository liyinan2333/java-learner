### 观察者模式(Observer Pattern)

#### 概念
也叫做发布订阅模式（Publish/subscribe）,它是一个在项目中经常使用的模式，其定义如下：

定义对象间一种一对多的依赖关系，使得每当一个对象改变状态，则所有依赖于它的对象都会得到通知并被自动更新。

**Subject被观察者**

定义被观察者必须实现的职责，它必须能够动态地增加、 取消观察者。它一般是抽象类或者是实现类，仅仅完成作为被观察者必须实现的职责： 管理观察者并通知观察者。

**Observer观察者**

观察者接收到消息后，即进行update（更新方法） 操作，对接收到的信息进行处理。

**ConcreteSubject 具体的被观察者**

定义被观察者自己的业务逻辑，同时定义对哪些事件进行通知。

**ConcreteObserver 具体的观察者**

#### 优点

**观察者和被观察者之间是抽象耦合**

如此设计，则不管是增加观察者还是被观察者都非常容易扩展，而且在Java中都已经实现的抽象层级的定义，在系统扩展方面更是得心应手。

**建立一套触发机制**

根据单一职责原则，每个类的职责是单一的，那么怎么把各个单一的职责串联成真实世界的复杂的逻辑关系呢？比如，我们去打猎，打死了一只母鹿，母鹿有三个幼崽，因失去了母鹿而饿死，尸体又被两只秃鹰争抢，因分配不均，秃鹰开始斗殴，然后羸弱的秃鹰死掉，生存下来的秃鹰，则因此扩大了地盘……这就是一个触发机制，形成了一个触发链。观察者模式可以完美地实现这里的链条形式。

####  缺点

观察者模式需要考虑一下开发效率和运行效率问题，一个被观察者，多个观察者，开发和调试就会比较复杂，而且在Java中消息的通知默认是顺序执行，一个观察者卡壳，会影响整体的执行效率。在这种情况下 一般考虑采用异步的方式。多级触发时的效率更是让人担忧，大家在设计时注意考虑。

#### 使用场景

* 关联行为场景。需要注意的是，关联行为是可拆分的，而不是“组合”关系。

* 事件多级触发场景。

* 跨系统的消息交换场景。如消息队列的处理机制。

#### 注意事项

使用观察者模式也有以下两个重点问题要解决。

**广播链的问题**

如果你做过数据库的触发器，你就应该知道有一个触发器链的问题，比如表A上写了一个触发器，内容是一个字段更新后更新表B的一条数据，而表B上也有个触发器，要更新表C，表C也有触发器……完蛋了，这个数据库基本上就毁掉了！我们的观察者模式也是一样的问题，一个观察者可以有双重身份，既是观察者，也是被观察者，这没什么问题呀，但是链一旦建立，这个逻辑就比较复杂，可维护性非常差，根据经验建议，在一个观察者模式中最多出现一个对象既是观察者也是被观察者，也就是说消息最多转发一次（传递两次），这还是比较好控制的。

**注意：** 它和责任链模式的最大区别就是观察者广播链在传播的过程中消息是随时更改的，它是由相邻的两个节点协商的消息结构； 而责任链模式在消息传递过程中基本上保持消息不可变，如果要改变，也只是在原有的消息上进行修正。

**异步处理问题**

这个EJB是一个非常好的例子，被观察者发生动作了，观察者要做出回应，如果观察者比较多，而且处理时间比较长怎么办？那就用异步呗，异步处理就要考虑线程安全和队列的问题，这个大家有时间看看Message Queue，就会有更深的了解。

#### 项目中真实的观察者模式

为什么要说“真实”呢？因为我们刚刚讲的那些是太标准的模式了，在系统设计中会对观察者模式进行改造或改装，主要在以下3个方面。

**观察者和被观察者之间的消息沟通**

被观察者状态改变会触发观察者的一个行为，同时会传递一个消息给观察者，这是正确的，在实际中一般的做法是： 观察者中的update方法接受两个参数，一个是被观察者，一个是DTO（Data Transfer Object，据传输对象） ，DTO一般是一个纯洁的JavaBean,由被观察者生成，由观察者消费。当然，如果考虑到远程传输，一般消息是以XML格式传递。

**观察者响应方式**

我们这样来想一个问题，观察者是一个比较复杂的逻辑，它要接受被观察者传递过来的信息，同时还要对他们进行逻辑处理，在一个观察者多个被观察者的情况下，性能就需要提到日程上来考虑了，为什么呢？如果观察者来不及响应，被观察者的执行时间是不是也会被拉长？那现在的问题就是： 观察者如何快速响应？有两个办法： 一是采用多线程技术，甭管是被观察者启动线程还是观察者启动线程，都可以明显地提高系统性能，这也就是大家通常所说的异步架构； 二是缓存技术，甭管你谁来，我已经准备了足够的资源给你了，我保证快速响应，这当然也是一种比较好方案，代价就是开发难度很大，而且压力测试要做的足够充分，这种方案也就是大家说的同步架构。

**被观察者尽量自己做主**

这是什么意思呢？被观察者的状态改变是否一定要通知观察者呢？不一定吧，在设计的时候要灵活考虑，否则会加重观察者的处理逻辑，一般是这样做的，对被观察者的业务逻辑doSomething方法实现重载，如增加一个doSomething(boolean isNotifyObs)方法，决定是否通知观察者，而不是在消息到达观察者时才判断是否要消费。

#### 最佳实践

观察者模式在实际项目和生活中非常常见，我们举几个经常发生的例子来说明。

**文件系统**

比如，在一个目录下新建立一个文件，这个动作会同时通知目录管理器增加该目录，并通知磁盘管理器减少1KB的空间，也就说“文件”是一个被观察者，“目录管理器”和“磁盘管理器”则是观察者。

**猫鼠游戏**

夜里猫叫一声，家里的老鼠撒腿就跑，同时也吵醒了熟睡的主人，这个场景中，“猫”就是被观察者，老鼠和人则是观察者。

**ATM取钱**

比如你到ATM机器上取钱，多次输错密码，卡就会被ATM吞掉，吞卡动作发生的时候，会触发哪些事件呢？第一，摄像头连续快拍，第二，通知监控系统，吞卡发生； 第三，初始化ATM机屏幕，返回最初状态。一般前两个动作都是通过观察者模式来完成的，后一个动作是异常来完成。

**广播收音机**

电台在广播，你可以打开一个收音机，或者两个收音机来收听，电台就是被观察者，收音机就是观察者。