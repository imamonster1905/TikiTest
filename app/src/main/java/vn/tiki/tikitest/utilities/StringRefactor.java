package vn.tiki.tikitest.utilities;

public class StringRefactor {
    public static String handleString(String hotKey) {
        if (hotKey.contains(" ")) {
            String[] arrKey = hotKey.split(" ");
            int length = arrKey.length;
            int centerPos;
            if (length % 2 == 0)
                centerPos = length / 2 - 1;
            else if (length == 3 & arrKey[0].length() <= arrKey[2].length())
                centerPos = 1;
            else
                centerPos = ((length - 1) / 2) - 1;

            hotKey = hotKey.replace(arrKey[centerPos] + " ", arrKey[centerPos] + "\n");
        }
        return hotKey;
    }
}
