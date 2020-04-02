import java.util.Arrays;

class ColoringBook {
  private int[] world;
  private int maxWideOfArea;
  
  public ColoringBook(int[] world) {
    if(world.length == 0)
      this.world = new int[1];
    else {
      this.world = new int[world.length + 1];
      for(int i = 1; i < this.world.length; ++i) {
        this.world[i] = world[i-1];
      }
    }
  }

  public void service() {
    int countOfArea = 0;
    int wideOfArea = -1;
    int maxWideOfArea = 0;
    int lastBlock = this.world[0];

    if(this.world.length <= 1) {
      System.out.println(countOfArea);
      System.out.println(maxWideOfArea);
    }
    
    for (int i : this.world) { 
      if(i != lastBlock) {
        if(wideOfArea > this.maxWideOfArea) 
          maxWideOfArea = wideOfArea;
        ++countOfArea; 
        wideOfArea = 1;
      }
      else
        ++wideOfArea;
    } 

    if(wideOfArea != 1)
      ++countOfArea; 

    System.out.println(countOfArea);
    System.out.println(maxWideOfArea);
  }

  public static void main(String[] args) {
    int[] hoho = {1, 1, 0, 1, 0, 0};
    ColoringBook coloringBook = new ColoringBook(hoho);
    coloringBook.service();
  }
}