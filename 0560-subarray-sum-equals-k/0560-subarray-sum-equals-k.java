class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumFrequencyMap = new HashMap<>();
        sumFrequencyMap.put(0, 1);
        int totalCount = 0; 
        int cumulativeSum = 0; 
        for (int num : nums){
            cumulativeSum += num;
            totalCount += sumFrequencyMap.getOrDefault(cumulativeSum - k, 0);
            sumFrequencyMap.put(cumulativeSum, sumFrequencyMap.getOrDefault(cumulativeSum, 0) + 1);
        }
        return totalCount;
    }
}