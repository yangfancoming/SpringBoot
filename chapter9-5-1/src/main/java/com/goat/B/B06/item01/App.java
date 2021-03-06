package com.goat.B.B06.item01;

import org.junit.Test;

/**
 * Created by 64274 on 2019/7/15.
 *
 组合模式中的角色：

 Component 抽象组件：为组合中所有对象提供一个接口，不管是叶子对象还是组合对象。
 Composite 组合节点对象：实现了Component的所有操作，并且持有子节点对象。
 Leaf 叶节点对象：叶节点对象没有任何子节点，实现了Component中的某些操作。

 组合模式让我们能用树形方式创建对象的结构，树里面包含了组合以及个别的对象。
 使用组合结构，我们能把相同的操作应用在组合和个别对象上。换句活说，在大多数情况下，我们可以忽略对象组合和个别对象之问的差别。
 * @ date 2019/7/15---20:53
 */
public class App {


    @Test
    public void test(){
        // 创建root 根节点对象(也是容器节点)
        Component root = new Node("root");

        //创建两个组合节点 node1 和 node2
        Component node1 = new Node("node1");
        Component node2 = new Node("node2");

        //给root 添加将 node1 和 node2 容器节点
        root.add(node1);
        root.add(node2);

        //给node1 添加 leaf1 和 leaf2  叶节点
        Component leaf1 = new Leaf("leaf1");
        Component leaf2 = new Leaf("leaf2");
        node1.add(leaf1);
        node1.add(leaf2);

        //给 node2 添加 leaf3 叶节点和 node3 容器节点
        Component leaf3 = new Leaf("leaf3");
        Component node3 = new Node("node3");
        node2.add(leaf3);
        node2.add(node3);

        //给node3 容器节点添加 leaf4 leaf5 叶节点
        Component leaf4 = new Leaf("leaf4");
        Component leaf5 = new Leaf("leaf5");
        node3.add(leaf4);
        node3.add(leaf5);

        // 只操作root根节点
        root.operation("");
    }

}
/**
 上述代码中，在组合节点对象Composite的operation()方法中除了执行自身的操作外，
 还调用了子节点的operation()方法，这样使得客户端可以透明的遍历所有的节点对象的操作，
 而不用关心操作的是叶子节点还是组合节点，将它们一视同仁。这看上去有点像二叉树的遍历，
 不过这里并不是二叉树，每个组合节点可以有若干个子节点，而这些子节点，如果是组合节点，
 则可以继续拥有子节点，如果是叶子节点，那么就终止了。

 叶子节点和组合节点可以有相同的操作，如上面代码中的operation()方法，但是叶子节点不具备add、remove以及getChild操作，
 如果你试图在叶子节点上调用这些方法就会抛出不支持的异常。组合节点可以添加子节点，
 因此组合节点实现了add、remove以及getChild等操作。组合节点持有一个节点的集合，
 在组合节点的operation()方法中通过遍历调用持有节点的operation()方法，就像是在递归遍历一样。
 通过这种方式Client客户端可以透明的访问节点对象，你可以在客户端中调用一个组合节点的operation()方法，也可以调用一个叶子节点的operation()方法，
 也就是说你根本不需要关心调用的是组合节点还是叶子节点，它们都可以进行相同的操作。
*/