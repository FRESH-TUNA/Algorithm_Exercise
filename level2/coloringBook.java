import java.util.Stack;
import java.util.Iterator;

class ColoringBook {
  private int[] world;
  private int maxWideOfArea;
  private int countOfArea;
  
  public ColoringBook(int[] world) {
    if(world.length == 0)
      this.world = new int[1];
    else
      this.world = Arrays.copyOf(world, world.length + 1);
      this.world[this.world.length - 1] = this.world[1];
  }

  public void service() {
    int countOfArea = 0;
    int lastBlock = this.world[0];
    int wideOfArea = 0;
    int maxWideOfArea = 0;

    if(this.world.length <= 1) {
      System.out.println(countOfArea);
      System.out.println(maxWideOfArea);
    }
    
    for (int i : this.world) { 
      if(i != lastBlock) {
        if(wideOfArea > this.maxWideOfArea) 
          maxWideOfArea = wideOfArea;
        ++this.countOfArea; 
        wideOfArea = 1;
      }
      else
        ++wideOfArea;
    } 
    System.out.println(countOfArea);
    System.out.println(maxWideOfArea);
  }

  public static void main(String[] args) {
    int[] hoho = {1, 1, 0, 1, 0, 0};
    ColoringBook coloringBook = new ColoringBook(hoho);
    coloringBook.service();
  }
}