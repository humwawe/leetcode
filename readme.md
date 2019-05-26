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

或者用`k`最小堆存每个链表的第一个值
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
        nums[++i] = nums[j];
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
# 44. Wildcard Matching
直接递归求解，会大量计算重复元素，考虑两种方案
1. 将`p`中的连着的`*`变为一个`*`
2. 记忆递归，每次需要返回时便记录，出口出增加若有值便返回

记忆性的递归可以改造成`dp`，速度会更快
# 45. Jump Game II
动态规划，从后往前，一个点的跳跃次数等于能跳到后面所有的点中最小的跳跃次数那个点`+1`。这种方法会超时，比如对于`4,3,2,1,1,0`，在求每一个前面的点的时候，会循环后面点中最小的跳跃次数

贪心的策略，从前往后，考虑一个点可以到达的最远距离，思考每一步能跳的最远距离，返回步数即可

也可以把走的过程当成图，把每一步能走的点放入到达队列中，或者说是对图进行广度遍历
# 46. Permutations
递归求每个可能性，记录某个值是否被用过
# 47. Permutations II
跟[46](#46-permutations)思路差不多，记录最后一个被用过的值，如果已经用过了，该位置就不能再用了，只对当前位置判断
# 48. Rotate Image
先外圈后内圈，四个元素直接交换顺序，主要是找到每个元素该在的位置

或者操作比较方便的算法：先转置后镜像对称
# 49. Group Anagrams
构造一个`Map`来放所有的值
``` java
Map<Long, List<String>> map = new HashMap<>();
```
一般思路对每个字符串排序后看是否在`map`里
``` java
char[] arr = key.toCharArray();
Arrays.sort(arr);
key = new String(arr);
```
如果用数字来唯一表示一个单词
* 用二进制位为1来表示字符串中的某个字符，但这不能保证唯一性，比如`"huh","tit"`
* 用质数来表示每一位，然后想乘得到结果，可能会溢出（也有可能`hash`碰撞），此题用`int`可以通过，但好像还不如排序快
# 50. Pow(x, n)
将n表示为二进制，折半的计算

对于折半需要注意一个地方：
>即`-1 >> 1`位仍然是`-1`，而`-1 / 2`结果为`0`，因此用移位操作需要将负数转化为正数避免死循环，同时还要考虑`Integer.MIN_VALUE`无法转换为正数

>而如果用除`2`操作，可以不用变为0来处理，只需最后的时候求个倒数
# 51. N-Queens
递归记录哪些可以访问即可

用数字来表示状态（初始，访问，因访问不能被访问）
>由于不能被访问可能由多种位置的皇后导致，再回状态的时候每种操作只能回一次
# 52. N-Queens II
可以采用位运算来记录可以访问的位置
``` java
private void dfs(int n, int row, int col, int pie, int na) {
    if (row >= n) {
        count++;
        return;
    }
    //该行可以放的位置
    int bits = (~(col | pie | na)) & ((1 << n) - 1);
    while (bits > 0) {
        // 取低位的1
        int emp = bits & -bits;
        dfs(n, row + 1, col | emp, (pie | emp) << 1, (na | emp) >> 1);
        // 去掉最后一个1
        bits &= bits - 1;
    }
}
```
# 53. Maximum Subarray
一次循环，`max`记录出现的最大值，`tmp`为当前选i的情况，`i`之前为正就选`i`，之前为负，就从`i`开始
``` java
nums[i] = nums[i] + max(nums[i-1], 0)
```
# 54. Spiral Matrix
左下右上的走，若走完某次已经到达个数就结束
# 55. Jump Game
在第一步中找到能跳的最大位置，再在这些位置找能跳的最大位置，若有能超过总长度的即为可以跳过
# 56. Merge Intervals
排序，然后比较，排序可以只比较第一个数
``` java
return o1[0] - o2[0]
```
``` java
result.toArray(new int[0][])
```
数字如果小于等于被转的变量的长度，都可以。若数字大于`result`的长度，则后面的补充为`null`

对于二维数组`{{}}`,长度为`1`，`a[0].length == 0`
# 57. Insert Interval
每次二分找应保留的`low`和`high`的位置，然后再加上中间的
> 比较麻烦的是二分查找找到和没找到时，确定位置
# 58. Length of Last Word
一个单词加个空格，该单词也算最后一个，因此`trim`后再从后前知道找到空格
# 59. Spiral Matrix II
一圈一圈的填，因为正方形，算出圈数赋值即可
# 60. Permutation Sequence
递归找到便返回

可以考虑直接求出第`k`位的值
``` java
pos = k / total;
k = k % total;
result.append(input.get(pos));
input.remove(pos);
total = total / (n - 1);
n = n - 1;
```
从高到低计算每一位后面有多少个，跟`k`比较，求出该位置的值
# 61. Rotate List
求出总长度，两个指针一个先走`k`次，再一起走直到某个到末尾，再将后`k`个以到前面
# 62. Unique Paths
动态规划可解，一排一排的求应该可以用个一维数组求出

另外可以考虑成一个组合问题，从总共的步数`m+n-2`中挑出`m-1`布向下的
# 63. Unique Paths II
跟[62](#62-unique-paths)差不多，跟出现1的地方返回`0`即可
``` java
if (j > 0) {
    dp[j] += dp[j - 1];
}
```
# 64. Minimum Path Sum
动态规划，在从上或左中小的选一个走过来
# 65. Valid Number
根据不同情况转移到不同状态，有点状态机的感觉
# 66. Plus One
由于只加1，所以如果该位置`+1`小于`9`即可返回，而大于`9`就是`0`，然后前一位继续`+1`
# 67. Add Binary
直接相加，记录进位和各位，若没加完，后面继续加
# 68. Text Justification
记录能放几个单词，总共多少空格，有多少个位置，平均放就是商，余数每加一个加到左边的位置

最后一行要挨着放，也要考虑什么时候到了最后一行
# 69. Sqrt(x)
`int`里开根号最大的数值是`46340`，这样`mid`相乘也不会溢出（也可以用`x/mid>mid`来保证不溢出）

从`0`到`46340`二分，退出时返回`right`值
> 可以用[牛顿迭代法](https://www.guokr.com/question/461510/)求出
# 70. Climbing Stairs
动态规划
``` java
dp[n] = dp[n - 1] + dp[n - 2]
```
# 71. Simplify Path
用一个字符串来保留信息，若是`..`则找到最后一个`/`，删除后面的

可以用栈来保存，看到`..`弹出即可
# 72. Edit Distance
动态规划
``` java
result[i + 1][j + 1] = result[i][j];

result[i + 1][j + 1] = Math.min(Math.min(result[i][j + 1], result[i + 1][j]), result[i][j]) + 1;
```
# 73. Set Matrix Zeroes
用`set`记录行和列要位`0`的位置

可以用常数空间记录第一行和第一列是否为`0`，然后用第一行和第一列来记录该行和该列是否为`0`
# 74. Search a 2D Matrix
题中第一个数大于上一行最后一个数
* 可以采用先找到列的位置，再在列中查找
* 可以把二维数组转成一位数组的形式二分
# 75. Sort Colors
使用快排的思路，维护左边（为`0`）和右边（为`2`）和中间（为`1`），遍历数组根据值看是跟前面交换还是跟后面交换

另外可以存下每个颜色出现的次数，再更改数组，不过遍历了两次

可以用三指针，记录每个指针应该的位置，然后看是否覆盖
``` java
switch (nums[i]){
    case 0:
        nums[bluePosition++] = 2;
        nums[whitePosition++] = 1;
        nums[redPosition++] = 0;
        break;
    case 1:
        nums[bluePosition++] = 2;
        nums[whitePosition++] = 1;
        break;
    case 2:
        nums[bluePosition++] = 2;
        break;
}
```
# 76. Minimum Window Substring
滑动窗口
> 滑动右窗口找到满足条件的子串后，滑动左窗口直到不满足条件，继续滑动右窗口重复过程
# 77. Combinations
递归
> 循环里可以不用到n，到n-(k-level)即可，可以少点计算
# 78. Subsets
递归每个遇到的值
# 79. Word Search
注意剪枝的情况，如果某一步为`true`后，就没必要继续往其他方向走了
# 80. Remove Duplicates from Sorted Array II
在小于2的时候可以往前走，若是相等且大于等于2了，则j往后走

也可以直接让j与i位置的前第2个元素比较
``` java
for (int n : nums) {
if (i < 2 || n != nums[i - 2]) {
    nums[i++] = n;
    }
}
```
# 81. Search in Rotated Sorted Array II
跟[33](#33-search-in-rotated-sorted-array)思路类似，即二分后某一边仍然有序
看这一边是否包含决定二分的方向

此题可以右重复元素，因此当`left=mid`的时候（已知`mid`不等于`target`），将`left`往后移动即可
# 82. Remove Duplicates from Sorted List II
如果前一个和后一个不等则把前一个加到`dummy`后，如果相等则遍历到不等的时候，记录不等的那个地方
# 83. Remove Duplicates from Sorted List
跟[82](#82-remove-duplicates-from-sorted-list-ii)差不多只是遍历到不相等后，记录前一个位置

考虑递归的方法，如果后面已经去重完毕，把head的next指向它，并只需考虑head和head.next是否相等
``` java
head.next = deleteDuplicates(head.next);
if(head.val == head.next.val) head = head.next;
```
但是，82可如果变为
``` java
head.next = deleteDuplicates(head.next);
if(head.next!=null && head.val == head.next.val) head = head.next.next;
```
会有问题，因为`deleteDuplicates(head.next)`后的元素，不只在与`head`相等的时候去掉`head`，比如`1,1,1,2`，`deleteDuplicates(head.next)`作用在`1,1,2`后变为`2`，而`head`为`1`，此时`1,2`保留了，因此这种情况下还要记录是否删掉`head`
``` java
boolean flag=false;
if(head.val == head.next.val) flag = true;
head.next = deleteDuplicates(head.next);
if(head.next != null && head.val == head.next.val) head = head.next.next;
else if(flag) head=head.next;
```
另一种思路递归，先把前面的处理掉：存在`nex`的移动就不要`head`
``` java
ListNode nex = head.next;
while(nex != null && head.val == nex.val){
    nex = nex.next;
}
if (head.next == nex) {
    head.next = deleteDuplicates(head.next);
} else {
   head = deleteDuplicates(nex); 
} 
```
>把递归理解为已经处理的结果，再在本级中运用，可以方便的处理各种问题
# 84. Largest Rectangle in Histogram

考虑分值的方法，找到最小值的位置二分求左边、右边和全部中最大值

普通方法是以当前值为高向左和向右找比它低的，可以考虑使用单调栈，栈中存放索引值，来计算宽度
> 把这个想象成锯木板，如果木板都是递增的就一直往里放，如果突然遇到一块木板`i`比栈顶矮了一截，就找之前最戳出来的一块（其实就是第`i-1`块），计算一下这个木板单独的面积，然后把它锯成次高的，因为之后的计算都再也用不着这块木板本身的高度了（复杂度降低）。再然后如果次高的仍然比现在这个`i`木板高，就继续单独计算这个次高木板的面积（应该是第`i-1`和`i-2`块），再把它俩锯短。直到发觉不需要锯就比第`i`块矮了，`i`入栈，继续往右找更高的。为了避免到了最后一直都是递增的，可以在最后加一块高度为`0`的木板
# 85. Maximal Rectangle
对1的位置求当前行矩形面积（1的延展长度），在此范围内求下一行延展的最长长度，若此长度变小，在更新范围继续下一行

另一个方法可以想象成[84](#84-largest-rectangle-in-histogram)题，对每一行列举求得当前和的各个高度，然后求最大面积
``` java
for (int i = 0; i < row; i++) {
    for (int j = 0; j < col; j++) {
        heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
    }
    result = Math.max(result, largestRectangleArea(heights));
}
```
# 86. Partition List
递归的思路，假设之后的节点都已经排好了，考虑第一个节点的情况即可

另外可以用两个指针记录大于等于`x`的，和小于`x`的，最后在合起来

# 87. Scramble String
递归，对每个位置考虑
1. `s1`的`left`和`s2`的`left`与上`s1`的`right`和`s2`的`right`
2. `s1`的`left`和`s2`的`right`与上`s1`的`right`和`s2`的`left`
# 88. Merge Sorted Array
从后往前填大的数字
# 89. Gray Code
考虑求出了`grayCode(n-1)`，下一步就是对该结果逆序并在第一位加上`1`

>雷编码的生成过程：`G(i) = i ^ (i/2)`
# 90. Subsets II
递归，如果该位置用过就继续
注意如果给`lastUsed`赋值为其他的整数，比如最小的整数，当`nums`里面存在最小整数就有问题，因此包装为`Integer`赋值为`null`
# 91. Decode Ways
动态规划，注意边界和`0`的情况
# 92. Reverse Linked List II
找到各个位置，反转即可，反转思路与[25](#25-reverse-nodes-in-k-group)差不多
# 93. Restore IP Addresses
递归`1-3`个字符串，用完且字符串为空就加入`result`
# 94. Binary Tree Inorder Traversal
主要是非递归的实现

可以构造一个`Command`来模拟递归的执行过程
# 95. Unique Binary Search Trees II
考虑如果已经构成了一个一个列表，多一个数字如何构建下一个列表

对每一个进行遍历，
* 添加`head`为`n`的右孩子
* 添加`head`的右孩子，把右孩子接到左边
* 添加`head`的右孩子的右孩子，把右孩子的右孩子接到左边
* ...

另外的思路是：每个数字都能做为head，head左边k个元素和右边n-k个元素独立
![](http://latex.codecogs.com/gif.latex?f(n)=\sum_{k=1}^nf(k-1)*SP(n-k))
>此即为卡特兰数
``` java
for (int i = 1; i <= n; i++) {
    List<TreeNode> leftSubTrees = generate(1, i - 1);
    List<TreeNode> rightSubTrees = generate(i + 1, n);
    for (TreeNode left : leftSubTrees) {
        for (TreeNode right : rightSubTrees) {
            TreeNode node = new TreeNode(i);
            node.left = left;
            node.right = right;
            res.add(node);
        }
    }
}
```
# 96. Unique Binary Search Trees
使用卡特兰数的公式
# 97. Interleaving String
普通递归超时，可以采用记忆化递归或是动态规划
# 98. Validate Binary Search Tree
递归，考虑`root`值小于左边最小值，大于右边最大值，最小值最大值可以记录在函数中
``` java
boolean helper(TreeNode node, Integer lower, Integer upper) {
    if (node == null) return true;

    int val = node.val;
    if (lower != null && val <= lower) return false;
    if (upper != null && val >= upper) return false;

    if (! helper(node.right, val, upper)) return false;
    if (! helper(node.left, lower, val)) return false;
    return true;
}
```

也可以直接中序遍历，看每次遍历到的数是否大于前一个数字
# 99. Recover Binary Search Tree
中序遍历记录第一个有问题的地方，直接与最小值进行交换

或者遍历途中记录第一个位置和最后一个位置
``` java
for (int i = 0; i < list.size() - 1; i++) {
    if (list.get(i).val > list.get(i + 1).val) {
        if (first == -1) {
            first = i;
            last = i + 1;
        } else {
            last = i + 1;
            break;
        }
    }
}
```
# 100. Same Tree
递归比较即可