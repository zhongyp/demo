## Java 动态代理

### InvocationHandler

this is the interface implemented by the invocation handler of java.lang.a proxy.
译：这是一个代理处理程序的实现接口

### newProxyInstance(ClassLoader loader, Class<?> interface, InvocationHandler h)

ClassLoader:一个ClassLoader对象，定义了由哪个Classloader对象来对生成的代理对象进行加载

Interface:一个Interface对象数组，表示我们将要给我需要代理的对象提供一组什么接口，提供一组接口给它，那么这个代理对象就实现了这些接口，
这样就能调用这组接口中的方法了。

InvocationHandler:一个handler对象，表示当我这个动态代理调用到哪一个InvocationHandler对象上。
