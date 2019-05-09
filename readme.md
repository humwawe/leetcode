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
# 15. 3Sum
排序后，`c = a + b`,对每一个`c`进行计算，用两个指针移动
``` java
if (i == 0 || (i > 0 && nums[i] != nums[i - 1]))
while (left < right && nums[left] == nums[left + 1]) left++;
while (left < right && nums[right] == nums[right - 1]) right--;
```
>优化的地方时考虑如果值相同，就继续移动，这样可以不用set判重复
# 16. 3Sum Closest
排序、双指针。 
>三个数加起来，太大就移动右指针，太小就移动左指针
# 17. Letter Combinations of a Phone Number
循环加递归
# 18. 4Sum
排序后遍历计算前两个数的和，并用指针来指向后两个数
>有个优化的点前两层循环固定某个数的情况下，若最大值或最小值有问题，便提前结束
``` java
// first loop
if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
    break;
}
if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
    continue;
}
// second loop
if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
    break;
}
if (nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
    continue;
}
```
# 19. Remove Nth Node From End of List
双指针先将一个移动`n`次，随后两个指针一起移动

注意当第一个移动后为空，说明需要删除第一个节点
# 20. Valid Parentheses
栈，注意栈的状态
# 21. Merge Two Sorted Lists
声明一个`head`当作哨兵，最后返回`head.next`
# 22. Generate Parentheses
左括号需要一直比右括号多即可以为正确

对每个位置的可能性进行递归
> 扩展，生成括号的个数其实对应于**栈混洗**的个数：把入栈当成左括号，出栈当作右括号，不同的混洗次序即代表了不同的括号组合

> 栈混洗的个数即为**卡特兰数**：

> ![](http://latex.codecogs.com/gif.latex?SP(N)=\sum_{k=1}^NSP(k-1)*SP(n-k))

> 考虑对`1`这个元素，可以在第`k`个位置出栈，此时，前边`k-1`个元素和后面`n-k`个元素都是独立的

# 23. Merge k Sorted Lists
依此遍历生成一个链表，再跟之后的合并

可以按照分治的算法先分再合，效率更快
# 24. Swap Nodes in Pairs
找个哨兵节点，接到`head`，再直接进行变换
# 25. Reverse Nodes in k-Group
反转链表采用直接移动指向的方法，比题[24](#24-swap-nodes-in-pairs)的解法变换好理解
# 26. Remove Duplicates from Sorted Array
采用循环比较，若相等就移动整个后面的数组，比较耗时
``` java
int i = 0;
for (int j = 1; j < nums.length; j++) {
    if (nums[j] != nums[i]) {
        nums[i++] = nums[j];
    }
}
```
这种方法遍历一次，每次不相等就往前面放，用`i`记住该放的位置
# 27. Remove Element
思路跟[26](#26-remove-duplicates-from-sorted-array)差不多，碰到不等于目标值，就往前面放
# 28. Implement strStr()
暴力遍历，一一比较，可以减去`needle`的长度降低循环次数
> 有`KMP`算法效率较高
# 29. Divide Two Integers
由于只能用有符号31位表示，需要主要被除数或除数为最小负数的情况
求负数采用异或值与`0`比较
除以`2^n`，刚刚大于除数，结果加上`2^n`，被除数减去`2^n`个除数，继续下去
# 30. Substring with Concatenation of All Words
开始用了`list`和`map`的递归都超时了，把`map`的递归改成循环通过
> 从`list`构建`map`的方法可以用`java8`的`stream`
``` java
Map<String, Integer> collect = list.stream().map(word -> new AbstractMap.SimpleEntry<>(word, 1)).collect(toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue, (v1, v2) -> v1 + v2));
Map<Object, Long> collect1 = list.stream().map(word -> new AbstractMap.SimpleEntry<>(word, 1)).collect(groupingBy(AbstractMap.SimpleEntry::getKey, counting()));
```
# 31. Next Permutation
1. 从数组倒着查找，找到第一个`nums[i]`比`nums[i+1]`小的`i`
2. 再从`nums[i+1]`到`nums[nums.length-1]`当中找到刚好大于`nums[i]`的元素，然后交换
3. 再将`i+1`后面的元素反转
这种方法编程时可以直接包含其他特殊情况
# 32. Longest Valid Parentheses
当`count==0`的时候更新结果，可能导致无法更新，如`"(()"`，因此按反方向再扫描一次

可以使用栈来操作，注意加入栈的是下标，当遇到`")"`便与栈顶相减，表示可能的结果
``` java
if (s.charAt(i) == '(') {
    stack.push(i);
} else {
    if (stack.empty()) {
        start = i + 1;
    } else {
        stack.pop();
        result = stack.empty() ? Math.max(result, i - start + 1) : Math.max(result, i - stack.peek());
    }
}
```
# 33. Search in Rotated Sorted Array
二分后有一边仍然是有序的，在有序中找出必然在有序这边的情况，否则肯定在另一边
# 34. Find First and Last Position of Element in Sorted Array
二分查找目标，再在两边分别二分查找边界，注意循环的退出条件
# 35. Search Insert Position
二分查找，找到便返回位置，找到最后没找到返回`left`的位置即可
# 36. Valid Sudoku
开三个二维空间，遍历一次，若某次的元素已经被使用，返回false

也可以开三个一维空间，用一个数字的每位来表示遇到的数字
``` java
int flag = 0x1 << (board[i][j] - '0');
if (flag == (row[i] & flag) || flag == (column[j] & flag) || (flag == (square[box] & flag))) {
    return false;
}
row[i] |= flag;
column[i] |= flag;
square[i] |= flag;
```
`char`转成`int`可以
* `-'0'`
* `Character.getNumericValue()`
# 37. Sudoku Solver
利用棋盘初始化`row`，`column`，`square`，达到剪枝目的，并记录为`.`的位置信息`index`（用两位数字表示）
对所有位置循环`1-9`，填入应该的值，递归求解
# 38. Count and Say
递归得到下一个值，

`StringBuilder`可以直接`append`数字，不用转换成`String`
# 39. Combination Sum
递归到`target`为`0`即加入一个解，递归设计必须有返回值

排序后，判断当前`candidates[i]`大于`target`可以退出循环

记录`level`，当第一个值用完了，开始用第二个则不再往前考虑
# 40. Combination Sum II
不重复，所以若后一个数跟前一个相等则不再考虑，这种方法也需要排序
``` java
if (i != level && candidates[i] == candidates[i - 1]) {
    continue;
}
```
# 41. First Missing Positive
想象一个大的`hashtable`，当前数组只是前面的一段，因此把在这个数组里的值的放到合适位置，再便利一边看找第一个不在合适位置的`index`

交换的时候如果两个值相等就不交换，避免死循环
# 42. Trapping Rain Water
纵向分析每个位置能接多少水
> 即由该点两边最高高度中小的高度决定，两者相减即为可以接的水，若为负，则为`0`。一次循环可以得到每个点一边最大的高度
# 43. Multiply Strings
可以开一个两个字符串长度总和大小的空间，两次循环每次更新相应位置即可
``` java
if (num1 == "0" || num2 == "0") 
```
执行会报错，改成`equals`执行正常