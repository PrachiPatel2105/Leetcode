class Solution {
    public List<String> fizzBuzz(int n) {
        List<String>answers=new LinkedList<>();
        for(int i=1;i<=n;i++){
            boolean isDivBy3=i%3==0;
            boolean isDivBy5=i%5==0;
            if(isDivBy3&&isDivBy5){
                answers.add("FizzBuzz");
            }else if(isDivBy3){
                answers.add("Fizz");
            }else if(isDivBy5){
                answers.add("Buzz");
            }else{
                answers.add(""+i);
            }
        }
        return answers;
    }
}