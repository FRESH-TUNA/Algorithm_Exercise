class Solution {
  public String max_calculator(String number) {
    String max_number = number.substring(1, number.length());
    for(int i = 0; i < number.length(); i++) {
      String candidate = number.substring(0,i) + number.substring(i + 1, number.length());
      if(candidate.compareTo(max_number) > 0) {
        max_number = candidate;
      }
    }
    return max_number;
  }
  public String solution(String number, int k) {
    String max_number = number;
    for(int i = 0; i < k; i++) {
      max_number = max_calculator(max_number);
    }
    return max_number;
  }
}
