# 1. Two Sum
有可能为负数

# 2. Add Two Numbers
``` java
int x = (p != null) ? p.val : 0;
int y = (q != null) ? q.val : 0;
```
>考虑如果一个链表用完了，可以看成0处理，这样可以少写点代码

# 3. Longest Substring Without Repeating Characters
>滑动窗口

两个指针
* 一个往后移，没有就在`hashset`里放。
* 如果出现了就用另一个指针移除从开始到前一次出现的一段

也可以用`map`来记录每个字符出现的位置

* 一个指针往后移，没出现就往`map`里放，`key`是字符，`value`是位置
* 如果在`map`中重复出现，就用另一个指针指向前一次出现的位置（相当于删除）

# 4. Median of Two Sorted Arrays
>用到虚拟数组的概念，使得任意个数的数组都为奇数，分割较为容易

1 2 3 -> # 1 # 2 # 3 #
* 分割点落在#号上，求出来L、R为左右两边的数
* 若落在数值上，求出来L、R即都为该数值 

此题也可推广到求排序数组的第k个元素，即让`mid2=2k-mid1`（在虚拟数组中所以2k）

[两个有序数组中的中位数和TopK问题](https://blog.csdn.net/hk2291976/article/details/51107778)
