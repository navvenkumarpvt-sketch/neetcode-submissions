class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

public List<String> decode(String str) {
    List<String> list = new ArrayList<>();

    int i = 0;

    while (i < str.length()) {
        int j = i;

        // Find the '#' after the length
        while (str.charAt(j) != '#') {
            j++;
        }

        // Extract the length
        int length = Integer.parseInt(str.substring(i, j));

        // Move past '#'
        j++;

        // Extract the actual string
        String s = str.substring(j, j + length);
        list.add(s);

        // Move to the next encoded string
        i = j + length;
    }

    return list;
}
}
