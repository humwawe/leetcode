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
# 5. Longest Palindromic Substring
循环时可以把最大值减去以减小次数
# 6. ZigZag Conversion
画图来计算位置
# 7. Reverse Integer
注意溢出的情况
# 8. String to Integer (atoi)
用`long`来表示返回，一旦计算出溢出返回`Integer.MAX_VALUE`或者`Integer.MIN_VALUE`
# 9. Palindrome Number
先计算长度，然后从两边扫过来
# 10. Regular Expression Matching
循环+递归
# 11. Container With Most Water
从两头往中间扫，左边比较低就移动左边，右边比较低就移动右边，记录扫动过程中的最大值
# 12. Integer to Roman
对每个数字的转换关系进行映射
# 13. Roman to Integer
``` java
int[] transform = new int[]{0, 0, 100, 500, 0, 0, 0, 0, 1, 0, 0, 50, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10};
```
将罗马数字与'A'相减可以映射
``` java
sum += cur >= prev ? cur : -cur;
prev = cur;
```
从字符串最后开始遍历，比较前面一个元素与当前元素的大小。
>基于一般情况数字是从大到小的，若中间有个小数字，则需要减去小数字
# 14. Longest Common Prefix
没有采用先求最小的长度来定义循环边界，而是一直循环，`catch`抛出的异常，需要注意边界和抛出异常的`index`位置