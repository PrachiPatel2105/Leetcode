class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>result=new ArrayList<>();
        Map<String,List<String>>map=new HashMap<>();
        for(String str:strs){
            char chars[]=str.toCharArray();
            Arrays.sort(chars);
            String sortedString=new String(chars);
            if(map.containsKey(sortedString)==false){
                map.put(sortedString,new ArrayList<>());
            }
            map.get(sortedString).add(str);
        }
        result.addAll(map.values());
        return result;
    }
}