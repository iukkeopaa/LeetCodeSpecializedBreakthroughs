### 关于log(n)的一些思考


>O(logn) 这种对数时间复杂度。这是一种极其高效的时间复杂度，有的时候甚至比时间复杂
度是常量级 O(1) 的算法还要高效。


>>因为 logn 是一个非常“恐怖”的数量级，即便 n 非常非常大，对应的 logn 也很小。比如
n 等于 2 的 32 次方，这个数很大了吧？大约是 42 亿。也就是说，如果我们在 42 亿个数
据中用二分查找一个数据，最多需要比较 32 次。

>>>我们前面讲过，用大 O 标记法表示时间复杂度的时候，会省略掉常数、系数和低阶。对于
常量级时间复杂度的算法来说，O(1) 有可能表示的是一个非常大的常量值，比如
O(1000)、O(10000)。所以，常量级时间复杂度的算法有时候可能还没有 O(logn) 的算法
执行效率高。