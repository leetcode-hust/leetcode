package test;

/**
 * Created by louyuting on 17/1/6.
 */
public class HashTest {


    public static void main(String[] args) {
        System.out.println(getHash("192.168.0.0:8011"));
        System.out.println(getHash("192.168.0.1:8011"));
        System.out.println(getHash("192.168.0.2:8011"));
        System.out.println(getHash("192.168.0.3:8011"));
        System.out.println(getHash("192.168.0.4:8011"));
    }

    private static int getHash(String str)
    {
        final int p = 16777619;
        int hash = (int)2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }

}
