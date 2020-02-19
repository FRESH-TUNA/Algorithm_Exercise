class Solution {
  public String max_calculator(String number) {
    int max_number = -1;
    for(int i = 0; i < number.length(); i++) {
      String candidate = number.substring(0,i) + number.substring(i + 1, number.length());
      if(Integer.parseInt(candidate) > max_number) {
        max_number = Integer.parseInt(candidate);
      }
    }
    return Integer.toString(max_number);
  }
  public String solution(String number, int k) {
    String max_number = number;
    for(int i = 0; i < k; i++) {
      max_number = max_calculator(max_number);
    }
    return max_number;
  }
}
