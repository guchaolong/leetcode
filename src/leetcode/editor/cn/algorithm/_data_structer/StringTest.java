package leetcode.editor.cn.algorithm._data_structer;

/**
 * Description:
 *
 * @author GUCHAOLONG
 * @date 2020/11/30 18:42
 */
public class StringTest {
    public static void main(String[] args) {
        System.out.println("a - a " + ('a' - 'a'));
        System.out.println("b - a " + ('b' - 'a'));
        System.out.println("y - a " + ('y' - 'a'));
        System.out.println("z - a " + ('z' - 'a'));
        System.out.println(isWordDiff("anagram", "nagvram"));
    }

    /**
     * 字母异位词
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isWordDiff(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
