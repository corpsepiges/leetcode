/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return guessRange(1,n);
    }
    public int guessRange(int start,int end){
        if(start==end){
            return start;
        }
        int middle=start/2+end/2+(start%2+end%2)/2;
        int ans=guess(middle);
        if(ans==0){
            return middle;
        }
        if(ans>0){
            return guessRange(middle+1,end);
        }
        return guessRange(start,middle-1);
    }
}