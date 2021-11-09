package com.ryang.leetcode;

/**
 * @Auther: renyang
 * @Date: 2018/11/28 10:53
 * @Description:判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */

/**
 * Description: 思路：
 * 1.先将整数转换为字符串
 * 2.对转换后的字符串进行反转
 * 3.比较反转前后的字符串
 *
 * @auther: renyang
 * @param:
 * @return:
 * @date: 2018/11/28 11:30
 */
public class Case9 {
    public boolean isPalindrome(int x) {
        boolean result = false;
        String oldString = String.valueOf(x);
        char[] oldChar = oldString.toCharArray();
        char[] currentChar = new char[oldChar.length];
        int j = 0;
        for (int i = oldChar.length - 1; i > -1; i--) {
            currentChar[j++] = oldChar[i];
        }
        String currentString = String.valueOf(currentChar);
        if (oldString.equals(currentString)) {
            result = true;
        }
        return result;
    }

    /**
     * Description:思路:
     * 将数字本身反转，然后将反转后的数字与原始数字进行比较，如果它们是相同的，那么这个数字就是回文。
     * 但是，如果反转后的数字大于int.MAX，我们将遇到整数溢出问题。
     * 为了避免数字反转可能导致的溢出问题，所以考虑只反转int数字的一半。
     * 毕竟，如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同。
     * @auther: other
     * @param:
     * @return:
     * @date: 2018/11/28 15:20
     */
    public boolean isPalindrome1(int x) {
        /* 特殊情况：
        * 1.当x < 0 时，x不是回文数
        * 2.当数字的最后一位是0时，为了使该数字是回文数字，
        *   则第一位也该是0，即x==0才满足条件。
        * */
        if (x < 0 || x % 10 == 0 && x != 0){
            return false;
        }

        int revertedNum = 0;
        // 将原始数字除以10，然后给反转后的数字乘上10，
        // 所以，当原始数字小于反转后的数字时，就意味着我们已经处理了一半位数的数字。
        while (x > revertedNum){
            revertedNum = x / 10 + revertedNum * 10;
            x = x / 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNum || x == revertedNum / 10;
    }

}
